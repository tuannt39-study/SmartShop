'use strict';

App.controller('UserFeedbackController',['$scope','UserFeedbackService',function($scope,UserFeedbackService){
		
	var self=this;
	
	self.feedback={id:null,name:'', email:'',phone:'',note:''};
	self.feedbacks=[];
	
	self.submit=submit;
	
	function createdFeedback(feedback){
		UserFeedbackService.createdFeedback(feedback)
			.then(
			 function(errResponse){
				console.error('Error while creating User');				
			  } 		
		);
	}
	
	function submit(){
	 console.log('Saving New Contact', self.feedback);
	 createdFeedback(self.feedback);
	}
	
	function reset(){
		self.contact={id:null,email:'',name:'',phone:'',note:''};
		$scope.myForm.$setPristine();
	}
}]);