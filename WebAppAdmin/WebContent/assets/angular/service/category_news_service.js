'use strict';

App.factory('CategoryNewsService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WebService/api/danh-muc/';

	var xhr = new XMLHttpRequest();
	xhr.open("GET", REST_SERVICE_URI, true);

    var factory = {
        fetchAllCategoryNews: fetchAllCategoryNews,
        createCategoryNews: createCategoryNews,
        updateCategoryNews:updateCategoryNews,
        deleteCategoryNews:deleteCategoryNews
    };

    return factory;
    
    function fetchAllCategoryNews() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "news/all")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching CategoryNews');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createCategoryNews(news) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "add", news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating CategoryNews');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateCategoryNews(news, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "update/" + id, news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating CategoryNews');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCategoryNews(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "delete/" + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting CategoryNews');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
