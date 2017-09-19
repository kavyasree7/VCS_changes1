Application.$controller("createNewInvoicePageController", ["$scope", function($scope) {
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

    $scope.button3Click = function($event, $isolateScope) {
        if ($scope.Widgets.FirstAddItem.show == false && $scope.Widgets.newRowItem.show == false) {
            $scope.Widgets.FirstAddItem.show = true;
        } else if ($scope.Widgets.newRowItem.show == false && $scope.Widgets.newRowItem2.show == false) {
            $scope.Widgets.newRowItem.show = true;

        } else {
            $scope.Widgets.newRowItem2.show = true;
        }
    };


    $scope.buttonTaxa1Click = function($event, $isolateScope) {
        if ($scope.Widgets.newRowTaxa.show == false && $scope.Widgets.newRowTaxa2.show == false) {
            $scope.Widgets.newRowTaxa.show = true;
        } else {
            $scope.Widgets.newRowTaxa2.show = true;
        }
    };


    $scope.buttonTaxa2Click = function($event, $isolateScope) {
        if ($scope.Widgets.newRowTaxa3.show == false && $scope.Widgets.newRowTaxa4.show == false) {
            $scope.Widgets.newRowTaxa3.show = true;
        } else {
            $scope.Widgets.newRowTaxa4.show = true;
        }


    };


    $scope.buttonTaxa3Click = function($event, $isolateScope) {
        if ($scope.Widgets.newRowTaxa5.show == false && $scope.Widgets.newRowTaxa6.show == false) {
            $scope.Widgets.newRowTaxa5.show = true;
        } else {
            $scope.Widgets.newRowTaxa6.show = true;
        }
    };

    function totalTaxs() {
        $scope.Widgets.item1tax1.datavalue + $scope.Widgets.item1tax2.datavalue + $scope.Widgets.item1tax3.datavalue + $scope.Widgets.item2tax1.datavalue + $scope.Widgets.item2tax2.datavalue + $scope.Widgets.item2tax3.datavalue + $scope.Widgets.item3tax1.datavalue + $scope.Widgets.item3tax2.datavalue + $scope.Widgets.item3tax3.datavalue;
    }





    $scope.button10Click = function($event, $isolateScope) {
        $scope.Widgets.message1.type = "info";
        $scope.Widgets.message1.caption = "Registo da Fatura com Sucesso.";
        $scope.Widgets.message1.show = true;
        $scope.Variables.InvoiceVar.insertRecord();
        $scope.Variables.timerVariable1.invoke();
    };

}]);


Application.$controller("partnerDialogPatnerController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);



Application.$controller("saletaxDialogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform3Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("productDialogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform3_1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);