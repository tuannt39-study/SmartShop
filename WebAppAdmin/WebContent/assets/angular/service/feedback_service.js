'use trict';

App.factory('FeedbackService',['$http','$q',function($http,$q){
	
	var REST_SERVICE_URI='http://localhost:8080/WebService/api/phan-hoi/';
	
    var xhr=new XMLHttpRequest();
    xhr.open("GET",REST_SERVICE_URI,true);
    
    var factory={
    		fetchAllFeedbacks:fetchAllFeedbacks
    };
    
    return factory;
    
    function fetchAllFeedbacks(){
    	
    	var deferred=$q.defer();
    	
    	$http.get(REST_SERVICE_URI +"all")
    	.then(
    			
    			function (response){
    				deferred.resolve(response.data);
    			},
    			
    			function(errRespone){
    				deferred.error('Error while fatching Contacts');
    				deferred.reject(errResponse);
    			}
    	);
    	
    	return deferred.promise;
    }
}]);
