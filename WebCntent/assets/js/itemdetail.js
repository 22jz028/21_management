import {ajax} from './lib/module.js';   // 使いたい関数をインポート

(function(){
  /* HTML要素 */
  const elid = document.querySelector('#item-id');
  const elidd = document.querySelector('#item-idd');
  const elItemName = document.querySelector('#item-name');
  const elPrice = document.querySelector('#item-price');
  const eldescription = document.querySelector('#item-text');
  const elmaterial = document.querySelector('#item-material');
  const elsizename = document.querySelector('#item-sizename');
  const elimage = document.querySelector('#item-image');
  const elupdate = document.querySelector('#update');
  const eldalete = document.querySelector('#delet');



  /* その他の変数 */
//  let item = {};

  /* GETパラメータを取得 */
//  const params = GetParameter(window.location);
    // パラメータを全て表示
//    console.log(params);
  

  /* 画面表示時：商品詳細を読み込む */
//  ajax('/management/Itemdetail', 'get', obt)
//  .then(res => {
    // console.log(res);
    // データを一時格納
//    item = res;
    // 取得したデータを画面に表示
//    elItemName.value = item.product_name;
//    elPrice.value = item.price;
//    eldescription.value = item.description;
//    elmaterial.value = item.material;
//    elsizename.value = item.sizename;
//    elimage.value = item.image;
//  });

  elupdate.addEventListener('click', () => {
    // 登録データ
    const obt = {
      id : elid.value,
      product_name : elItemName.value,
      price : elPrice.value,
      description : eldescription.value,
      material : elmaterial.value,
      sizename : elsizename.value,
      image : elimage.value 
    };
    ajax('http://localhost:8080/management/itemdetail', 'post', obt)
    .then(res => {
      alert('更新しました');
    });
  });
  eldalete.addEventListener('click', () => {
    // 登録データ
    const obt = {
      id : elidd.value,
    };
    ajax('http://localhost:8080/management/Itemdelet', 'post', obt)
    .then(res => {
      alert('削除しました');
    });
  });
})();