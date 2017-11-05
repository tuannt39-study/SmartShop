'use strict';

App.factory('NewsService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WebService/api/tin-tuc/';

	var xhr = new XMLHttpRequest();
	xhr.open("GET", REST_SERVICE_URI, true);

    var factory = {
        fetchAllNews: fetchAllNews,
        createNews: createNews,
        updateNews:updateNews,
        deleteNews:deleteNews
    };

    return factory;

    function fetchAllNews() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "all")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createNews(news) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "add", news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateNews(news, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "update/" + id, news)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteNews(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "delete/" + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting News');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
