package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private int id;
	private String nome;
	private String idade;
	
	private List<Aluno> aluno = new ArrayList<Aluno >();
	
	public Aluno() {
		
	}

	public Aluno(int id, String nome, String idade, String disponibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Aluno(int id2, String nome2, String idade2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

}
