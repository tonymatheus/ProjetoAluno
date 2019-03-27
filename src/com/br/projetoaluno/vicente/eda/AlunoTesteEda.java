package com.br.projetoaluno.vicente.eda;
import  java.util.List;
import  java.util.ArrayList;
import java.util.Collections;

public class AlunoTesteEda {

		public static void main(String[] args) {
			List<Aluno> lista = new ArrayList<Aluno>();
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
			System.out.println("   (0) Encerrar \n");
			System.out.print("              Informe sua op��o: ");
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
			case 0:
				System.out.println("\n PROGAMA FINALIZADO !!!");
				System.out.println("\n OBRIGADO POR UTILIZA-LO !!!");
				
				break;
			default:
				System.out.println("\n OP��O INEXISTENTE!!!");
			}
		}

		private static void insereNoFinal(List<Aluno> lista) {
			Aluno aluno = new Aluno();
			obtemNomeAluno(aluno);
			obtemDemaisDadosAluno(aluno);
			if (lista.add(aluno))
				System.out.println("ALUNO  INSERIDO  COM  SUCESSO!");
			else
				System.out.println("ALUNO N�O INSERIDO!");
		}

		private static void excluiAluno(List<Aluno> lista) {
			Aluno aluno = new Aluno();
			obtemNomeAluno(aluno);
			if (lista.remove(aluno))
				System.out.println("\n" + aluno.getNome() + " ALUNO  EXLU�DO COM  SUCESSO!");
			else
				System.out.println("\n" + aluno.getNome() + " NOME  DE ALUNO  N�O  EXISTENTE NA LISTA");
		}

		private static void recuperaAluno(List<Aluno> lista) {
			Aluno aluno = new Aluno();
			obtemNomeAluno(aluno);
			int pos = lista.indexOf(aluno);
			if (pos == -1)
				System.out.println("\n" + aluno.getNome() + " n�o existente na lista!");
			else {
				System.out
						.println("\n" + aluno.getNome() + " encontrado(a) na posi��o " + pos + ": " + lista.get(pos) + ".");
			}
		}

		private static void alteraNota(List<Aluno> lista) {
			Aluno aluno = new Aluno();
			obtemNomeAluno(aluno);
			int pos = lista.indexOf(aluno);
			if (pos == -1)
				System.out.println("\n" + aluno.getNome() + " n�o existente na lista!");
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
			System.out.println("Ordena��o de Lista ");
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
			System.out.print("Informe matr�cula do(a) aluno(a): ");
			String matr = EntradaDeDados.leString();
			a.setMatricula(matr);
			System.out.print("Informe nota do(a) aluno(a): ");
			float nota = EntradaDeDados.leFloat();
			a.setNota(nota);
		}
		
	}


