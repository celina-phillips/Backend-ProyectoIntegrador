package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.exceptions.ResourceNotFoundException;
import com.example.phillipscelinaintegradorback.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/registrarPaciente")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping("/buscarpaciente/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPaciente(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/todospacientes")
    public ResponseEntity<List<Paciente>> todosPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodosPacientes());
    }

    @PutMapping("/actualizarPaciente")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscarPaciente(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/eliminarPaciente/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Se eliminó el paciente correctamente");
    }

}