package com.modelo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.LivroException;
import com.modelo.model.Livro;
import com.modelo.service.LivroServiceImpl;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -217911482678897884L;
	public void init() {
//		getServletContext().getInitParameter("PARAMETER"); // SHOW PARAMETER CYCLE
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action) {
				case "/listar":
				listarLivros(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e.getMessage());
		}
	}
	
	private void listarLivros(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		LivroServiceImpl livroService = new LivroServiceImpl();
		try {
			List<Livro> lista = livroService.listarLivros();
			request.setAttribute("listaLivro", lista);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Livros.jsp");
	        dispatcher.forward(request, response);
		} catch (LivroException e) {
			e.printStackTrace();
		}
	}
}
