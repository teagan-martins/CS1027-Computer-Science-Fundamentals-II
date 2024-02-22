// Class representing a game of Wordle

public class WordLL {
	
	private Word mysteryword; // Initializing instance variables
	private LinearNode<Word> history;
	
	public WordLL(Word mystery) { // Constructor
		
		history = null; // Sets history to null
		
		mysteryword = mystery; // Sets mysteryword to the Word mystery parameter
	}
	
	public boolean tryWord(Word guess) { // Method that represents a single guess of a word
		
		LinearNode<Word> recentWord = new LinearNode<Word>(guess); // Creating a linked list of Words
		
		if (guess.labelWord(mysteryword) == true) { // If loop that creates a history of past guesses and returns true if the words are the same
			recentWord.setNext(history);
			history = recentWord;
			return true;
		}
		else { // Otherwise returns false but still adds the word to history
			recentWord.setNext(history);
			history=recentWord;
			return false;
		}
			
		
	}
	
	public String toString() { // Overriding toString to display a history of word guesses when printed
		
		int count = 0; // Variable to keep count of guesses
		
		LinearNode<Word> recentWord; // Creating a new linked list of Words
		recentWord = history; // Setting recentWord to history
		
		while (true) { // While loop to iterate over recentWord
			recentWord = recentWord.getNext();
			count = count + 1; // Incrementing count
			if (recentWord==null) { // Breaking through the for loop once there are no more guesses to iterate over
				break;
			}
		}
		
		String out = new String(""); // Creating the string for output
		
		recentWord = history; // Setting recentWord back to history
		
		for (int i = 0; i < count; ++i) { // For loop to iterate over recentWord
			out = out + recentWord.getElement() + "\n"; // Adding each guess to the string for output
			recentWord = recentWord.getNext(); // Setting recentWord to the next node
		}
		
		
		
		return out; // Returning the string output
		
		
	}
	
	
}
