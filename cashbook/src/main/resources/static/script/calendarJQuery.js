// const daysContainer = $(".days"),
//     nextBtn = $(".next-btn"),
//     prevBtn = $(".prev-btn"),
//     month = $(".month"),
//     todayBtn = $(".today-btn");
    
// const months = [
// "January", "Feburary", "March", "April", "May", "June",
// "July", "August", "September", "October", "November", "December"
// ];

// const days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

// const date = new Date();
// let currentYear = date.getFullYear();
// let currentMonth = date.getMonth();
// let currentDay = date.getDate();

// var doughnutChartInstance;

// $(document).ready(function () {

//     nextBtn.on("click",nextBtnClick);
//     prevBtn.on("click",prevBtnClick);
//     todayBtn.on("click",todayBtnClick);
//     daysContainer.on("click",selectDay);
    
//     // 캘린더 랜더링
//     renderCalendar();
//     // 도넛 차트
//     donut(currentYear, currentMonth, currentDay);
// });

// function renderCalendar() {
//     date.setDate(1);
//     const firstDay = new Date(currentYear, currentMonth, 1);
//     const lastDay = new Date(currentYear, currentMonth + 1, 0);
//     const lastDayIndex = lastDay.getDay();
//     const lastDayDate = lastDay.getDate();
//     const prevLastDay = new Date(currentYear, currentMonth, 0);
//     const prevLastDayDate = prevLastDay.getDate();
//     const nextDays = 7 - lastDayIndex - 1;

//     month.text(`${months[currentMonth]} ${currentYear}`);

//     let daysHtml = "";

//     for (let x = firstDay.getDay(); x > 0; x--) {
//         daysHtml += `<div class="day prev">${prevLastDayDate - x + 1}</div>`;
//     }

//     for (let i = 1; i <= lastDayDate; i++) {
//         if (i === new Date().getDate() && currentMonth === new Date().getMonth() && currentYear === new Date().getFullYear()) {
//             daysHtml += `<div class="day today">${i}</div>`;
//             continue;
//         }
//         daysHtml += `<div class="day">${i}</div>`;
//     }

//     for (let i = 1; i <= nextDays; i++) {
//         daysHtml += `<div class="day next">${i}</div>`;
//     }

//     daysContainer.html(daysHtml);
//     selectDay();
// }


// function nextBtnClick (){
//     currentMonth++;
//     if (currentMonth > 11) {
//         currentMonth = 0;
//         currentYear++;
//     }
//     renderCalendar();
// }

// function prevBtnClick(){
//     currentMonth--;
//     if (currentMonth < 0) {
//         currentMonth = 11;
//         currentYear--;
//     }
//     renderCalendar();
// }

// function todayBtnClick(){
//     currentMonth = date.getMonth();
//     currentYear = date.getFullYear();
//     renderCalendar();
// }

// function hideTodayBtn() {
//     if (currentMonth === new Date().getMonth() && currentYear === new Date().getFullYear()) {
//         todayBtn.hide();
//     } else {
//         todayBtn.show();
//     }
// }

// function selectDay() {
//     daysContainer.on("click", ".day", function () {
//         $(".selectDay").removeClass("selectDay");
//         if (!$(this).hasClass("today")) {
//             $(this).addClass("selectDay");
//         }
//         let currentDay = $(this).text();
//         donut(currentYear, currentMonth, currentDay);
//     });
// }

// function donut(currentYear, currentMonth, currentDay) {
//     let memberId = $("#memberId").val();
//     currentMonth++;
//     console.log(memberId, currentYear, currentMonth, currentDay);
//     $.ajax({
//         url: "/cashbook/statics/getValue",
//         data: {
//             "memberId": memberId,
//             "year": currentYear,
//             "month": currentMonth,
//             "day": currentDay,
//         },
//         method: "GET",
//         success: function (result) {
//             console.log(result);
//             if (!result) {
//                 $(".dailyChart").html("<h3>결과가 존재하지 않습니다.</h3>")
//             }else{
//                 let income = result[0].Income;
//                 let expense = result[0].Expense;
//                 console.log(income);
//                 console.log(expense);

//                 const data = {
//                     labels: ['Income', 'Expense'],
//                     datasets: [{
//                         label: '일별 통계',
//                         data: [income, expense],
//                         backgroundColor: ['rgb(75, 192, 192)', 'rgb(255, 99, 132)'],
//                         hoverOffset: 4
//                     }]
//                 };
                
//                 const config = {
//                     type: 'doughnut',
//                     data: data,
//                     options: {
//                         responsive: false,
//                         maintainAspectRatio: false
//                     }
//                 };
//                 console.log($("#myDonutChart"));
                
//                 const ctx = $("#myDonutChart")[0].getContext('2d');
                
//                 // 기존 차트가 존재하면 파기
//                 if (window.doughnutChartInstance) {
//                     window.doughnutChartInstance.destroy();
//                 }
                
//                 // 도넛 차트 생성
//                 window.doughnutChartInstance = new Chart(ctx, config);
                
