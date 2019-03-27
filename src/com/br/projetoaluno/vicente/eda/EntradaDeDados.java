package com.br.projetoaluno.vicente.eda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDeDados {
	public static String leString() {
		Scanner input = new Scanner (System.in);
		String s = input.next();
		if (input.hasNextLine())
			s = s+input.nextLine();
		return s;
	}
	
	public static int leInt() {
		Scanner input = new Scanner (System.in);
		while(true){
			try {
				int i = input.nextInt();
				return i;
			}
			catch (InputMismatchException e) {
				System.out.print(e + " - Não é número inteiro!!! Tente novamente: ");
				input.nextLine();
			}
		}
	}
	
	public static float leFloat() {
		Scanner input = new Scanner (System.in);
		while(true){
			try {
				float f = input.nextFloat();
				return f;
			}
			catch (InputMismatchException e) {
				System.out.print(e + " - Não é número real!!! Tente novamente: ");
				input.nextLine();
			}
		}
	}
}
