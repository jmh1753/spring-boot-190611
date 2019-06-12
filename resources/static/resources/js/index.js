//var app;  연산자가 없어서 선언     선언과 할당을 함꼐하는것 초기화
var app = (()=>{    //바깥펑션은 앱이고 안쪽펑션은 init 
    let init = ()=>{
        login_form();
    }  
    let login_form = ()=>{       
        let wrapper = document.querySelector('#wrapper');  //js에서 객체가됨(컴포넌트)
        wrapper.innerHTML = '<form action="/action_page.php">'
        +'  First name:<br>'
        +'  <input type="text" name="firstname" value="Mickey">'
        +'  <br>'
        +'  Last name:<br>'
        +'  <input type="text" name="lastname" value="Mouse">'
        +'  <br><br>'
        +'  <input id="login_btn"type="button" value="LOGIN">'
        +'  <input id="join_btn" type="button" value="JOIN">'
        +'</form> ';   
        let join_btn = document.querySelector('#join_btn');
        join_btn.addEventListener('click', ()=>{
            join_form();
        });       
    }  


    let join_form = ()=>{
        let wrapper = document.querySelector('#wrapper');
        wrapper.innerHTML = '<form action="/action_page.php">'
        +' First name:<br>'
        +' <input type="text" name="firstname" value="jeong">'
        +' <br>'
        +' Last name:<br>'
        +' <input type="text" name="lastname" value="moonho">'
        +' <br>'
        +' age:<br>'
        +' <input type="text" name="firstname" value="27">'
        +' <br>'
        +' phone:<br>'
        +' <input type="text" name="firstname" value="01055754786">'
        +' <br>'
        +' address:<br>'
        +' <input type="text" name="firstname" value="은평구">'
        +' <br>'
        +' <br><br>'
        +' <input type="button" value="LOGIN" id="login_btn">'
        +' <input type="button" value="JOIN" id="join_btn">'
        +'</form> ';
        let login_btn = document.querySelector('#login_btn');
        login_btn.addEventListener('click', ()=>{
            login_form();
        })
    } 


    return {init : init};   //클로저   펑션은 인풋과 아웃풋이 존재해야함 인풋은 파라미터 아웃풋은 리턴값    클로저는 함수시스템에서 맨마지막 단계 
                 //이닛의 값을 앱에게 전달
})();   







