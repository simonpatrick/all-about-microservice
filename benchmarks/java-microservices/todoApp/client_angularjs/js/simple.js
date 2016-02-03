/**
 * Created by patrick on 16/2/3.
 */

angular.module('todoApp',[])
.controller('todoController',function($scope){
   $scope.tasks=[];
   $scope.newTodo={};
   $scope.add=function(){ //here actuall newTodo is $scope.newTodo
       $scope.newTodo['status']='active';
       $scope.tasks.push($scope.newTodo);
       $scope.newTodo={};
   };
    $scope.delete=function(){
        //interesting points, why this can understanding the $index
        console.log(this.$index);
        console.log(this);
        $scope.tasks.splice(this.$index,1);
    }
});