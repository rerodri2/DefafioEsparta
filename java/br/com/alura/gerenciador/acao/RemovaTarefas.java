package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemovaTarefas implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("acao removendo tarefas");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removetarefa(id);
		return "redirect:entrada?acao=ListaTarefa";

	}

}
