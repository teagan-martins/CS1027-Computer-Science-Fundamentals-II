public class Yahtzee { // A class representing a game of Yahtzee
	
	private Dice[] dice; // Variable representing an array of dice
	
	public Yahtzee() { // Constructor for setting up the dice rolls
		
		Dice die1 = new Dice(); // Rolling 5 dice
		die1.roll();
		Dice die2 = new Dice();
		die2.roll();
		Dice die3 = new Dice();
		die3.roll();
		Dice die4 = new Dice();
		die4.roll();
		Dice die5 = new Dice();
		die5.roll();
		
		this.dice = new Dice[] {die1, die2, die3, die4, die5}; // Adding the rolled dice to the array of dice

		}
	
	
	public Yahtzee(Dice[] dArray) { // Constructor that sets the dice array as the inputted parameter
		this.dice = dArray; // dArray = dice Array
	}
	
	
	public int[] getValueCount() { // Method for returning the amount of each number that was rolled (returned in an integer array)
		
		int[] numberCount = {0, 0, 0, 0, 0, 0}; // Initializing the array which will count the dice
		
		int i = 0;
		
		for (i = 0; i < 5; i++) { // Counting the values of the dice through a for loop
			if (dice[i].getValue()==1) {
				numberCount[0] += 1;
			}
			else if (dice[i].getValue()==2) {
				numberCount[1] += 1;
			}
			else if (dice[i].getValue()==3) {
				numberCount[2] += 1;
			}
			else if (dice[i].getValue()==4) {
				numberCount[3] += 1;
			}
			else if (dice[i].getValue()==5) {
				numberCount[4] += 1;
			}
			else {
				numberCount[5] += 1;
			}
			
		}
		
		return numberCount; // Returning the integer array containing the count of the rolls
	}
	
	public int[] getScoreOptions() { // Method for getting all of the scoring options
		
		int[] scores = new int[13]; // Integer array that will contain all of the possible scores
		
		scores[0] = this.getValueCount()[0]*1; // Sum of 1s
		scores[1] = this.getValueCount()[1]*2; // Sum of 2s
		scores[2] = this.getValueCount()[2]*3; // Sum of 3s
		scores[3] = this.getValueCount()[3]*4; // Sum of 4s
		scores[4] = this.getValueCount()[4]*5; // Sum of 5s
		scores[5] = this.getValueCount()[5]*6; //Sum of 6s
		
		
		if (this.getValueCount()[0]>=3 || this.getValueCount()[1]>=3 || this.getValueCount()[2]>=3 || this.getValueCount()[3] >= 3 || this.getValueCount()[4]>=3 || this.getValueCount()[5] >=3) { // Checking to see if there are 3 or more of one number
			scores[6] = this.getValueCount()[0]*1+this.getValueCount()[1]*2+this.getValueCount()[2]*3+this.getValueCount()[3]*4+this.getValueCount()[4]*5+this.getValueCount()[5]*6; // Sum of all dice
		}
		else {
			scores[6] = 0;
		}
		
		if (this.getValueCount()[0]>=4 || this.getValueCount()[1]>=4 || this.getValueCount()[2]>=4 || this.getValueCount()[3] >= 4 || this.getValueCount()[4]>=4 || this.getValueCount()[5] >=4) { // Checking to see if there are 4 or more of one number
			scores[7] = this.getValueCount()[0]*1+this.getValueCount()[1]*2+this.getValueCount()[2]*3+this.getValueCount()[3]*4+this.getValueCount()[4]*5+this.getValueCount()[5]*6; // Sum of all dice
		}
		else {
			scores[7] = 0;
		}
			
		
		if ((this.getValueCount()[0]==2 || this.getValueCount()[1]==2 || this.getValueCount()[2]==2 || this.getValueCount()[3]==2 || this.getValueCount()[4]==2 || this.getValueCount()[5]==2) && (this.getValueCount()[0]==3 || this.getValueCount()[1]==3 || this.getValueCount()[2]==3 || this.getValueCount()[3]==3 || this.getValueCount()[4]==3 || this.getValueCount()[5]==3)) { // Checking to see if there are 2 of one number as well as 3 of one number
			scores[8] = 25; // Full house = 25
		}
		
		
		if (this.getValueCount()[0]>=1 && this.getValueCount()[1]>=1 && this.getValueCount()[2]>=1 && this.getValueCount()[3]>=1) { // Checking to see if there a 4 numbers in a row
			scores[9] = 30; // Small straight = 30
		}
		else if (this.getValueCount()[1]>=1 && this.getValueCount()[2]>=1 && this.getValueCount()[3]>=1 && this.getValueCount()[4]>=1) { // Checking to see if there a 4 numbers in a row
			scores[9] = 30; // Small straight = 30
		}
		else if (this.getValueCount()[2]>=1 && this.getValueCount()[3]>=1 && this.getValueCount()[4]>=1 && this.getValueCount()[5]>=1) { // Checking to see if there a 4 numbers in a row
			scores[9] = 30; // Small straight = 30
		}
		else {
			scores[9] = 0;
		}
		
		if ((this.getValueCount()[0]==1 && this.getValueCount()[1]==1 && this.getValueCount()[2]==1 && this.getValueCount()[3]==1 && this.getValueCount()[4]==1) || (this.getValueCount()[1]==1 && this.getValueCount()[2]==1 && this.getValueCount()[3]==1 && this.getValueCount()[4]==1 && this.getValueCount()[5]==1)) { // Checking to see if there are 5 numbers in a row
			scores[10] = 40; // Large straight = 40
		}
		
		for (int num : this.getValueCount()) { // Checking to see if there are 5 of one single number
			if (num==5) {
				scores[11] = 50; // YAHTZEE! (50 points)
			}
		}
		
		
		scores[12] = this.getValueCount()[0]*1+this.getValueCount()[1]*2+this.getValueCount()[2]*3+this.getValueCount()[3]*4+this.getValueCount()[4]*5+this.getValueCount()[5]*6; // Sum of all numbers (chance)
		
		
	return scores; // Returning an integer array of all possible scoring options
	}
	
	public int[] score() { // Method for returning the highest possible scoring option and its index #
		
		int max = this.getScoreOptions()[0]; // Assigning the highest possible score to the ones
		int maxIndex = 0; // Assigning the highest possible score's index to the ones
		
		int[] maximize = new int[2]; // Creating an integer array that will contain the max score and its index
		
		int i = 0;
		
        for (i = 1; i < this.getScoreOptions().length; i++) { // Using a for loop to find the max score and the index with it
            if (this.getScoreOptions()[i] > max) {
                max = this.getScoreOptions()[i];
                maxIndex = i;
            }
        }
        
        maximize[0] = max;
        maximize[1] = maxIndex;
        
        return maximize; // Returning the integer array that contains the max score and its associated index
	}
	
	public boolean equals(Yahtzee game) { // Method for determining if one Yahtzee game's rolls of dice are equivalent to another's
		if (this.getValueCount()[0]==(game.getValueCount()[0]) && (this.getValueCount()[1])==(game.getValueCount()[1]) && (this.getValueCount()[2])==(game.getValueCount()[2]) && (this.getValueCount()[3])==(game.getValueCount()[3]) && (this.getValueCount()[4])==(game.getValueCount()[4]) && (this.getValueCount()[5])==(game.getValueCount()[5])) {
			return true; // Returning true if equivalent
		}
		else {
			return false; // Returning false if not equivalent
		}
	}
	
	public String toString() { // Method for returning a formatted string of dice rolls
		return ("Dice: {" + this.dice[0].getValue() + ", " + this.dice[1].getValue()) + ", " + this.dice[2].getValue() + ", " + this.dice[3].getValue() + ", " + this.dice[4].getValue() + "}";
	}
	
			
}
