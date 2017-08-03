(function() {
    'use strict';

    angular
        .module('androidServerApp')
        .controller('ProductDetailController', ProductDetailController);

    ProductDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Product', 'Feedback', 'Category'];

    function ProductDetailController($scope, $rootScope, $stateParams, previousState, entity, Product, Feedback, Category) {
        var vm = this;

        vm.product = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('androidServerApp:productUpdate', function(event, result) {
            vm.product = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
