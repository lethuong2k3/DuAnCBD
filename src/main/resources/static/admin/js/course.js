let images = [];
let videos = [];
let app_course = angular.module("course", []);
app_course.controller("course-ctrl", function ($scope, $http){
    let feeTitle = document.getElementById('feeTitle');
    let feeDescription = document.getElementById('feeComment');
    let feePrice = document.getElementById('feePrice');
    let courseName = document.getElementById('courseName');
    let courseComment = document.getElementById('courseComment');
    $scope.fees = [];
    $scope.removeErrorFee = () => {
        let inputFee = document.querySelectorAll('.input-row');
        Array.from(inputFee).map(ele => ele.classList.remove('error'));
        document.getElementById('formFee').reset();
    }

    $scope.addFee = () => {
        let isValid = checkFee();
        if (isValid) {
            let fee = {
                title: feeTitle.value,
                description: feeDescription.value,
                price: feePrice.value
            }
            $scope.fees.push(fee);
            $('#feeModal').modal('hide');
            $('#courseModal').modal('show');
            $scope.removeErrorFee();
        }
    }

    $scope.addCourse = () => {
        if ($scope.fees.length === 0) {
            toastr["warning"]("Vui lòng thêm học phí trước khi thêm mới khóa học!");
            return;
        }
        let isValid = checkCourse();
        if (isValid) {
            let course = {
                title: courseName.value,
                description: courseComment.value,
                fees:$scope.fees
            }
            $http.post(`/admin/course/add`,course).then(resp => {
                if(resp.status === 200)
                {
                    toastr["success"](resp.data.message);
                }
            })
                .catch(error =>{
                    toastr["error"](error);
                })
        }
    }

    $scope.removeFee = (fee) => {
        let index = $scope.fees.indexOf(fee);
        if (index !== -1) {
            $scope.fees.splice(index, 1);
        }
    }

    function checkFee() {
        let isCheck = true;

        if (feeTitle.value == '') {
            setError(feeTitle, 'Tiêu đề học phí không được để trống');
            isCheck = false;
        }

        if (feePrice.value == '') {
            setError(feePrice, 'Giá học phí không được để trống');
            isCheck = false;
        } else if (!isNumber(feePrice.value)) {
            setError(feePrice, 'Đơn giá phải là số')
            isCheck = false;
        } else if (feePrice.value <= 0) {
            setError(feePrice, 'Đơn giá phải là số nguyên dương')
            isCheck = false;
        }
        return isCheck;
    }

    function checkCourse() {
        let isCheck = true;
        if (courseName.value == '') {
            setError(courseName, 'Tên khóa học không được để trống');
            isCheck = false;
        }
        return isCheck;
    }
})