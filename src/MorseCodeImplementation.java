import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This class implements MorseCode Conversion
 * 
 * */
public class MorseCodeImplementation {
	static Tree<String> tree = new Tree<String>();

	/*
	 *                             (root)               
                                     |                   
                        --------------------------       
                     /                              \       
                   /                                  \    
                 E                                     T         
                 |                                     |        
             ---------                              --------      
          /             \                        /           \    
        /                 \                    /               \      
       I                   A                  N                 M  
   /       \           /      \           /       \           /   \
  S         U         R        W         D         K         G     O
 / \       /         /        / \       / \       / \       / \   
H   V     F         L         P   J    B   X     C   Y     Z   Q
	 * */
	public static void createBinaryTree() {
		tree.insert(" ", Tree.ROOT);
		tree.insert("E", Tree.LEFT_CHILD);
		tree.insert("I", Tree.LEFT_CHILD);
		tree.insert("S", Tree.LEFT_CHILD);
		tree.insert("H", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.insert("V", Tree.RIGHT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.insert("U", Tree.RIGHT_CHILD);
		tree.insert("F", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT); 
		tree.insert("A", Tree.RIGHT_CHILD);
		tree.insert("R", Tree.LEFT_CHILD);
		tree.insert("L", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.insert("W", Tree.RIGHT_CHILD);
		tree.insert("P", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.insert("J", Tree.RIGHT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.insert("T", Tree.RIGHT_CHILD);
		tree.insert("N", Tree.LEFT_CHILD);
		tree.insert("D", Tree.LEFT_CHILD);
		tree.insert("B", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.insert("X", Tree.RIGHT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT); 
		tree.insert("K", Tree.RIGHT_CHILD);
		tree.insert("C", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.insert("Y", Tree.RIGHT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT); 
		tree.insert("M", Tree.RIGHT_CHILD);
		tree.insert("G", Tree.LEFT_CHILD);
		tree.insert("Z", Tree.LEFT_CHILD);
		tree.move(Tree.PARENT);
		tree.insert("Q", Tree.RIGHT_CHILD);
		tree.move(Tree.PARENT);
		tree.move(Tree.PARENT);
		tree.insert("O", Tree.RIGHT_CHILD);

		tree.move(Tree.ROOT); //resets current to the root

	}


	public static String decode(String morseText) {

		if(morseText.length() == 0) {
			String holder = tree.findElement();
			tree.move(Tree.ROOT);
			return holder;
		}
		char currentChar = morseText.charAt(0);

		if(currentChar != '.' && currentChar != '-' && currentChar != '_') {
			throw new RuntimeException("Not a dot or dash.");
		}
		if(currentChar == '.') {
			tree.move(Tree.LEFT_CHILD);
			return decode(morseText.substring(1));
		}
		else if(currentChar == '-') {
			tree.move(Tree.RIGHT_CHILD);
			return decode(morseText.substring(1));
		}
		else if(currentChar == '_') {
			String holder = tree.findElement();
			tree.move(Tree.ROOT);
			return holder + decode(morseText.substring(1));
		}

		tree.move(Tree.ROOT);
		return " ";


	}

	public static String encode(String sentence) {
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};
		String[] morseTrans = {/*A-I*/".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
				/*J-S*/".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
				/*T-Z*/"-", "..-", "...-", ".--", "-..-", "-.--", "--..", ""};
		String result = "";
		sentence = sentence.toUpperCase();

		for(int i=0; i<sentence.length(); i++) {
			for(int j=0; j<letters.length; j++) {
				if(sentence.charAt(i) == (letters[j])) {
					result = result + morseTrans[j] + "_";
					break;
				}
			}
		}
		return result;
	}
}
