package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable int id){
        return pacienteService.buscarPaciente(id);
    }

    @DeleteMapping
    public void eliminarPaciente(@RequestParam int id){
        pacienteService.eliminarPaciente(id);
    }

    @GetMapping("/buscarTodos")
    public List<Paciente> buscarTodosPacientes(){
        return pacienteService.buscarTodosPacientes();
    }

}
