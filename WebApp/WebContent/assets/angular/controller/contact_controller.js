'use strict';

angular.module('myApp').controller('ContactController',['$scope','ContactService', function($scope,ContactService){
	var self=this;
	self.contact={id:null, name:'',email:'',phone:'',fax:'',address:''};
	self.contacts=[];
	
	self.edit=edit;	
	self.submit=submit;
	self.remove=remove;
	self.reset=reset;
	
	fetchAllContacts();
	
	function fetchAllContacts(){
		
		ContactService.fetchAllContacts()
			.then(
					
			 function(d){
				 self.contacts=d;
			 },
			 
			 function(errResponse){
				console.error('Error while fetching Contacts'); 
			 }
		);
	}
	
	 function createContact(contact){
		 ContactService.createContact(contact)
	            .then(
	            		
	            fetchAllContacts,
	            function(errResponse){
	                console.error('Error while creating User');
	            }
	        );
	    }
	
	function updateContact(contact,id){
		
		ContactService.updateContact(contact,id)
		  .then(
				  fetchAllContacts,
		   
		   function(errResponse){
			   console.error('Error while updating contact');
		   }
		  );		  
	}
	
	 function deleteContact(id){
		 
	        ContactService.deleteContact(id)
	            .then(
	            		
	            fetchAllContacts,
	            
	            function(errResponse){
	                console.error('Error while deleting User');
	            }
	        );
	    }
	
	function submit(){
		if(self.contact.id===null){
			console.log('Saving New Contact', self.contact);
			createContact(self.contact);
		}else{
			updateContact(self.contact,self.contact.id);
			console.log('Contact update with id', self.contact.id);
		}
		
		reset();
	}
	
	function edit(id){
		
		console.log('id to be edited', id);
		
		for(var i=0;i<self.contacts.length;i++){
			
			if(self.contacts[i].id===id){
				self.contact=angular.copy(self.contacts[i]);
			}
		}
	}
	
	function remove(id){
		console.log('id to be deleted',id);
		
		if(self.contact.id===id){
			reset();
		}
		deleteContact(id);
	}
	
	function reset(){
		self.contact={id:null,email:'',name:'',phone:'',fax:'',address:''};
		$scope.myForm.$setPristine();
	}
	
}]);