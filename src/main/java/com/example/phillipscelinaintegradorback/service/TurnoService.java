package com.example.phillipscelinaintegradorback.service;

import com.example.phillipscelinaintegradorback.dao.IDao;
import com.example.phillipscelinaintegradorback.dao.TurnoDAOLista;
import com.example.phillipscelinaintegradorback.domain.Turno;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    private IDao<Turno> turnoIDao= new TurnoDAOLista();

    public Turno guardarTurno(Turno turno){
        return turnoIDao.guardar(turno);
    }
}
