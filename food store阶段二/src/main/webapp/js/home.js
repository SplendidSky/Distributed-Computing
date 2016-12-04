$(document).ready(function() {

    $("#err-password").hide();
    $("#err-nouser").hide();

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

    $("#logout").click(function() {
        // $.get("/food_store/logout", function(){
        //         window.href="/food_store/";
        // });

        $.ajax({
            type : 'GET',
            contentType : 'application/json',
            url : '/food_store/logout',
            dataType : 'text',
            success : function(data) {
                console.log(data);
                if (data == "1")
                    window.location.href = "/food_store/";
                else alert("登出失败");
            },
            error : function() {
                alert("error")
            }
        });

    });
});