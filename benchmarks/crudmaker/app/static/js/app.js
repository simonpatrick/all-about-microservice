/**
 * Created by patrick on 16/2/5.
 */

angular.module('crudMaker', ['ui.router', 'ngResource', 'angularGrid'
    , 'ngAnimate', 'statellizer']);

angular.module('crudMaker')
    .run(function ($rootScope, $state) {
        $rootScope.$state = $state;
        $rootScope.$state.current.title = "CRUD MAKER";
    });