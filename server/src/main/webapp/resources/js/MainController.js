app = angular.module("myapp", ["ngRoute","ui.router"]);

app.config(function($routeProvider, $httpProvider, $locationProvider,$stateProvider, $urlRouterProvider) {

    $stateProvider
.state('product', {
url: 'resources/static/js/message/message.html',
views: {
	'': { templateUrl: 'Product.html' },
	'columnOne@about': { template: 'Look I am a column!' }
	}

});
	
	//    $routeProvider
	
    /*.when("/Product", {
        templateUrl : "Product.html"
    })    .when(HTMLPATH+'/Product.html', {
        template: '<h2>ABC</h2> from the template'
    })
    .when("#red", {
        templateUrl : HTMLPATH+"/product/test"
    })
    .when("/green", {
        templateUrl : "green.htm"
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });*/
});
app.controller("MainController", function($scope, $http) {
	
  $scope.menus = [{
    title: "Menu1", 
    action: "#", 
    menus: [{
        title: "Product",
        action: "Product.html"
      },{
        title: "Inwarding",
        action: "Product.html",
        menus: [{
            title: "Menu 3",
            action: "stuff"
          },{
            title: "Menu 4",
            action: "moreStuff"
          }]
      }]
  },{
    title: "Menu2", 
    action: "#", 
    menus: [{
        title: "Submenu 2a",
        action: "awesomeStuff"
      },{
        title: "Submenu 2b",
        action: "moreAwesomeStuff"
      }]
  }]
  
  
  $scope.saveUpdate = function(product){
		
		 formData =  {
				"brand": product.brand,
				"product": product.product,
				"rate_mode":product.rate_mode,
				"description":product.description,
				"ingredient_desc":product.ingredient_desc,
				"quantity":product.quantity,
				"packaging_type":product.packaging_type,
				"MRP":product.MRP,
				"purchase_rate":product.purchase_rate,
				"orp":product.orp,
				"scheme":product.scheme,
				"shelf_life":product.shelf_life
		}
		
 		/*var  data  = {
					 	"product": {

					 		"quantity": ""
					 	},
					 	"productDescription": {
					 		"brand": "",
					 		"name": "",
					 		"unit": {
					 			"id": "1"
					 		},
					 		"packaging": {
					 			"id": "1"
					 		},
					 		"scheme": "",
					 		"company": {
					 			"id": ""
					 		},
					 		"category": {
					 			"id": ""
					 		},
					 		"barcode": {
					 			"id": ""
					 		},
					 		"purUnit": {
					 			"id": ""
					 		},
					 		"shelfLife": "",
					 		"purchRate": "",
					 		"mrp": "",
					 		"rateMode": ""
					 	}
					 }*/
		 $http({
//		        url: 'http://localhost:8080/ondoortotal/product/save',
		        url: 'http://localhost:8080/product/save',
		        method: "POST",
		        data: formData,
		        headers: {'Content-Type': 'application/json'}
		    })
		    .then(function(response) {
		    	alert('Success');
		    }, 
		    function(response) { // optional
		    	alert('Fail');
		            // failed
		    });
	}
	
  
  function fetchMenus(){
	  console.log('Menus*********');
      $http.post("http://localhost:8080/auth/")
          .then(
          function (response) {
//              deferred.resolve(response.data);
//              console.log("response",response);
          },
          function(errResponse){
              console.error('Error while creating User');
//              deferred.reject(errResponse);
          }
      );
//      return deferred.promise;
  }
  
  

});

$(document).ready(function() {});