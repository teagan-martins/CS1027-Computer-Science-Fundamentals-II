// A class representing a single Word comprised of letter classes

public class Word {
	
	private LinearNode<Letter> firstLetter = null; // Initializing the linked list of letters
	
	public Word(Letter[] letters) { // Constructor which takes in an array of letters

		LinearNode<Letter> current; // Creating another array of letters
		
		for (int i = letters.length-1; i >= 0; --i) { // Iterating over the letter array
			current = new LinearNode<Letter>(letters[i]); // Setting current to point to the current letter
			current.setNext(firstLetter); // Setting current's next element to be firstLetter
			firstLetter = current; // Setting firstLetter to be equal to current
		}
	}
	
	
	
	public String toString() { // Overriding toString
		
		String fullWord = new String(); // Creating the string that will be output
		fullWord = "Word: " + firstLetter.getElement();
		
		LinearNode<Letter> current; // Creating a new linked list called current
		current = firstLetter; // Setting current to be firstLetter
		int count = 0; // Creating a count variable to increment over a while loop
		
		while (true) { // while loop to get the length of firstLetter (which current is also equal to)
			current = current.getNext(); // Setting current to point to the next node
			count = count + 1; // Incrementing count by 1
			if (current==null) { // If the current node is null, break
				break;
			}
		}
		
		current = this.firstLetter; // Setting current back to firstLetter
		
		for (int i = 0; i < count - 1; ++i) { // Iterating over a for loop to generate each letter and its status
			current = current.getNext(); // Setting current to point to the next node
			fullWord = fullWord + " " + current.getElement(); // Adding the current letter to fullWord (surrounded by its status/label)
		}
		
		fullWord = fullWord + " "; // Adding a space at the end
		
		return fullWord; // Returning the new string for output
		
		
	}
	
	
	public boolean labelWord(Word mystery) { // A method for inputting a mystery word for comparison
		
		LinearNode<Letter> current; // Creating a new linked list of letters called current
		current = firstLetter; // Setting current to firstLetter
		
		int count = 0; // Creating a variable called count to keep count of the length of the array
		
		while (true) { // While loop to count the length of the array
			current = current.getNext(); // Setting current to point to the next node
			count = count + 1; // Incrementing count
			if (current==null) {
				break;
			}
		}
		
		int tracker = 0; // Creating a variable called tracker to keep track of the length of the input array
		
		current = mystery.firstLetter; // Setting current to point to the first node in mystery
		
		while (true) { // Using a while loop to get the length of mystery
			current=current.getNext(); // Setting current to the next node in mystery
			tracker = tracker + 1; // Incrementing count
			if (current == null) { // If the current node is null, break
				break;
			}
		}
			
		LinearNode<Letter> latest; // Creating a new linked list called latest which will be used to point to the current node
		latest = firstLetter; // Setting latest to the first node
		
		LinearNode<Letter> ongoing; // Creating a new linked list called ongoing which will be used to point to the current node
		ongoing = firstLetter; // Setting ongoing to the first node
		
		LinearNode<Letter> recent; // Creating a new linked list called recent which will be used to point to the current node
		recent = mystery.firstLetter; // Setting recent to the first node in mystery
		
		current = firstLetter; // Setting current back to the first node
		
		if (count >= tracker) { // If statement that checks which word is longer
			for (int t = 0; t<count; ++t) {
				current.getElement().setUnused(); // Setting each of current's values to unused
				current = current.getNext(); // Setting current to the next node
				
			}
		}
				
		
		current = mystery.firstLetter; // Setting current to mystery's firstLetter
		
		if (count>=tracker) { // If statement that checks which word is longer
			for (int j = 0; j<tracker; ++j) { // For loop to iterate through the mystery linked list
				for (int k = 0; k < count; ++k) { // For loop to iterate through the guess linked list
					if (ongoing.getElement().equals(current.getElement())) { // Checking if the element in one list is equal to an element in the other
						ongoing.getElement().setUsed(); // Setting the element to used if equal
					}
				ongoing = ongoing.getNext(); // Setting ongoing to the next node
				
				
				}
			current=current.getNext(); // Setting current to the next node
			ongoing = this.firstLetter; // Setting ongoing to firstLetter
			}
		}
		
		int tally = 0; // Creating a variable called tally which will keep count of the amount of correct letters
		
		if (count>=tracker) { // If the guess word length is longer than the mystery word's length, enter this block of code
			for (int i = 0; i < tracker; ++i) { // For loop to iterate through mystery linked list
					if (latest.getElement().equals(recent.getElement())) { // Checking if the element of one list is the same as the other and in the same position
						latest.getElement().setCorrect(); // Setting the element to correct
						tally = tally + 1; // Incrementing tally
						latest = latest.getNext(); // Setting latest to point to the next node
						recent = recent.getNext(); // Setting recent to point to the next node
					}
					else { // If not correct element, enter this block of code below
						latest=latest.getNext(); // Setting latest to point to the next node
						recent=recent.getNext(); // Setting recent to point to the next node
					}
			}
		}
		
		
		
		LinearNode<Letter> here; // Creating a new linked list called here
		here = firstLetter; // Setting here to firstLetter
		
		if (tracker>count) { // Checking the length of each word
			for (int z = 0; z < count; ++z) { // Iterating through the guess word
				here.getElement().setUnused(); // Setting each letter in here to unused
				here = here.getNext(); // Setting here to point to the next node
			}
		}
		
		
		if (tracker>count) { // Checking the length of each word
			for (int j = 0; j<tracker; ++j) { // Iterating over the mystery word
				for (int k = 0; k < count; ++k) { // Iterating over the guess word
					if (ongoing.getElement().equals(current.getElement())) { // Checking if the letter is present in both words
						ongoing.getElement().setUsed(); // Setting the letter to used
					}
					ongoing = ongoing.getNext(); // Setting ongoing to point to the next node
			
			
				}
				current=current.getNext(); // Setting current to point to the next node
				ongoing = this.firstLetter; // Setting ongoing to point to the next node
			}
		}
	
	
	
		if (tracker>count) { // Checking the length of each word
			for (int i = 0; i < count; ++i) { // Iterating over the guess word
					if (latest.getElement().equals(recent.getElement())) { // Checking if the guess word letter is correct
						latest.getElement().setCorrect(); // Setting the letter to correct
						latest = latest.getNext(); // Setting latest to point to the next node
						recent = recent.getNext(); // Setting recent to point to the next node
					}
					else { // If not correct...
						latest=latest.getNext(); // Setting latest to point to the next node
						recent=recent.getNext(); // Setting recent to point to the next node
					}
			}
		}
	
	
		if (tracker==count) { // If both the word lengths are equal
			if (tally==count) { // If the count of correct letters is equal to the count of total letters
				return true;
			}
		
		}
		return false;
	
	}
		
}
