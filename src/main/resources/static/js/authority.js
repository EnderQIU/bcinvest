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
user_id_token = getCookie("user_id_token");
if (user_id_token == null || user_id_token == "") {
    location.href = "introduction.html";
}
window.requestUserTokenCallBack = function(data) {
    data = $.parseJSON(data);
    if (data.user_id_token != null && data.user.user_id_token != "") {
        setCookie("user_id_token", data.user_id_token, 7);
    }
    if (data.status != null && data.status != "") {
        switch (data.status) {
            case "unapplied":
                window.companyStatus = "unapplied";
                location.href= "fillInfo.html";
                break;
            case "checking":
                window.companyStatus = "checking";
                location.href= "fillInfo.html";
                break;
            case "unpassed":
                window.companyStatus = "unpassed";
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
}
$.ajax({
    url: "/user/company/status",
    type: "GET",
    async: true,
    data: {
        "user_id_token": user_id_token
    },
    success: function(data) {
        window.requestUserTokenCallBack(data);
    }
});