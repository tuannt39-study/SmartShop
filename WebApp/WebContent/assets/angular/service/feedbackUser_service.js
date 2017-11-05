'use trict';

App.factory('UserFeedbackService',['$http','$q',function($http,$q){
	
	var REST_SERVICE_URI= 'http://localhost:8080/WebService/api/phan-hoi/';
	
	var xhr=new XMLHttpRequest();
	xhr.open("GET", REST_SERVICE_URI, true);
	
	var factory={
			createdFeedback:createdFeedback,			
	};
	
	return factory;
	
	function createdFeedback(feedback){
		var deferred =$q.defer();
		$http.post(REST_SERVICE_URI+"add", feedback)
			.then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('Error while creating User');
					deferred.reject(errResponse);
				}
			);
		return deferred.promise;
	}
}]);