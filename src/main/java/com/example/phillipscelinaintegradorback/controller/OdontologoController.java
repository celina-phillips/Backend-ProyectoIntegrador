package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Odontologo;

import com.example.phillipscelinaintegradorback.exceptions.ResourceNotFoundException;
import com.example.phillipscelinaintegradorback.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologo(id).orElse(null);
        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologoService.buscarOdontologo(odontologo.getId()) == null){
            response = new ResponseEntity("Esa información ingresada no existe", HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity("Actualización exitosa", HttpStatus.PARTIAL_CONTENT);
            odontologoService.actualizarOdontologo(odontologo);
        }
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Se eliminó el odontologo correctamente");
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscaTodosOdontologos());
    }

}
