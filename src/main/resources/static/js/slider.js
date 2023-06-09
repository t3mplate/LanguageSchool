var slideIndex = 1;//переменная для индексации слайда
showSlides(slideIndex);

// Кнопки вперед, назад
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Круглые кнопки
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");//переменная для всего слайдера
  var dots = document.getElementsByClassName("dot");//переменная круглых кнопок
  if (n > slides.length) {slideIndex = 1}//отображается слайд 1, если n > количества слайдов
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";//прячем другие слайды
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");//круглая кнопка активирована, если на ней необходимый слайд
  }
  slides[slideIndex-1].style.display = "block";//отображение слайда
  dots[slideIndex-1].className += " active";//отображение кнопки
}