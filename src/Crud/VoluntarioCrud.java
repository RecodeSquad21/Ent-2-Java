package Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.VoluntarioDao;
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
				
				Voluntario voluntario = new Voluntario();
				voluntario.setNome(nome);
				
				voluntarioDAO.save(voluntario);
				
				System.out.println("***Cadastrado***\n");
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