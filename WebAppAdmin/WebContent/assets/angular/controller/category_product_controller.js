'use strict';

App.controller('CategoryProductController', ['$scope', 'CategoryProductService', function($scope, CategoryProductService) {
    var self = this;

    self.product={id:null,name:'',note:''};
    self.products=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllCategoryProduct();

    function fetchAllCategoryProduct(){
    	CategoryProductService.fetchAllCategoryProduct()
            .then(
            function(d) {
                self.products = d;
            },
            function(errResponse){
                console.error('Error while fetching CategoryProduct');
            }
        );
    }

    function createCategoryProduct(product){
    	CategoryProductService.createCategoryProduct(product)
            .then(
        		fetchAllCategoryProduct,
            function(errResponse){
                console.error('Error while creating CategoryProduct');
            }
        );
    }

    function updateCategoryProduct(product, id){
        CategoryProductService.updateCategoryProduct(product, id)
            .then(
            fetchAllCategoryProduct,
            function(errResponse){
                console.error('Error while updating CategoryProduct');
            }
        );
    }

    function deleteCategoryProduct(id){
        CategoryProductService.deleteCategoryProduct(id)
            .then(
            fetchAllCategoryProduct,
            function(errResponse){
                console.error('Error while deleting CategoryProduct');
            }
        );
    }

    function submit() {
        if(self.product.id===null){
            console.log('Saving New CategoryProduct', self.product);
            createCategoryProduct(self.product);
        }else{
            updateCategoryProduct(self.product, self.product.id);
            console.log('CategoryProduct updated with id ', self.product.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.products.length; i++){
            if(self.products[i].id === id) {
                self.product = angular.copy(self.products[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.product.id === id) {//clean form if the CategoryProduct to be deleted is shown there.
            reset();
        }
        deleteCategoryProduct(id);
    }


    function reset(){
        self.product={id:null,name:'',note:''};
        $scope.myFormProduct.$setPristine(); //reset Form
    }
    
}]);
