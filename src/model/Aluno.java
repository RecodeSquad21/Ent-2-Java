package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;
	
	private List<Aluno> aluno = new ArrayList<Aluno >();
	
	public Aluno() {
		
	}

	public Aluno(int id, String nome, String endereco, String cidade, String estado, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


}
