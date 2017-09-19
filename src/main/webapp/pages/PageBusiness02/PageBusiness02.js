Application.$controller("PageBusiness02PageController", ["$scope", function($scope) {
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


    $scope.button11Click = function($event, $isolateScope) {
        $scope.Widgets.label81_1.caption = "Total Value";
        $scope.Widgets.label82_1.caption = "50000€";
        $scope.Widgets.label83_1.caption = "Maria";
    };


    $scope.button12Click = function($event, $isolateScope) {
        $scope.Widgets.label81_1.caption = "Highest Invoice";
        $scope.Widgets.label82_1.caption = "15000€";
        $scope.Widgets.label83_1.caption = "Jorge";
    };



    $scope.button13Click = function($event, $isolateScope) {
        $scope.Widgets.label81_1.caption = "Oldest Invoice";
        $scope.Widgets.label82_1.caption = "1000€";
        $scope.Widgets.label83_1.caption = "Sofia";
    };


    $scope.button14Click = function($event, $isolateScope) {
        $scope.Widgets.label82_2.caption = "YTD";
        $scope.Widgets.label83_2.caption = "50000€";
    };


    $scope.button15Click = function($event, $isolateScope) {
        $scope.Widgets.label82_2.caption = "MTD";
        $scope.Widgets.label83_2.caption = "1000€";
    };


    $scope.button16Click = function($event, $isolateScope) {
        $scope.Widgets.label83_3.caption = "YTD";
        $scope.Widgets.label84_3.caption = "40000€";
    };


    $scope.button17Click = function($event, $isolateScope) {
        $scope.Widgets.label83_3.caption = "MTD";
        $scope.Widgets.label84_3.caption = "1000€";
    };


    $scope.button18Click = function($event, $isolateScope) {
        $scope.Widgets.label83_4.caption = "Best Partner";
        $scope.Widgets.label84_2.caption = "2000€";
        $scope.Widgets.label85_1.caption = "Lucas";
    };


    $scope.button19Click = function($event, $isolateScope) {
        $scope.Widgets.label83_4.caption = "Highest Invoice";
        $scope.Widgets.label84_2.caption = "2500€";
        $scope.Widgets.label85_1.caption = "Joana";
    };


    $scope.button20Click = function($event, $isolateScope) {
        $scope.Widgets.label83_4.caption = "Recent Partner";
        $scope.Widgets.label84_2.caption = "500€";
        $scope.Widgets.label55_1.caption = "Tobias";
    };

}]);