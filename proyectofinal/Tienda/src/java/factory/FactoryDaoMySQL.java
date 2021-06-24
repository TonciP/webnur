package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class FactoryDaoMySQL extends FactoryDao{

	private FactoryDaoMySQL(){
		;
	}

	public static FactoryDao getFactoryInstance(){
		if(instancia==null)
			instancia = new FactoryDaoMySQL();
		return instancia;
	}

	@Override
	public ContactoDao getNewContactoDao(){
		return new ContactoDaoMySQL();
	}

	@Override
	public FileDao getNewFileDao(){
		return new FileDaoMySQL();
	}

	@Override
	public UsuarioDao getNewUsuarioDao(){
		return new UsuarioDaoMySQL();
	}

    @Override
    public ArticuloDao getArticuloDao() {
        return new ArticuloDao(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuariotiendaDao getNewUsuariotiendaDao() {
        return new UsuariotiendaDao(); //To change body of generated methods, choose Tools | Templates.
    }


}

