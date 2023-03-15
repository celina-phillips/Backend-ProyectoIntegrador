package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable int id){
        return odontologoService.buscarOdontologo(id);
    }

    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo);
    }

    @DeleteMapping
    public void eliminarOdontologo(@RequestParam int id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping("/buscarTodos")
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoService.buscarTodosOdontologos();
    }
}
