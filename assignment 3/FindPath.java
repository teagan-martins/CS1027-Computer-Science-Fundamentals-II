import java.io.FileNotFoundException; // Importing errors for exceptions
import java.io.IOException;

public class FindPath { // Class representing the path to take to get the treasure

	private Map pyramidMap; // Creating an instance variable representing the map
	
	public FindPath(String fileName) { // Constructor for giving the class a map file
		
		
	try { // Trying to give pyramidMap a file representing the map
		pyramidMap = new Map(fileName); // Giving pyramidMap a file representing the map
	} catch (InvalidMapCharacterException e) { // Catching an InvalidMapCharacterException
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) { // Catching a FileNotFoundException
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) { // Catching an IOException
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	public DLStack path() { // Method for finding the path to get all the treasures
		
		DLStack<Chamber> cstack = new DLStack<Chamber>(); // Creating an empty stack of Chambers
		
		Chamber start = pyramidMap.getEntrance(); // Getting the entrance chamber and putting it in a Chamber variable
		
		final int N = pyramidMap.getNumTreasures(); // Getting the number of of treasures and storing it in an int variable
		
		int found = 0; // Getting the number of treasures found
		
		cstack.push(start); // Putting the entrance chamber into the empty stack
		
		start.markPushed(); // Marking the start chamber as pushed
		
		while (cstack.isEmpty()==false) { // While cstack is not empty...
			Chamber curr = cstack.peek(); // Peek at the top of the stack
			if (curr.isTreasure()==true) { // If the top of the stack is a treasure...
				found = found + 1; // Increment found
				if (found==N) { // If found is equal to the total number of treasures...
					break; // Break out of loop
				}
			}
			
			Chamber c = this.bestChamber(curr); // Creating a chamber variable c that represents the best neighbour chamber to move to
			
			if (c!=null) { // If c is not null...
				cstack.push(c); // Push c into the stack
				c.markPushed(); // Mark c as pushed
			}
			else { // Otherwise...
				Chamber top = cstack.pop(); // Pop the top of the stack
				top.markPopped(); // Mark the top that was just popped as being popped
			}
			
		}
		
		return cstack; // Returning the stack
		
		
	}
	
	public Map getMap() { // Method that returns the map
		return pyramidMap; // Returns the map
	}
	
	public boolean isDim(Chamber currentChamber) { // Method that detects if a chamber is dim or not
		
		Chamber curr = currentChamber; // Creating a chamber that represents the inputed chamber parameter
		
		boolean dim = false; // Creating a boolean called dim and setting it to false
		
		
		if (curr.equals(null)==false) { // If the current chamber is not null,
			if (curr.isSealed()==false) { // If the current chamber is not sealed,
				if (curr.isLighted()==false) { // If the current chamber is not lighted,
					for (int i = 0; i < 6; ++i) { // For loop that iterates through the neighbouring chambers
						if (curr.getNeighbour(i)!=null) { // If the neighbour chamber is not null,
							if (curr.getNeighbour(i).isLighted()==true) { // If the neighbour chamber is lighted,
								dim = true; // Set dim to true
								break; // Break out of the loop
							}
						}

					}
				}
			}
		}
		
		return dim; // Return if the chamber is dim or not
	}
	
	public Chamber bestChamber(Chamber currentChamber) { // Method for finding the best chamber
		
		Chamber curr = currentChamber; // Creating a chamber that represents the inputed chamber parameter
		
		for (int i = 0; i < 6; ++i) { // For loop that iterates through neighbouring chambers
			Chamber neighbour = curr.getNeighbour(i); // Creating a Chamber variable that represents one of the neighbours
			if (neighbour!=null) { // If neighbour is not null,
				if (neighbour.isMarked()==true) { // If neighbour is marked,
					// Do nothing
				}
				
				else if (neighbour.isTreasure()==true) { // If neighbour is a treasure chamber,
					return neighbour; // Return the neighbour
				}
			}

		}
		
		
		for (int i = 0; i < 6; ++i) { // For loop that iterates through neighbouring chambers
			Chamber neighbour = curr.getNeighbour(i); // Creating a Chamber variable that represents one of the neighbours
			if (neighbour!=null) { // If neighbour is not null,
				if (neighbour.isMarked()==true) { // If neighbour is marked,
					// Do nothing
				}
				
				else if (neighbour.isLighted()==true) { // If neighbour is lighted,
					return neighbour; // Return the neighbour
				}
			}

		}
		
		for (int i = 0; i < 6; ++i) { // For loop that iterates through neighbouring chambers
			Chamber neighbour = curr.getNeighbour(i); // Creating a Chamber variable that represents one of the neighbours
			if (neighbour!=null) { // If neighbour is not null,
				if (neighbour.isMarked()==true) { // If neighbour is marked,
					// Do nothing
				}
				
				else if (this.isDim(neighbour)==true) { // If neighbour is dim,
					return neighbour; // Return the neighbour
				}
			}

		}
		
		return null; // Return null otherwise (if there is no valid neighbouring chamber)
	
	
	
	}
}