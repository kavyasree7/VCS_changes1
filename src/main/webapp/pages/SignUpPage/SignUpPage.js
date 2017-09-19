Application.$controller("SignUpPagePageController", ["$scope", function($scope) {
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
        if ($scope.Widgets.name.datavalue == "" || $scope.Widgets.name.datavalue == null) {
            $scope.Widgets.message1.type = "error";
            $scope.Widgets.message1.caption = "Write your Name.";
            $scope.Widgets.message1.show = true;
        } else if ($scope.Widgets.email.datavalue == "" || $scope.Widgets.email.datavalue == null) {
            $scope.Widgets.message1.type = "error";
            $scope.Widgets.message1.caption = "Write your Email.";
            $scope.Widgets.message1.show = true;
        } else {
            $scope.Variables.sv_name.setData({
                dataValue: $scope.Widgets.name.datavalue
            });
            $scope.Variables.sv_email.setData({
                dataValue: $scope.Widgets.email.datavalue
            });
            $scope.Widgets.message1.type = "info";
            $scope.Widgets.message1.caption = "Register successfully.";
            $scope.Widgets.message1.show = true;
            $scope.Variables.SignUpVar.insertRecord();
            $scope.Variables.goToPage_regBusinessPage.invoke();
        }
    };


        $scope.button1Dblclick = function ($event, $isolateScope) { 

        };
 
    }
]);




Application.$controller("loginFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);
Application.$controller("login2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);