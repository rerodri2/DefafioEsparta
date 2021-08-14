package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet{
	
	 public OiMundoServlet() {
		System.out.println("Criando Oi mundo servlet");
	}
	@Override
	protected void service(HttpServletRequest resq, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parabens voce escreveu seu primeiro servlet");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("o servlet oiMundo foi chamado");

	}

}
