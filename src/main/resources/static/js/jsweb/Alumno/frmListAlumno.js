$(document).ready(function() {
	$("#tblalumno").hide();
});
$(document).on("change", "#cboespecialidad", function() {
	var idespecialidad = $("#cboespecialidad").val();
	alert(idespecialidad);
	if (idespecialidad === "0") {
		$("#tblalumno").hide();
		$("#tblalumno").html("");
		alert("Seleccione un curso");
	} else {
		$.ajax({
			type: 'GET',
			url: "/Alumno/listarAlumnosxEspecialidad",
			data: {
				idesp: idespecialidad
			},
			success: function(data) {
				//console.log(data);
				$("#tblalumno").html("");
				if (data.length > 0) {
					$.each(data, function(index, value) {
						procedencia = value.proce == "P" ? "Particular" : "Estatal";
						$("#tblalumno").append("<div class='col mb-4'>" +
							"<div class='card h-100 border-primary'>" +
							"<img src='/img/silueta.jpg' class='card-img-top' >" +
							"<div class='card-body'>" +
							"<h5 class='card-title'><b>Cod.Alumno: " + value.idalumno + "</b></h5>" +
							"<p class='card-text'>" + value.apealumno + " " + value.nomalumno + "<br />" +
							"Colegio: " + procedencia + "<br />" +
							"<button data-codalumno='"+value.idalumno+"' type='button' class='btn btn-primary btnvernotas'>Ver Notas</button>" +
							"</p></div></div></div>");
					});
					$("#tblalumno").show();
				} else {
					$("#tblalumno").hide();
					$("#tblalumno").html("");
				}
			}
		});
	}
});
$(document).on("click", ".btnvernotas", function() {
	$("#modalcursosnota").modal("show");
	$.ajax({
		type: 'GET',
		url: "/Alumno/listarCursosNotasxAlumno",
		data: {
				idalumno: $(this).attr("data-codalumno")
			},
		dataType: 'json',
		success: function(resultado) {
			console.log(resultado);
			$("#tblcursonota > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcursonota > tbody").append("<tr>" +
					"<td>" + value.nomcurso + "</td>" +
					"<td class='text-center'>" + value.credito + "</td>" +
					"<td class='text-center'>" + value.exaparcial + "</td>" +
					"<td class='text-center'>" + value.exafinal + "</td>" +
					"</tr>");
			});
		}

	});
});