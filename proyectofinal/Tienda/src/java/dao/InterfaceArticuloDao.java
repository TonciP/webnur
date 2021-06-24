/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.tblarticulos;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class InterfaceArticuloDao {
    
        public abstract int insert(tblarticulos obj) throws Exception;

	public abstract void update(tblarticulos obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<tblarticulos> getList(int usuarioidd);
        
        public abstract tblarticulos getListArticuloById(int articuloid);
        
        public abstract ArrayList<tblarticulos> GetAllList();

	public abstract int insertfavoritos(tblarticulos obj) throws Exception ;
        
        public abstract int insertmuebles(tblarticulos obj) throws Exception ;
        
        public abstract int insertelectrico(tblarticulos obj) throws Exception ;
        
        public abstract int insertropa(tblarticulos obj) throws Exception ;
        
}
