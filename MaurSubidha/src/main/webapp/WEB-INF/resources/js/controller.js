var cartApp = angular.module ("cartApp", []);
 
cartApp.controller("cartCtrl", function($scope, $http){
 
    $scope.refreshCart = function(){
       $http.get('http://localhost:9002/Project1/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };
 
    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
 
    $scope.addToCart= function(productId){
        $http.post('http://localhost:9002/Project1/rest/cart/add/' + productId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };
    
    $scope.removeFromCart= function(cartItemid){
    	alert('Product successfully removed to the cart!');
        $http.put('http://localhost:9002/Project1/rest/cart/remove/' + cartItemid).success(function(){
        	
           $scope.refreshCart();
        });
    };
    
    $scope.clearCart= function(){
        $http.post('http://localhost:9002/Project1/rest/cart/' + $scope.cartId).success(function(){
        	 $scope.refreshCart();
        });
    };
    
    $scope.calGrandTotal= function(){
        var grandTotal = 0;
 
        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
 
        return grandTotal;
    }
 
});