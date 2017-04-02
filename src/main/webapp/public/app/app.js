define(['angular', 'angular-message', '$', 'bootbox'], function(angular) {
	'use strict';	
	
	// Create the angularjs app
    var app = angular.module('sphApp', ['ngMessages']);

    // Initialize the angularjs app
    app.init = function () {
    	angular.bootstrap(document, ['sphApp']);    	
    }
    
    // Create a controller
	app.controller('ArticleCtrl', ['$scope', 'ArticleService', 'ArticleUIService', function($scope, ArticleService, ArticleUIService){
				
		ArticleService.getArticles(postFetchAll);
		
		ArticleUIService.initializer($scope);
		
		// Function will trigger for read icon, which is the data-table is clicked
		$scope.articleView = function(id) {
			ArticleUIService.clearMessage($scope);
			$scope.readonly = true;
			ArticleService.getArticle(id, preEdit);
		};
		
		// Function will trigger for edit icon, which is the data-table is clicked		
		$scope.articleEdit = function(id) {
			ArticleUIService.clearMessage($scope);
			$scope.readonly = false;
			ArticleService.getArticle(id, preEdit);
		};
		
		// Function will trigger for delete icon, which is the data-table is clicked
		$scope.articleDelete = function(article) {
			ArticleUIService.clearMessage($scope);
			bootbox.confirm({
				title: 'Delete Article Confirmation',
				message: 'This action will delete the Article <h5><i>' + article.headline + '</i></h5> from the system permanently.',
				callback: function(result) {
					if(result) {
						ArticleService.deleteArticle(article, postDelete);
					}
				},
				onEscape: false
			});							
		};
		
		// Function will trigger for either creating a new article or updating an existing article
		$scope.addArticle = function() {
			ArticleUIService.clearMessage($scope);
			$scope.readonly = false;
			if ($scope.article.id == undefined) {
				ArticleService.createArticle($scope.article, postSave);
			} else {
				ArticleService.updateArticle($scope.article, postSave);
			}			
		};
		
		// To navigate from data-table view to form view
		$scope.showAdd = function() {
			ArticleUIService.clearMessage($scope);
			$scope.article = {};
			ArticleUIService.enableList($scope, false);
		};
		
		// To coming back to the data-table view
		$scope.back = function() {
			ArticleUIService.clearMessage($scope);
			ArticleUIService.enableList($scope, true);
		}; 	
		
		// To close the message box
		$scope.clearMessage = function() {
			ArticleUIService.clearMessage($scope);
		};
		
		
		function postFetchAll(payload){
			if (payload.status == 200) {
				$scope.articles = payload.data;
			} else {
				ArticleUIService.setMessage($scope, false, 'Error: Not able to fetch all the articles.');
			}
		}
		
		function postSave(payload) {
			if (payload.status == 200) {
				if (payload.config.method === 'POST') {
					ArticleUIService.setMessage($scope, true, 'New Article has added.');
				} else {
					ArticleUIService.setMessage($scope, true, 'Article has updated.');
				}				
				ArticleService.getArticles(postFetchAll);
				$scope.article = {};
				ArticleUIService.enableList($scope, true);				
			} else {
				ArticleUIService.setMessage($scope, false, 'Error in Article process.');
			}
		}
		
		function preEdit(payload) {
			if (payload.status == 200) {
				$scope.article = payload.data;
				ArticleUIService.enableList($scope, false);
			} else {
				ArticleUIService.setMessage($scope, false, 'Error: Not able to load the article');
			}
		}
		
		function postDelete(payload) {
			if (payload.status == 200) {
				ArticleService.getArticles(postFetchAll);
				ArticleUIService.setMessage($scope, true, 'Article has deleted.')
			} else {
				ArticleUIService.setMessage($scope, false, 'Error: Not able to delete the article');
			}
		}
		
	}]);

	// This service stands to do communication between front-end and back-end
	app.factory('ArticleService', ['$http', function($http){
		return {
			getArticles: function(callBackFn) {
				$http.get(contextPath + '/api/articles').then(callBackFn);
			},			
			getArticle: function(id, callBackFn) {
				$http.get(contextPath + '/api/articles/' + id).then(callBackFn);
			},
			createArticle: function(article, callBackFn) {
				$http.post(contextPath + '/api/articles', article).then(callBackFn);
			},
			updateArticle: function(article, callBackFn) {
				$http.put(contextPath + '/api/articles/' + article.id, article).then(callBackFn);
			},
			deleteArticle: function(id, callBackFn) {
				$http.delete(contextPath + '/api/articles/'+ id).then(callBackFn);
			}
		}
	}]);
	
	// This service stands to handle front-end logic
	app.factory('ArticleUIService', function () {
		return {
			initializer: function($scope) {
				$scope.readonly = false;
				$scope.message = {};
				this.enableList($scope, true);
				this.removeHideClass('article-list');
				this.removeHideClass('article-form');				
			},
			enableList: function($scope, bool) {
				$scope.showArticleList = bool;
				$scope.showArticleForm = !bool;
			},
			removeHideClass: function(elementId) {
				$('#' + elementId).removeClass('hide');
			},
			setMessage: function($scope, info, content) {
				$scope.message.alert = true;
				$scope.message.info = info;
				$scope.message.warn = !info;
				$scope.message.content = content;
			},
			clearMessage: function($scope){
				$scope.message.alert = false;
			}
	
		}				
	});
	
    return app;
});