package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoCrud {

	public static void main(String[] args) {
		// criar uma instancia do DAO para utilizar os metodos
		AlunoDAO alunoDAO = new AlunoDAO();

		Scanner input = new Scanner(System.in);

		// setar as variaveis de navegaçao
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		// instancia da lista que vai armazenar
		List<Aluno> alunos = new ArrayList<Aluno>();

		// Menu
		do {
			System.out.println("-----CRUD Aluno-----");
			System.out.println("1- Cadastro de Aluno");
			System.out.println("2- Consulta de Aluno");
			System.out.println("3- Delete de Aluno");
			System.out.println("4- Atualização do Aluno");
			System.out.println("0- sair");

			opcao = input.nextInt();

			// navegaçao do crud
			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("****Cadastrar Aluno****");
				System.out.println("Digite o nome:");
				nome = input.nextLine();
				nome = input.nextLine();

				Aluno aluno = new Aluno();
				aluno.setNome(nome);

				alunoDAO.save(aluno);

				System.out.println("***Cadastrado***\n");
				break;
			case 2:
				for (Aluno a : alunoDAO.getAluno()) {
					System.out.println("Id: " + a.getId_Aluno() + ", Nome: " + a.getNome());
				}

				System.out.println("*Consulta Finalizada*");
				break;
			case 3:
				System.out.println("ID para exclusão: ");
				posicao = input.nextInt();

				alunoDAO.deleteById(posicao);
				System.out.println("Aluno Excluído");
				break;
			case 4:
				System.out.println("Atualizando cadastro do Aluno");
				System.out.println("Digite o Id do Aluno:");
				id = input.nextInt();
				System.out.println("Digite o novo nome do Aluno:");
				nome = input.nextLine();
				nome = input.nextLine();

				Aluno alunos1 = new Aluno();
				alunoDAO.update(aluno);
				break;

			default:
				System.out.println(opcao != 0 ? "\n Opcao invalida, tente novamente.\n" : "");
				break;
			}

		} while (opcao != 0);

		input.close();
		System.out.println("***Finalizado***");

	}

}

public class AlunoCrud {

}
