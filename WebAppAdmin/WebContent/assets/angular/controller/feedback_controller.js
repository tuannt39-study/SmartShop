'use strict';

App.controller('FeedbackController',['$scope','FeedbackService',function($scope,FeedbackService){
	
	var self=this;
	
	self.feedback={id:null,name:'',email:'',phone:'',note:'',createTime:''};
	self.feedbacks=[];
	
	fetchAllFeedbacks();
	
	function fetchAllFeedbacks(){
		
		FeedbackService.fetchAllFeedbacks()
			.then(
			 
			 function(d){
				 self.feedbacks=d;				 
			    },
			 
			 function(errResponse){
				 consloe.error('Error while fetching Contacts');
			     }
			 
		    );
		}
  }]);