function getSonstigesFeld() {
	  var selectField = document.getElementById("addToCult");
	  var textField = document.getElementById("mySonstigesText");
	  if(selectField.value == "showTextFeld")
	    textField.style.visibility = "visible";
	  else {
	    textField.style.visibility = "hidden";
	  }
	}