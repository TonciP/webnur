/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dto.Usuariotienda;
import dto.tblarticulos;
import java.util.ArrayList;


/**
 *
 * @author tonci
 */
public class Respuesta {
    
    private boolean isOK;
    private String message;
    private Usuariotienda usuario;
    private tblarticulos articulo;
    private ArrayList<tblarticulos>listarticulos;

    public Respuesta() {
        isOK = true;
    }

    public Respuesta (boolean isOK, String message){
        this.isOK = isOK;
        this.message = message;
        
    }
    
    public Respuesta (boolean isOK, String message, tblarticulos articulo){
        this.isOK = isOK;
        this.message = message;
        this.articulo = articulo;
        
    }
    
    public Respuesta(boolean isOK, String message ,Usuariotienda usuario) {
        this.isOK = isOK;
        this.message = message;
        this.usuario=usuario;
    }
    
    public Respuesta(boolean isOk,String message,ArrayList<tblarticulos>listarticulos){
        this.isOK = isOk;
        this.message = message;
        this.listarticulos = listarticulos;
    }

    public boolean isIsOK() {
        return isOK;
    }

    public void setIsOK(boolean isOK) {
        this.isOK = isOK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usuariotienda getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuariotienda usuario) {
        this.usuario = usuario;
    }

    public tblarticulos getArticulo() {
        return articulo;
    }

    public void setArticulo(tblarticulos articulo) {
        this.articulo = articulo;
    }

    
    
    public ArrayList<tblarticulos> getListarticulos() {
        return listarticulos;
    }

    public void setListarticulos(ArrayList<tblarticulos> listarticulos) {
        this.listarticulos = listarticulos;
    }
    
    
    
    
    
}
