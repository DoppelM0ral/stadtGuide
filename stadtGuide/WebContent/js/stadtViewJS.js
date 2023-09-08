function showOption(option){
	
	document.getElementById("restaurant").classList.add("hidden");
	document.getElementById("unterkunft").classList.add("hidden");
	document.getElementById("kultur").classList.add("hidden");
	document.getElementById("aktivitaet").classList.add("hidden");

	if(option.value == "restaurant"){
		document.getElementById("restaurant").classList.remove("hidden");
	}else if(option.value == "unterkunft"){
		document.getElementById("unterkunft").classList.remove("hidden");
	}else if(option.value == "kultur"){
		document.getElementById("kultur").classList.remove("hidden");
	}else if(option.value == "aktivitaet"){
		document.getElementById("aktivitaet").classList.remove("hidden");
	}
}