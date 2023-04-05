package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.exceptions.ResourceNotFoundException;
import com.example.phillipscelinaintegradorback.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepo;
    @Autowired
    public PacienteService(PacienteRepository pacienteRep) {
        this.pacienteRepo = pacienteRep;
    }

    public List<Paciente> buscarTodosPacientes(){
        return pacienteRepo.findAll();
    }

    //public Optional<Paciente> buscarXEmail(String email){
        //return pacienteRepo.findByEmail(email);
    //}
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepo.save(paciente);
    }
    public Paciente actualizarPaciente(Paciente paciente){
        return pacienteRepo.save(paciente);
    }
    public Optional<Paciente> buscarPaciente(Long id){
        return pacienteRepo.findById(id);
    }
    public void eliminarPaciente(Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteBuscado= pacienteRepo.findById(id);
        if (pacienteBuscado.isPresent()){
            pacienteRepo.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Este paciente no existe");
        }
    }
}

