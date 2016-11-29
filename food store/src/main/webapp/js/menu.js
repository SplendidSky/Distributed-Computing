
$(document).ready(function(){

    var menu = $("#menu");
    $(".plus").bind("click", function() {
        var amount = $(this).next();
        amount.text(parseInt(amount.text())+1);
    });

    $(".minus").bind("click", function() {
        var amount = $(this).prev();
        var current_amount = parseInt(amount.text());
        if (current_amount > 0) {
            amount.text(current_amount-1);          
        }
    });

    $("#commit").click(function() {
        var array = [];
        var empty = true;
        $(".amount").each(function(index) {

            if ($(this).text() != "0") {
                console.log($(this).text());
                empty = false;
            }

            var item = {
                "food_id": $(this).parent().attr("id"),
                "amount" : $(this).text()
            };
            array.push(item);
        });

        if (empty) {
            alert("餐品不能为空!");
            return;
        }

        //post
        $.ajax({
            type: "POST",
            url: "menu/commit",
            contentType: "application/json",
            data: JSON.stringify({
                "commits": array
            }),
            success: function () {
                // window.location.href = "/food_store/order-form?orderId="+id;
                window.location.href = "/food_store/order";
                console.log(1);
            }
        });

    });

});
