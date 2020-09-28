//渲染开始日期最大值为结束日期，结束日期最小值为开始日期
//startId 开始日期元素id , stopId 结束日期元素id
//放在数据加载后执行，否则得不到元素数据
function loadStartDateAndStopDate(startId, stopId) {
    var laydateMaxDate = "2099-12-31 23:59:59";
    var laydateMinDate = "1900-1-1 00:00:00";
    var startIdDate = $("#" + startId).val();
    var stopIdDate = $("#" + stopId).val();
    if (startIdDate != null && startIdDate != undefined && startIdDate != "") {
        laydateMinDate = startIdDate;
    }
    if (stopIdDate != null && stopIdDate != undefined && stopIdDate != "") {
        laydateMaxDate = stopIdDate;
    }
    var startDate = laydate.render({
        elem: '#' + startId,
        max: laydateMaxDate,
        done: function (value, date) {
            if (value !== '') {
                var minDateYear = startDate.config.max.year;
                var minDateMonth = startDate.config.max.month + 1;
                var minDateDay = startDate.config.max.date;
                var minDate = minDateYear + "-" + minDateMonth + "-" + minDateDay;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(minDate));
                if (time > time2) {
                    $("#" + startId).val("");
                    top.layer.msg('选择现在时间大于结束时间！', {icon: 5});
                } else {
                    endDate.config.min.year = date.year;
                    endDate.config.min.month = date.month - 1;
                    endDate.config.min.date = date.date;
                }
            } else {
                endDate.config.min.year = '1900';
                endDate.config.min.month = '1';
                endDate.config.min.date = '1';
            }
            $("#" + startId).change();
        }
    });

    var endDate = laydate.render({
        elem: '#' + stopId,
        min: laydateMinDate,
        done: function (value, date) {
            if (value !== '') {
                var maxDateYear = endDate.config.min.year;
                var maxDateMonth = endDate.config.min.month + 1;
                var maxDateDay = endDate.config.min.date;
                var maxDate = maxDateYear + "-" + maxDateMonth + "-" + maxDateDay;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(maxDate));
                if (time < time2) {
                    $("#" + stopId).val("");
                    top.layer.msg('选择现在时间小于开始时间！', {icon: 5});
                } else {
                    startDate.config.max.year = date.year;
                    startDate.config.max.month = date.month - 1;
                    startDate.config.max.date = date.date;
                }
            } else {
                startDate.config.max.year = '2099';
                startDate.config.max.month = '11';
                startDate.config.max.date = '31';
            }
            $("#" + stopId).change();
        }
    });
}

//渲染开始日期最大值为结束日期，结束日期最小值为开始日期(到时分秒)
//startId 开始日期元素id , stopId 结束日期元素id
//放在数据加载后执行，否则得不到元素数据
function loadStartDateAndStopDateToHour(startId, stopId) {
    var laydateMaxDate = "2099-12-31 23:59:59";
    var laydateMinDate = "1900-1-1 00:00:00";
    var startIdDate = $("#" + startId).val();
    var stopIdDate = $("#" + stopId).val();
    if (startIdDate != null && startIdDate != undefined && startIdDate != "") {
        laydateMinDate = startIdDate;
    }
    if (stopIdDate != null && stopIdDate != undefined && stopIdDate != "") {
        laydateMaxDate = stopIdDate;
    }
    var startDate = laydate.render({
        elem: '#' + startId,
        type: 'datetime',
        max: laydateMaxDate,
        done: function (value, date) {
            if (value !== '') {
                var minDateYear = startDate.config.max.year;
                var minDateMonth = startDate.config.max.month + 1;
                var minDateDay = startDate.config.max.date;
                var minDateHour = startDate.config.max.hours;
                var minDateMinute = startDate.config.max.minutes;
                var minDateSecond = startDate.config.max.seconds;
                var minDate = minDateYear + "-" + minDateMonth + "-" + minDateDay + " " + minDateHour + ":" + minDateMinute + ":" + minDateSecond;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(minDate));
                if (time > time2) {
                    $("#" + startId).val("");
                    top.layer.msg('选择现在时间大于结束时间！', {icon: 5});
                } else {
                    endDate.config.min.year = date.year;
                    endDate.config.min.month = date.month - 1;
                    endDate.config.min.date = date.date;
                    endDate.config.min.hours = date.hours;
                    endDate.config.min.minutes = date.minutes;
                    endDate.config.min.seconds = date.seconds;
                }
            } else {
                endDate.config.min.year = '1900';
                endDate.config.min.month = '1';
                endDate.config.min.date = '1';
                endDate.config.min.hours = '00';
                endDate.config.min.minutes = '00';
                endDate.config.min.seconds = '00';
            }
            $("#" + startId).change();
        }
    });

    var endDate = laydate.render({
        elem: '#' + stopId,
        type: 'datetime',
        min: laydateMinDate,
        done: function (value, date) {
            if (value !== '') {
                var maxDateYear = endDate.config.min.year;
                var maxDateMonth = endDate.config.min.month + 1;
                var maxDateDay = endDate.config.min.date;
                var maxDateHour = endDate.config.min.hours;
                var maxDateMinute = endDate.config.min.minutes;
                var maxDateSecond = endDate.config.min.seconds;
                var maxDate = maxDateYear + "-" + maxDateMonth + "-" + maxDateDay + " " + maxDateHour + ":" + maxDateMinute + ":" + maxDateSecond;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(maxDate));
                if (time < time2) {
                    $("#" + stopId).val("");
                    top.layer.msg('选择现在时间小于开始时间！', {icon: 5});
                } else {
                    startDate.config.max.year = date.year;
                    startDate.config.max.month = date.month - 1;
                    startDate.config.max.date = date.date;
                    startDate.config.max.hours = date.hours;
                    startDate.config.max.minutes = date.minutes;
                    startDate.config.max.seconds = date.seconds;
                }
            } else {
                startDate.config.max.year = '2099';
                startDate.config.max.month = '11';
                startDate.config.max.date = '31';
                startDate.config.max.hours = '23';
                startDate.config.max.minutes = '59';
                startDate.config.max.seconds = '59';
            }
            $("#" + stopId).change();
        }
    });
}

