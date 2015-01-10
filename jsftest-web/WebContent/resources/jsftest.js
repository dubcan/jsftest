var msg = function msg(data) {
	console.log("msg starting...")
	if (data.status != "success")
		return;

	// getElementsByTagName

	function hasErrors() {
		console.log("has errors called");
		var errorAreas = [ "registerUser:nameErrorMessage",
				"registerUser:surnameErrorMessage",
				"registerUser:emailErrorMessage", "registerCard:",
				"registerCard:", "registerCard:", ];

		return errorAreas.some(function(entry) {
			var errorArea = document.getElementById(entry);
			if (errorArea == null) {
				console.log("entry " + entry + " has no error area");
				return false;
			}

			if (errorArea.innerHTML !== null && errorArea.innerHTML !== "") {
				console.log("shit! we have errors on " + entry + "!");
				return true;
			}

		});
	}

	if (!hasErrors()) {
		console.log("no errors! now show next form");
		document.getElementById("registerCard").style.display = "inline-block";
	} else {
		console.log("we have errors!");
	}
};