package Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.AlunoDao;
import Dao.VoluntarioDao;
import model.Aluno;
import model.Voluntario;

public class VoluntarioCrud {

	public static void main(String[] args) {
		//criar uma instancia do DAO para utilizar os metodos
		VoluntarioDao voluntarioDAO = new VoluntarioDao();
		
		Scanner input = new  Scanner(System.in);
		
		// setar as variaveis de navegaçao
		int opcao =0;
		int posicao = 0;
		
		int id = 0;
		String nome = "";
		String sobrenome = "";
		String cidade = "";
		String estado = "";
		String cep = "";
		String email = "";
		String apresentacao = "";
		
		//instancia  da lista que vai armazenar
		List<Voluntario> voluntarios = new ArrayList<Voluntario>();

		//Menu
		do {
			System.out.println("-----CRUD Voluntario-----");
			System.out.println("1- Cadastro de Voluntario");
			System.out.println("2- Consulta de Voluntario");
			System.out.println("3- Delete de Voluntario");
			System.out.println("4- Atualização do Voluntario");
			System.out.println("0- sair");
			
			opcao = input.nextInt();
			
			//navegaçao do crud
			switch(opcao) {
			case 1:
				//CREATE
				System.out.println("****Cadastrar Voluntario****");
				System.out.println("Digite o nome:");
				nome = input.nextLine();
				nome = input.nextLine();
				System.out.println("Digite o Sobrenome:");
				sobrenome = input.nextLine();
				System.out.println("Digite o Cidade:");
				cidade = input.nextLine();
				System.out.println("Digite o Estado:");
				estado = input.nextLine();
				System.out.println("Digite o Cep:");
				cep = input.nextLine();
				System.out.println("Digite o Email:");
				email = input.nextLine();
				System.out.println("Digite sua Apresentação:");
				apresentacao = input.nextLine();
				
				Voluntario voluntario = new Voluntario();
				voluntario.setNome(nome);
				voluntario.setSobrenome(sobrenome);
				voluntario.setCidade(cidade);
				voluntario.setEstado(estado);
				voluntario.setCep(cep);
				voluntario.setEmail(email);
				voluntario.setApresentacao(apresentacao);
				
				voluntarioDAO.save(voluntario);
				
				System.out.println("***Cadastrado***\n");
				break;
			case 2:
				for (Voluntario a : voluntarioDAO.getVoluntario()) {
					System.out.println("Id: " + a.getId() + ", Nome: " + a.getNome() + " " + a.getSobrenome() + ", Cidade: " + a.getCidade() + ", Estado: " + a.getEstado() + ", Cep: " + a.getCep() + ", Email: " + a.getEmail());
				}
				
				System.out.println("*Consulta Finalizada*");
				break;
			case 3:
				System.out.println("ID para exclusão: ");
				posicao = input.nextInt();
				
				voluntarioDAO.deleteById(posicao);
				System.out.println("Voluntário Excluído");
				break;
			case 4:
				System.out.println("Atualizando cadastro do Aluno");
				System.out.println("Digite o Id do Aluno:");
				id = input.nextInt();
				System.out.println("Digite o novo nome:");
				nome = input.nextLine();
				nome = input.nextLine();
				System.out.println("Digite o novo Sobrenome:");
				sobrenome = input.nextLine();
				System.out.println("Digite a nova Cidade:");
				cidade = input.nextLine();
				System.out.println("Digite o novo Estado:");
				estado = input.nextLine();
				System.out.println("Digite o novo Cep:");
				cep = input.nextLine();
				System.out.println("Digite o novo Email:");
				email = input.nextLine();
				System.out.println("Digite sua nova Apresentação:");
				apresentacao = input.nextLine();
				
				Voluntario voluntario1 = new Voluntario(id, nome, sobrenome, cidade, estado, cep, email, apresentacao);
				VoluntarioDao.update(voluntario1);
				break;	
		
				
			default:
				System.out.println(opcao != 0 ? "\n Opcao invalida, tente novamente.\n":"");
			break;
			}
			
		}while(opcao != 0);
			
		input.close();
		System.out.println("***Finalizado***");
			
	}

}