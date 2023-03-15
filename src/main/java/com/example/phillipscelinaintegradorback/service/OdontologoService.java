package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.dao.OdontologoDAOH2;
import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private OdontologoDAOH2 odontologoDAOH2= new OdontologoDAOH2();

    public Odontologo buscarOdontologo(int id){
        return odontologoDAOH2.buscar(id);
    }

    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoDAOH2.buscarTodos();
    }

    public Odontologo buscarXApellido(String apellido){
        return odontologoDAOH2.buscarXCriterioString(apellido);
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoDAOH2.guardar(odontologo);
    }

    public void eliminarOdontologo(int id){
        odontologoDAOH2.eliminar(id);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo){

        return odontologoDAOH2.actualizar(odontologo);
    }
}
