$(document).on("click", "#btnagregarcurso", function() {
	$("#txtnomcurso").val("");
	$("#txtcredcurso").val("");
	$("#hddidcurso").val("0");
	$("#modalcurso").modal("show");
});
$(document).on("click", ".btnactualizarcurso", function() {
	$("#txtnomcurso").val($(this).attr("data-nomcurso"));
	$("#txtcredcurso").val($(this).attr("data-credcurso"));
	$("#hddidcurso").val($(this).attr("data-codcurso"));
	$("#modalcurso").modal("show");
});
$(document).on('input', '#txtcredcurso', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});
$(document).on("click", "#btnregistrarcurso", function() {
	//alert("Hizo clic en el botón login"); Envio de alerta para el cliente.
	//console.log("Hizo clic en el botón login"); // Imprime mensajes en la consola del navedaor.
	//$("#txtusuario") => obtengo el elemento de la vista (pagina JSP)    
	//$("#txtusuario").val() => obtengo el VALOR del elemento de la vista (INPUT)    
	//$("#txtusuario").text() => seteo el VALOR del elemento de la vista (SPAN)    
	if ($("#txtnomcurso").val() === "") {
		$("#errornomcurso").text("Es obligatorio ingresar el nombre del curso.");
	} else {
		$("#errornomcurso").text("");
	}
	if ($("#txtcredcurso").val() === "") {
		$("#errorcredcurso").text("Es obligatorio ingresar el crédito del curso.");
	} else {
		$("#errorcredcurso").text("");
	}
	if ($("#txtnomcurso").val() !== "" && $("#txtcredcurso").val() !== "") {
		if ($("#hddidcurso").val() === "0") {
			$.ajax({
				type: 'POST',
				contentType: 'application/json',
				url: "/Curso/registrarCurso",
				data: JSON.stringify({
					nomcurso: $("#txtnomcurso").val(),
					credito: $("#txtcredcurso").val()
				}),
				success: function(resultado) {
					if (resultado.respuesta) {
						//alert("Se registró el curso correctamente.");
						mostrarMensaje(resultado.mensaje, "success");
						ListarCursos();
					} else {
						//alert("Ocurrio un error en la base de datos.");
						mostrarMensaje(resultado.mensaje, "danger");
					}
				}
			});
		} else {
			$.ajax({
				type: 'POST',
				contentType: 'application/json',
				url: "/Curso/registrarCurso",
				data: JSON.stringify({
					idcurso: $("#hddidcurso").val(),
					nomcurso: $("#txtnomcurso").val(),
					credito: $("#txtcredcurso").val()
				}),
				success: function(resultado) {
					if (resultado.respuesta) {
						//alert("Se actualizó el curso correctamente.");
						mostrarMensaje(resultado.mensaje, "success");
						ListarCursos();
					} else {
						//alert("Ocurrio un error en la base de datos.");
						mostrarMensaje(resultado.mensaje, "danger");
					}
				}
			});
		}
		$("#modalcurso").modal("hide");
	}
	//console.log($("#hddidcurso").val());

});
$(document).on("click", ".btneliminarcurso", function() {
	$("#hddidcursoeliminar").val("");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el curso: " + $(this).attr("data-nomcurso") + "?");
	$("#hddidcursoeliminar").val($(this).attr("data-codcurso"));
	$("#modaeliminarcurso").modal("show");
});
$(document).on("click", "#btneliminarcurso", function() {
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/Curso/eliminarCurso',
		data: JSON.stringify({
			idcurso: $("#hddidcursoeliminar").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				mostrarMensaje(resultado.mensaje, "success")
				//alert("Se eliminó el curso correctamente.");
				ListarCursos();
			} else {
				mostrarMensaje(resultado.mensaje, "danger");
				//alert("Ocurrió un error en la base de datos.");
			}
			$("#modaeliminarcurso").modal("hide");
		}
	});
})

function ListarCursos() {
	$.ajax({
		type: 'GET',
		url: "/Curso/listarCursos",
		dataType: 'json',
		success: function(resultado) {
			$("#tblcurso > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcurso > tbody").append("<tr>" +
					"<td>" + value.idcurso + "</td>" +
					"<td>" + value.nomcurso + "</td>" +
					"<td>" + value.credito + "</td>" +
					"<td><button type='button' class='btn btn-primary btnactualizarcurso'" +
					" data-codcurso='" + value.idcurso + "' " +
					" data-nomcurso='" + value.nomcurso + "' " +
					" data-credcurso='" + value.credito + "' " +
					">Actualizar</button></td>" +
					"<td><button type='button' class='btn btn-danger btneliminarcurso'" +
					" data-codcurso='" + value.idcurso + "' " +
					" data-nomcurso='" + value.nomcurso + "' " +
					">Eliminar</button></td>" +
					"</tr>");
			});
		}

	});
}

function mostrarMensaje(mensaje, estilo){
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-"+estilo+" alert-dismissible fade show' role='alert'>"+
		"<strong>"+ mensaje+ "</strong>"+
		"<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'>" +
		"</button></div>")
}