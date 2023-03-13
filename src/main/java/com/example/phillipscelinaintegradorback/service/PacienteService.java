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


}
