package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.dao.PacienteDAOH2;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteDAOH2 pacienteDAOH2=new PacienteDAOH2();

    public List<Paciente> buscarTodosPacientes(){
        return pacienteDAOH2.buscarTodos();
    }
    public Paciente buscarXEmail(String email){
        return pacienteDAOH2.buscarXCriterioString(email);
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteDAOH2.guardar(paciente);
    }

    public Paciente buscarPaciente(int id){
        return pacienteDAOH2.buscar(id);
    }

    public void eliminarPaciente(int id){
        pacienteDAOH2.eliminar(id);
    }

    public Paciente actualizarDomicilio(Paciente paciente){
        return pacienteDAOH2.actualizar(paciente);
    }

    public Paciente actualizarPaciente(Paciente paciente){
        return pacienteDAOH2.actualizar(paciente);
    }

}
