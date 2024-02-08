
import {ajax} from "./lib/module.js";

(function () {
	const elItemid = document.querySelector('#item-id');
	const elStck = document.querySelector('#item-stock');
	const elstockupdate = document.querySelector('#item-update');
    ajax('/21_management/ItemList')
        .then(res => {
            let items = res;
            console.log("script.js:", items);

            const elList = document.querySelector('.list-item');
            console.log(elList);

            // テーブルのヘッダーを一度だけ表示
            const elTable = document.createElement('table');
            elTable.innerHTML = `
                <tr>
                	<th>商品コード</th>
                    <th>商品名</th>
                    <th>商品価格</th>
                    <th>商品説明</th>
                    <th>素材</th>
                    <th>サイズ名</th>
                    <th>カテゴリー</th>
                </tr>
            `;
            elList.appendChild(elTable);

            // 各アイテムを追加
            items.forEach(list => {
                const elItem = document.createElement('tr');
                elItem.innerHTML = `
                    <th>${list.id}</th>
                    <th>${list.product_name}</th>
                    <th>${list.price}円</th>
                    <th>${list.description}</th>
                    <th>${list.material}</th>
                    <th>${list.sizename}</th>
                    <th>${list.category}</th>

                `;

                // 新しい行をテーブルに追加
            elTable.appendChild(elItem);
            });
            elstockupdate.addEventListener('click', () =>{
				const obt = {
					id : elItemid.value,
					stock : elStck.value
				};
				ajax('http://localhost:8080/21_management/stoc', 'post', obt)
				.then(res =>{
					alert('追加しました');
				})
			})
		})
})();
