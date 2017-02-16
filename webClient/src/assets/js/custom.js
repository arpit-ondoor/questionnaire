//JavaScript Document
$(document).ready(function(){

	/*
  $('input.suggest_brand').autocomplete({
    data: {
      "Apple": null,
      "Microsoft": null,
      "Google": 'http://placehold.it/250x250'
    }
  });
  */
  /*--------*/  
});

/*
Checkbox activity on
WMS- Product List
*/
$(document).on('change','input[type="checkbox"]',function(){
	if($(this).is(':checked')){
		var $toastContent = $('<span>Pruduct Published on Live Site</span>');
  		Materialize.toast($toastContent, 3000);
	}else{
		var $toastContent = $('<span>Product Unpublished</span>');
  		Materialize.toast($toastContent, 3000);
	}
});

/*
Toggle slide for 
WMS- filter product by category
*/

$(document).on('click','ul.filter>li>a',function(){
	$(this).parent('li').children('ul').stop().slideToggle();	
	$(this).parents('li').siblings('li').children('a').removeClass('active');
		$(this).toggleClass('active');
	$(this).closest('ul').toggleClass('active');
});

//subcategories
$(document).on('click','.filter.cat_main > li',function(){
	$(this).siblings('li').children('ul.subcat').slideUp();
})

//leafcats
// $(document).on('click','.leaflist li',function(){
// 	$(this).parents('ul').siblings('ul').slideUp();	
// })

$(document).on('click','.subcat>li>a',function(){
	$(this).closest('li').children('ul').stop().slideToggle();
	$(this).closest('li').siblings('li').children('ul').slideUp();
	//$(this).children('ul').slideToggle();	
	//$(this).siblings('li').children('ul').slideUp();
})

//tag inputs
/*
$(document).on('click','.category-tags li',function(){
	$(this).remove();
})
*/


//category add dynamically
/*
$(document).on('click','.catsuggestions ul>li',function(){
	var newcat = $(this).text();
	var newcatId=$(this).attr("catid");

	console.log(newcatId);
	$('ul.category-tags').append('<li><a (click)="removeCat()">'+ newcat +'</a></li>');
	$('.catsuggestions ul>li').remove();
	$('#product-category-input').val('').focus();	
	 $('input.catlabel:last-child').val(newcat).focus().blur();
})
*/
//Show image before upload
function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
            };
            reader.readAsDataURL(input.files[0]);
        }
    }