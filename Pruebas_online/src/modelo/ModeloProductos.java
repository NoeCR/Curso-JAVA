package modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Producto;

public class ModeloProductos {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	private Session sesion = sf.openSession();
	
	public ModeloProductos() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() throws Exception{
		List<Producto> productos = new ArrayList<>();
		Query q = sesion.createQuery("from Producto");
	    productos = (List<Producto>)q.list();
	    sesion.close();
		
		
		return productos;
	}
}
