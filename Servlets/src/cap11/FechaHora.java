package cap11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class FechaHora
 */
@WebServlet("/FechaHora")
public class FechaHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FechaHora() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Calendar fechahora = new GregorianCalendar();
    	PrintWriter out = response.getWriter();
    	out.println("Fecha: " + 
    			fechahora.get(Calendar.DAY_OF_MONTH) + "/" + 
    			(fechahora.get(Calendar.MONTH)+1) + "/" +
    			fechahora.get(Calendar.YEAR));
    	out.println("Hora: " + 
    	    	fechahora.get(Calendar.HOUR_OF_DAY) + ":" + 
    	    	fechahora.get(Calendar.MINUTE) + "/" +
    	    	fechahora.get(Calendar.SECOND));
    	out.close();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		procesarPeticion(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		procesarPeticion(request,response);
	}
	
	public String getServletInfo() {
		return "Servlet FechaHora";
	}
}
