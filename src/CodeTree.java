import java.util.Scanner;

public class CodeTree {

	static Tree<String> theTree = new Tree<String>();
	public static void main(String[] args) {  
		boolean dontQuit = true;
		Scanner scan = new Scanner(System.in);
		char choice;
		String result, input;
		MorseCodeImplementation codeImplementation = new MorseCodeImplementation();
		codeImplementation.createBinaryTree();
		System.out.println("(p) print pre-order traversal of Binary tree");
		System.out.println("(d) decode Morse to English");
		System.out.println("(e) encode English to Morse");
		System.out.println("(q) quit");

		while(dontQuit) {
			System.out.print("\nChoice: ");
			choice = scan.next().charAt(0);
			if(choice != 'p' && choice != 'd' && choice != 'e' && choice != 'q') {
				System.out.println("Not a valid choice.");
				continue;
			} else if(choice == 'q') {
				dontQuit = false;
				break;
			} else if(choice == 'p') {
				System.out.println(theTree.traverse());
			} else if(choice == 'd') {
				scan.nextLine();
				System.out.print("Morse to decode: ");
				input = scan.nextLine();
				result = codeImplementation.decode(input);
				System.out.println("'" + input + "'" + " decodes to " + "'" + result + "'");
			} else {
				scan.nextLine();
				System.out.print("String to encode: ");
				input = scan.nextLine();
				result = codeImplementation.encode(input);
				System.out.println("'" + input + "'" + " encodes to " + "'" + result + "'");
			}
		}
	}
}