function loadStartDateAndStopDateToMonth(startId, stopId, maxDate, minDate) {
    var defaultLaydateMaxDate = "2099-12-31 23:59:59";
    if (maxDate != undefined && maxDate != "") {
        defaultLaydateMaxDate = maxDate;
    }
    var defaultLaydateMinDate = "1900-1-1 00:00:00";
    if (minDate != undefined && minDate != "") {
        defaultLaydateMinDate = minDate;
    }
    var maxValueDate = defaultLaydateMaxDate;
    var minValveDate = defaultLaydateMinDate;
    var startIdDate = $("#" + startId).val();
    var stopIdDate = $("#" + stopId).val();
    if (startIdDate != null && startIdDate != undefined && startIdDate != "") {
        minValveDate = startIdDate;
    }
    if (stopIdDate != null && stopIdDate != undefined && stopIdDate != "") {
        maxValueDate = stopIdDate;
    }
    var startDate = laydate.render({
        elem: '#' + startId,
        type: 'month',
        min: defaultLaydateMinDate,
        max: maxValueDate,
        done: function (value, date) {
            if (value !== '') {
                var maxDateYear = startDate.config.max.year;
                var maxDateMonth = startDate.config.max.month + 1;
                var maxDateParamter = maxDateYear + "-" + maxDateMonth;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(maxDateParamter));
                if (time > time2) {
                    $("#" + startId).val("");
                    top.layer.msg('选择现在时间大于结束时间！', {icon: 5});
                } else {
                    endDate.config.min.year = date.year;
                    endDate.config.min.month = date.month - 1;
                }
            } else {
                endDate.config.min.year = defaultLaydateMinDate.split("-")[0];
                endDate.config.min.month = defaultLaydateMinDate.split("-")[1] - 1;
            }
            $("#" + startId).change();
        }
    });

    var endDate = laydate.render({
        elem: '#' + stopId,
        type: 'month',
        min: minValveDate,
        max: defaultLaydateMaxDate,
        done: function (value, date) {
            if (value !== '') {
                var minDateYear = endDate.config.min.year;
                var minDateMonth = endDate.config.min.month + 1;
                var minDateParameter = minDateYear + "-" + minDateMonth;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(minDateParameter));
                if (time < time2) {
                    $("#" + stopId).val("");
                    top.layer.msg('选择现在时间小于开始时间！', {icon: 5});
                } else {
                    startDate.config.max.year = date.year;
                    startDate.config.max.month = date.month - 1;
                }
            } else {
                startDate.config.max.year = defaultLaydateMaxDate.split("-")[0];
                startDate.config.max.month = defaultLaydateMaxDate.split("-")[1] - 1;
            }
            $("#" + stopId).change();
        }
    });
}
