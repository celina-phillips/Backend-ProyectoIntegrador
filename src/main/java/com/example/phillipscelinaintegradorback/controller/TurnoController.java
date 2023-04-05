package com.example.phillipscelinaintegradorback.controller;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.domain.Turno;
import com.example.phillipscelinaintegradorback.dto.TurnoDTO;
import com.example.phillipscelinaintegradorback.service.OdontologoService;
import com.example.phillipscelinaintegradorback.service.PacienteService;
import com.example.phillipscelinaintegradorback.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/registrarTurno")
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turno){
        ResponseEntity<TurnoDTO> respuesta;
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPaciente(turno.getPaciente_id());
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologo(turno.getOdontologo_id());
        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
    @GetMapping("/buscarTurno/{id}")
    public ResponseEntity<TurnoDTO> buscarTurnoOptional(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){

            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/eliminarTurno/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado=turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno eliminado correctamente");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El turno que esta queriendo eliminar no existe");
        }
    }

    @GetMapping("/todosTurnos")
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }
}
