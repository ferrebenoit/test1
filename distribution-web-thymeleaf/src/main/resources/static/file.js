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

		/*RestangularProvider.addElementTransformer('computers', function(element) {
			console.log(element);
			for (var key in element.data._embedded.computers) {
	            element[key] = element.data._embedded.computers[key];
	        }

	        return element;
	    });*/
		
		
		RestangularProvider.addFullRequestInterceptor(function(element, operation, what, url, headers, params) {
			console.log('--addFullRequestInterceptor---');
			//element.id = 1;
			
			console.log(element); 
			console.log(operation);
			console.log(what);
			console.log(url);
			console.log(headers); 
			console.log(params);
			console.log('**addFullRequestInterceptor***');
			
			if (operation == 'getList') {
	            
	            params.page = params._page - 1;
	            params.size = params._perPage;
	            
	            if 
	            params.sort = params._sortField + "," + params._sortDir
	            
	            delete params._page;
	            delete params._perPage;
	            delete params._sortDir;
	            delete params._sortField;
	        }
			
			return {element : element};
		});

		
		/*RestangularProvider.addFullRequestInterceptor(function(element, operation, what, url, headers, params) {
			console.log(params);
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

		RestangularProvider.addResponseInterceptor(function(data, operation, what, url, response, deferred) {
			console.log('--addResponseInterceptor---');
			console.log(data); 
			console.log(operation); 
			console.log(what);
			console.log(url);
			console.log(response); 
			console.log(deferred);
			console.log('**addResponseInterceptor***');
			
			var extractedData;
			// .. to look for getList operations
			if (operation === "getList") {
				// .. and handle the data and meta data
				extractedData = data._embedded.computers;
			} else {
				extractedData = data;
			}
			return extractedData;
			
		});

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

		computer.listView()
		.title('Liste Ordinateurs')
		.description('Liste des ordinateurs')
		.infinitePagination(true)
		.fields([
		         nga.field('id'), // The default displayed name is the camelCase field name. label() overrides id
		         nga.field('name'), // the default list field type is "string", and displays as a string
		         nga.field('macAddress') // Date field type allows date formatting
		         ])
		         .listActions(['show', 'edit', 'delete']);

		computer.creationView()
		.fields([
		         nga.field('name') // the default edit field type is "string", and displays as a text input
		         .attributes({ placeholder: 'the computer title' }) // you can add custom attributes, too
		         .validation({ required: true, minlength: 3, maxlength: 100 }), // add validation rules for fields
		         nga.field('macAddress', 'string') // text field type translates to a textarea
		         ]);

		computer.editionView()
		.title('Edit Computer "{{ entry.values.title }}"') // title() accepts a template string, which has access to the entry
		.actions(['list', 'show', 'delete']) // choose which buttons appear in the top action bar. Show is disabled by default
		.fields([
		         computer.creationView().fields(), // fields() without arguments returns the list of fields. That way you can reuse fields from another view to avoid repetition
		         ]);
		
		computer.showView() // a showView displays one entry in full page - allows to display more data than in a a list
		.fields([
		         computer.editionView().fields(), // reuse fields from another view in another order
		         ]);
	//	 admin.menu(nga.menu()
	//			 .addChild(nga.menu(post).icon('<span class="glyphicon glyphicon-file"></span>'))
	//	 );
				 
				 
		nga.configure(admin);

	});
}());