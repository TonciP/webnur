/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuariotienda;
import java.util.ArrayList;
import service.Login;

/**
 *
 * @author Usuario
 */
public abstract class interfaceUsuariotiendaDao {
    	public abstract int insert(Usuariotienda obj) throws Exception;

	public abstract void update(Usuariotienda obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Usuariotienda> getList();


	public abstract Usuariotienda get(int id);
        
	public abstract Usuariotienda get(String username);
        
        public abstract Usuariotienda getLogin(Usuariotienda user);

}
