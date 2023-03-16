package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Turno;
import com.example.phillipscelinaintegradorback.service.OdontologoService;
import com.example.phillipscelinaintegradorback.service.PacienteService;
import com.example.phillipscelinaintegradorback.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private OdontologoService odontologoService;
    private PacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //trabajo
        if (pacienteService.buscarPaciente(turno.getPaciente().getId())!=null &&
        odontologoService.buscarOdontologo(turno.getOdontologo().getId())!=null){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
}
