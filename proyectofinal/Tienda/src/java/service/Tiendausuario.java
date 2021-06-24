/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ArticuloDao;

import dto.tblarticulos;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */

@Path("/articulos")
public class Tiendausuario {
    
    // api/articulos/Getarticulos
    @Path("/Getarticulos" )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta GetAriculos(tblarticulos articulo){
       ArticuloDao dao = factory.FactoryDao.getFactoryInstance().getArticuloDao();
       ArrayList<tblarticulos> obj = dao.getList(articulo.getUsuarioid());
       
        if (obj != null) {
             return new Respuesta(true,"ok",obj);
        }
       
      return new Respuesta(false,"nulo");
    }
    
    // api/articulos/Getarticulos
    @Path("/Getarticulos" )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta GetAriculos(tblarticulos articulo){
       ArticuloDao dao = factory.FactoryDao.getFactoryInstance().getArticuloDao();
       ArrayList<tblarticulos> obj = dao.getList(articulo.getUsuarioid());
       
        if (obj != null) {
             return new Respuesta(true,"ok",obj);
        }
       
      return new Respuesta(false,"nulo");
    }
    
    // api/articulos/GetAllarticulos
    @Path("/GetAllarticulos")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta GetAllarticulos(){
       ArticuloDao dao = factory.FactoryDao.getFactoryInstance().getArticuloDao();
       ArrayList<tblarticulos> obj = dao.GetAllList();
       
        if (obj != null) {
             return new Respuesta(true,"ok",obj);
        }
       
      return new Respuesta(false,"nulo");
    }
    
    // api/articulos/GetAriculosById
    @Path("/GetAriculosById" )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta GetAriculosById(tblarticulos articulo){
       ArticuloDao dao = factory.FactoryDao.getFactoryInstance().getArticuloDao();
       tblarticulos obj = dao.getListArticuloById(articulo.getArticuloid());
       
        if (obj != null) {
             return new Respuesta(true,"ok",obj);
        }
       
      return new Respuesta(false,"nulo");
    }
    
    

    
    
 }

