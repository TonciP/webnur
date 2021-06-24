/*var loader = setInterval(function () {
    if(document.readyState !== "complete") return;
    // clearInterval(loader);
    // alert("Document loaded successful!");
    // document.write("Document loaded successful!");
    //inciararticulos();
 }, 300);*/
 
 $(document).ready(function () {
    inciararticulos();
 });

function inciararticulos() {
    debugger;
    $.ajax({
        type: "POST",
        url: "api/articulos/GetAllarticulos",
        data: null,
        dataType: "json",
        "headers": {
            "Content-Type": "application/json"
          },
        success: function (response) {
            debugger;
            var list = response.listarticulos;
            $.each(list, function (indexInArray, valueOfElement) { 
                var html = agregar(valueOfElement);
                //$('.seccion').append(html);                 
            });
        }
    });

}

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}


function agregar($valueArticulos){
        var n=$('section').find('.item-section').toArray().length;
        var section=$('.seccion:last-child').toArray().length;
        var html = "";
        if((n % 3) == 0){
            //agrego nuevo section
             
            html += "<section>" 
            + "<div class='item-section'>"
            + "<img class='imgsection'  src='https://th.bing.com/th/id/R8fc14fd2e46b3881e23b4b437bcd971d?rik=%2f6KtFE8ylHurFQ&riu=http%3a%2f%2fwww.arqhys.com%2fconstruccion%2ffotos%2fconstruccion%2fMuebles-coloniales.jpg&ehk=L8zWZzXukE9JOtLOOA3Lw986SDQXV%2bTih%2bMV25QvpxU%3d&risl=&pid=ImgRaw' alt='mueble'>"
            + "<p>" + $valueArticulos.titulo + "</p>"
            + "<p>" + $valueArticulos.marca + "</p>"
            + "<p>" + $valueArticulos.descripcion + "</p>"
            + "<p>" + $valueArticulos.precio + "</p>"
            + '<button class="click"  onclick="comprar(this)" id="' + $valueArticulos.articuloid  + '"> '
            + "Comprar"
            + '<i class="fa fa-shopping-cart"></i>'
            + "</button>"
            + "</div></section>;"
            $('.seccion').append(html);
        }else{
            //agreggo al ultimo section

            html += "" 
            + "<div class='item-section'>"
            + "<img class='imgsection'  src='https://th.bing.com/th/id/R8fc14fd2e46b3881e23b4b437bcd971d?rik=%2f6KtFE8ylHurFQ&riu=http%3a%2f%2fwww.arqhys.com%2fconstruccion%2ffotos%2fconstruccion%2fMuebles-coloniales.jpg&ehk=L8zWZzXukE9JOtLOOA3Lw986SDQXV%2bTih%2bMV25QvpxU%3d&risl=&pid=ImgRaw' alt='mueble'>"
            + "<p>" + $valueArticulos.titulo + "</p>"
            + "<p>" + $valueArticulos.marca + "</p>"
            + "<p>" + $valueArticulos.descripcion + "</p>"
            + "<p>" + $valueArticulos.precio + "</p>"
            + '<button class="click"  onclick="comprar(this)" id="' + $valueArticulos.articuloid  + '"> '
            + "Comprar"
            + '<i class="fa fa-shopping-cart"></i>'
            + "</button>"
            + "</div>"
            $('.seccion').find('section:last-child').append(html);
             
        }
        /*Swal.fire({
            title: '<h4>Habilite Cors</h4>',
            icon: 'info',
            html:
              'numero:' + n + ":" + section,
            showCancelButton: true,
            showConfirmButton: false,
          });*/

          return html;
    }