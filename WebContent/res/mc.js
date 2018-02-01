/**
 * 
 */
function validate() {
	var ok = true;
	var p = document.getElementById("principal").value;
	
	if (isNaN(p) || p <= 0) {
		document.getElementById("principalError").innerHTML = "*";
		alert("Principal invalid!");
		ok = false;
	}
	else {
		document.getElementById("principalError").innerHTML = "";
	}
	
	p = document.getElementById("interest").value;
	if (isNaN(p) || p <= 0 || p >= 100) {
		document.getElementById("interestError").innerHTML = "*";
		alert("Interest invalid!");
		ok = false;
	}
	else {
		document.getElementById("interestError").innerHTML = "";
	}
	
	p = document.getElementById("period").value
	if (isNaN(p) || p <= 0) {
		document.getElementById("periodError").innerHTML = "*";
		alert("Period invalid!");
		ok = false;
	}
	else {
		document.getElementById("periodError").innerHTML = "";
	}
	
	return ok
}