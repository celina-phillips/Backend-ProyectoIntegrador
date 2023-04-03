package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import com.example.phillipscelinaintegradorback.exceptions.ResourceNotFoundException;
import com.example.phillipscelinaintegradorback.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepo;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepo) {
        this.odontologoRepo = odontologoRep;
    }

    public Optional<Odontologo> buscarOdontologo(Long id){
        return odontologoRepo.findById(id);
    }
    public List<Odontologo> buscaTodosOdontologos(){
        return odontologoRepo.findAll();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepo.save(odontologo);
    }
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado= odontologoRepo.findById(id);
        if (odontologoBuscado.isPresent()){
            odontologoRepo.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Este odontologo no existe");
        }
    }
    //agregando excepciones(sigo por aca)
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepo.save(odontologo);
    }
}
