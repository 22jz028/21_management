//import ajax from "./Ajax.js";
//
//(function(){
//	ajax('/management/ItemList')
//	.then(res => {
//		let items = res;
//		console.log("script.js:", items);
////		items.forEach(element =>{
////			const elName = document.querySelector('.name');
////			const elPrice = document.querySelector('.price');
////			const elId = document.querySelector('.id');
////			elName.innerHTML =+ items[i].product_name;
////			elPrice.innerHTML =+ items[i].price;
////			elId.innerHTML =+ items[i].id;
//			
//			const elList = document.querySelector('.list-item');
//            console.log(elList);
//			items.forEach(list => {
//			const elItem = `
//			<tr>
//				<th>${list.name}</th>
//				<th>${list.price}</th>
//				<th>${list.id}</th>
//				<th><button>編集画面</button></th>
//			</tr>
//			`			
//			
//			elList.innerHTML = `
//			 <tr>
//	            <th>商品画像</th>
//	            <th>商品名</th>
//	            <th>商品価格</th>
//	            <th>商品コード</th>
//	            <th></th>
//       		 </tr>
//			`;
//			elList.innerHTML += elItem;
//			})
//			
//			
////		if (items[0].product_name) {
//        // レスポンスに名前が入ってれば成功とみなす
////        const elName = document.querySelector('.name');
////        const elPrice = document.querySelector('.price');
////        const elId = document.querySelector('.id');
////        elName.innerHTML = items[0].product_name;
////        elPrice.innerHTML = items[0].price;
////        elId.innerHTML = items[0].id;
////		}	
//        
//	})
//})()





import ajax from "./Ajax.js";

(function () {
    ajax('/management/ItemList')
        .then(res => {
            let items = res;
            console.log("script.js:", items);

            const elList = document.querySelector('.list-item');
            console.log(elList);

            // テーブルのヘッダーを一度だけ表示
            const elTable = document.createElement('table');
            elTable.innerHTML = `
                <tr>
                    <th>商品画像</th>
                    <th>商品名</th>
                    <th>商品価格</th>
                    <th>商品コード</th>
                    <th></th>
                </tr>
            `;
            elList.appendChild(elTable);

            // 各アイテムを追加
            items.forEach(list => {
                const elItem = document.createElement('tr');
                elItem.innerHTML = `
                    <th>${list.product_name}</th>
                    <th>${list.price}</th>
                    <th>${list.id}</th>
                    <th><button>編集画面</button></th>
                `;

                // 新しい行をテーブルに追加
                elTable.appendChild(elItem);
            });
        })
})();
