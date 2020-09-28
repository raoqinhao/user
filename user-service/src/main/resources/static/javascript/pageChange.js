// JavaScript Document
$(document).ready(function () {

    var page = 1;
    var tatol = $(".sliderBox .one-page").length;
    $(".nextChange").on("click", function () {
        page++;
        // if (page > tatol) {
        // 	page = 1;
        // }
        changeimages();
        changedotted();
    });
    $(".prevChange").click(function () {
        page--;
        // if (page < 1) {
        // 	page = tatol;
        // }
        changeimages();
        changedotted();
    });
    $(".rotationPoint span").click(function () {
        var index = $(this).attr("data-index");
        page = index;
        changeimages();
        changedotted();
    });

    function changedotted() {
        $(".rotationPoint span").eq(page - 1).siblings().removeClass("current");
        $(".rotationPoint span").eq(page - 1).addClass("current");
    }

    function changeimages() {
        $(".sliderBox .one-page").eq(page - 1).css("display", "block");
        $(".sliderBox .one-page").eq(page - 1).siblings().css("display", "none");
    }


});