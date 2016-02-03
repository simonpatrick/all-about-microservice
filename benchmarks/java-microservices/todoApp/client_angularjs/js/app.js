/**
 The main todoList module
 */
var toDoList = angular.module('toDoList', ['ngRoute', 'ngResource'])
    .config(function ($routeProvider) {
        'use strict';

        var routeConfig = {
            controller: 'ToDoController',
            templateUrl: 'todoList.html',
            resolve: {
                store: function (todoStorage) {
                    return todoStorage.then(function (module) {
                        module.get();
                        return module;
                    });
                }
            }
        };

        $routeProvider
            .when('/', routeConfig)
            .when('/:status', routeConfig)
            .otherwise({
                redirectTo: '/'
            });
    });
