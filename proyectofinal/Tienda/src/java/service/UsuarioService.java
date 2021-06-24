/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.UsuariotiendaDao;
import dto.Usuariotienda;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tonci
 */
@Path("/usuarios")
public class UsuarioService {
    
    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta insertar(Usuariotienda usuario) throws Exception{
        
        UsuariotiendaDao dao = factory.FactoryDao.getFactoryInstance().getNewUsuariotiendaDao();
        int id;
        if(!usuario.getNombre().equals("") && !usuario.getUsername().equals("")
                && !usuario.getCorreo().equals("")){
               id = dao.insert(usuario);
        }else{
            return new Respuesta(false,"Usuario no se pudo insertar");
        }
      
        if (id == 0) {
            return new Respuesta(false,"no se pudo introducir");
        }
        return new Respuesta(true,"se inserto con exito");
    }
    // /api/usuarios/login
    @Path("/login" )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta login(Usuariotienda usuario){
        try {
            UsuariotiendaDao dao = factory.FactoryDao.getFactoryInstance().getNewUsuariotiendaDao();
            Usuariotienda obj = dao.getLogin(usuario);
            System.out.println("nombre:"+usuario.getNombre());
            System.out.println("entro");
            if(obj == null){
                return new Respuesta(false, "Nombre de Usuario y/o Contraseña incorrectos null");
            }else{
                                String json = " { " +
                        "\"nombreCompleto\" : \"" + obj.getNombre()+ "\"," +
                        "\"username\" : \"" + obj.getApellidop()+ "\"," +
                        "\"usuarioId\" : " + obj.getApellidom()+ "" +
                        "}";               
                
                return new Respuesta(true, json,obj);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new Respuesta(false, "Ocurrió un error al verificar el usuario"); 
    }
    
    
    
    
}
