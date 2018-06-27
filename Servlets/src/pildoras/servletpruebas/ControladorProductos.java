package pildoras.servletpruebas;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.pildoras.Producto;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloproductos;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Apéndice de método generado automáticamente
		super.init();
		
		modeloproductos = new ModeloProductos();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String comando = request.getParameter("instruccion");
		
		if(comando==null) {
			comando = "listar";
		}
		switch(comando) {
		case "listar":
			obtenerProductos(request,response);
			break;
		case "insertarBBDD":
				agregarProducto(request,response);
				break;
		case "cargar":
			try {
				cargaProductos(request,response);
			} catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
				break;
		case "actualizarBBDD":
			try {
				actualizarProducto(request,response);
			} catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
				break;
		case "eliminar":
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
				break;	
		default:
			obtenerProductos(request,response);
			
		}
		
		
	}


	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Apéndice de método generado automáticamente
		//capturar el codidgo articulo
		String codArt = request.getParameter("CArticulo");
		//borrar producto de la BBDD
		modeloproductos.eliminarProducto(codArt);
		//Volver al listado de productos
		obtenerProductos(request,response);
	}


	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String codArt = request.getParameter("CArt");
		String sec = request.getParameter("Seccion");
		String nomArt = request.getParameter("nomArt");
		Long precio = Long.parseLong(request.getParameter("precio"));
		String fecha = request.getParameter("fecha");		
		String imp = request.getParameter("importado");
		String porg = request.getParameter("porg");
		Producto p = new Producto(codArt,sec,nomArt,precio,fecha,imp,porg,null);
		modeloproductos.updateProducto(p);
		
		obtenerProductos(request,response);
	}


	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Apéndice de método generado automáticamente
		String codArt = request.getParameter("CArticulo");
		
		Producto p = modeloproductos.getProducto(codArt);
		
		request.setAttribute("ProductoActualizar", p);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarPorducto.jsp");
		dispatcher.forward(request, response);
	}


	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Apéndice de método generado automáticamente
		String codArt = request.getParameter("CArt");
		String sec = request.getParameter("Seccion");
		String nomArt = request.getParameter("nomArt");
		Long precio = Long.parseLong(request.getParameter("precio"));
		String fecha = request.getParameter("fecha");		
		String imp = request.getParameter("importado");
		String porg = request.getParameter("porg");
		Producto p = new Producto(codArt,sec,nomArt,precio,fecha,imp,porg,null);
		
		modeloproductos.agregarElNuevoProducto(p);
		obtenerProductos(request,response);
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Apéndice de método generado automáticamente
		List<Producto> productos;
		try {
			productos = modeloproductos.getProdctos();
			request.setAttribute("ListaProdcutos", productos);
			request.getRequestDispatcher("/ListaProductos.jsp").forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
