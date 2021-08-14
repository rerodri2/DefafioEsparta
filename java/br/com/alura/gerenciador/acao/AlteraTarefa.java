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

public class AlteraTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Cadastrando nova tarefa");
		String nomeTarefa = request.getParameter("nome");
		String paramDataTarefa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("acao altera empresas" + id);
		
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 dataAbertura = sdf.parse(paramDataTarefa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		System.out.println(id);
		
		Banco banco = new Banco();
		Tarefa tarefa = banco.buscatarefaPelaId(id);
		tarefa.setNome(nomeTarefa);
		tarefa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=ListaTarefa";


	}
}
