var showUserForm = function showUserForm(data) {
	console.log("showUserForm starting...")
	if (data.status != "success")
		return;
	
	
	console.log("hide init form and show user form")
	document.getElementById("initForm").style.display = "none";
	document.getElementById("registerUserForm").style.display = "inline-block";
	
}

var showCardRegisterForm = function showCardRegisterForm(data) {
	console.log("msg starting...")
	if (data.status != "success")
		return;

	function hasErrors() {
		console.log("has errors called");
		var errorAreas = [ "registerUserForm:nameErrorMessage",
				"registerUserForm:surnameErrorMessage",
				"registerUserForm:emailErrorMessage", "registerCard:",
				"registerCard:", "registerCard:", ];

		return errorAreas.some(function(entry) {
			var errorArea = document.getElementById(entry);
			if (errorArea == null) {
				console.log("entry " + entry + " has no error area");
				return false;
			}

			if (errorArea.innerHTML !== null && errorArea.innerHTML !== "") {
				console.log("we have errors on " + entry + "!");
				return true;
			}

		});
	}

	if (!hasErrors()) {
		console.log("no errors! now show next form");
		document.getElementById("registerCardForm").style.display = "inline-block";
	} else {
		console.log("we have errors!");
	}
};