// A class representing a single letter

public class Letter {
	
	private char letter; // Initializing the instance variables
	private int label;
	private final int UNSET = 4;
	private final int UNUSED = 3;
	private final int USED = 2;
	private final int CORRECT = 1;
	
	public Letter(char c) { // Constructor to set the label (status) to UNSET and the letter to the input character
		label = UNSET;
		letter = c;
	}
	
	public boolean equals(Object otherObject) { // Overriding equals method
		
		if (otherObject instanceof Letter) { // Detects if the parameter input Object is of type Letter
			if (this.letter ==((Letter) otherObject).letter) {
				return true; // Returns true if otherObject is of type letter
			}
			else { // Returns false otherwise
				return false;
			}
		}
		else {
			return false; // Returns false otherwise
		}
	}
	
	public String decorator() { // Method to set the status of a letter in a word
		if (this.label == USED) {
			return "+";
		}
		else if (this.label==UNUSED) {
			return "-";
		}
		else if (this.label==CORRECT) {
			return "!";
		}
		else if (this.label==UNSET) {
			return " ";
		}
		return " ";
	}
	
	public String toString() { // Overriding toString to output the status + letter + status
		return (this.decorator() + letter + this.decorator());
	}
	
	public void setUnused() { // Method to set the status of the character to unused
		this.label = UNUSED;
	}
	
	public void setUsed() { // Method to set the status of the character to used but wrong spot
		this.label = USED;
	}
	
	public void setCorrect() { // Method to set the status of the character to correct
		this.label = CORRECT;
	}
	
	public boolean isUnused() { // Method to check if the character is unused
		if (this.label==UNUSED) { // If the character is unused, return true
			return true;
		}
		else { // Otherwise, return false
			return false;
		}
	}
	
	public static Letter[] fromString(String s) { // Method to create an array of letters from a word input as a string
		
		Letter[] letterArray = new Letter[s.length()]; // Creating an array of letter objects with the length of the input string
		
		for (int i = 0; i < s.length();++i) { // Setting each element in the array equal to the corresponding letter in the input word
			letterArray[i] = new Letter(s.charAt(i));
		}
		return letterArray; // Returning the letter array
	}
	
}
