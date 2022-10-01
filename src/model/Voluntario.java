package model;

public class Voluntario {

	private int id;
	private String nome;
	private String disponibilidade;
	
	public Voluntario() {
		
	}

	public Voluntario(int id, String nome, String disponibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.disponibilidade = disponibilidade;
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

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int getIdade() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
