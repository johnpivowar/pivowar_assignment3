

import java.security.SecureRandom;
import java.util.Scanner;

public class CA3
{
	// Declare global variables for indexes and final score
	public static int i = 0;
	public static int numCorrect = 0;
	public static int numIncorrect = 0;
	public static double score = 0;

	public static void main(String[] args)
	{
		// Call quiz method to begin quiz
		quiz();
	}
	
	public static void quiz()
	{
		tenProblems();
		// Display completion message after 10 questions complete
		displayCompletionMessage();
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
		System.out.print(i + ".) " + "How much is " + num1 + " times " + num2 + "?");
		// return correct answer to generated question
		return num1 * num2;
	}
	public static int readResponse()
	{
		// Scan user input for answer to question
		System.out.print("\nYour answer: ");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
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
		// Increment index of number of correct answers the user has gotten
		++numCorrect;
		// Print correct message
		// Generate random number using SecureRandom object to pick response to correct answer
		SecureRandom rand = new SecureRandom();
		int resp = 1 + rand.nextInt(3);
		switch (resp)
		{
			// If resp generates 1
			case 1: 
				System.out.println("Very Good! ");
				break;
			// If resp generates 2
			case 2:
				System.out.println("Excellent! ");
				break;
			// If resp generates 3
			case 3:
				System.out.println("Nice work! ");
				break;
			// If resp generates 4
			case 4:
				System.out.println("Keep up the good work! ");
				break;
		}
	}
	public static void displayIncorrectResponse()
	{
		// Increment index of number of incorrect answers the user has gotten
		++numIncorrect;
		// Print incorrect message
		// Generate random number using SecureRandom object to pick response to correct answer
		SecureRandom rand = new SecureRandom();
		int resp = 1 + rand.nextInt(3);
		switch (resp)
		{
			// If resp generates 1
			case 1: 
				System.out.println("No. Please try again. ");
				break;
			// If resp generates 2
			case 2:
				System.out.println("Wrong. Try once more. ");
				break;
			// If resp generates 3
			case 3:
				System.out.println("Don’t give up! ");
				break;
			// If resp generates 4
			case 4:
				System.out.println("No. Keep trying. ");
				break;
		}
	}
	public static void displayCompletionMessage()
	{
		// Calculate users percent correct
		score = ((double)numCorrect / ((double)numCorrect + (double)numIncorrect)) * (double)100;
		if (score < 75)
		{
			// If user got less than 75% correct
			System.out.println("Please ask your teacher for extra help. ");
			System.out.println(" ");
			// Reset global variables before starting new quiz
			numCorrect = 0;
			numIncorrect = 0;
			i = 0;
			// Start new quiz for new user
			quiz();
		}
		else
		{
			// If user got above 75% correct
			System.out.println("Congratulations, you are ready to go to the next level! ");
			System.out.println(" ");
			// Reset global variables before starting new quiz
			numCorrect = 0;
			numIncorrect = 0;
			i = 0;
			// Start new quiz for new user
			quiz();
		}
	}
	public static void tenProblems()
	{
		++i;
		// While loop for 10 iterations to answer 10 questions
		while (i <= 10)
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
				// Increment index by one every time the while loop completes
				quiz();
			}
			else
			{
				// Display incorrect message
				displayIncorrectResponse();
					// Increment index by one every time the while loop completes
				quiz();
			} 
		}
	}
}	