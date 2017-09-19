Application.$controller("regBusinessPagePageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };

    $scope.button1Click = function($event, $isolateScope) {
        $scope.Widgets.message1.type = "info";
        $scope.Widgets.message1.caption = "Registo da Empressa com Sucesso.";
        $scope.Widgets.message1.show = true;
        $scope.Variables.CompanyVar.insertRecord();
        $scope.Variables.timerVariable1.invoke();

        $scope.Variables.sv_businessName.setData({
            dataValue: $scope.Widgets.businessNameFinal.datavalue
        });
        $scope.Variables.sv_businessType.setData({
            dataValue: $scope.Widgets.businessTypeFinal.datavalue
        });
        $scope.Variables.sv_subBusinessType.setData({
            dataValue: $scope.Widgets.subBusinessTypeFinal.datavalue
        });
        $scope.Variables.sv_country.setData({
            dataValue: $scope.Widgets.countryFinal.datavalue
        });
    };

    $scope.select3Click = function($event, $isolateScope) {
        $scope.Widgets.SubBusinessType.show = true;

    };

}]);

Application.$controller("wmWizardPlaceOrderItemsGridController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);