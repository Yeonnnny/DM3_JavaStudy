$(function () {
    donut();
});

function donut() {
    $.ajax({

    });
    // 데이터 및 설정 정의
    const data = {
        labels: [
            'Income',
            'Expense',
        ],
        datasets: [{
            label: '일별 통계',
            data: [50, 50],
            backgroundColor: [
                'rgb(75, 192, 192)', //녹색
                'rgb(255, 99, 132)'  //빨강
            ],
            hoverOffset: 4
        }]
    };

    // 도넛 차트 생성
    const config = {
        type: 'doughnut',
        data: data,
        options: {
            responsive: false,
            maintainAspectRatio: false
        }
    };

    const myDonutChart = new Chart(
        document.getElementById('myDonutChart'),
        config
    );
}