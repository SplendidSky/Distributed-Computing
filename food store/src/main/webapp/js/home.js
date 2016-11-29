$(document).ready(function() {
    $(".radio").bind("click", function() {
        var city = $(this).attr("value");
        var current, next;

        current = $(".slide-in");
        switch (city) {
            case "北京":
                next = $("#bj");
                break;
            case "广东":
                next = $("#gd");
                break;
            case "四川":
                next = $("#sc");
                break;
        }

        next.addClass("slide-wait");
        next.fadeIn("fast", function() {});
        current.fadeOut("slow", function() {
            current.removeClass("slide-in");
            next.removeClass("slide-wait");
            next.addClass("slide-in");
        });
    });

    $("#search-bt").click(function() {
        var value = $("#search").val();
        var href = "/food_store/?keyword=" + value;
        window.location.href = href;
    });
});