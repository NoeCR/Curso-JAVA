package com.softgest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Categoria;
import modelo.ModeloCategorias;


@WebServlet("/ControladorCategoria")
public class ControladorCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloCategorias modelocategorias;   
 
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		try {
			modelocategorias = new ModeloCategorias();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> categorias;
		
		try {
			categorias = modelocategorias.getCategorias();
			
			request.setAttribute("ListaCategorias", categorias);
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
