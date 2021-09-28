$(document).on("click", "#btnlogin", function() {
	if ($("#txtusuario").val() === "") {
		$("#errorusuario").text("Es obligatorio ingresar su usuario.");
	} else {
		$("#errorusuario").text("");
	}
	if ($("#txtpassword").val() === "") {
		$("#errorpassword").text("Es obligatorio ingresar su password.");
	} else {
		$("#errorpassword").text("");
	}
	if ($("#txtusuario").val() !== "" && $("#txtpassword").val() !== "") {
		$("#frmlogin").submit();		
	}
});