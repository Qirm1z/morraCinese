package org.generation.italy;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Esercizio: morra cinese
		 * 
		 * Scrivere un programma che simula il gioco "morra cinese". Il computer
		 * "genera" in maniera casuale la sua mossa ("carta", "forbice", "sasso") senza
		 * mostrarla all'utente. All'utente viene chiesto di inserire la sua mossa, e a
		 * questo punto viene mostrata anche la mossa del computer. Il programma mostra
		 * quindi chi ha vinto, secondo le seguenti regole: il sasso vince sulla forbice
		 * la forbice vince sulla carta la carta vince sul sasso dopo ogni partita,
		 * mostrare il punteggio dell'utente e del computer Il programma termina quando
		 * uno dei due giocatori arriva a 5
		 */

		String[] cpuMove = { "sasso", "carta", "forbice" };
		Random r = new Random();

		Scanner sc = new Scanner(System.in);

		boolean confirm = true;

		int userScore = 0, cpuScore = 0;

		do {

			while (cpuScore < 5 && userScore < 5) {

				int possibleMove = r.nextInt(cpuMove.length);

				System.out.println("Scegli una mossa tra sasso, carta e forbice.");
				String userInput = sc.nextLine().toLowerCase();

				while (!userInput.equals("sasso") && !userInput.equals("carta") && !userInput.equals("forbice")) {
					System.out.println("Inserisci una mossa valida.");
					userInput = sc.nextLine().toLowerCase();
				}

				System.out.println("La CPU ha giocato: " + cpuMove[possibleMove] + "!");

				if (userInput.equals(cpuMove[possibleMove])) {
					System.out.println("E' un pareggio! CPU: " + cpuScore + " Giocatore: " + userScore);
				} else if ((userInput.equals("sasso") && cpuMove[possibleMove].equals("carta"))
						|| (userInput.equals("carta") && cpuMove[possibleMove].equals("forbice"))
						|| (userInput.equals("forbice") && cpuMove[possibleMove].equals("sasso"))) {
					cpuScore++;
					System.out.println("Il computer vince il round! CPU: " + cpuScore + " Giocatore: " + userScore);
				} else {
					userScore++;
					System.out.println("Hai vinto il round! CPU: " + cpuScore + " Giocatore: " + userScore);
				}
			} if (userScore==5)
				System.out.println("Hai vinto la partita!");
			else
				System.out.println("Il computer ha vinto la partita. :(");
			cpuScore=0; //resettiamo i punteggi per la prossima partita.
			userScore=0;
			System.out.println("Vuoi riprovare? (s/n)");
			String input = sc.next();
			confirm = input.equalsIgnoreCase("s");
			sc.nextLine();
		} while (confirm);

		sc.close();

	}
}
