

import java.security.SecureRandom;
import java.util.Scanner;

public class CA5
{
	// Declare global variables for indexes and final score
	public static int i = 0;
	public static int numCorrect = 0;
	public static int numIncorrect = 0;
	public static int diff = 0;
	public static int pSign = 0;
	public static double score = 0;

	public static void main(String[] args)
	{
		// Call quiz method to begin quiz
		quiz();
	}
	
	public static void quiz()
	{
		diff = readDifficulty();
		pSign = readProblemType();
		tenProblems(diff, pSign);
	}
	
	public static double askQuestion(int[] nums, int pType) 
	{
		switch (pType)
		{
			case 1:
			{
				// All addition problems
				System.out.print(i + ".) " + "How much is " + nums[0] + " plus " + nums[1] + "?");
				return nums[0] + nums[1];
			}
			case 2:
			{
				// All multiplication problems
				System.out.print(i + ".) " + "How much is " + nums[0] + " times " + nums[1] + "?");
				return nums[0] * nums[1];
			}
			case 3:
			{
				// All subtraction problems
				System.out.print(i + ".) " + "How much is " + nums[0] + " minus " + nums[1] + "?");
				return nums[0] - nums[1];
			}
			case 4:
			{
				// All division problems
				System.out.print(i + ".) " + "How much is " + nums[0] + " divided by " + nums[1] + "?");
				return (double)nums[0] / (double)nums[1];
			}
			case 5:
			{
				// Generate random number with SecureRandom object to get even mixture
				SecureRandom rand = new SecureRandom();
				int type = 1 + rand.nextInt(3);
				switch (type)
				{
					case 1:
					{
						// Addition problem
						System.out.print(i + ".) " + "How much is " + nums[0] + " plus " + nums[1] + "?");
						return nums[0] + nums[1];
					}
					case 2:
					{
						// Multiplication problem
						System.out.print(i + ".) " + "How much is " + nums[0] + " times " + nums[1] + "?");
						return nums[0] * nums[1];
					}
					case 3:
					{
						// Subtraction problem
						System.out.print(i + ".) " + "How much is " + nums[0] + " minus " + nums[1] + "?");
						return nums[0] - nums[1];
					}
					case 4:
					{
						// Division problem
						System.out.print(i + ".) " + "How much is " + nums[0] + " divided by " + nums[1] + "?");
						return (double)nums[0] / (double)nums[1];
					}
				}
			}
		}
		// return correct answer to generated question
		return nums[0] * nums[1];
	}
	public static double readResponse()
	{
		// Scan user input for answer to question
		System.out.print("\nYour answer to two decimals: ");
		Scanner sc = new Scanner(System.in);
		double answer = sc.nextDouble();
		return answer;
	}
	public static int isAnswerCorrect(double correctAns, double answer) 
	{
		// Rounds correct answer to two decimal places
		double crAns = (double) Math.round(correctAns * 100) / 100;
		if (crAns == answer || correctAns == Double.POSITIVE_INFINITY)
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
	public static void tenProblems(int diff, int pSign)
	{
		++i;
		// While loop for 10 iterations to answer 10 questions
		while (i <= 10)
		{
			// Declare variables
			double correctAns, answer;
			String choice;
			Scanner sc = new Scanner(System.in);
			int[] nums = new int[2];
			// Set nums equal to array of generated numbers
			nums = generateQuestionArgument(diff);
			// Generate question using array nums and problem type
			correctAns = askQuestion(nums, pSign);
			// Read user input
			answer = readResponse();
			// Check if user is correct
			int correct = isAnswerCorrect(correctAns, answer);
			if (correct == 1)
			{
				// If correct display message
				displayCorrectResponse();
				tenProblems(diff, pSign);
				// Increment index by one every time the while loop completes
			}
			else
			{
				// Display incorrect message
				displayIncorrectResponse();
				tenProblems(diff, pSign);
			} 
			// Display completion message after 10 questions complete
			displayCompletionMessage();
			// Restore difficulty back to 0
			diff = 0;
			quiz();
		}
	}
	public static int readDifficulty()
	{
		// Ask user to input difficulty level
		System.out.println("Enter Difficulty Level [1-4]: ");
		Scanner sc = new Scanner(System.in);
		int diff = sc.nextInt();
		// Return user input for difficulty level
		return diff;
	}
	public static int[] generateQuestionArgument(int diff)
	{
		// Declare array so I can return both generated numbers
		int[] nums = new int[2];
		SecureRandom rand = new SecureRandom();
		switch(diff)
		{
		// Switch statement for each level of difficulty
			case 1:
			{
				// Generate random numbers with SecureRandom object for difficulty level 1
				nums[0] = rand.nextInt(10);	
				nums[1] = rand.nextInt(10);
				break;
			}
			case 2:
			{
				// Generate random numbers with SecureRandom object for difficulty level 2
				nums[0] = rand.nextInt(100);	
				nums[1] = rand.nextInt(100);
				break;
			}
			case 3:
			{
				// Generate random numbers with SecureRandom object for difficulty level 3
				nums[0] = rand.nextInt(1000);	
				nums[1] = rand.nextInt(1000);
				break;
			}
			case 4:
			{
				// Generate random numbers with SecureRandom object for difficulty level 4
				nums[0] = rand.nextInt(10000);	
				nums[1] = rand.nextInt(10000);
				break;
			}
		}
		// Return array containing both generated numbers
		return nums;
	}
	public static int readProblemType()
	{
		// Ask user to input problem type
		System.out.println("Enter Problem Type [1]Addition, [2]Multiplication, [3]Subtraction, [4]Divison, [5]Mixture of All: ");
		Scanner sc = new Scanner(System.in);
		int pType = sc.nextInt();
		// Return user input for problem type
		return pType;
	}
}	