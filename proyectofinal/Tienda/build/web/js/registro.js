function registrarlogin(){
    debugger;
    var txtnombre = $('#txtnombre').val();
    var txtapellido = $('#txtapellido').val();
    var txtcorreo = $('#txtcorreo').val();
    var txtfecha = $('#txtfechanacimiento').val();
    var txtusername = $('#txtcorreo').val();
    var txtpassuser = $('#txtfechanacimiento').val();


    
    var dato = {
        nombre:txtnombre,
        apellidop:txtapellido,
        apellidom:txtapellido,
        correo:txtcorreo,
        fecha_nacimiento:txtfecha,
        username:txtusername,
        passuser:txtpassuser
    }
    $.ajax({
        type: "POST",
        url: "api/usuarios/insert",
        "headers": {
            "Content-Type": "application/json"
          },
        data: JSON.stringify(dato),
        dataType: "json",
        success: function (response) {
            debugger;
            if (response.isOK) {
                Swal.fire({
                    title: '<h4>Registro Exitoso</h4>',
                    icon: 'info',
                    text:
                    'Se registro exitosamente',
                    showCancelButton: true,
                    showConfirmButton: false,
                    });
                $(location).attr('href', 'login.html');
            }else{
                Swal.fire({
                    title: '<h4>Registro sin exitos</h4>',
                    icon: 'info',
                    text:
                    'Intente nuevamente',
                    showCancelButton: true,
                    showConfirmButton: false,
                    });
                $(location).attr('href', 'login.html');
            }
        },
        error: function (error) {
            Swal.fire({
                title: '<h4>Registro sin exitos</h4>',
                icon: 'info',
                text:
                'Intente nuevamente',
                showCancelButton: true,
                showConfirmButton: false,
                });
        }
    });
}

function comprobarnulos($dato) {
    if ($datos === "") {
        return false;
    }
    return $dato;
}

function cancelar() {
    $(location).attr('href', 'login.html');
}