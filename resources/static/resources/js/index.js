alert("자바스크립트 연결성공!!");

var wrapper = document.querySelector('#wrapper');  //js에서 객체가됨(컴포넌트)
wrapper.innerHTML = '<h1>SPA 시작</h1>'
+'<div id="target">삭제할 내용</div>'
+'<button id="btn">지워버리자</button>'
+'<button id="btn2">추가하자</button>';

var btn = document.querySelector('#btn');
var target = document.querySelector('#target');

btn.addEventListener('click', function(){
    target.innerHTML = '';
});

var btn2 = document.querySelector('#btn2');

btn2.addEventListener('click', function(){
    var temp = document.createTextNode('새로 추가됨');
    target.appendChild(temp);
});
