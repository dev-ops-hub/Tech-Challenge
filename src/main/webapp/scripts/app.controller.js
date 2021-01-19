(function(){
    'use strict';
    angular.module('mainApp')
    .controller('userFormController', userFormController)
    .controller('userViewController', userViewController)
    .controller('userSuccessController', userSuccessController)
    .controller('userErrorController', userErrorController);

    /**
     * Controller for the input form.
     * It contains 2 functions.
     *  <ul>
     *    <li>Submit the form</li>
     *    <li>Check the text area less than 120 words</li>
     *  </ul>
     * or to find out if the user is authenticated.
     **/

    //Inject the dependencies
    userFormController.$inject = ['$state', '$http', '$scope'];
    function userFormController($state, $http, $scope) {
    	var $ctrl = this;
    	$ctrl.queryForm = {
              id : -1,
              topic : "",
              email : "",
              message : ""
          };
    	$ctrl.wordCounts = 0;
      	    //Function to submit the form
      	    $ctrl.submit = function(){
      		//Get the data
      		var params = {
        			  'email': $ctrl.email,
    			      'topic': $ctrl.topic,
    			      'message': $ctrl.message
     		 };
       		 $http.post('form/query', params)
       		 .then(function successCallback(response) {
       			//console.log(response.status + ": " + JSON.stringify(response.data));
       			$state.go('success', { email:response.data.email,
       								   topic: response.data.topic,
       								   message: response.data.message});
       		 }, function errorCallback(response) {

       			$state.go('error', {  status:response.status,
									  message: response.data.message,
									  timestamp: response.data.timestamp});
       		 });
 	      };

		  //Function to check the text area less than 120 words
	      $ctrl.checkWords = function(){
	    	  if(typeof $ctrl.message!= "undefined" &&
	    			  	$ctrl.message.length > 0 )
	    	  {
	    		  var words = $ctrl.message.split(" ");
	              var tmp = '';
	              	  // if more than 120 words, capture the first 120 words
	                  // and display back to the textarea
	                  if (words.length > 120){
	                    for(var i=0; i<120;i++){
	                      tmp += words[i] + ' ';
	                    }
	                    $ctrl.wordCounts = i;
	                    $ctrl.message = tmp;
	                  }
	                  else{
	                	 $ctrl.wordCounts = words.length;
	 	              }
		   	  }
	    	  else {
	    		  $ctrl.wordCounts = 0;
	    	  }

	      };

	     $ctrl.checkWords();

    }

    //Inject the dependencies
    userViewController.$inject = ['$state', '$http', '$scope'];
    function userViewController($state, $http, $scope) {
   	 	var $ctrl = this;
   	    $ctrl.submit = function(){
      		//Get the data
      		var params = {
        			  'userId': $ctrl.userId,
    			      'pwd': $ctrl.pwd
     		 };
      		$http({
      			method: 'GET',
      			url: 'form/query',
      			 params: {userId: $ctrl.userId, pwd: $ctrl.pwd}
      		 })
       		 .then(function successCallback(response) {
       			 $scope.queries = response.data;
       		 }, function errorCallback(response) {
       			$state.go('error', {  status:response.status,
									  message: response.data.message,
									  timestamp: response.data.timestamp});
       		 });
 	      };

    }

    /**
     * Controller to display the entry is submitted successfully
     *
     **/
    userSuccessController.$inject = [ '$stateParams', '$state'];
    function userSuccessController($stateParams, $state) {
    	 var $ctrl = this;
    	 $ctrl.email = $stateParams.email;
    	 $ctrl.topic = $stateParams.topic;
    	 $ctrl.message = $stateParams.message;

    	 $ctrl.backToHome = function(){
      		  $state.go('home',{refresh: false});
      	 };
    }

    /**
     * Controller to display the error
     *
     **/
    userSuccessController.$inject = [ '$stateParams', '$state'];
    function userErrorController($stateParams, $state) {
    	 var $ctrl = this;
    	 $ctrl.status = $stateParams.status;
    	 $ctrl.message = $stateParams.message;
    	 $ctrl.timestamp = $stateParams.timestamp;

    	 $ctrl.backToHome = function(){
      		  $state.go('home',{refresh: false});
      	 };
    }

})();