// Jack Wakefield | 13 September 2023 | Hangman

//#PRINT: Welcome
//#REPEAT
//	PRINT: Difficulty selection
//	IF Easy THEN
//		Pull up easy word database and pick random word from database
//	ELSEIF Hard THEN
//		Pull up hard word database and pick random word from database
//	ENDIF
//	
//	WHILE There are still more than 0 attempts remaining or word is not guessed
//		PRINT: Guess selection
//		IF Guess has already been attempted THEN
//			Re-do guess selection
//		ELSEIF Guess is in word THEN
//			Fill in spots where letter is in word
//		ELSE
//			Reduce remaining attempts by one
//	ENDWHILE
//	
//	PRINT: Win/lose
//	
//	PRINT: Play again selection
//UNTIL User picks the option to not play again

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String wordList[] = {"laptop", "desktop", "tablet", "smartphone", "guess"};
		for(int i = 0; i < 5; i++) {
			wordList[i].equalsIgnoreCase(null);
		}
		
		boolean play = true;
		int attempts = 0;
		
		//PRINT: Welcome
		System.out.println("Welcome to hangman.");
		System.out.println();
		
		//REPEAT
		while (play) {
			String targetWord = wordList[rand.nextInt(wordList.length)];
			String guessedWord = "";
			for(int i =0; i < targetWord.length(); i++) {
				guessedWord = guessedWord + '-';
			}
			System.out.println(guessedWord);
			
			//WHILE There are still more than 0 attempts remaining or word is not guessed
			while (attempts < 6) {
				//PRINT: Guess selection
				
				System.out.println("Guess a letter:");
				char userChar = sc.next().charAt(0);
				char guessedChar = Character.toLowerCase(userChar);
				
				
				
				if (incorrectAttempt(guessedChar, targetWord)) {
					attempts++;
				}
				
				printHangman(attempts);
				
				guessedWord = revealCharacter(guessedChar, targetWord, guessedWord);
				System.out.println(guessedWord);
			}
			play = false;
		}

		
		sc.close();
	}
	public static boolean incorrectAttempt(char guess, String target) {
		for (int i = 0; i< target.length(); i++) {
			if (target.charAt(i) == guess) {
				return false;
			}
		}
		return true;
	}
	
	public static String revealCharacter(char guess, String target, String revealed) {
		StringBuilder result = new StringBuilder(revealed);
		
		for (int i = 0; i< target.length(); i++) {
			if (target.charAt(i) == guess) {
				result.setCharAt(i, guess);
			}
		}
		return result.toString();
	}

	public static void printHangman(int hangStage) {
		switch (hangStage) {
		case 0:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 1:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 2:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |   |  ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 3:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |  /|  ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 4:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |  /|\\ ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 5:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |  /|\\ ");
			System.out.println(" |  /   ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		case 6:
			System.out.println(" _____  ");
			System.out.println(" |/  |  ");
			System.out.println(" |   o  ");
			System.out.println(" |  /|\\ ");
			System.out.println(" |  / \\ ");
			System.out.println(" |      ");
			System.out.println(" ======= ");
			break;
		}
	}
}

