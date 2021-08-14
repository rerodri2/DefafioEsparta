package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

//import com.google.gson.Gson;
//import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Tarefa;

@WebServlet("/empresas")
public class TarefaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tarefa> tarefas = new Banco().gettarefa();

		String valor = request.getHeader("Accept");
		System.out.println(valor);

		if (valor.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("tarefa", Tarefa.class);
			String xml = xstream.toXML(tarefas);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else if (valor.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(tarefas);
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'messege':'no content'}");
		}

	}
}
