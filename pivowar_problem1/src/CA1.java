

import java.security.SecureRandom;
import java.util.Scanner;

public class CA1 
{
	public static void main(String[] args)
	{
		// Call quiz method to begin quiz
		quiz();
	}
	
	public static void quiz()
	{
		// Declare variables
		int correctAns, answer;
		String choice;
		Scanner sc = new Scanner(System.in);
		// Generate question
		correctAns = askQuestion();
		// Read user input
		answer = readResponse();
		// Check if user is correct
		int correct = isAnswerCorrect(correctAns, answer);
		if (correct == 1)
		{
			// If correct display message
			displayCorrectResponse();
			// Ask if they want more questions
			System.out.println("Try another question? [y/n] ");
			choice = sc.next();
			if (choice.equalsIgnoreCase("n"))
			{
				// Exit if they say no
				System.exit(0);
			}
			else
			{
				// Continue if they say yes
				quiz();
			}
		}
		else
		{
			// Loop while user is incorrect
			do
			{
				// Display incorrect message
				displayIncorrectResponse();
				// Read input until user is correct
				answer = readResponse();
				correct = isAnswerCorrect(correctAns, answer);
			} while (correct == 0);
			// Ask if they want more questions
			displayCorrectResponse();
			System.out.println("Try another question? [y/n] ");
			choice = sc.next();
			// Exit if they say no
			if (choice.equalsIgnoreCase("n"))
			{
				System.exit(0);
			}
			else
			{
				// Continue if they say yes
				quiz();
			}
		} 
	}
	
	public static int askQuestion() 
	{
		int num1, num2;
		// Initialize variables
		SecureRandom rand = new SecureRandom();
		// Generate random numbers with SecureRandom object
		num1 = rand.nextInt(10);	
		num2 = rand.nextInt(10);
		// Print question
		System.out.print("How much is " + num1 + " times " + num2 + "?");
		// return correct answer to generated question
		return num1 * num2;
	}
	public static int readResponse()
	{
		// Scan user input for answer to question
		System.out.print("\nYour answer: ");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
		
		// Return user input for answer to question
		return answer;
	}
	public static int isAnswerCorrect(int correctAns, int answer) 
	{
		if (correctAns == answer)
		{
			// If user is correct return true/1
			return 1;
		}
		else
		{
			// If user is incorrect return false/0
			return 0;
		}
	}
	public static void displayCorrectResponse()
	{
		// Print correct message
		System.out.println("Very Good! ");
	}
	public static void displayIncorrectResponse()
	{
		// Print incorrect message
		System.out.println("No. Please try again.");
	}
}	