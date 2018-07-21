function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) { 
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start,c_end));
        } 
    }
    return "";
};
function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
};
function requestCompanyStatusTokenCallBack(data) {
    if (data.user_id_token != null && data.user_id_token != "") {
        setCookie("user_id_token", data.user_id_token, 7);
    }
    if (data.status != null && data.status != "") {
        switch (data.status) {
            case "unapplied":
                location.href= "fillInfo.html";
                break;
            case "checking_1":
                location.href= "fillInfo.html";
                break;
            case "unpassed":
                location.href= "fillInfo.html";
                break;
            case "passed":
                window.companyStatus = "passed";
                break;
            default:
                window.location.href = "introduction.html";
        }
    } else {
        setCookie("user_id_token", "", -1);
        location.href ="";
    }
};

//模拟用
setCookie("user_id_token", "testToken");
user_id_token = getCookie("user_id_token");
if (user_id_token == null || user_id_token == "") {
    location.href = "introduction.html";
}
$.ajax({
    url: "/api/user/company/status",
    type: "GET",
    async: false,
    headers: {
        "user_id_token": user_id_token,
    },
    success: function(data) {
        window.requestCompanyStatusTokenCallBack(data);
    },
    error: function (data) {
        setCookie("user_id_token", "", -1);
        window.location.href = "introduction.html"
    }
});
$.ajax({
    url: '/api/user/company/info',
    type: 'GET',
    async: false,
    headers: {
        'user_id_token': getCookie('user_id_token')
    },
    success: function (data) {
        window.company_name = data.name;
    },
    error: function (data) {
        setCookie('user_id_token', '', -1);
        window.location.href = 'introduction.html';
    }
});