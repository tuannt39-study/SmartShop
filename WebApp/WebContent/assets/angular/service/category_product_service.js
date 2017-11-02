'use strict';

angular.module('myApp').factory('CategoryProductService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WebService/api/danh-muc/';

	var xhr = new XMLHttpRequest();
	xhr.open("GET", REST_SERVICE_URI, true);

    var factory = {
        fetchAllCategoryProduct: fetchAllCategoryProduct,
        createCategoryProduct: createCategoryProduct,
        updateCategoryProduct:updateCategoryProduct,
        deleteCategoryProduct:deleteCategoryProduct
    };

    return factory;

    function fetchAllCategoryProduct() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "product/all")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching CategoryProduct');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createCategoryProduct(product) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "add", product)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating CategoryProduct');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateCategoryProduct(product, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "update/" + id, product)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating CategoryProduct');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCategoryProduct(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "delete/" + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting CategoryProduct');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
}]);
