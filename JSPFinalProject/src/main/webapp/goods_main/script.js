const openModal = (item) => {
	console.log(item);
	document.getElementById(item).classList.add("show");
};

const closeModal = (item) => {
	console.log(item);
	document.getElementById(item).classList.toggle("show");
};