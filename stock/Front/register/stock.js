let register = document.getElementById('register');

let pname = document.getElementById('pname');
let price = document.getElementById('price');
let pnum = document.getElementById('pnum');
let categories = document.getElementsByName('category');

let inputForm = document.getElementById("inputForm");

register.addEventListener('click',validation);


function validation(){
    if(pname.value.length==0) {
        alert("물품명을 입력해주세요");
        pname.select();
        return;
    }
    if(price.value.length==0) {
        alert("물품 가격을 입력해주세요");
        price.select();
        return;
    }
    if(pnum.value.length==0) {
        alert("물품 개수를 입력해주세요");
        pnum.select();
        return;
    }
    let isChecked = false;
    categories.forEach((node)=>{
        if(node.checked) {
            // console.log(node.value); 
            let category = node.value;
            isChecked=true;
        }
    })

    if(!isChecked){
        alert("카테고리 1개 꼭 선택 해주세요");
        return;
    }

    inputForm.reset();
    
}



