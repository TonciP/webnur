
/*var loader = setInterval(function () {
    if(document.readyState !== "complete") return;
    // clearInterval(loader);
    // alert("Document loaded successful!");
    // document.write("Document loaded successful!");
    alert("inicio");
 }, 300);*/

function verificarlogin(){
    debugger;
    var inputuser=$('#txtuser').val();
    var inputpassword=$('#txtpassword').val();

    var dato = {
        username:inputuser,
        passuser:inputpassword
    };

    $.ajax({
        type: "POST",
        // url: "api/usuarios/login",
        url: "api/usuarios/login",
        data: JSON.stringify(dato),
        dataType: "json",
        "headers": {
            "Content-Type": "application/json"
          },
        success: function (data) {
            debugger;
            if(data.isOK){
                localStorage.setItem("userInSession", data.usuario.usuarioid);
                //document.location.href = "template/paginaprincipal.html";
                //document.cookie = "username=" + data.usuario.nombre;
                $(location).attr("href", "template/paginaprincipal.html");
                return;
            }else{
                Swal.fire({
                title: '<h4>Usuario no valido</h4>',
                icon: 'info',
                text:
                'Introdusca un usuario valido',
                showCancelButton: true,
                showConfirmButton: false,
                });
            }
        },
        error: function(error){

            $('#msg-error-login').val('Error');
            $('#msg-error-login').css('display', "block");

            
        }
    });
}