function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
};
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
setCookie('user_id_token', 'testToken');
window.requestByCode = function(code) {
    $.ajax(
        {
            url:"/user/company/status",
            async: false,
            type: "POST",
            data: {
                "code": code
            },
            success: window.requestUserTokenCallBack,
        }
    )
};
window.requestByCookie = function(cookie) {
    $.ajax(
        {
            url:"/user/company/status",
            async: false,
            type: "GET",
            headers: {
                "user_id_token": cookie
            },
            success: function(data) {
                window.requestUserTokenCallBack(data)
            },
        }
    )
};
window.requestUserTokenCallBack = function(data) {
    if (data.user_id_token != null && data.user_id_token != "") {
        setCookie("user_id_token", data.user_id_token, 7);
    }
    if (data.status != null && data.status != "") {
        switch (data.status) {
            case "unapplied":
                window.companyStatus = "unapplied";
                break;
            case "checking_1":
                window.companyStatus = "checking";
                break;
            case "checking_2":
                window.companyStatus = "checking";
                break;
            case "unpassed":
                window.companyStatus = "unpassed";
                alert("您上次提交的信息未通过");
                break;
            case "passed":
                window.companyStatus = "passed";
                window.location.href = "company_center.html";
                break;
            default:
                window.location.href = "introduction.html";
        }
    } else {
        setCookie("user_id_token", "", -1);
        location.href ="introduction.html";
    }
}
var url = location.search;
window.requestParameter = new Object();
if (url != "") {
    url = url.substr(1);
    var requestParameterString = url.split("&");
    for (var i = 0; i < requestParameterString.length; i++) {
        requestParameter[requestParameterString[i].split("=")[0]] = unescape(requestParameterString[i].split("=")[1]);
    }
}
var user_id_token = getCookie("user_id_token");
if (user_id_token != null && user_id_token != "") {
    window.requestByCookie(user_id_token);
} else if (window.requestParameter.code != null && window.requestParameter.code != "") {
    window.requestByCode(window.requestParameter.code);
}
