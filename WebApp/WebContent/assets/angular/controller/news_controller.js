'use strict';

angular.module('myApp').controller('NewsController', ['$scope', 'NewsService', function($scope, NewsService) {
    var self = this;

    self.news={id:null,title:'',brief:'',content:'',categoryID:'',userID:'',createdTime:''};
    self.newss=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllNews();

    function fetchAllNews(){
    	NewsService.fetchAllNews()
            .then(
            function(d) {
                self.newss = d;
            },
            function(errResponse){
                console.error('Error while fetching News');
            }
        );
    }

    function createNews(news){
    	NewsService.createNews(news)
            .then(
        		fetchAllNews,
            function(errResponse){
                console.error('Error while creating News');
            }
        );
    }

    function updateNews(news, id){
        NewsService.updateNews(news, id)
            .then(
            fetchAllNews,
            function(errResponse){
                console.error('Error while updating News');
            }
        );
    }

    function deleteNews(id){
        NewsService.deleteNews(id)
            .then(
            fetchAllNews,
            function(errResponse){
                console.error('Error while deleting News');
            }
        );
    }

    function submit() {
        if(self.news.id===null){
            console.log('Saving New News', self.news);
            createNews(self.news);
        }else{
            updateNews(self.news, self.news.id);
            console.log('News updated with id ', self.news.id);
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
        if(self.news.id === id) {//clean form if the News to be deleted is shown there.
            reset();
        }
        deleteNews(id);
    }


    function reset(){
        self.news={id:null,title:'',brief:'',content:'',categoryID:'',userID:'',createdTime:''};
        $scope.myFormNews.$setPristine(); //reset Form
    }
    
}]);
