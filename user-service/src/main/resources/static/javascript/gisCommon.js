$(document).ready(function () {


    var listItemA = $(".list-item>a"),
        littleList = $(".little-list");
    $('.list-item>a').on("click", function () {
        var href = $(this).next('ul').children('li:first-child').children('a').attr('href');
        $(".list-item").removeClass('up')
        $(this).parent('li').addClass('up');
        if ($(this).next('ul').css("display") == "none") {
            $(".little-list").hide();
            $(this).next('ul').css("display", "inline-block");
            $(this).next('ul').children('li:first-child').addClass('on');
            $(this).next('ul').children('li:first-child').siblings().removeClass('on');
            $("#iframe").attr("src", href);
            $('.little-list').prev('a').children('i').removeClass('layui-icon-triangle-f').addClass(
                'layui-icon-triangle-d')
            $(this).children('i').removeClass('layui-icon-triangle-d').addClass(
                'layui-icon-triangle-r');

        } else if (littleList) {
            $('.list-item>a').children('i').removeClass('layui-icon-triangle-r').addClass(
                'layui-icon-triangle-d')
            $(this).next('ul').css("display", "inline-block");
            $(".little-list").hide()
        } else {
            $(this).children('i').removeClass('layui-icon-triangle-r').addClass(
                'layui-icon-triangle-d');
            $(this).next('ul').css("display", "none");
            $(this).next('ul').children('li').removeClass('on');
        }
    })
    $(".little-list li a").click(function () {
        $(this).parent('li').siblings().removeClass('on')
        $(this).parent('li').addClass('on')
    })
    $(".chart-tab-title li").each(function (index) {
        $(this).click(function () {
            $(".chart-tab-title li.select-this").removeClass('select-this');
            $(this).addClass('select-this');
            $(".chart-tab-title li p").css("color", "#000");
            $(this).children('p').css("color", "#2ac58e");
            $(".layui-card-body div.chart-show").removeClass('chart-show');
            $(".layui-card-body .chart-item").eq(index).addClass("chart-show");
        })
    });
    $(".processNum").mouseover(function () {
        $(this).parent().next().show()
    });
    // $(".Step").mouseover(function() {

    //     $(".show-box").eq(index).
    // });
    $(".Step").each(function (index) {
        $(this).mouseover(function () {
            $(".show-box").eq(index).show();
        });
        ;

    });
    $(".toggle").mouseover(function () {
        $(this).children('.navigationBox').show()
    });
    $(".navigationBox").mouseout(function () {
        $(this).hide()
    });
    $(".close").click(function () {
        $(this).parent().parent().hide()
    });
    $(".query-criteria").click(function () {
        $(this).next('ul').toggle();
        if ($(this).next('ul').css("display") == "none") {
            $(this).children('i').removeClass('icon-triangle').addClass(
                'icon-dsj');
        } else {
            $(this).children('i').removeClass('icon-dsj').addClass(
                'icon-triangle');
        }
    });
    $(".w-i").click(function () {
        $(this).parent().next('.layui-card-body').toggle();
        if ($(this).parent().next('.layui-card-body').css("display") == "none") {
            $(this).removeClass('layui-icon-right').addClass(
                'layui-icon-down');
        } else {
            $(this).removeClass('layui-icon-down').addClass(
                'layui-icon-right');
        }
    });
    $(".loginBox .layui-input").focus(function () {
        $(this).prev().css('color', '#4d7aff');
    }).blur(function () {
        $(this).prev().css('color', '#d2d2d2');
    });

    $(".dbclick").dblclick(function () {
        var texts = $(".dbclick").val();
        layer.config({
            skin: 'green'
        })
        layer.open({
            type: 0,
            title: '审核或审批记录',
            area: ['500px', '300px'],
            content: texts
        });
    });
    $('.serch').on('click', function () {
        layer.config({
            skin: 'green'
        })
        layer.open({
            type: 2,
            title: '一键搜',
            // offset: '200px',
            shadeClose: true,
            shade: 0.8,
            area: ['100%', '100%'],
            content: '/a-search.html'
        });
    });

    $(".head-btn").click(function () {
        $(this).next().toggle();
        $(this).next().next().toggle()
    });
    $(".layui-btn-container button").each(function () {
        $(this).click(function () {
            $(".layui-btn-container button").removeClass('currentThis');
            $(this).addClass('currentThis');
        })
    })

    $(".regional-list li").mouseover(function (index) {
        $(".regional-list li").removeClass('current');
        $(this).addClass('current');
    })


    $(function () {
        $(".regional-list li").each(function (index) {
            $(this).mouseover(function () {
                $(".regional-list li.current").removeClass("current");
                $(this).addClass("current");
                $(".second-tab-content .item-show").removeClass("item-show");
                $(".second-tab-content .tab-item").eq(index).addClass("item-show");
            });
        })

        $(".List-of-files li").each(function (index) {
            $(this).click(function () {
                $(".List-of-files li.active").removeClass("active");
                $(this).addClass("active");
                $(".content-of-files .current").removeClass("current");
                $(".content-of-files .item").eq(index).addClass("current");
            });
        })
    });

    $(".step-item").each(function (index) {
        $(this).click(function () {

            $(this).children('.surface').toggle()
        })
    })


    $(".btn-delect").each(function () {
        $(this).click(function () {
            $(this).parent().remove()
        })
    })
    $(".icon-sla").click(function () {
        $(this).parent().parent().css("display", "none")
    });
    $(".party1").click(function () {
        $("#party1").show()
    });
    $(".party2").click(function () {
        $("#party2").show()
    });
    $(".collapse-title").each(function (index) {
        $(this).click(function () {
            $(".table-item .current").removeClass("current");
            $(".table-item").eq(index).toggle();

        })
    })
})