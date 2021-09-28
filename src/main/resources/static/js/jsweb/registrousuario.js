$(document).on("submit", "form", function(event) {
	var passwordvalido = true;
	if ($("#txtnombres").val() === "") {
		$("#errornombres").text("Es obligatorio ingresar su nombre.");
		event.preventDefault();
	} else {
		$("#errornombres").text("");
		event.preventDefault();
	}
	if ($("#txtapellidos").val() === "") {
		$("#errorapellidos").text("Es obligatorio ingresar su apellido.");
		event.preventDefault();
	} else {
		$("#errorapellidos").text("");
		event.preventDefault();
	}
	if ($("#txtusuario").val() === "") {
		$("#errorusuario").text("Es obligatorio ingresar su usuario.");
		event.preventDefault();
	} else {
		$("#errorusuario").text("");
		event.preventDefault();
	}
	if ($("#txtpassword").val() === "") {
		passwordvalido = false;
		$("#errorpassword").text("Es obligatorio ingresar su password.");
		event.preventDefault();
	} else {
		if($("#txtpassword").val().match(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$/)){
			passwordvalido = true;
			$("#errorpassword").text("");
			event.preventDefault();
		}else{
			passwordvalido = false;
			$("#errorpassword").text("Su password debe tener 8 caracteres 1 letra mayúscula y 1 número.");
			event.preventDefault();
		}
	}
	if ($("#txtnombres").val() !== "" && $("#txtapellidos").val() !== ""&& 
		$("#txtusuario").val() !== "" && passwordvalido) {
		return;		
	}
});