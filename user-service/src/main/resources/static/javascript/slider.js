// JavaScript Document
$(document).ready(function () {

    var page = 1;
    var tatol = $(".content-of-files .item").length;
    $(".next").click(function () {

        page++;

        if (page > tatol) {
            page = 1;
        }
        $(".item-part").eq(page - 1).siblings().removeClass("partThis");
        $(".item-part").eq(page - 1).addClass("partThis");
    });
    $(".pre").click(function () {
        page--;

        if (page < 1) {
            page = tatol;
        }
        $(".item-part").eq(page - 1).siblings().removeClass("partThis");
        $(".item-part").eq(page - 1).addClass("partThis");
        // changeimages();
        // changedotted();
    });
    $(".List-of-files li").click(function () {
        var index = $(this).attr("data-index");
        page = index;
        changeimages();
        changedotted();
    });

    function changedotted() {
        $(".List-of-files li ").eq(page - 1).siblings().removeClass("active");
        $(".List-of-files li").eq(page - 1).addClass("active");
    }

    function changeimages() {
        $(".content-of-files .item").eq(page - 1).css({"z-index": 1, "opacity": 1});
        $(".content-of-files .item").eq(page - 1).siblings().css({"z-index": 0, "opacity": 0});
    }


});