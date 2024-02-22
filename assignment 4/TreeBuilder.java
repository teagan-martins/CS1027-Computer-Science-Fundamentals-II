
public class TreeBuilder<T> { // Class for building a Tree
	
	public LinkedBinaryTree<T> buildTree (T[] data) { // Method for building the tree and returning it
		LinkedQueue<T> dataQueue = new LinkedQueue<T>(); // Creating a new LinkedQueue called dataQueue
		LinkedQueue<BinaryTreeNode<T>> parentQueue = new LinkedQueue<BinaryTreeNode<T>>(); // Creating a LinkedQueue of BinaryTreeNodes called parentQueue
		
		int l = data.length; // Getting the length of the inputed array parameter
		
		for (int i = 0; i < l; ++i) { // For loop to iterate through the data parameter
			dataQueue.enqueue(data[i]); // Putting each item in data to the queue of dataQueue
		}
		
		LinkedBinaryTree tree = new LinkedBinaryTree(dataQueue.dequeue()); // Creating a LinkedBinary Tree with the first item in dataQueue (and removing it)
		parentQueue.enqueue(tree.getRoot()); // Putting the root of tree into the queue of parentQueue
		
		while (dataQueue.isEmpty()==false) { // While dataQueue is not empty...
			T a = dataQueue.dequeue(); // Dequeue dataQueue and store the value in a
			T b = dataQueue.dequeue(); // Dequeue dataQueue and store the value in b
			
			BinaryTreeNode<T> parent = parentQueue.dequeue(); // Create a new BinaryTreeNode called parent through the dequeue operation of parentQueue
			
			BinaryTreeNode<T> temp = new BinaryTreeNode<T>(a); // Create a new BinaryTree node called temp with the value of a
			BinaryTreeNode<T> curr = new BinaryTreeNode<T>(b); // Create a new BinaryTree node called curr with the value of b
			if (a!=null) { // If a is not null...
				parent.setLeft(temp); // Set parent's left value to temp
				parentQueue.enqueue(temp); // Enqueue temp into parentQueue
			}
			if (b!=null) { // If b is not null...
				parent.setRight(curr); // Set parent's right value to curr
				parentQueue.enqueue(curr); // Enqueue curr into parentQueue
			}
		}
		
		return tree; // Return the final tree
		
	}
}
