/*document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validarFormulario); 
  });*/
  
  function validarFormulario(evento) {
    debugger;
    var titulo = document.getElementById('titulo').value;
    if(titulo.length == 0) {
        $('#error').css('display','block');
      return;
    }
    var marca = document.getElementById('marca').value;
    if (marca.length == 0) {
        $('#error').css('display','block');
      return;
    }
    var precio = document.getElementById('precio').value;
    if(precio.length == 0) {
        $('#error').css('display','block');
      return;
    }
    var descripcion = document.getElementById('descripcion').value;
    if(descripcion.length == 0) {
        $('#error').css('display','block');
      return;
    }
    this.submit();
  }

  function cancelar() {
      $(location).attr('href', 'paginaprincipal.html');
  }