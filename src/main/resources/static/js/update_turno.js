window.addEventListener('load', function () {



    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        let turnoId = document.querySelector('#turno_id').value;


        const formData = {
            id: document.querySelector('#turno_id').value,
            paciente_id: document.querySelector('#paciente').value },
            odontologo_id: document.querySelector('#odontologo').value },
            fecha: document.querySelector('#fecha').value,

        };


        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno modificado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {

                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";

                resetUploadForm();
            })



    })
})


function findBy(id) {
    const url = '/turnos' + "/" + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let turno = data;
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#paciente').value = turno.paciente_id;
            document.querySelector('#odontologo').value = turno.odontologo_id;
            document.querySelector('#fecha').value = turno.fecha;
            //el formulario por default esta oculto y al editar se habilita
            document.querySelector('#div_turno_updating').style.display = "block";
        }).catch(error => {
            alert("Error: " + error);
        })
}

function resetUploadForm() {
    document.querySelector('#paciente').value = "";
    document.querySelector('#odontologo').value = "";
    document.querySelector('#fecha').value = "";
}