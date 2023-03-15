package com.example.phillipscelinaintegradorback.dao;

import com.example.phillipscelinaintegradorback.bd.BD;
import com.example.phillipscelinaintegradorback.domain.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS(" +
                    "MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());

            ps.execute();
            logger.debug("Conexión a la base de datos exitosa");

            ResultSet clave = ps.getGeneratedKeys();
            while (clave.next()){
                odontologo.setId(clave.getInt(1));
            }

            logger.debug("Se guardo el odontólogo con ID: " + odontologo.getId());

        }catch (Exception e){
            e.printStackTrace();
            logger.error("Error de conexión a la base de datos");
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;

    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;

        Odontologo odontologo= null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID = ?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;


    }

    @Override
    public void eliminar(int id) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            ps.execute();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("UPDATE ODONTOLOGOS " +
                    "SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?");
            ps.setString(1, odontologo.getMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
            return odontologo;
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;

        List<Odontologo> odontologoList = new ArrayList<>();

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = preparedStatement.executeQuery();

            logger.debug("Se ha conectado a la base de datos");

            while (rs.next()){

                int id = rs.getInt("id");
                String numMatricula = rs.getNString("num_matricula");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");

                odontologoList.add(new Odontologo(id,numMatricula,nombre,apellido));

            }
            logger.debug("Se ha generado el listado de todos los odontólogos, en total son: " + odontologoList.size());
            preparedStatement.close();


        }catch (Exception e){
            e.printStackTrace();
            logger.error("Se ha generado error con la conexión a la base de datos");

        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }

    @Override
    public Odontologo buscarXCriterioString(String criterio) {
        Connection connection=null;
        Odontologo odontologo=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE APELLIDO=?");
            ps.setString(1,criterio);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                odontologo =new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return odontologo;
    }

}
