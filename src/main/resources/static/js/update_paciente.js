window.addEventListener('load', function () {



    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;


        const formData = {
            id: document.querySelector('#paciente_id').value,
            apellido: document.querySelector('#apellido').value,
            nombre: document.querySelector('#nombre').value,
            documento: document.querySelector('#documento').value,
            fecha_ingreso: document.querySelector('#fecha_ingreso').value,
            email: document.querySelector('#email').value,
        };


        const url = '/pacientes/actualizarPaciente';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })


    function findBy(id) {
          const url = '/pacientes/buscarpaciente/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#apellido').value = paciente.apellido;
              document.querySelector('#nombre').value = paciente.nombre;
              document.querySelector('#documento').value = paciente.documento;
              document.querySelector('#fecha_ingreso').value = paciente.fechaIngreso;
              document.querySelector('#email').value = paciente.email;
              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }