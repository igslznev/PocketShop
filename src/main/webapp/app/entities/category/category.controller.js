(function() {
    'use strict';

    angular
        .module('androidServerApp')
        .controller('CategoryController', CategoryController);

    CategoryController.$inject = ['Category'];

    function CategoryController(Category) {

        var vm = this;

        vm.categories = [];

        loadAll();

        function loadAll() {
            Category.query(function(result) {
                vm.categories = result;
                vm.searchQuery = null;
            });
        }
    }
})();
