var app =  {
    $wrapper :  $wrapper = document.querySelector('#wrapper'),
    init : init
}; 
var customer = {
    join_form : join_form,
    join : join,
    login_form : login_form,
    login : login,
    mypage : mypage,
    mypage_form : mypage_form,
    count : count,
    update_form : update_form,
    update : update,
    remove : remove
};
var employee = {
    login : login,
    customer_list : customer_list,
    admin_login : admin_login,
    customer_list_form : customer_list_form
};
var session = {
    set_value : set_value,
    get_value : get_value
};
//customerId customerName ssn phone city
function customer_list_form(){
    return '<h2>고객목록</h2>'+
    '<table id="customer-table">'+
        '<tr>'+
            '<th>아이디</th>'+
            '<th>고객명</th>'+
            '<th>주민번호</th>'+
            '<th>전화번호</th>'+
            '<th>도시</th>'+
        '</tr>'+  
        '<tbody id="tbody">'+
        '<tbody>'+
    '</table>';
 }

function set_value(x){
    sessionStorage.setItem(x.name,x.value);
}
function get_value(x){
    return sessionStorage.getItem(x);
}
function init(){
    $wrapper.innerHTML = customer.login_form();
    document.getElementById('join-btn')
        .addEventListener('click',()=>{
            alert("회원가입버튼 클릭");
            $wrapper.innerHTML = customer.join_form();
            document.getElementById('confirm-btn')
            .addEventListener('click', e=>{
                e.preventDefault();
                customer.join();
        });
});
document.getElementById('login-btn')
    .addEventListener('click',e=>{
        e.preventDefault();
        alert('로그인 버튼 클릭');
        customer.login({userid : 'customerId',
                        domain : 'customers'
                        });
});
document.getElementById('admin-btn')
    .addEventListener('click',e=>{
        e.preventDefault();
        alert('관리자 버튼 클릭');
        employee.admin_login();
    });
}
function admin_login(){
    let isAdmin = confirm("관리자입니까?");
    if(isAdmin){
        let pass = prompt("관리자 번호를 입력하세요");
        if(pass == 1000){
            employee.customer_list();
        }else{
            alert('입력한 번호가 일치하지 않습니다.');
        }
    }else{
    alert('관리자만 접속이 가능합니다.');  
    }
}
function customer_list(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'customers', true);
    alert("리스트뿌리기");
    
    xhr.onload=()=>{
        if(xhr.readyState=== 4 && xhr.status === 200){
            //let d = JSON.parse(xhr.responseText);  
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = employee.customer_list_form();
            let tbody = document.getElementById('tbody');
            let i = 0;
            let rows = '';
            for(;i<5; i++){
                rows += "<tr><td>"+i+"</td><td>"+i+"</td>"+
                "<td>"+i+"</td><td>"+i+"</td><td>"+i+"</td></tr>"
            }
            tbody.innerHTML = rows;
        
            let blocks = document.createElement('div');
            blocks.setAttribute('id', 'blocks');
            wrapper.appendChild(blocks);
            let spans = '';
            i = 1;
            for(;i<6;i++){
                spans += "<span style='display:inline-block;padding-right:20px;border: 1px solid black;'>"+i+"</span>";
            }
            blocks.innerHTML=spans;
        }
    };
    xhr.send();
}

function join_form(){
    return '<form>'
    +'아이디<br>'
    +'	<input type="text" id="customerId" name="customerId"><br>'
    +'비밀번호<br>'
    +'	<input type="password" id="password" name="password"><br>'
    +'이 름<br>'
    +'	<input type="text" id="customerName" name="customerName"><br>'
    +'주민번호<br>'
    +'	<input type="text" id="ssn" name="ssn"><br>'
    +'전화번호<br>'
    +'	<input type="text" id="phone" name="phone"><br>'
    +'도 시<br>'
    +'	<input type="text" id="city" name="city"><br>'
    +'주 소<br>'
    +'	<input type="text" id="address" name="address"><br>'
    +'우편번호<br>'
    +'	<input type="text" id="postalcode" name="postalcode"><br>'
    +'<br><br>'
    +'	<input id="confirm-btn" type="submit" value="확인">'
    +'	<input id="cancel-btn" type="reset" value="취소">'
    +'</form>';
}
function join(){
    let xhr = new XMLHttpRequest();
    alert('join함수');
    alert(document.getElementById('customerId').value);
    alert(document.getElementById('ssn').value);////////////////////////////////////
    let data = {
        customerId : document.getElementById('customerId').value, 
        customerName : document.getElementById('customerName').value,
        password : document.getElementById('password').value,
        ssn : document.getElementById('ssn').value ,
        phone : document.getElementById('phone').value,
        city : document.getElementById('city').value,
        address : document.getElementById('address').value,
        postalcode : document.getElementById('postalcode').value
        
    };
    xhr.open('POST','customers',true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8')
    xhr.onload=()=>{
        if(xhr.readyState==4 & xhr.status==200){
            
            let d = JSON.parse(xhr.responseText);
            alert("d : " +d);
            if(d.result==='SUCCESS'){
                alert('회원가입 성공 :'+d.result);
                //  로그인 폼...
            }else{
                alert('회원가입 실패');
            }
        }else{
            alert('AJAX 실패');
        }
    };
    xhr.send(JSON.stringify(data));
}

function login_form(){
    return '<form>'
    +'  아이디:<br>'
    +'  <input type="text" id="customerId" name="customerId">'
    +'  <br>'
    +'  비밀번호:<br>'
    +'  <input type="text" id="password" name="password">'
    +'  <br><br>'
    +'  <input id="login-btn" type="button" value="LOGIN">'
    +'  <input id="join-btn" type="button" value="JOIN">'
    +'  <input id="admin-btn" type="button" value="관리자">'
    +'</form> ';
}
function login(x){
    id = document.getElementById(x.userid).value;
    pass = document.getElementById('password').value;
    let xhr = new XMLHttpRequest();
    xhr.open('GET', x.domain+'/'+id+'/'+pass, true);
    xhr.onload=()=>{
        if(xhr.readyState=== 4 && xhr.status === 200){
            let d = JSON.parse(xhr.responseText);
            alert('세션에 들어간 이름: '+d.customerId)
            session.set_value({'name':'userid','value':d.customerId});
            session.set_value({'name':'username','value':d.customerName});
            if(d){
                if(x.domain==='customers'){                
                    customer.mypage(d);
                }else{
                    employee.customer_list();
                }
                
            }else{
                app.init();
            }
            
        }
    };
    xhr.send();
}

function mypage(x){
$wrapper.innerHTML = customer.mypage_form(x);

document.querySelector('#update-btn')
    .addEventListener('click',e=>{
        e.preventDefault();
        alert('세션 테스트 ID' + session.get_value('userid'));
        alert('세션 테스트 NAME' + session.get_value('username'));
        customer.update(x);
    });
document.querySelector('#remove-btn')
    .addEventListener('click',e=>{
        e.preventDefault();
        alert('탈퇴버튼 클릭'+x.customerId);
        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'customers/'+x.customerId, true);
        xhr.onload=()=>{
            if(xhr.readyState=== 4 && xhr.status === 200){
                app.init();
            }
        };
        xhr.send();
    });
}

