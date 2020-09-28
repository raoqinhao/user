var divWidth = 0;
var divHeight = 0;

function BOX_show(e, Left, Top, Width, Height) {
    if (document.getElementById(e) == null) {
        alert("找不到对应的对话框唯一标识！");
        return;
    }
    divWidth = Width;
    divHeight = Height;
    if (document.getElementById(e + "_title") != null) {
        drag(e);
    }
    BG_layout();
    BOX_layout(e, Left, Top, Width, Height);
    //改变窗体重新调整位置
    window.onresize = function () {
        BG_layout();
        BOX_layout(e, Left, Top, Width, Height);
    }
    //滚动窗体重新调整位置
    window.onscroll = function () {
        BG_layout();
    }
}

//影藏显示层
function BOX_remove(e) {
    window.onscroll = null;
    window.onresize = null;
    document.getElementById(e).style.display = "none";
    document.getElementById('BOX_overlay').style.display = "none";
}

//背景层
function BG_layout() {
    //判断是否新建遮掩层
    if (document.getElementById('BOX_overlay') == null) {
        var overlay = document.createElement("div");
        overlay.setAttribute('id', 'BOX_overlay');
        document.body.appendChild(overlay);
    }
    var bo = document.getElementById('BOX_overlay');
    bo.style.left = '0px';
    bo.style.top = '0px';
    bo.style.width = getWidth() + "px";
    if (scrollPosHeight() == 0) {
        bo.style.height = "100%";
    } else {
        bo.style.height = parseInt(getHeight() + scrollPosHeight()) + "px";
    }
    bo.style.zIndex = "886";
    bo.style.display = "";
}

//显示层
function BOX_layout(e, Left, Top, Width, Height) {
    var a = document.getElementById(e);
    a.style.display = "";
    a.style.left = parseInt((getWidth() - Width) / 2) + "px";
    var topHeight = parseInt(getHeight() * 2 / 3 - Height);
    if (scrollPosHeight() == 0 || topHeight < 0) {
        a.style.top = Top + "px";
    } else {
        a.style.top = parseInt(topHeight + scrollPosHeight()) + "px";
    }
    a.style.width = Width + "px";
    a.style.height = Height + "px";
    a.style.zIndex = "887";
}

function HiddenButton(e) {
    e.style.visibility = 'hidden';
    e.previousSibling.style.visibility = 'visible'
}

//获取窗口宽度
function getWidth() {
    var winWidth = 0;
    if (window.innerWidth) {
        winWidth = window.innerWidth;
    } else if ((document.body) && (document.body.clientWidth)) {
        winWidth = document.body.clientWidth;
    }
    //通过深入Document内部对body进行检测，获取窗口大小
    if (document.documentElement && document.documentElement.clientWidth) {
        winWidth = document.documentElement.clientWidth;
    }
    return winWidth;
}

//获取窗口高度
function getHeight() {
    var winHeight = 0;
    if (window.innerHeight) {
        winHeight = window.innerHeight;
    } else if ((document.body) && (document.body.clientHeight)) {
        winHeight = document.body.clientHeight;
    }
    return winHeight;
}

//获得窗体内容滚动及获取滚动条的偏移值 
function scrollPosHeight() {
    var scrollPos;
    //window.pageYOffset是NS专用属性，它的含义和IE下的document.body.scrollTop一样 
    if (typeof window.pageYOffset != 'undefined') {
        scrollPos = window.pageYOffset;
    } else if (typeof document.compatMode != 'undefined' && document.compatMode != 'BackCompat') {
        scrollPos = document.documentElement.scrollTop;
    } else if (typeof document.body != 'undefined') {
        scrollPos = document.body.scrollTop;
    }
    return scrollPos;
}

//拖动窗口
function drag(o) {
    if (typeof o == "string") {
        title = document.getElementById(o + "_title");
        o = document.getElementById(o);
    }
    o.orig_x = parseInt(o.style.left) - document.body.scrollLeft;
    o.orig_y = parseInt(o.style.top) - document.body.scrollTop;
    o.orig_index = o.style.zIndex;

    title.onmousedown = function (a) {
        this.style.cursor = "move";
        this.style.zIndex = 887;
        var d = document;
        if (!a) a = window.event;
        var x = a.clientX + d.body.scrollLeft - o.offsetLeft;
        var y = a.clientY + d.body.scrollTop - o.offsetTop;
        d.ondragstart = "return false;"
        d.onselectstart = "return false;"
        d.onselect = "document.selection.empty();"

        if (o.setCapture)
            o.setCapture();
        else if (window.captureEvents)
            window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);

        d.onmousemove = function (a) {
            if (!a) a = window.event;
            var moveleft = a.clientX + document.body.scrollLeft - x;
            if (moveleft > (getWidth() - divWidth - 3) || moveleft < 0) {
                return false;
            } else {
                o.style.left = moveleft;
            }
            var movetop = a.clientY + document.body.scrollTop - y;
            //很无语的IE定点问题，时不时会出现能下移的现象，必须加上i这个参数
            var i = 0;
            if (divHeight > 160) {
                i = 12;
            }
            if (movetop > (getHeight() - divHeight - 8 - i) || movetop < 0) {
                return false;
            } else {
                o.style.top = movetop;
            }
            o.orig_x = parseInt(o.style.left) - document.body.scrollLeft;
            o.orig_y = parseInt(o.style.top) - document.body.scrollTop;
        }

        d.onmouseup = function () {
            if (o.releaseCapture)
                o.releaseCapture();
            else if (window.captureEvents)
                window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
            d.onmousemove = null;
            d.onmouseup = null;
            d.ondragstart = null;
            d.onselectstart = null;
            d.onselect = null;
            o.style.cursor = "normal";
            o.style.zIndex = 887;
        }
    }
}  