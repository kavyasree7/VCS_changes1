Application.$controller("myBusinessPagePageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.livelist7_1Click = function($event, $isolateScope) {
        if ($scope.Widgets.livelist7_1.selectedItemWidgets.Name.caption == "Suit Animal") {
            $scope.Variables.goToPage_PageBusiness01.invoke();
        } else
            $scope.Variables.goToPage_PageBusiness02.invoke();
    };





    $scope.button3Click = function($event, $isolateScope) {
        $scope.Widgets.label14.caption = "Total Value";
        $scope.Widgets.label45_1.caption = "50000€";
        $scope.Widgets.label15.caption = "Maria";
    };


    $scope.button4Click = function($event, $isolateScope) {
        $scope.Widgets.label14.caption = "Highest Invoice";
        $scope.Widgets.label45_1.caption = "15000€";
        $scope.Widgets.label15.caption = "Jorge";
    };


    $scope.button5Click = function($event, $isolateScope) {
        $scope.Widgets.label14.caption = "Oldest Invoice";
        $scope.Widgets.label45_1.caption = "1000€";
        $scope.Widgets.label15.caption = "Sofia";
    };


    $scope.button6Click = function($event, $isolateScope) {
        $scope.Widgets.label48.caption = "YTD";
        $scope.Widgets.label17_1.caption = "50000€";
    };


    $scope.button7Click = function($event, $isolateScope) {
        $scope.Widgets.label48.caption = "MTD";
        $scope.Widgets.label17_1.caption = "1000€";
    };


    $scope.button9Click = function($event, $isolateScope) {
        $scope.Widgets.label49.caption = "YTD";
        $scope.Widgets.label19.caption = "40000€";
    };


    $scope.button8Click = function($event, $isolateScope) {
        $scope.Widgets.label49.caption = "MTD";
        $scope.Widgets.label19.caption = "1000€";
    };


    $scope.button10Click = function($event, $isolateScope) {
        $scope.Widgets.label20.caption = "Best Partner";
        $scope.Widgets.label50_1.caption = "2000€";
        $scope.Widgets.label21.caption = "Lucas";
    };


    $scope.button11Click = function($event, $isolateScope) {
        $scope.Widgets.label20.caption = "Highest Invoice";
        $scope.Widgets.label50_1.caption = "2500€";
        $scope.Widgets.label21.caption = "Joana";
    };


    $scope.button13Click = function($event, $isolateScope) {
        $scope.Widgets.label20.caption = "Recent Partner";
        $scope.Widgets.label50_1.caption = "500€";
        $scope.Widgets.label21.caption = "Tobias";
    };

}]);