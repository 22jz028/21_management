import {ajax} from './lib/module.js';
(function(){
	const elItemName = document.querySelector('#item-name');
	const elPrice = document.querySelector('#item-price');
	const elstock = document.querySelector('#item-stoc');
	const eldescription = document.querySelector('#item-text');
	const elimage = document.querySelector('#item-image');
	const elmaterial = document.querySelector('#material');
	const elsizename = document.querySelector('#sizename');
	const elcategory = document.querySelector('#category');
	const elADDcreate = document.querySelector('#create');
	
	elADDcreate.addEventListener('click', () =>{
		const obt = {
			product_name : elItemName.value,
			price : elPrice.value,
			description : eldescription.value,
			stock : elstock.value,
			image : elimage.value,
			material : elmaterial.value,
			sizename : elsizename.value,
			category : elcategory.value
		};
		ajax('http://localhost:8080/21_management/create','post', obt)
		.then(res =>{
			alert('追加しました');
		})
	})
})();