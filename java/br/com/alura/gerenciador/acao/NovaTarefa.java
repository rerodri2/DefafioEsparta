package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Tarefa;

public class NovaTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova tarefa");
		String nomeTarefa = request.getParameter("nome");
		String paramDataTarefa = request.getParameter("data");
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 dataAbertura = sdf.parse(paramDataTarefa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nomeTarefa);
		tarefa.setDataAbertura(dataAbertura);
		Banco banco = new Banco();
		banco.adiciona(tarefa);
		request.setAttribute("tarefa", tarefa.getNome());

		return "redirect:entrada?acao=ListaTarefa";

		
	}

}
