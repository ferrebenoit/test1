/*global angular*/
(function () {
	"use strict";

	var app = angular.module('myApp', ['ng-admin']);

	app.controller('main', function ($scope, $rootScope, $location) {
		$rootScope.$on('$stateChangeSuccess', function () {
			$scope.displayBanner = $location.$$path === '/dashboard';
		});
	});

	app.config(function (NgAdminConfigurationProvider, RestangularProvider) {
		var nga = NgAdminConfigurationProvider;
		function truncate(value) {
			if (!value) {
				return '';
			}
			return value.length > 50 ? value.substr(0, 50) + '...' : value;
		}

		/*RestangularProvider.addFullRequestInterceptor(function(element, operation, what, url, headers, params) {
			if (operation == "getList") {
				// custom pagination params
				if (params._page) {
					params._start = (params._page - 1) * params._perPage;
					params._end = params._page * params._perPage;
				}
				delete params._page;
				delete params._perPage;
				// custom sort params
				if (params._sortField) {
					params._sort = params._sortField;
					delete params._sortField;
				}
				// custom filters
				if (params._filters) {
					for (var filter in params._filters) {
						params[filter] = params._filters[filter];
					}
					delete params._filters;
				}
			}
			return { params: params };
		});*/
		/*RestangularProvider.addResponseInterceptor(function(data, operation, what, url, response, deferred) {
			if (operation == "getList") {
				var newResponse = response._embedded.computers;
		        newResponse.paging = response.paging;
		        newResponse.error = response.error;
		        console.log(response);
		        console.log(newResponse);
		        
		        return newResponse;
			}
			console.log("in interceptor");
			return response ;
		});*/

		//console.log("begin");
		var admin = nga.application('ng-admin backend demo') // application main title
		.baseApiUrl('http://localhost:8080/'); // main API endpoint


		var computer = nga.entity('computers');

		admin.addEntity(computer);


		computer.dashboardView() // customize the dashboard panel for this entity
		.title('Recent computers')
		.order(1) // display the post panel first in the dashboard
		.perPage(5) // limit the panel to the 5 latest posts
		.fields([nga.field('name').isDetailLink(true).map(truncate)]); // fields() called with arguments add fields to the view

		
	//	 admin.menu(nga.menu()
	//			 .addChild(nga.menu(post).icon('<span class="glyphicon glyphicon-file"></span>'))
	//	 );
				 
				 
		nga.configure(admin);

	});
}());