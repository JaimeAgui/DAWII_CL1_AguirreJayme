$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtprocedencia").val("");
    $("#hddidalumno").val("0");
    $("#cboespecilidad").empty();
    $.ajax({
        type: "GET",
        url: "/Especilidad/listarEspecilidad",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecilidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnombre").val($(this).attr("data-nomalumno"));
    $("#txtapellido").val($(this).attr("data-apealumno"));
    $("#txtprocedencia").val($(this).attr("data-proce"));
    $("#hddidalumno").val($(this).attr("data-idalumno"));
    $("#cboespecilidad").empty();
    var idespe = $(this).attr("data-idesp");
    $.ajax({
        type: "GET",
        url: "/Especilidad/listarEspecilidad",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecilidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
            $("#cboespecilidad").val(idespe);
        }
    })
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnregistrar", function(){
    $.ajax({
        type: "POST",
        url: "/registrarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalumno").val(),
            apealumno: $("#txtnombre").val(),
            nomalumno: $("#txtapellido").val(),
            idesp: $("#cboespecilidad").val(),
            proce: $("#txtprocedencia").val()
        }),
        success: function(resultado){
        if(resultado.respuesta){
                    }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});



$(document).on("click", ".btneliminar", function(){
    var idalumno = $(this).attr("data-idalumno");
    $.ajax({
        type: "DELETE",
        url: "/eliminarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: idalumno
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarAlumno();
            }
            alert(resultado.mensaje);
        }
    });

});


function ListarAlumno(){
    $.ajax({
        type: "GET",
        url: "/listarAlumno",
        dataType: "json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.apealumno+"</td>"+
                    "<td>"+value.nomalumno+"</td>"+
                    "<td>"+value.nomesp+"</td>"+
                    "<td>"+value.proce+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'"+
                                      "data-idesp='"+value.idesp+"'"+
                                     "data-proce='"+value.proce+"'>Actualizar</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'>Eliminar</button>"+
                    "</td></tr>");
            })
        }
    })
}



