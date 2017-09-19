Application.$controller("myProfilePagePageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.livelist3_1Click = function($event, $isolateScope) {
        if ($scope.Widgets.livelist3_1.selectedItemWidgets.label17_1.caption == "Suit Animal") {
            $scope.Variables.goToPage_PageBusiness01.invoke();
        } else
            $scope.Variables.goToPage_PageBusiness02.invoke();
    };

}]);

Application.$controller("dialog1LinkedInController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog2FacebookController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);