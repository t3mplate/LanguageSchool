var cart = {}; //корзина

$.getJSON('js/item.json', function (data) {
    var item = data; //все товары в массиве
    //console.log(item);
    checkCart();
    //console.log(cart);
    showCart(); //вывожу товары на страницу

    function showCart() {
        var out = '';
        for (var key in cart) {
            out += '<div class="my-cart">';
            out += '<button class="delete" data-art="'+key+'">x</button>';
            out += '<div class="img-cart">';
            out += '<img src="'+item[key].img+'">';
            out += '</div>';
            out += item[key].name;
            out += '<button class="minus" data-art="'+key+'">-</button>';
            out += cart[key];
            out += '<button class="plus" data-art="'+key+'">+</button>';
            out += cart[key]*item[key].cost;
            out += '<br>';
            out += '</div>';
        }
        $('#my-cart').html(out);
        $('.plus').on('click', plusItem);
        $('.minus').on('click', minusItem);
        $('.delete').on('click', deleteItem);
    }
    function plusItem(){
        var articul = $(this).attr('data-art');
        cart[articul]++;
        saveCartToLS(); //сохраняю корзину в localStorage
        showCart();
    }
    function minusItem(){
        var articul = $(this).attr('data-art');
        if (cart[articul]>1) {
            cart[articul]--;
        }
        else {
            delete cart[articul];
        }
        saveCartToLS();//сохраняю корзину в localStorage
        showCart();
    }

    function deleteItem(){
        var articul = $(this).attr('data-art');
        delete cart[articul];
        saveCartToLS();//сохраняю корзину в localStorage
        showCart();
    }
});

function checkCart() {
    //проверяю наличие корзины в localStorage;
    if (localStorage.getItem('cart') != null) {
        cart = JSON.parse(localStorage.getItem('cart'));
    }
}
function saveCartToLS(){
    localStorage.setItem('cart', JSON.stringify(cart) );
}
