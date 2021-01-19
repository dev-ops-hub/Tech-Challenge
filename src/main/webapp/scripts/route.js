(function(){
    //Executed in strict mode.
	'use strict';
    angular.module('mainApp')
    .config(RoutesConfig)
    .config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);

    /**
     * Configure the pages routing.
     *
     **/
    RoutesConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
    function RoutesConfig($stateProvider, $urlRouterProvider){
    	// Redirect to home page if no other URL matches
    	$urlRouterProvider.otherwise('/failure');
    	// *** Set up UI states ***
        $stateProvider
        // Home page
        .state('home', {
            url: '/',
            params: { refresh: true },
            templateUrl: 'templates/form.template.html',
            controller: 'userFormController as userFormDetail'
        })
        // New Entry Form
        .state('new', {
            url: '/',
            templateUrl: 'templates/form.template.html',
            controller: 'userFormController as userFormDetail'
        })

        // Error Page
        .state('error', {
            url: '/error',
            templateUrl: 'templates/failure.template.html',
            controller: 'userErrorController as userData',
            // These are params that this state expects to be populated
            // Allows us to pass via $state.go(path, params)
            params: { status: null, message: null, timestamp: null }
         })
         // Success Page
        .state('success', {
            url: '/success',
            templateUrl: 'templates/success.template.html',
            controller: 'userSuccessController as userData',
            // These are params that this state expects to be populated
            // Allows us to pass via $state.go(path, params)
            params: { email: null, topic: null, message: null }
         })
         // view Page
        .state('view', {
            url: '/view',
            templateUrl: 'templates/retrieve.template.html',
            controller: 'userViewController as userData'
         })
         .state('default', {
            url: '',
            params: { refresh: true },
            templateUrl: 'templates/form.template.html',
            controller: 'userFormController as userFormDetail'
        });

     }

})();