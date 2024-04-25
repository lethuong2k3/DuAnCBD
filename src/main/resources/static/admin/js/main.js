(function ($) {
    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();

    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Sidebar Toggler
    $('.sidebar-toggler').click(function () {
        $('.sidebar, .content').toggleClass("open");
        return false;
    });


    // Progress Bar
    $('.pg-bar').waypoint(function () {
        $('.progress .progress-bar').each(function () {
            $(this).css("width", $(this).attr("aria-valuenow") + '%');
        });
    }, {offset: '80%'});


    // Calender
    $('#calender').datetimepicker({
        inline: true,
        format: 'L'
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        items: 1,
        dots: true,
        loop: true,
        nav : false
    });


    // Worldwide Sales Chart
    var ctx1 = $("#worldwide-sales").get(0).getContext("2d");
    var myChart1 = new Chart(ctx1, {
        type: "bar",
        data: {
            labels: ["2016", "2017", "2018", "2019", "2020", "2021", "2022"],
            datasets: [{
                label: "USA",
                data: [15, 30, 55, 65, 60, 80, 95],
                backgroundColor: "rgba(0, 156, 255, .7)"
            },
                {
                    label: "UK",
                    data: [8, 35, 40, 60, 70, 55, 75],
                    backgroundColor: "rgba(0, 156, 255, .5)"
                },
                {
                    label: "AU",
                    data: [12, 25, 45, 55, 65, 70, 60],
                    backgroundColor: "rgba(0, 156, 255, .3)"
                }
            ]
        },
        options: {
            responsive: true
        }
    });


    // Salse & Revenue Chart
    var ctx2 = $("#salse-revenue").get(0).getContext("2d");
    var myChart2 = new Chart(ctx2, {
        type: "line",
        data: {
            labels: ["2016", "2017", "2018", "2019", "2020", "2021", "2022"],
            datasets: [{
                label: "Salse",
                data: [15, 30, 55, 45, 70, 65, 85],
                backgroundColor: "rgba(0, 156, 255, .5)",
                fill: true
            },
                {
                    label: "Revenue",
                    data: [99, 135, 170, 130, 190, 180, 270],
                    backgroundColor: "rgba(0, 156, 255, .3)",
                    fill: true
                }
            ]
        },
        options: {
            responsive: true
        }
    });



    // Single Line Chart
    var ctx3 = $("#line-chart").get(0).getContext("2d");
    var myChart3 = new Chart(ctx3, {
        type: "line",
        data: {
            labels: [50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150],
            datasets: [{
                label: "Salse",
                fill: false,
                backgroundColor: "rgba(0, 156, 255, .3)",
                data: [7, 8, 8, 9, 9, 9, 10, 11, 14, 14, 15]
            }]
        },
        options: {
            responsive: true
        }
    });


    // Single Bar Chart
    var ctx4 = $("#bar-chart").get(0).getContext("2d");
    var myChart4 = new Chart(ctx4, {
        type: "bar",
        data: {
            labels: ["Italy", "France", "Spain", "USA", "Argentina"],
            datasets: [{
                backgroundColor: [
                    "rgba(0, 156, 255, .7)",
                    "rgba(0, 156, 255, .6)",
                    "rgba(0, 156, 255, .5)",
                    "rgba(0, 156, 255, .4)",
                    "rgba(0, 156, 255, .3)"
                ],
                data: [55, 49, 44, 24, 15]
            }]
        },
        options: {
            responsive: true
        }
    });


    // Pie Chart
    var ctx5 = $("#pie-chart").get(0).getContext("2d");
    var myChart5 = new Chart(ctx5, {
        type: "pie",
        data: {
            labels: ["Italy", "France", "Spain", "USA", "Argentina"],
            datasets: [{
                backgroundColor: [
                    "rgba(0, 156, 255, .7)",
                    "rgba(0, 156, 255, .6)",
                    "rgba(0, 156, 255, .5)",
                    "rgba(0, 156, 255, .4)",
                    "rgba(0, 156, 255, .3)"
                ],
                data: [55, 49, 44, 24, 15]
            }]
        },
        options: {
            responsive: true
        }
    });


    // Doughnut Chart
    var ctx6 = $("#doughnut-chart").get(0).getContext("2d");
    var myChart6 = new Chart(ctx6, {
        type: "doughnut",
        data: {
            labels: ["Italy", "France", "Spain", "USA", "Argentina"],
            datasets: [{
                backgroundColor: [
                    "rgba(0, 156, 255, .7)",
                    "rgba(0, 156, 255, .6)",
                    "rgba(0, 156, 255, .5)",
                    "rgba(0, 156, 255, .4)",
                    "rgba(0, 156, 255, .3)"
                ],
                data: [55, 49, 44, 24, 15]
            }]
        },
        options: {
            responsive: true
        }
    });


})(jQuery);
toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-bottom-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}

