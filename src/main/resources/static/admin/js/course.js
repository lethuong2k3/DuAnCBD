let app_course = angular.module("course", []);

app_course.controller("course-ctrl", function ($scope, $http){
    $scope.fees = [];
    $scope.addFee = () => {
        if (
            $scope.fees.length >= 5
        ) {
            toastr["warning"]("Chỉ được thêm tối đa 5 học phí");
            return;
        }
        let fee = {
            title: $scope.title,
            description: $scope.description,
            price: $scope.price
        }
        $scope.fees.push(fee);
        $('#feeModal').modal('hide');
        $('#courseModal').modal('show');

    }
})