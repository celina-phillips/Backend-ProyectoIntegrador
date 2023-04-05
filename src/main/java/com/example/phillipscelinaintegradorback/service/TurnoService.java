package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.domain.Turno;
import com.example.phillipscelinaintegradorback.dto.TurnoDTO;
import com.example.phillipscelinaintegradorback.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private TurnoRepository turnoRepository;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public TurnoDTO guardarTurno(TurnoDTO turno){
        return convertirTurnoaTurnoDTO(
                turnoRepository.save(convertirTurnoDTOaTurno(turno)));
    }
    public Optional<TurnoDTO> buscarTurno(Long id){
        Optional<Turno> turnoBuscado=turnoRepository.findById(id);
        if (turnoBuscado.isPresent()){
            return Optional.of(convertirTurnoaTurnoDTO(turnoBuscado.get()));
        }
        else{
            return Optional.empty();
        }
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    private Turno convertirTurnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno= new Turno();
        Paciente paciente= new Paciente();
        Odontologo odontologo= new Odontologo();
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        paciente.setId(turnoDTO.getPaciente_id());
        paciente.setNombre(turnoDTO.getNombre_paciente());
        odontologo.setId(turnoDTO.getOdontologo_id());
        odontologo.setNombre(turnoDTO.getNombre_odontologo());
        //vincular los objetos
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        //el turno esta listo
        return turno;
    }
    private TurnoDTO convertirTurnoaTurnoDTO(Turno turno){
        TurnoDTO turnoDTO= new TurnoDTO();

        turnoDTO.setId(turno.getId());
        turnoDTO.setOdontologo_id(turno.getOdontologo().getId());
        turnoDTO.setPaciente_id(turno.getPaciente().getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setNombre_odontologo(turno.getOdontologo().getNombre());
        turnoDTO.setNombre_paciente(turno.getPaciente().getNombre());

        return turnoDTO;
    }

    public List<Turno> listar() {
        return turnoRepository.findAll();
    }
}
