window.addEventListener('load', function () {



    const formulario = document.querySelector('#update_odontologo_form');

    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.querySelector('#odontologo_id').value;


        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            num_matricula: document.querySelector('#num_matricula').value,

        };


        const url = '/odontologos/actualizar';
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
          const url = '/odontologos/buscar/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#odontologo_id').value = odontologo.id;
              document.querySelector('#nombre').value = odontologo.nombre;
              document.querySelector('#apellido').value = odontologo.apellido;
              document.querySelector('#num_matricula').value = odontologo.num_matricula;
              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_odontologo_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }