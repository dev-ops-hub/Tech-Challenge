(function(){
   //Executed in strict mode.
   'use strict';
   // Main App that includes the ngMessage and ui.router module as a dependency
   angular.module('mainApp', ['ngMessages','ui.router'])
   .constant('BasePath', "http://localhost:8080/");
})();

