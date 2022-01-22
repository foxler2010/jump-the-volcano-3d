package top.drewssite.volcano;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    
    //Scanner
	private Scanner scanner;

	//Constructor
	public Utility() {
		scanner = new Scanner(System.in);
	}

	//Scanner-getter
	public Scanner getScanner() {
		return scanner;
	}

	//Prompts the user to enter one of two options (ex. yes/no question).
	public boolean yesNoPrompt(String prompt, String isTrue, String isFalse) {
		boolean answer = true;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			System.out.print(prompt);
			String response = getScanner().next();
			System.out.println();
			if(response.equals(isTrue)) {
				answer = true;
				responseIsValid = true;
			} else if(response.equals(isFalse)) {
				answer = false;
				responseIsValid = true;
			} else {
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
			}
		}
		return answer;
		
	}

	//Extension of yes/no prompt, allowing as many true and false answers as you want.
	public boolean yesNoPrompt(String prompt, String[] isTrue, String[] isFalse) {
		boolean answer = true;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			System.out.println(prompt);
			String response = getScanner().next();
			System.out.println();
			for(int i = 0; i < isTrue.length - 1; i++) {
				if (response.equals(isTrue[i])); {
					answer = true;
				} if (response.equals(isFalse[i])) {
					answer = true;
				} else {
					System.out.println("That answer is invalid. Please try again.");
					System.out.println();
					responseIsValid = false;
				}
			}
		}
		return answer;
	}
	
	//Prompts the user to enter an integer.
	public int intPrompt(String prompt) {
		int response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = getScanner().nextInt();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = getScanner().next();
			}
		}
		return response;
	}
	
	//Prompts the user to enter a double.
	public double doublePrompt(String prompt) {
		double response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = getScanner().nextDouble();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = getScanner().next();
			}
		}
		return response;
	}

}
