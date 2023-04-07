package com.example.phillipscelinaintegradorback;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import com.example.phillipscelinaintegradorback.exceptions.ResourceNotFoundException;
import com.example.phillipscelinaintegradorback.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {
    @Autowired
    private OdontologoService odontologoService;


    public void cargarData() {
        this.odontologoService.guardarOdontologo(new Odontologo("Philllips", "Celina", "12345789"));


    }

    @Test
    public void guardarOdontologo() {
        this.cargarData();
        Odontologo odontologo = odontologoService.guardarOdontologo(new Odontologo("Santiago", "Bordeu", "8765432"));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(Long.valueOf(1));
        Assert.assertTrue(odontologoService.buscarOdontologo(Long.valueOf(1)).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscaTodosOdontologos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

}