function mypage_form(x){
    let customer = x;
    return '<h1>'+customer.customerName+' 마이페이지</h1> <br>'
    +'아이디<br>'
    +'<span id="customerId">'+customer.customerId+'</span><br>'
    +'비밀번호<br>'
    +'	<span id="password">'+customer.password+'</span><br>'
    +'이 름<br>'
    +'<span id="customerName">'+customer.customerName+'</span>'
    +'주민번호<br>'
    +'<span id="ssn">'+customer.ssn+'</span>'
    +'전화번호<br>'
    +'	<span id="phone">'+customer.phone+'</span><br>'
    +'도 시<br>'
    +'	<span id="city">'+customer.city+'</span><br>'
    +'주 소<br>'
    +'	<span id="address">'+customer.address+'</span><br>'
    +'우편번호<br>'
    +'	<span id="postalcode">'+customer.postalcode+'</span><br>'
    +'<br><br>'
    +'	<input id="update-btn" type="button" value="수 정">'
    +'	<input id="remove-btn" type="button" value="탈 퇴">';
}
function count(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'count', true);
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200){
            alert('성공');
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
        }
    }
    xhr.send();
}
function update_form(x){
    return '<form>'
    +'아이디<br>'
    +'	<span id="customerId">'+x.customerId+'</span><br>'
    +'비밀번호<br>'
    +'	<input type="password" id="password" name="password" value="'+x.password+'"><br>'
    +'이 름<br>'
    +'	<span id="customerName">'+x.customerName+'</span><br>'
    +'주민번호<br>'
    +'	<span id="ssn">'+x.ssn+'</span><br>'
    +'전화번호<br>'
    +'	<input type="text" id="phone" name="phone" value="'+x.phone+'"><br>'
    +'도 시<br>'
    +'	<input type="text" id="city" name="city" value="'+x.city+'"><br>'
    +'주 소<br>'
    +'	<input type="text" id="address" name="address" value="'+x.address+'"><br>'
    +'우편번호<br>'
    +'	<input type="text" id="postalcode" name="postalcode" value="'+x.postalcode+'"><br>'
    +'<br><br>'
    +'	<input id="confirm-btn" type="submit" value="확 인">'
    +'	<input id="cancel-btn" type="reset" value="취 소">'
    +'</form>';
}
function update(x){
    let wrapper = document.querySelector('#wrapper');
    wrapper.innerHTML = customer.update_form(x);
    alert('수정할 아이디: '+ document.getElementById('customerId').innerText );
    document.getElementById('confirm-btn')
        .addEventListener('click', e=>{
            e.preventDefault();
            let data = {
                customerId : document.getElementById('customerId').innerText ,
                customerName : document.getElementById('customerName').innerText ,
                password : document.getElementById('password').value,
                ssn : document.getElementById('ssn').innerText ,
                phone : document.getElementById('phone').value,
                city : document.getElementById('city').value,
                address : document.getElementById('address').value,
                postalcode : document.getElementById('postalcode').value
            }
            let xhr = new XMLHttpRequest();
            xhr.open('PUT','customers/'+x.customerId,true);
            xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
            xhr.onload=()=>{
                if(xhr.readyState===4 && xhr.status === 200){
                    let d = JSON.parse(xhr.responseText);
                    customer.mypage(d);
                }
            };
            xhr.send(JSON.stringify(data));    
        });
}

function remove(){
    let customerId = document.getElementById('customerId');
    let xhr = new XMLHttpRequest();
    xhr.open('delete','customers/'+customerId,true);
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200){
            alert('성공');
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
        }
    };
    xhr.send();
}