package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Tarefa;

public class ListaTarefas implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		Banco banco = new Banco();
		List<Tarefa>lista = banco.gettarefa();
		request.setAttribute("tarefas", lista);
		return "forward:listaTarefas.jsp";
		
	}

}
