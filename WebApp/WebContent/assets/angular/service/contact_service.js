'use strict';

angular.module('myApp').factory('ContactService',['$http','$q', function($http,$q){
	
	var REST_SERVICE_URI = 'http://localhost:8083/WebService/api/lien-he/';
	
	var xhr = new XMLHttpRequest();
	xhr.open("GET", REST_SERVICE_URI, true);
	
	var factory={
			fetchAllContacts:fetchAllContacts,
			updateContact:updateContact,
			createContact:createContact
	};
	
	return factory;
	
	function fetchAllContacts(){
		
		var deferred=$q.defer();
		
		 $http.get(REST_SERVICE_URI + "all")
         .then(
        		 
         function (response) {
             deferred.resolve(response.data);
         },
         
         function(errResponse){
             console.error('Error while fetching Contacts');
             deferred.reject(errResponse);
         }
     );
		 
     return deferred.promise;
	}
	
	 function createContact(contact) {
		 
	        var deferred = $q.defer();
	        
	        $http.post(REST_SERVICE_URI + "add", contact)
	            .then(
	            		
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            
	            function(errResponse){
	                console.error('Error while creating User');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
	function updateContact(contact,id){
		
		var deferred=$q.defer();
		
		$http.put(REST_SERVICE_URI+"update/"+id, contact)
		   .then(
				   
			function (response){
				deferred.resolve(response.data);
			},
			
			function (errResponse){
				console.error('Error while updating Contact');
				deferred.reject(errResponse);
			 }
		   );
		return deferred.promise;
	}
	
	function deleteContact(id) {
		
        var deferred = $q.defer();
        
        $http.delete(REST_SERVICE_URI + "delete/" + id)
            .then(
            		
            function (response) {
                deferred.resolve(response.data);
            },
            
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);
	