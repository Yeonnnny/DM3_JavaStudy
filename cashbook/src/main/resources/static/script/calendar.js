
/**
 *  Calendar (참고 : https://www.youtube.com/watch?v=C-rODtCYUbo) 
 */

const daysContainer = document.querySelector(".days"),
    nextBtn = document.querySelector(".next-btn"),
    prevBtn = document.querySelector(".prev-btn"),
    month = document.querySelector(".month"),
    todayBtn = document.querySelector(".today-btn");

const months = [
    "January",
    "Feburary",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
];

const days =["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];

// 현재 날짜 가져오기
const date = new Date();

// 현재 연도(year) 가져오기
let currentYear = date.getFullYear();

// 현재 월(month) 가져오기
let currentMonth = date.getMonth();


// days 랜더링
function renderCalendar() {
    // get prev month, current month and next month days
    date.setDate(1);
    const firstDay = new Date(currentYear, currentMonth, 1);
    const lastDay = new Date(currentYear, currentMonth+1,0);
    const lastDayIndex = lastDay.getDay();
    const lastDayDate = lastDay.getDate();
    const prevLastDay = new Date(currentYear,currentMonth, 0); // currentMonth의 0번째 날 즉, 이전 달의 마지막 날
    const prevLastDayDate =prevLastDay.getDate();
    const nextDays = 7 - lastDayIndex - 1; // 7 - currentMonth의 마지막 날의 인덱스 - 1

    // update current year and month in header
    month.innerHTML = `${months[currentMonth]} ${currentYear}`;

    // update days html
    let days ="";

    // prev month's days html
    for(let x = firstDay.getDay(); x>0;x--){
        days += `<div class="day prev">${prevLastDayDate -x +1}</div>`;
    }
    
    // current month's days html
    for(let i = 1; i<=lastDayDate;i++){
        // currentDay인 경우, today 클래스 추가
        if (i === new Date().getDate() && 
            currentMonth === new Date().getMonth() && 
            currentYear === new Date().getFullYear()
        ) {
            days += `<div class="day today">${i}</div>`;
            continue;
        }
        days += `<div class="day">${i}</div>`;
    }

    // next month's days html
    for(let i = 1; i<=nextDays;i++){
        days += `<div class="day next">${i}</div>`;
    }

    // run this function with every calendar render
    // hideTodayBtn(); 
    // selectDay();

    daysContainer.innerHTML = days;
}


renderCalendar();


nextBtn.addEventListener("click",()=>{
    // increase current month by one
    currentMonth++;
    if(currentMonth > 11){
        // if month gets greater than 11, make it 0 and increase year by one
        currentMonth = 0;
        currentYear++;
    }
    // render Calendar
    renderCalendar();
});


prevBtn.addEventListener("click",()=>{
    // decrease current month by one
    currentMonth--;
    if(currentMonth <0){
        // if month gets smaller than 0, make it 11 and decrease year by one
        currentMonth = 11;
        currentYear--;
    }
    // render Calendar
    renderCalendar();
});

// go to today
todayBtn.addEventListener("click",()=>{
    // set month and year to current
    currentMonth = date.getMonth();
    currentYear = date.getFullYear();
    // rerender Calendar
    renderCalendar();
});


// let's hide today btn if tis already current month and vice versa
function hideTodayBtn() {
    if (
        currentMonth === new Date().getMonth() &&
        currentYear === new Date().getFullYear()
    ) {
        todayBtn.style.display = "none";
    }else{
        todayBtn.style.display = "flex";
    }
}

// let's hide today btn if tis already current month and vice versa
function hideTodayBtn() {
    if (
        currentMonth === new Date().getMonth() &&
        currentYear === new Date().getFullYear()
    ) {
        todayBtn.style.display = "none";
    }else{
        todayBtn.style.display = "flex";
    }
}

// 일 클릭 시 
function selectDay() {
    // 일 클릭 시 이벤트
    daysContainer.addEventListener("click",(event)=>{
        if (event.target.classList.contains("day")) {
            // 이미 선택된 날짜에서 클래스 제거
            const selectedDay = daysContainer.querySelector(".selectDay");
            if (selectedDay) {
                selectedDay.classList.remove("selectDay");
            }
            if (!event.target.classList.contains("today")) {
                // 클린한 날짜가 today이 아닌 경우만 css 적용
                event.target.classList.add("selectDay"); // 클릭된 날짜에 클래스 추가
            }
        }
    });
}


/**
 * Donut Chart
*/

