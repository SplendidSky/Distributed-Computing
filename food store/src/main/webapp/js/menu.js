
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
        $(".amount").each(function(index) {
            var item = {
                "food_id": $(this).parent().attr("id"),
                "amount" : $(this).text()
            };
            array.push(item);
        });

        //post
        $.ajax({
            type: "POST",
            url: "menu/commit",
            contentType: "application/json",
            data: JSON.stringify({
                "commits": array
            }),
            success: function (id) {
                window.location.href = "/food_store/order?orderId="+id;
            }
        });

    });

});
