'use strict';

App.controller('CategoryNewsController', ['$scope', 'CategoryNewsService', function($scope, CategoryNewsService) {
    var self = this;
    
    self.news={id:null,name:'',note:''};
    self.newss=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllCategoryNews();

    function fetchAllCategoryNews(){
    	CategoryNewsService.fetchAllCategoryNews()
            .then(
            function(d) {
                self.newss = d;
            },
            function(errResponse){
                console.error('Error while fetching CategoryNews');
            }
        );
    }

    function createCategoryNews(news){
    	CategoryNewsService.createCategoryNews(news)
            .then(
        		fetchAllCategoryNews,
            function(errResponse){
                console.error('Error while creating CategoryNews');
            }
        );
    }

    function updateCategoryNews(news, id){
        CategoryNewsService.updateCategoryNews(news, id)
            .then(
            fetchAllCategoryNews,
            function(errResponse){
                console.error('Error while updating CategoryNews');
            }
        );
    }

    function deleteCategoryNews(id){
        CategoryNewsService.deleteCategoryNews(id)
            .then(
            fetchAllCategoryNews,
            function(errResponse){
                console.error('Error while deleting CategoryNews');
            }
        );
    }

    function submit() {
        if(self.news.id===null){
            console.log('Saving New CategoryNews', self.news);
            createCategoryNews(self.news);
        }else{
        	updateCategoryNews(self.news, self.news.id);
            console.log('CategoryNews updated with id ', self.news.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.newss.length; i++){
            if(self.newss[i].id === id) {
                self.news = angular.copy(self.newss[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.news.id === id) {//clean form if the CategoryProduct to be deleted is shown there.
            reset();
        }
        deleteCategoryNews(id);
    }

    function reset(){
        self.news={id:null,name:'',note:''};
        $scope.myFormNews.$setPristine(); //reset Form
    }
    
}]);
