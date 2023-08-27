$(document).ready(function (){
        $(".minusButton").on("click", function (evt){
                evt.preventDefault();
            decreaseQuantity($(this));

        });

    $(".plusButton").on("click", function (evt){
        evt.preventDefault();
        increaseQuantity($(this));

    });
});

function decreaseQuantity(link){
    productId  = link.attr("pid");
    qtyInput = $("#quantity" + productId);
    qtyCard = link.attr("cardq");
    cardId = link.attr("cardid");
    additionId = link.attr("additionid");

    newQty = parseInt(qtyInput.val())-1;
    qtyCardInt = parseInt(qtyCard);

    if(newQty > 0) {
        qtyInput.val(newQty);
        updateQuantity(productId, newQty, cardId, additionId, qtyCardInt-1);
    }
}

function increaseQuantity(link){
    productId  = link.attr("pid");
    qtyInput = $("#quantity" + productId);
    qtyCard = link.attr("cardq");
    cardId = link.attr("cardid");
    additionId = link.attr("additionid");

    newQty = parseInt(qtyInput.val())+1;
    qtyCardInt = parseInt(qtyCard);

    if(newQty < 10) {
        qtyInput.val(newQty);
        updateQuantity(productId, newQty, cardId, additionId,qtyCardInt+1);
    }
}

function updateQuantity(productId, quantity, cardId, additionId, quantityCard){
    let url = "/personal/products/update/" + cardId + "/" + productId + "/" + additionId + "/" + quantity + "/" + quantityCard;

    $.ajax({
        type:"POST",
        url: url

    }).done(function(newSubtotal){
        updateSubtotal(newSubtotal, productId);
        updateTotal();
    }).fail(function (){
        $("#modal").modal;
    });
}

function updateSubtotal(newSubtotal, productId){
    $("#subtotal" + productId).text(newSubtotal);
}
function updateTotal(){
    total = 0.0;

    $(".productSubtotal").each(function (index, element){
       total = total+ parseFloat(element.innerHTML);
    });
    $("#totalAmount").text("₴"+total)
}