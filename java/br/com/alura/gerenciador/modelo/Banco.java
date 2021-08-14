package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {
	
	private static List<Tarefa>lista = new ArrayList<>();
	private static List<Usuario>listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(chaveSequencial++);
		tarefa.setNome("Alura");
		Tarefa tarefa2 = new Tarefa();
		tarefa2.setId(chaveSequencial++);
		tarefa2.setNome("Caelum");
		lista.add(tarefa);
		lista.add(tarefa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("renan");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Tarefa tarefa) {
		Banco.lista.add(tarefa);
		tarefa.setId(chaveSequencial++);
	}
	
	public List<Tarefa>gettarefa(){
		return Banco.lista;
	}

	public void removetarefa(Integer id) {
		Iterator<Tarefa> it = lista.iterator();
		while(it.hasNext()) {
			Tarefa tar = it.next();
			if(tar.getId() == id) {
				it.remove();
			}
		}
		
		
		
	}

	public Tarefa buscatarefaPelaId(Integer id) {
		for (Tarefa tarefa : lista) {
			if(tarefa.getId() == id) {
				return tarefa;
				
			}
			
		}
		return null;
		
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario:listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	

}
