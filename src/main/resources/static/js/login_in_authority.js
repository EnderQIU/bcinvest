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
}
function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
}
function requestBankOrAuthorityInfoCallBack(data) {
    if (!isEmptyValue(data)) {
        if (!isEmptyValue(data.type)) {
            switch (data.type) {
                case 'bank':
                    window.location.href = 'bank.html'
                    break;
                case 'authority':
                    window.location.href = 'authorization.html';
                    break;
            }
        } else {
            setCookie('user_id_token', '', -1);
        }
    }
}
function isEmptyValue(value) {
    if (value === null) {
        return true;
    }
    var type = typeof(value);
    switch (type) {
        case 'number':
            return isNaN(value);
        case 'function':
            return false;
        case 'object':
            for (var key in value) {
                return false;
            }
            return true;
        case 'string':
            if (value.length > 0) {
                return false;
            }
            return true;
        case 'boolean':
            return false;
        case 'undefined':
            return true;
    }
}
{
    var user_id_token = getCookie('user_id_token');
    if (user_id_token == null || user_id_token == "") {
    } else {
        $.ajax({
            url: "/user/bankOrAuthority/info",
            type: "GET",
            async: false,
            headers: {
                "user_id_token": user_id_token,
            },
            success: function (data) {
                window.requestBankOrAuthorityInfoCallBack(data);
            }
        });
    }
}