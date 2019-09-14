import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This class implements Binary Tree Functionalities
 * Methods present are isEmpty, add, printBinaryTreeElements, loadMorseCodeData and decode
 * Private class Node is also present to implement Binary Tree
 */
public class MorseCodeBinaryTree {

	//Elements with specifying the root, leftLeaf and rightLeaf elements of the Tree
	private Node rootNode;
	private Node rightNode;
	private Node leftNode;

	//Constructor used to build the MorseCode Binary Tree
	public MorseCodeBinaryTree() {
		this.rootNode = new Node();
		this.rightNode = new Node();
		this.leftNode = new Node();
	}

	//This method checks if the Tree is empty or not
	private boolean isEmpty() {
		if(rootNode == null) {
			return true;
		}
		return false;
	}

	//Reads the Text file with the alphabets and its relevant MorseCode and loads it to the Binary Tree
	public void loadMorseCodeData(String translatorFile) {
		Scanner morseCodeFile = null;
		try {
			morseCodeFile = new Scanner(new File(translatorFile));

			while (morseCodeFile.hasNextLine()) {
				String str = morseCodeFile.nextLine().trim();
				if (str.length() > 0) {
					add(str.substring(1).trim(), str.charAt(0));
				}
			}
		} catch (FileNotFoundException exception) {
			System.out.println("File not found in the path found!");
		} finally {
			morseCodeFile.close();
		}
	}

	//Adds the elements with its MorseCode to the Binary Tree
	//	 The elements are added in the Binary Tree as given below:
	//
	//	                              (root)               
	//                                     |                   
	//                        --------------------------       
	//                     /                              \       
	//                   /                                  \    
	//                 E                                     T         
	//                 |                                     |        
	//             ---------                              --------      
	//          /             \                        /           \    
	//        /                 \                    /               \      
	//       I                   A                  N                 M  
	//   /       \           /      \           /       \           /   \
	//  S         U         R        W         D         K         G     O
	// / \       /         /        / \       / \       / \       / \   
	//H   V     F         L         P   J    B   X     C   Y     Z   Q
	private void add(String morseCode, char letter) {
		Node current = rootNode;
		String str = " ";
		for (int i=0;i<morseCode.length();i++) {
			str = morseCode.substring(i,i+1);
			if (str.equals("-")) {
				if (current.getRight() != null) {
					current = current.getRight();
				} else {
					current.setRight(new Node());
					current = current.getRight();
				}
			} else if (str.equals(".")) {
				if (current.getLeft() != null) {
					current = current.getLeft();
				} else {
					current.setLeft(new Node());
					current = current.getLeft();
				}
			} 
		}
		current.setElement(letter);
	}

	//Prints the elements of the Binary Tree by calling the printElements method for the currentNode
	public void printBinaryTreeElements() {        
		Node currentNode = rootNode;
		System.out.println("The right and left Node elements of the Tree: ");
		printElements(currentNode);
	}

	//Prints the elements of the Binary Tree (InOrder Traversal)
	private void printElements(Node currentNode) {      
		if (currentNode != null) {
			printElements(currentNode.getLeft());
			System.out.print(currentNode.getElement());  
			printElements(currentNode.getRight());
		}
	}

	//This method decodes MorseCode to English
	public String decodeMorseToEnglish(String morseCode) {
		String englishString = "";
		StringBuffer stringBuffer = new StringBuffer("");
		Node currentNode = rootNode;
		for (int i = 0; i < morseCode.length(); i++) {
			englishString = morseCode.substring(i, i + 1);
			if (englishString.equals(".")) {
				if (currentNode.getLeft() != null) {
					currentNode = currentNode.getLeft();
				} else {
					currentNode.setLeft(new Node());
					currentNode = currentNode.getLeft();
				}
			} else if (englishString.equals("-")) {
				if (currentNode.getRight() != null) {
					currentNode = currentNode.getRight();
				} else{
					currentNode.setRight(new Node());
					currentNode = currentNode.getRight();
				}
			} else if (englishString.equals("_") || englishString.equals(" ")){
				stringBuffer = stringBuffer.append(currentNode.getElement());
				currentNode = rootNode;
			}
		}
		stringBuffer = stringBuffer.append(currentNode.getElement());
		return stringBuffer.toString();
	}

	/**
	 * Node class used to implement the Binary Tree
	 */
	public class Node {
		
		//elements of the Node class - rightNode, leftNode and element
		private char element;
		private Node left;
		private Node right;

		//constructor initializing the rightNode, leftNode and element to empty
		public Node() {
			element = ' ';
			left = null;
			right = null;
		}

		//Getter and Setter for the elements of the Node class
		public char getElement() {
			return Character.toUpperCase(element);
		}

		public void setElement(char element) {
			this.element = element;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}