//                 // 차트를 그리기 위한 context 가져오기
//                 // const ctx = $("#myDonutChart")[0].getContext('2d');
//                 // myDonutChart = new Chart(ctx, config);
//                 console.log(myDonutChart);
                
//             }
//         }
//     });
// }

let myDonutChart; // 전역 변수를 선언하여 차트를 저장

$(document).ready(function () {
    const daysContainer = $(".days"),
        nextBtn = $(".next-btn"),
        prevBtn = $(".prev-btn"),
        month = $(".month"),
        todayBtn = $(".today-btn");

    const months = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    const date = new Date();
    let currentYear = date.getFullYear();
    let currentMonth = date.getMonth();
    let currentDay = date.getDate();

    // 전역 변수 선언
    var doughnutChartInstance;

    nextBtn.on("click", nextBtnClick);
    prevBtn.on("click", prevBtnClick);
    todayBtn.on("click", todayBtnClick);
    daysContainer.on("click", ".day", selectDay);

    // 캘린더 렌더링
    renderCalendar();
    // 도넛 차트
    donut(currentYear, currentMonth, currentDay);

    function renderCalendar() {
        date.setDate(1);
        const firstDay = new Date(currentYear, currentMonth, 1);
        const lastDay = new Date(currentYear, currentMonth + 1, 0);
        const lastDayIndex = lastDay.getDay();
        const lastDayDate = lastDay.getDate();
        const prevLastDay = new Date(currentYear, currentMonth, 0);
        const prevLastDayDate = prevLastDay.getDate();
        const nextDays = 7 - lastDayIndex - 1;

        month.text(`${months[currentMonth]} ${currentYear}`);

        let daysHtml = "";

        for (let x = firstDay.getDay(); x > 0; x--) {
            daysHtml += `<div class="day prev">${prevLastDayDate - x + 1}</div>`;
        }

        for (let i = 1; i <= lastDayDate; i++) {
            if (i === new Date().getDate() && currentMonth === new Date().getMonth() && currentYear === new Date().getFullYear()) {
                daysHtml += `<div class="day today">${i}</div>`;
                continue;
            }
            daysHtml += `<div class="day">${i}</div>`;
        }

        for (let i = 1; i <= nextDays; i++) {
            daysHtml += `<div class="day next">${i}</div>`;
        }

        daysContainer.html(daysHtml);
        hideTodayBtn();
    }

    function nextBtnClick() {
        currentMonth++;
        if (currentMonth > 11) {
            currentMonth = 0;
            currentYear++;
        }
        renderCalendar();
    }

    function prevBtnClick() {
        currentMonth--;
        if (currentMonth < 0) {
            currentMonth = 11;
            currentYear--;
        }
        renderCalendar();
    }

    function todayBtnClick() {
        currentMonth = date.getMonth();
        currentYear = date.getFullYear();
        renderCalendar();
    }

    function hideTodayBtn() {
        if (currentMonth === new Date().getMonth() && currentYear === new Date().getFullYear()) {
            todayBtn.hide();
        } else {
            todayBtn.show();
        }
    }

    function selectDay() {
        $(".selectDay").removeClass("selectDay");
        if (!$(this).hasClass("today")) {
            $(this).addClass("selectDay");
        }
        currentDay = $(this).text();
        donut(currentYear, currentMonth, currentDay);
    }

    function donut(currentYear, currentMonth, currentDay) {
        let memberId = $("#memberId").val();
        currentMonth++; // JavaScript에서 월은 0부터 시작하므로 1을 더해줍니다.
        console.log(memberId, currentYear, currentMonth, currentDay);

        $.ajax({
            url: "/cashbook/statics/getValue",
            data: {
                "memberId": memberId,
                "year": currentYear,
                "month": currentMonth,
                "day": currentDay,
            },
            method: "GET",
            success: function (result) {
                let income = result[0].Income;
                let expense = result[0].Expense;
                
                if (income==0 && expense==0) {
                    $(".dailyChart").html("<h3>결과가 존재하지 않습니다.</h3>");
                } else {
                    console.log(income);
                    console.log(expense);

                    const data = {
                        labels: ['Income', 'Expense'],
                        datasets: [{
                            label: '일별 통계',
                            data: [income, expense],
                            backgroundColor: ['rgb(75, 192, 192)', 'rgb(255, 99, 132)'],
                            hoverOffset: 4
                        }]
                    };

                    const config = {
                        type: 'doughnut',
                        data: data,
                        options: {
                            responsive: false,
                            maintainAspectRatio: false
                        }
                    };

                    // 기존 캔버스를 제거하고 새로 추가
                    $("#myDonutChart").remove(); // 기존 캔버스를 제거
                    $(".dailyChart").html('<canvas id="myDonutChart" width="200" height="200" style="width: 200px; height: 200px;"></canvas>'); // 새로운 캔버스 추가

                    const ctx = document.getElementById("myDonutChart").getContext("2d");

                    // 기존 차트가 존재하면 파기
                    if (doughnutChartInstance) {
                        doughnutChartInstance.destroy();
                    }

                    // 도넛 차트 생성
                    doughnutChartInstance = new Chart(ctx, config);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("AJAX Error: ", textStatus, errorThrown);
            }
        });
    }
});
