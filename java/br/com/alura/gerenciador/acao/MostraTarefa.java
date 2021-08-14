package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Tarefa;

public class MostraTarefa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando tarefas");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();
		Tarefa tarefa = banco.buscatarefaPelaId(id);
		System.out.println(tarefa.getNome());

		request.setAttribute("tarefa", tarefa);
		return "forward:formAlteraTarefa.jsp";
		

	}

}
