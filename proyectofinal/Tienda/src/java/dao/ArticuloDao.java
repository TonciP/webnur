/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.tblarticulos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ArticuloDao extends InterfaceArticuloDao{

    @Override
    public int insert(tblarticulos obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        
        int id = 0;
        String query = "Insert into tblarticulos values ('" + 
                obj.getArticuloid() + "','" + 
                obj.getUsuarioid() + "','" + 
                obj.getTitulo() + "','" + 
                obj.getMarca() + "','" + 
                obj.getDescripcion() + "','" + 
                obj.getPrecio() + "')";
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(tblarticulos obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tblarticulos SET ");
        query.append("articuloid = '" + obj.getArticuloid() + "', ");
        query.append("usuarioid = '" + obj.getUsuarioid() + "', ");
        query.append("titulo = '" + obj.getTitulo() + "' ");
        query.append("marca = '" + obj.getMarca() + "' ");
        query.append("descripcion = '" + obj.getDescripcion() + "' ");
        query.append("precio = '" + obj.getPrecio() + "' ");
        
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM tblarticulos ");
        query.append("WHERE articuloid = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<tblarticulos> getList(int usuarioidd) {
        Conexion objConexion = Conexion.getOrCreate();
           String query = "SELECT * FROM tblarticulos where usuarioid = " + usuarioidd;
           ResultSet objResultSet = objConexion.ejecutar(query);
           ArrayList<tblarticulos> list = new ArrayList<>();
           
        try {
            while(objResultSet.next()) {
                tblarticulos articulos = new tblarticulos();
                int articuloid = Integer.parseInt(objResultSet.getString("articuloid"));
                articulos.setArticuloid(articuloid);
                
                String usuarioid = objResultSet.getString("usuarioid");
                articulos.setUsuarioid(Integer.parseInt(usuarioid));
                
                String titulo = objResultSet.getString("titulo");
                articulos.setTitulo(titulo);
                
                String marca = objResultSet.getString("marca");
                articulos.setMarca(marca);
                
                String descripcion = objResultSet.getString("descripcion");
                articulos.setDescripcion(descripcion);
                
                String precio = objResultSet.getString("precio");
                articulos.setPrecio(Double.parseDouble(precio));
                
                list.add(articulos);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null;
           
    }


    @Override
    public int insertfavoritos(tblarticulos obj) throws Exception{
        Conexion objConexion = Conexion.getOrCreate();
        
        int id = 0;
               String query = "Insert into tblarticulo values ('" + 
                obj.getArticuloid() + "','" + 
                obj.getUsuarioid() + "')";
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public int insertmuebles(tblarticulos obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        
        int id = 0;
       String query = "Insert into tblmueble values ('" + 
                obj.getArticuloid() + "','" + 
                obj.getUsuarioid() + "')";
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public int insertelectrico(tblarticulos obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        
        int id = 0;
       String query = "Insert into tblelectrico values ('" + 
                obj.getArticuloid() + "','" + 
                obj.getUsuarioid() + "')";
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public int insertropa(tblarticulos obj) throws Exception {
       Conexion objConexion = Conexion.getOrCreate();
        
       int id = 0;
       String query = "Insert into tblropa values ('" + 
                obj.getArticuloid() + "','" + 
                obj.getUsuarioid() + "')";
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    public ArrayList<tblarticulos> GetAllList() {
              Conexion objConexion = Conexion.getOrCreate();
           String query = "SELECT * FROM tblarticulos" ;
           ResultSet objResultSet = objConexion.ejecutar(query);
           ArrayList<tblarticulos> list = new ArrayList<>();
           
        try {
            while(objResultSet.next()) {
                tblarticulos articulos = new tblarticulos();
                int articuloid = Integer.parseInt(objResultSet.getString("articuloid"));
                articulos.setArticuloid(articuloid);
                
                String usuarioid = objResultSet.getString("usuarioid");
                articulos.setUsuarioid(Integer.parseInt(usuarioid));
                
                String titulo = objResultSet.getString("titulo");
                articulos.setTitulo(titulo);
                
                String marca = objResultSet.getString("marca");
                articulos.setMarca(marca);
                
                String descripcion = objResultSet.getString("descripcion");
                articulos.setDescripcion(descripcion);
                
                String precio = objResultSet.getString("precio");
                articulos.setPrecio(Double.parseDouble(precio));
                
                list.add(articulos);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null; 
        
    }

    @Override
    public tblarticulos getListArticuloById(int articuloid) {
        Conexion objConexion = Conexion.getOrCreate();
           String query = "SELECT * FROM tblarticulos where articuloid = " + articuloid;
           ResultSet objResultSet = objConexion.ejecutar(query);
           
        try {
            if(objResultSet.next()) {
                tblarticulos articulos = new tblarticulos();
                int articuloById = Integer.parseInt(objResultSet.getString("articuloid"));
                articulos.setArticuloid(articuloById);
                
                String usuarioid = objResultSet.getString("usuarioid");
                articulos.setUsuarioid(Integer.parseInt(usuarioid));
                
                String titulo = objResultSet.getString("titulo");
                articulos.setTitulo(titulo);
                
                String marca = objResultSet.getString("marca");
                articulos.setMarca(marca);
                
                String descripcion = objResultSet.getString("descripcion");
                articulos.setDescripcion(descripcion);
                
                String precio = objResultSet.getString("precio");
                articulos.setPrecio(Double.parseDouble(precio));
                
                return articulos;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null;
    }
    
}
