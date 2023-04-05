window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de odontologos con el método GET
      //nos devolverá un JSON con una colección de odontologos
      const url = '/pacientes/todospacientes';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de odontologos del JSON
         for(paciente of data){
            //por cada odontólogo armaremos una fila de la tabla
            //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos al odontólogo
            var table = document.getElementById("pacienteTable");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

            //por cada odontólogo creamos un botón delete que agregaremos en cada fila para poder eliminar la misma
            //dicho botón invocará a la función de java script deleteByKey que se encargará
            //de llamar a la API para eliminar un odontólogo
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            //por cada odontólogo creamos un botón que muestra el id y que al hacerle clic invocará
            //a la función de java script findBy que se encargará de buscar al odontólogo que queremos
            //modificar y mostrar los datos de la misma en un formulario.
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';

            //armamos cada columna de la fila
            //como primer columna pondremos el botón modificar
            //luego los datos del paciente
            //como ultima columna el botón eliminar
            pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_documento\">' + paciente.documento + '</td>' +
                    '<td class=\"td_fecha\">' + paciente.fechaIngreso + '</td>' +
                    '<td class=\"td_email\">' + paciente.email + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/listarpaciente.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })