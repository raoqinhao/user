Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

function datetimeFormat(longTypeDate) {
    var datetimeType = "";
    var date = new Date();
    date.setTime(longTypeDate);
    datetimeType += date.getFullYear();//年
    datetimeType += "-" + getMonth(date);//月
    datetimeType += "-" + getDay(date);//日
    datetimeType += " " + getHours(date);//时
    datetimeType += ":" + getMinutes(date);//分
    datetimeType += ":" + getSeconds(date); //秒
    return datetimeType;
}

function longTypeForDate(longTypeDate) {
    var datetimeType = "";
    var date = new Date();
    date.setTime(longTypeDate);
    datetimeType += date.getFullYear();   //年
    datetimeType += "-" + getMonth(date); //月
    datetimeType += "-" + getDay(date);   //日
    return datetimeType;
}

function dateStrFormat(dateStr) {
    var datetimeType = dateStr.substring(0, 4);//年
    datetimeType += "-" + dateStr.substring(4, 6);//月
    datetimeType += "-" + dateStr.substring(6, 8);//日
    if (dateStr.length > 8) {
        datetimeType += " " + dateStr.substring(8, 10);//时
    }
    if (dateStr.length > 10) {
        datetimeType += ":" + dateStr.substring(10, 12);//分
    }
    if (dateStr.length > 12) {
        datetimeType += ":" + dateStr.substring(12, 14);//秒
    }
    return datetimeType;
}

/**
 * 根据秒数转换为时分秒
 * @param second
 * @returns {string}
 */
function secondFormat(second) {
    var hh = parseInt(second / 3600);
    if (hh < 10) hh = "0" + hh;
    var mm = parseInt((second - hh * 3600) / 60);
    if (mm < 10) mm = "0" + mm;
    var ss = parseInt((second - hh * 3600) % 60);
    if (ss < 10) ss = "0" + ss;
    var length = hh + ":" + mm + ":" + ss;
    if (second > 0) {
        return length;
    } else {
        return "0";
    }
}

//返回 01-12 的月份值
function getMonth(date) {
    var month = "";
    month = date.getMonth() + 1; //getMonth()得到的月份是0-11
    if (month < 10) {
        month = "0" + month;
    }
    return month;
}

//返回01-30的日期
function getDay(date) {
    var day = "";
    day = date.getDate();
    if (day < 10) {
        day = "0" + day;
    }
    return day;
}

//返回小时
function getHours(date) {
    var hours = "";
    hours = date.getHours();
    if (hours < 10) {
        hours = "0" + hours;
    }
    return hours;
}

//返回分
function getMinutes(date) {
    var minute = "";
    minute = date.getMinutes();
    if (minute < 10) {
        minute = "0" + minute;
    }
    return minute;
}

//返回秒
function getSeconds(date) {
    var second = "";
    second = date.getSeconds();
    if (second < 10) {
        second = "0" + second;
    }
    return second;
}