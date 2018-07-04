package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Categoria;

public class ModeloCategorias {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	private Session sesion = sf.openSession();
	
	public ModeloCategorias() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorias() throws Exception{
		
		List<Categoria> categorias = new ArrayList<>();		
		List<Categoria> categorias2 = new ArrayList<>();		
		Query q = sesion.createQuery("from Categoria");
		categorias = (List<Categoria>)q.list();
		sesion.close();		
		Iterator<Categoria> it = categorias.iterator();	    
	    while (it.hasNext()) {
	    	Categoria cat = it.next();
	    	categorias2.add(cat);
	    }
		return categorias2;
	}
}
