
import {ajax} from "./lib/module.js";

(function () {
	    ajax('/management/history')
        .then(res => {
            let users = res;
            console.log("history.js:", users);

            const elList = document.querySelector('#history');
            console.log(elList);

            // テーブルのヘッダーを一度だけ表示
            const elhistory = document.createElement('table');
            elhistory.innerHTML = `
                <tr>
                    <th>履歴id</th>
                    <th>商品名</th>
                    <th>ユーザーid</th>
                    <th>数量</th>
                    <th>配送状況</th>
                </tr>
            `;
            elList.appendChild(elhistory);

            // 各アイテムを追加
            users.forEach(list => {
                const users = document.createElement('tr');
                users.innerHTML = `
                    <th>${list.id}</th>
                    <th>${list.product_name}</th>
                    <th>${list.user_id}</th>
                    <th>${list.item_number}</th>
                    <th>${list.state}</th>
                `;

                // 新しい行をテーブルに追加
                elhistory.appendChild(users);
            });
      })
      const elstate = document.querySelector('#state');
      const elStateupdate = document.querySelector('#stateupdate');
      const elid = document.querySelector('#id');
      elStateupdate.addEventListener('click', () =>{
		const obt = {
			id : elid.value,
			state : elstate.value
		};
		console.log("通った")
		ajax('http://localhost:8080/management/history','post', obt)
		.then(res =>{
		})
	})
})();