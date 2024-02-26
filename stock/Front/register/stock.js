let register = document.getElementById('register');
let input = document.getElementsByTagName('input');
let category = document.getElementsByName('category');
let inputForm = document.getElementById("inputForm");

register.addEventListener('click',validation);


function validation(){
    for(let i=0;i<3;i++){
        console.log(input[i].value);
        if(input[i].value.length==0) {
            alert("값을 입력하세요.");
            input[i].select();
            return;
        }
    }
    
    category.forEach((node)=>{
        if(node.checked) console.log(node.value);
    })

    inputForm.reset();
    
}



