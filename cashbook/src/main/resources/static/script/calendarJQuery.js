let myDonutChart; // 차트에 대한 전역 변수를 선언

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
        currentMonth++; // JavaScript에서 월은 0부터 시작하므로 1을 더해줌
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
                console.log(income);
                console.log(expense);
                
                if (income==0 && expense==0) {
                    $(".dailyChart").html("<h3>결과가 존재하지 않습니다.</h3>");
                } else {

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
                            maintainAspectRatio: false,
                            plugins: {
                                datalabels: {
                                    color: '#fff', // 레이블의 텍스트 색상
                                    formatter: (value, ctx) => {
                                        return value; // 실제 값 반환
                                    },
                                    font: {
                                        size: 16, // 레이블의 폰트 크기
                                    }
                                }
                            },
                            tooltips: {
                                enabled: false
                            },
                            legend: {
                                display: false
                            }
                        }
                    };

                    // 기존 캔버스를 제거하고 새로 추가
                    $("#myDonutChart").remove(); // 기존 캔버스를 제거
                    $(".dailyChart").html('<canvas id="myDonutChart" width="400" height="400" style="width: 400px; height: 400px;"></canvas>'); // 새로운 캔버스 추가

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
