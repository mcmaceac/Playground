/**
 * 
 */
function validate() {
	var ok = true;
	var p = document.getElementById("principal").value;
	var errMessage = "";
	
	if (isNaN(p) || p <= 0) {
		document.getElementById("principalError").innerHTML = "*";
		//alert("Principal invalid!");
		errMessage += "Principal invalid!\n";
		ok = false;
	}
	else {
		document.getElementById("principalError").innerHTML = "";
	}
	
	p = document.getElementById("interest").value;
	if (isNaN(p) || p <= 0 || p >= 100 || p == null) {
		document.getElementById("interestError").innerHTML = "*";
		//alert("Interest invalid!");
		errMessage += "Interest invalid!\n";
		ok = false;
	}
	else {
		document.getElementById("interestError").innerHTML = "";
	}
	
	p = document.getElementById("period").value
	if (isNaN(p) || p <= 0) {
		document.getElementById("periodError").innerHTML = "*";
		errMessage += "Period invalid!\n";
		ok = false;
	}
	else {
		document.getElementById("periodError").innerHTML = "";
	}
	
	if (!ok) {
		alert(errMessage);
	}
	
	return ok
}