import java.util.Scanner;

/**
 * Main class used to run the MorseCode Binary Tree class
 */
public class MorseCodeBinaryTreeImplementation {

	//Main Method used to run the application
	public static void main(String[] args) {
		System.out.println("Welcome to Morse Code to English Translator: ");
		displayChoiceList();
		morseCodeImplementor();
	}

	//This method takes choices from user and perform functions accordingly
	//1: Displays the choice list
	//2: Translates MorseCode to English
	//3: Prints the Binary Tree Elements
	//4: Quits the application
	public static void morseCodeImplementor() {
		MorseCodeBinaryTree morseCodeBinaryTree = new MorseCodeBinaryTree();
		String file = "/Users/shipra/Desktop/MorseCodeAndAlphabets.txt";
		morseCodeBinaryTree.loadMorseCodeData(file);
		boolean dontQuit = true;
		Scanner scanner = new Scanner(System.in);
		String choice;
		String input;
		while(dontQuit) {
			System.out.print("\nEnter Choice: ");
			choice = scanner.nextLine();
			switch(choice) {
			case "1":
				displayChoiceList();
				break;
			case "2":
				System.out.print("Enter Morse Code to decode to English: ");
				input = scanner.nextLine();
				System.out.println(input+ " translates to: " + morseCodeBinaryTree.decodeMorseToEnglish(input));
				break;
			case "3":
				morseCodeBinaryTree.printBinaryTreeElements();
				break;
			case "4":
				System.out.println("Quitting MorseCode-English Translator!");
				dontQuit = false;
				break;
			default:
				System.out.println("Not a valid choice. Try again!");
				displayChoiceList();
				continue;
			}
		}
		scanner.close();
	}

	//Displays the notification list for MorseCode-English Translator
	private static void displayChoiceList() {
		String message = "\nMorseCode-English Translator\n" +
				"1. Display list\n" +
				"2. Decode the Morse Code to English\n" +
				"3. Print the elements of the Binary Morse Code Tree\n" +
				"4. Quit\n";
		System.out.println(message);
	}
}
