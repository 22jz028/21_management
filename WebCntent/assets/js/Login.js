import {ajax} from './lib/module.js';

(function(){
	const eluser_name = document.querySelector('#user-name');
	const elpass = document.querySelector('#user-pass');
	const ellogin = document.querySelector('#user-login');
	
	
	ellogin.addEventListener('click' , () =>{
		const obt = {
			user_name : eluser_name.value,
			passward : elpass.value
		};
		ajax('http://localhost:8080/management/Login', 'post', obt)
		.then(res => {
            console.log("jsで表示", res);
            if (res.status === 'login:だめ') {
                alert('ログインに失敗しました。ユーザー名とパスワードを確認してください。');
            } else {
                sessionStorage.setItem("login_userid", res);
                location.href = "../items/index.html";
            }
        })
        .catch(error => {
            console.error('エラーが発生しました:', error);
            alert('ログイン中にエラーが発生しました。');
        });
	});
})();

