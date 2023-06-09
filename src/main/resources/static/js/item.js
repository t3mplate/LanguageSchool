var cart = {}; //корзина

$('document').ready(function(){
    loadGoods();
    checkCart();
    showMiniCart();
});

function loadGoods() {
    //загружаю товары на страницу
    $.getJSON('js/item.json', function (data) {
        var out = '';
        for (var key in data){
            out+='<div class="single-item">';
            out+='<h3 style="color: white">'+data[key]['name']+'</h3>';
            out+='<img src="'+data[key].img+'">';
            out+='<p style="color: white">Цена: '+data[key]['cost']+'р</p>';
            out+='<button class="add-to-cart" data-art="'+key+'">В корзину</button>';
            out+='</div>';
        }
        $('#item').html(out);
        $('button.add-to-cart').on('click', addToCart);
    });
}
function addToCart() {
    //добавляем товар в корзину
    var articul = $(this).attr('data-art');
    if (cart[articul]!=undefined) {
        cart[articul]++;
    }
    else {
        cart[articul] = 1;
    }
    localStorage.setItem('cart', JSON.stringify(cart) );
    //console.log(cart);
    showMiniCart();
}
function checkCart(){
    //проверяю наличие корзины в localStorage;
    if (localStorage.getItem('cart') != null) {
        cart = JSON.parse (localStorage.getItem('cart'));
    }
}

/*function showMiniCart(){
    var out ='';
    for (var i in cart){
        out += i + ' --- '+cart[i]+'<br>'; //хрень больше для более удобного дебага, показывает на index.html айдишники товаров и колличество их в корзине
    }                                      //просто чтоб в консоль не лазить :)
    $('#mini-cart').html(out);
} */
