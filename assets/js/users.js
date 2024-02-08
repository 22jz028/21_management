import {ajax} from "./lib/module.js";

(function () {
    ajax('/21_management/Users')
        .then(res => {
            let users = res;
            console.log("users.js:", users);

            const elList = document.querySelector('.users-list');
            console.log(elList);

            // テーブルのヘッダーを一度だけ表示
            const elTable = document.createElement('table');
            elTable.innerHTML = `
                <tr>
                    <th>ユーザー名</th>
                    <th>メールアドレス</th>
                    <th>ユーザーコード</th>
                    <th></th>
                </tr>
            `;
            elList.appendChild(elTable);

            // 各アイテムを追加
            users.forEach(list => {
                const users = document.createElement('tr');
                users.innerHTML = `
                    <th>${list.user_name}</th>
                    <th>${list.email}</th>
                    <th>${list.id}</th>
                `;

                // 新しい行をテーブルに追加
                elTable.appendChild(users);
            });
        })
})();