function setError(ele, message) {
    let parentEle = ele.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}

function isNumber (number) {
    return !isNaN(number) && isFinite(number);
}

function image_select() {
    let image = document.getElementById('image').files;
    for (i = 0; i < image.length; i++) {
        if (!isImage(image[i])) {
            toastr["error"](image[i].name + " không đúng định dạng hình ảnh");
            continue;
        } else if (check_duplicate(image[i].name, images)) {
            if (image[i].size > 10048576) {
                toastr["warning"](image[i].name + " có kích thước lớn hơn 10MB");
                continue;
            }
            images.push({
                "name": image[i].name,
                "url": URL.createObjectURL(image[i]),
                "size": image[i].size,
                "file": image[i]
            })
        } else {
            toastr["error"](image[i].name + " đã có trong danh sách");
        }
        document.getElementById('image').value = "";
        document.getElementById('container').innerHTML = image_show();
    }
}

function video_select() {
    let video = document.getElementById('video').files;
    for (i = 0; i < video.length; i++) {
        if (!isVideo(video[i])) {
            toastr["error"](video[i].name + " không đúng định dạng video");
            document.getElementById('image').value = '';
            continue;
        } else if (check_duplicate(video[i].name, videos)) {
            if (video[i].size > 1000048576) {
                toastr["warning"](video[i].name + " có kích thước lớn hơn 1GB");
                continue;
            }
            videos.push({
                "name": video[i].name,
                "url": URL.createObjectURL(video[i]),
                "size": video[i].size,
                "file": video[i]
            })
        } else {
            toastr["error"](video[i].name + " đã có trong danh sách");
        }
        document.getElementById('video').value = "";
        document.getElementById('lst-video').innerHTML = video_show();
    }
}

function image_show() {
    let image = "";
    images.forEach(i => {
        image += `<div class="image_container d-flex justify-content-center position-relative">
                       <img src="`+ i.url +`" alt="Image"> 
                        <span class="position-absolute" onclick="delete_image(`+ images.indexOf(i) +`)">&times;</span>
                  </div>`;
    })
    return image;
}

function video_show() {
    let video = "";
    videos.forEach(i => {
        video += `<video controls="controls" src="`+ i.url +`" type="video/mp4" width="330px" height="200px" style="margin: 10px"></video>
                  <button onclick="delete_video(`+ videos.indexOf(i) +`)" type="button" class="btn-close" aria-label="Close"></button>`;
    })
    return video;
}

function delete_image(e) {
    images.splice(e, 1);
    document.getElementById('container').innerHTML = image_show();
}

function delete_video(e) {
    videos.splice(e, 1);
    document.getElementById('lst-video').innerHTML = video_show();
}

function check_duplicate(name, lst) {
    var status = true;
    if (lst.length > 0) {
        for (e = 0; e < lst.length; e++) {
            if (lst[e].name == name) {
                status = false;
                break;
            }
        }
    }
    return status;
}


function isImage(file) {
    return file.name.match(/\.(jpg|jpeg|png|gif|bmp)$/);
}

function isVideo(file) {
    return file.name.match(/\.(m4v|avi|mpg|mp4)$/);
}


