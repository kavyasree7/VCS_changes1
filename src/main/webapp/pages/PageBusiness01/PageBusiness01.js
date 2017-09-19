Application.$controller("PageBusiness01PageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.button13Click = function($event, $isolateScope) {
        $scope.Widgets.label111_1.caption = "Total Value";
        $scope.Widgets.label112_1.caption = "50000€";
        $scope.Widgets.label113_1.caption = "Maria";
    };


    $scope.button14Click = function($event, $isolateScope) {
        $scope.Widgets.label111_1.caption = "Highest Invoice";
        $scope.Widgets.label112_1.caption = "15000€";
        $scope.Widgets.label113_1.caption = "Jorge";
    };


    $scope.button15Click = function($event, $isolateScope) {
        $scope.Widgets.label111_1.caption = "Oldest Invoice";
        $scope.Widgets.label112_1.caption = "1000€";
        $scope.Widgets.label113_1.caption = "Sofia";
    };


    $scope.button16Click = function($event, $isolateScope) {
        $scope.Widgets.label112_2.caption = "YTD";
        $scope.Widgets.label113_2.caption = "50000€";
    };


    $scope.button17Click = function($event, $isolateScope) {
        $scope.Widgets.label112_2.caption = "MTD";
        $scope.Widgets.label113_2.caption = "1000€";
    };


    $scope.button18Click = function($event, $isolateScope) {
        $scope.Widgets.label113_3.caption = "YTD";
        $scope.Widgets.label114_1.caption = "40000€";
    };


    $scope.button19Click = function($event, $isolateScope) {
        $scope.Widgets.label113_3.caption = "MTD";
        $scope.Widgets.label114_1.caption = "1000€";
    };


    $scope.button20Click = function($event, $isolateScope) {
        $scope.Widgets.label113_4.caption = "Best Partner";
        $scope.Widgets.label114_2.caption = "2000€";
        $scope.Widgets.label115_1.caption = "Lucas";
    };


    $scope.button21Click = function($event, $isolateScope) {
        $scope.Widgets.label113_4.caption = "Highest Invoice";
        $scope.Widgets.label114_2.caption = "2500€";
        $scope.Widgets.label115_1.caption = "Joana";
    };


    $scope.button22Click = function($event, $isolateScope) {
        $scope.Widgets.label113_4.caption = "Recent Partner";
        $scope.Widgets.label114_2.caption = "500€";
        $scope.Widgets.label115_1.caption = "Tobias";
    };

}]);