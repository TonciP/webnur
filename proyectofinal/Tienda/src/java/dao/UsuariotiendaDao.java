/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Usuario;
import dto.Usuariotienda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Login;

/**
 *
 * @author Usuario
 */
public class UsuariotiendaDao extends interfaceUsuariotiendaDao{

    @Override
    public int insert(Usuariotienda obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("insert into tblusuario (nombre,apellidop,apellidom,correo,fecha_nacimiento,username,passuser) VALUES (");
        query.append("'" + obj.getNombre()+ "',");
        query.append("'" + obj.getApellidop()+ "',");
        query.append("'" + obj.getApellidom()+ "', ");
        query.append("'" + obj.getCorreo()+ "', ");
        query.append("'" + obj.getFecha_nacimiento()+ "', ");
        query.append("'" + obj.getUsername()+ "', ");
        query.append("'" + obj.getPassuser()+ "' ");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

       @Override
    public Usuariotienda get(String username) {
                try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tblusuario WHERE username = '" + username + "'";
            ResultSet objResultSet = objConexion.ejecutar(query);
             
            if (objResultSet.next()) {
                Usuariotienda obj = new Usuariotienda();
                int usuarioid = objResultSet.getInt("usuarioid");
                obj.setUsuarioid(usuarioid);

                String nombre = objResultSet.getString("nombre");
                obj.setNombre(nombre);

                String apellidop = objResultSet.getString("apellidop");
                obj.setApellidop(apellidop);

                String apellidom = objResultSet.getString("apellidom");
                obj.setApellidom(apellidom);
                
                String correo = objResultSet.getString("correo");
                obj.setCorreo(correo);
                
                String fecha_nacimiento = objResultSet.getString("fecha_nacimiento");
                obj.setFecha_nacimiento(fecha_nacimiento);
                
                String passuser = objResultSet.getString("passuser");
                obj.setUsername(passuser);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public Usuariotienda getLogin(Usuariotienda user) {
           Conexion objConexion = Conexion.getOrCreate();
           String query = "SELECT * FROM tblusuario WHERE username = '" + user.getUsername() + "'"
                    + " AND passuser = '" + user.getPassuser() + "'";
           ResultSet objResultSet = objConexion.ejecutar(query);
            
        try {
            if (objResultSet.next()) {
                Usuariotienda obj = new Usuariotienda();
                int usuarioid = objResultSet.getInt("usuarioid");
                obj.setUsuarioid(usuarioid);

                String nombre = objResultSet.getString("nombre");
                obj.setNombre(nombre);

                String apellidop = objResultSet.getString("apellidop");
                obj.setApellidop(apellidop);

                String apellidom = objResultSet.getString("apellidom");
                obj.setApellidom(apellidom);
                
                String correo = objResultSet.getString("correo");
                obj.setCorreo(correo);
                
                String fecha_nacimiento = objResultSet.getString("fecha_nacimiento");
                obj.setFecha_nacimiento(fecha_nacimiento);
                
                String passuser = objResultSet.getString("passuser");
                obj.setUsername(passuser);

                return obj;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariotiendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void update(Usuariotienda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuariotienda> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuariotienda get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
