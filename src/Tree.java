/*
 * This class implements Binary Tree Functionalities
 * Insert, findElement, isEmpty, move, findParent, traverse methods
 */

public class Tree<E> {

	//Elements with specifying the root, leftLeaf and rightLeaf elements of the Tree
	public static final String ROOT = "root";
	public static final String LEFT_CHILD = "leftChild";
	public static final String RIGHT_CHILD = "rightChild";
	public static final String PARENT = "parent";

	private Node<E> currentNode; 
	private Node<E> currentRoot;
    	
	//This method inserts a new node onto the tree
	public void insert(E element, String side) {
		Node<E> newNode = new Node<E>(element);
		if(side == ROOT) {
			currentRoot = newNode;
			currentNode = newNode;
		} else if(side == LEFT_CHILD) {
			currentNode.setLeft(newNode);
			currentNode = newNode;
		} else if(side == RIGHT_CHILD) {
			currentNode.setRight(newNode);
			currentNode = newNode;
		}
	}

	//This method finds the element found on the node of the tree and returns it
	public E findElement() {
		return currentNode.getElement();
	}
	
	//This method checks if the Tree is empty or not
	public boolean isEmpty() {
		if(currentRoot == null) {
			return true;
		}
		return false;
	}

	//This method moves the elements added to tree on different nodes
	public Boolean move(String move) {
		switch(move) {
		case PARENT:
			if(currentNode == currentRoot) {
				return false;
			}
			findParent(currentRoot);
			return true;
		case LEFT_CHILD:
			if(currentNode.getLeft() == null) {
				return false;
			}
			currentNode = currentNode.getLeft();
			return true;
		case RIGHT_CHILD:
			if(currentNode.getRight() == null) {
				return false;
			}
			currentNode = currentNode.getRight();
			return true;
		case ROOT:
			currentNode = currentRoot;
			return true;
		default:
			return false;
		}
	}

	//This method finds the parent node on the Tree
	private void findParent(Node<E> element) {
		if(element == null || currentNode == currentRoot) {
			return;
		}
		if(element.getLeft() == currentNode || element.getRight() == currentNode) {
			currentNode = element;
		} else {
			findParent(element.getRight());
			findParent(element.getLeft());
		}
	}

	//This method traverses the binary tree to retrieve the elements stored in the tree
	public String traverse() {
		return traverseTree(currentRoot);
	}

	private String traverseTree(Node<E> target) {
		if(target == null) {
			return "";
		}
		return target.getElement().toString() + traverseTree(target.getLeft()) + traverseTree(target.getRight());
	}

	// class Node for implementing the Binary Tree
	private static class Node<E> {
		private Node<E> left;
		private Node<E> right;
		private E element;

		public Node(E data) {
			left = null;
			right = null;
			element = data;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

}
