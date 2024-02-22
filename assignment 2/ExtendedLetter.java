// Class representing a non-letter character

public class ExtendedLetter extends Letter { // Subclass of Letter
	
	private String content; // Initializing instance variables
	private int family;
	private boolean related;
	private final int SINGLETON = -1;

	public ExtendedLetter(String s) { // Constructor which sets values for the instance variables
		super('m');
		content = s;
		related = false;
		family = SINGLETON;
		
	}
	
	public ExtendedLetter(String s, int fam) { // Overloaded constructor which sets values for the instance variables
		super('m');
		
		content = s;
		related = false;
		family = fam;
	}
	
	public boolean equals(Object other) { // Overriding equals method
		if (!(other instanceof ExtendedLetter)) { // Checking if other is not of type ExtendedLetter and returning false
			return false;
		}
		else if (other instanceof ExtendedLetter){ // Checking if other is of type ExtendedLetter
			if ((this.family == ((ExtendedLetter) other).family)) { // Checking if family is equal to other family
				this.related = true; // Setting related to true
			}
			if ((this.content.equals(((ExtendedLetter) other).content))) { // Checking if content equals other content
				return true; // Returning true
			}
			else { // Otherwise...
				return false; // Returning false
			}
		}
		
		return false; // Returning false
	}
	
	public String toString() { // Overriding toString method
		if ((this.isUnused()==true) && (this.related==true)) { // Checking if both isUnused and related are equal to true
			return "." + this.content + "."; // Returning . + content + .
		}
		else { // Otherwise...
			return (super.decorator() + this.content + super.decorator()); // Returning the status + content + status
		}
	}
	
	
	public static Letter[] fromStrings(String[] content, int[] codes) { // Method for returning an array of letters
		
		int len = content.length; // Getting the length of content
		
		Letter[] letterArray = new Letter[len]; // Setting letterArray with the length of len
		
		if (codes.equals(null)) { // Checking if code is a null list
			for (int i = 0; i < len; ++i) { // Iterating over letterArray
				ExtendedLetter specialLetter1 = new ExtendedLetter(content[i]);
				letterArray[i] = specialLetter1; // Assigning each spot in letterArray to be a letter from content
			}
		}
		else { // Otherwise...
			for (int j = 0; j < len; ++j) { // Iterating over letterArray
				ExtendedLetter specialLetter2 = new ExtendedLetter(content[j],codes[j]);
				letterArray[j] = specialLetter2;
			}
		}
		
		return letterArray; // Returning letterArray
		
	}
	
	

}
