public class DLStack<T> implements DLStackADT<T> { // Class representing a stack of double linked nodes
	
	private DoubleLinkedNode<T> top; // Instance variable representing the top of the stack
	private int numItems; // Instance variable representing the number of nodes in the stack
	
	public DLStack() { // Constructor that gives top and numItems values
		top = null; // Setting top to null (empty stack)
		numItems = 0; // Setting numItems to 0 (empty stack)
	}
	
	public void push(T dataItem) { // Method for adding an item to the top of the stack
		
		DoubleLinkedNode<T> temp = new DoubleLinkedNode<T>(dataItem); // Creating a DoubleLinkedNode with the inputed parameter
		
		temp.setPrevious(top); // Setting temp's previous node to top
		if (top!=null) { // If top is not null (to avoid nullpointer exception),
			top.setNext(temp); // Set top's next node to temp
		}
		top = temp; // Set top to temp
		numItems = numItems+1; // Increment numItems
		
		
	}
	
	public T pop() throws EmptyStackException { // Method for removing the top of the stack
		if (isEmpty()) throw new EmptyStackException("Stack"); // If the stack is empty, throw an EmptyStackException
		
		if (top==null) { // If top is null,
			return null; // Return null
		}
		
		T result = top.getElement(); // Creating an element of type generic T that represents the element at the top of the stack
		
		top = top.getPrevious(); // Setting top to the previous node
		
		if (top==null) { // If top is null
			numItems = numItems - 1; // Decrement numItems
			return result; // Return result
		}
		else { // Otherwise
			top.setNext(null); // Set top's next node to null
			numItems = numItems - 1; // Decrement numItems
			return result; // Return result
		}
	}
	
	public T pop(int k) throws InvalidItemException { // Method for removing a node with a certain index
		
		if (k==1) { // If k is 1,
			return this.pop(); // Just use pop() as it is the same thing
		}
		
		DoubleLinkedNode<T> temp = top; // Setting temp to the node at the top of the stack
		
		DoubleLinkedNode<T> result = top; // Setting result to the node at the top of the stack
		
		DoubleLinkedNode<T> result2 = top; // Setting result2 to the node at the top of the stack
		
		DoubleLinkedNode<T> live = top; // Setting live to the node at the top of the stack
			
		if ((k > numItems) || (k<=0)) { // If k is greater than the number of items or lower than or equal to 0
			throw new InvalidItemException("Invalid Item"); // Throw an InvalidItemException
		}
		else { // Otherwise,
			for (int i = 0; i < k; ++i) { // For loop that iterates through the stack
				temp = temp.getPrevious(); // Set temp to its previous node (temp will be the node before the node to be removed at the end)
			}
			
			for (int j = 0; j< k-2; ++j) { // For loop that iterates through the stack until k-2
				live = live.getPrevious(); // Set live to its previous node (live will be the node after the last node in the case of if k is the index of the last node)
			}
			
			for (int h = 0; h < k-1; ++h) { // For loop that iterates through the stack until k-1
				result2 = result2.getPrevious(); // Set result2 to its previous node (result2 will be the last node in the case of if k is the index of the last node)
			}
		}
		
		DoubleLinkedNode<T> curr = temp; // Setting a double linked node curr to be the same as temp
		
		if (temp==null) { // If temp is null,
			live.setPrevious(null); // Set live's previous node to null
			return result2.getElement(); // Return result2's element
		}
		
		else { // Otherwise,
			
			result = temp.getNext(); // Set result to temp's next node (node to be removed)
			
			temp.setNext(temp.getNext().getNext()); // Set temp's next node to two nodes after it
			
			temp = temp.getNext(); // Set temp to the node after it
			
			temp.setPrevious(curr); // Set temp's previous node to curr (node to be removed has been removed)
			
			numItems = numItems - 1; // Decrement the total number of items
			
			return result.getElement(); // Return result's element
		}
		
		
		
	}
	
	public T peek() throws EmptyStackException { // Method for viewing the top of the stack without removing it
		if (isEmpty()) throw new EmptyStackException("Stack"); // If the stack is empty, throw an EmptyStackException
		
		return top.getElement(); // Return the element at the top of the stack
	}
	
	public boolean isEmpty() { // Method for checking if the stack is empty or not
		
		if (numItems == 0) { // If the number of items is 0,
			return true; // Return true (stack is empty)
		}
		else { // Otherwise,
			return false; // Return false (stack is not empty)
		}
	}
	
	public int size() { // Method for getting the size of the stack (number of items in the stack)
		return numItems; // Return the number of items in the stack
	}
	
	public DoubleLinkedNode<T> getTop() { // Method for returning the node at the top of the stack
		return top; // Return top (node at top)
	}
	
	public String toString() { // Overriding toString method
		
		DoubleLinkedNode<T> temp = top; // Setting double linked node temp to be equal to top
		
		String result = new String("[ "); // Creating the string to be returned
		
		for (int i = 0; i < numItems; ++i) { // For loop that iterates through the stack
			result = result + temp.getElement() + " "; // Setting result to be equal to itself + the current node's element with a space after it
			temp = temp.getPrevious(); // Setting temp to be its previous node
		}
		
		result = result + "]"; // Adding a square bracket to the end of result
		
		return result; // Returning result (string that is printed when someone prints a DLStack)
		
	}
	
}