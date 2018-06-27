package pildoras.servletpruebas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import clases.pildoras.Producto;

public class ModeloProductos {
	
	//private SessionFactory sf = new Configuration().configure().buildSessionFactory();
    //private Session sesion = sf.openSession();
    
	public ModeloProductos() {
		
	}
	@SuppressWarnings("unchecked")
	public List<Producto> getProdctos()throws Exception{
		List<Producto> productos = new ArrayList<>();
		List<Producto> productos2 = new ArrayList<>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session sesion = sf.openSession();
	    Query q = sesion.createQuery("from Producto");
	    productos = (List<Producto>)q.list();
	    sesion.close();
	    Iterator<Producto> it = productos.iterator();	    
	    while (it.hasNext()) {
	    	Producto pro = it.next();
	    	productos2.add(pro);
	    }
		return productos2;
		
	}
	public void agregarElNuevoProducto(Producto p) {		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.save(p);
		tx.commit();
		sesion.close();
	}
	public Producto getProducto(String codArt) {		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
	    Producto p = null;
		try {
			p = (Producto)sesion.load(Producto.class, (String)codArt);
			//p.getFecha();
		} catch (HibernateException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	    sesion.close();
		return p;
	}
	public void updateProducto(Producto p) {
		// TODO Apéndice de método generado automáticamente
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.update(p);
		tx.commit();
		sesion.close();
		
	}
	public void eliminarProducto(String codArt) {
		// TODO Apéndice de método generado automáticamente
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Producto p = (Producto) sesion.load(Producto.class, (String)codArt);
		sesion.delete(p);
		tx.commit();
		sesion.close();
	}
	
	

}
