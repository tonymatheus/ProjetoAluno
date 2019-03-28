package com.br.projetoaluno.vicente.eda;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Excecoes.ListaVaziaException;



public class AlunoTesteEda {

	public static void main(String[] args) {
		ListaDados<Aluno> lista = new ListaDados<>();
		int opcao;
		do {
			menuPrincipal();
			opcao = EntradaDeDados.leInt();
			OpcaoMenu(lista, opcao);
		} while (opcao != 0);
	}

	private static void menuPrincipal() {
		System.out.println("\n\n            *MENU*  \n");
		System.out.println("   (1) Inserir aluno no final");
		System.out.println("   (2) Excluir aluno pelo nome");
		System.out.println("   (3) Alterar nota de aluno");
		System.out.println("   (4) Mostrar aluno pelo nome");
		System.out.println("   (5) Ordenar listagem pelo nome");
		System.out.println("   (6) Mostrar listagem completa");
		System.out.println("   (7) Inserir  na  Posição");
		System.out.println("   (8) Excluir  na  Posição");
		System.out.println("   (9) Modifica Aluno na Posição");
		System.out.println("   (0) Encerrar \n");
		System.out.print("              Informe sua opção: ");
	}

	private static void OpcaoMenu(List<Aluno> lista, int opcao) {
		switch (opcao) {
		case 1:
			insereNoFinal(lista);
			break;
		case 2:
			excluiAluno(lista);
			break;
		case 3:
			alteraNota(lista);
			break;
		case 4:
			recuperaAluno(lista);
			break;
		case 5:
			ordenaListagem(lista);
			break;
		case 6:
			mostraListagem(lista);
			break;

		case 7:
			iseriNaPosi(lista);
			break;
		case 8:
			excluirNaPosi(lista);
		case 9:
			modificaAlunoNaPosicao(lista);
		case 0:
			System.out.println("\n PROGAMA FINALIZADO !!!");
			System.out.println("\n OBRIGADO POR UTILIZA-LO !!!");

			break;
		default:
			System.out.println("\n OPÇÃO INEXISTENTE!!!");
		}
	}

	private static void insereNoFinal(List<Aluno> lista) {
		Aluno aluno = new Aluno();
		obtemNomeAluno(aluno);
		obtemDemaisDadosAluno(aluno);
		if (lista.add(aluno))
			System.out.println("ALUNO  INSERIDO  COM  SUCESSO!");
		else
			System.out.println("ALUNO NÃO INSERIDO!");
	}

	/*
	 * private static void iseriNaPosi(List<Aluno> lista) { Scanner sc = new Scanner
	 * (System.in); Aluno aluno = new Aluno ();
	 * 
	 * int Pos; String nome;
	 * System.out.println("Digite a Posição em  que deseja Inserir Novo Nome : " );
	 * Pos =sc.nextInt(); sc.nextLine();
	 * System.out.println("Digite O Nome Desejado : "); nome = sc.nextLine();
	 * aluno.setNome(nome); lista.add(Pos, aluno);
	 * System.out.println("Inserção de Nome Por Posição Feita  Com  Sucesso!!!!!");
	 * 
	 * }
	 */
	private static void iseriNaPosi(List<Aluno> lista) {
		Scanner sc = new Scanner(System.in);
		int pos;
		Aluno aluno = new Aluno();
		System.out.println("Digite a Posição em  que deseja Inserir Novo Nome : ");
		pos = sc.nextInt();
		obtemNomeAluno(aluno);
		lista.add(pos, aluno);
		System.out.println("Inserção de Nome Por Posição Feita  Com  Sucesso!!!!!");

	}

	private static void excluiAluno(List<Aluno> lista) {
		Aluno aluno = new Aluno();
		obtemNomeAluno(aluno);
		if (lista.remove(aluno))
			System.out.println("\n" + aluno.getNome() + " ALUNO  EXLUÍDO COM  SUCESSO!");
		else
			System.out.println("\n" + aluno.getNome() + " NOME  DE ALUNO  NÃO  EXISTENTE NA LISTA");
	}

	private static void excluirNaPosi(List<Aluno> lista) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a Posição Para Exclusão  do  Aluno");
		lista.remove(sc.nextInt());
		System.out.println("Exclusão  Por Posição Feita com  Sucesso!!!!");

	}
	

	private static void recuperaAluno(List<Aluno> lista) {
		Aluno aluno = new Aluno();
		obtemNomeAluno(aluno);
		int pos = lista.indexOf(aluno);
		if (pos == -1)
			System.out.println("\n" + aluno.getNome() + " não existente na lista!");
		else {
			System.out
					.println("\n" + aluno.getNome() + " encontrado(a) na posição " + pos + ": " + lista.get(pos) + ".");
		}
	}
	
	private static Aluno modificaAlunoNaPosicao(List<Aluno> lista)  {
		Aluno aluno = new Aluno ();
		Scanner sc = new  Scanner(System.in);
		try {
			int pos = 0;
			System.out.println("Digite a Posição  do  Aluno ");
			pos=sc.nextInt();
			sc.nextLine();
			obtemNomeAluno(aluno);
			
			if (lista.isEmpty()) {
				throw new ListaVaziaException();
			}
			
			//lista.get(pos);
			lista.set(pos, aluno);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		} catch (ListaVaziaException e) {
			e.getMessage();
		}
		return aluno;
	}
	

	private static void alteraNota(List<Aluno> lista) {
		Aluno aluno = new Aluno();
		obtemNomeAluno(aluno);
		int pos = lista.indexOf(aluno);
		if (pos == -1)
			System.out.println("\n" + aluno.getNome() + " não existente na lista!");
		else {
			aluno = lista.get(pos);
			System.out.println("\n" + aluno.getNome() + " tem nota = " + aluno.getNota());
			System.out.print("DIGITE A NOVA NOTA DO  ALUNO(a): ");
			float nota = EntradaDeDados.leFloat();
			aluno.setNota(nota);
			lista.set(pos, aluno);
		}
	}

	private static void ordenaListagem(List<Aluno> lista) {
		Collections.sort((List<Aluno>) lista);
		System.out.println("Ordenação de Lista ");
		mostraListagem(lista);

	}
	

	private static void mostraListagem(List<Aluno> lista) {
		System.out.print("\n    - LISTAGEM COMPLETA - \n");
		System.out.print(lista.toString());
		System.out.print("\n\n    -  FIM DA LISTAGEM  - \n");
	}

	private static void obtemNomeAluno(Aluno a) {
		System.out.print("\nInforme nome do(a) aluno(a): ");
		String nome = EntradaDeDados.leString();
		a.setNome(nome);
	}

	private static void obtemDemaisDadosAluno(Aluno a) {
		System.out.print("Informe matrícula do(a) aluno(a): ");
		String matr = EntradaDeDados.leString();
		a.setMatricula(matr);
		System.out.print("Informe nota do(a) aluno(a): ");
		float nota = EntradaDeDados.leFloat();
		a.setNota(nota);
	}

}
