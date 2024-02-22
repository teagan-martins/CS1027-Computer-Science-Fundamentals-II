
public class Ski { // Class representing a skill hill
	
	private BinaryTreeNode<SkiSegment> root; // Initializing instance variables
	
	public Ski(String[] data) { // Constructor
		
		SkiSegment[] segments = new SkiSegment[data.length]; // Creating a new ski segment with the length of the inputed parameter
		
		for (int i = 0; i<data.length;++i) { // For loop to iterate through the segments variable
			if (data[i]==null) { // If the node is null...
				segments[i]=null; // The corresponding segments node will be null
			}
			else if (data[i].contains("jump")) { // If the node contains the substring jump...
				segments[i] = new JumpSegment(String.valueOf(i),data[i]); // The corresponding segments node will be a JumpSegment
			}
			else if (data[i].contains("slalom")) { // If the node contains the substring slalom...
				segments[i] = new SlalomSegment(String.valueOf(i),data[i]); // The corresponding segments node will be a SlalomSegment
			}
			else { // Otherwise...
				segments[i] = new SkiSegment(String.valueOf(i),data[i]); // The corresponding segments node will just be a SkiSegment
			}
		}
		
		TreeBuilder<SkiSegment> slope = new TreeBuilder<SkiSegment>(); // Creating a new TreeBuilder containing SkiSegments
		
		LinkedBinaryTree<SkiSegment> skitree = slope.buildTree(segments); // Creating a LinkedBinaryTree through the TreeBuilder
		
		this.root=skitree.getRoot(); // Setting the instance variable root equal to the root of skitree
		
	}
	
	public BinaryTreeNode<SkiSegment> getRoot() { // Method for returning the root
		return root; // Return the instance variable root
	}
	
	public void skiNextSegment (BinaryTreeNode<SkiSegment> node, ArrayUnorderedList<SkiSegment> sequence) { // Method for choosing the next SkiSegment to take
		ArrayUnorderedList<SkiSegment> s = new ArrayUnorderedList<SkiSegment>(); // Creating an ArrayUnorderedList containing SkiSegments
		s=sequence; // Setting s equal to the sequence parameter
		
		BinaryTreeNode<SkiSegment> n = new BinaryTreeNode<SkiSegment>(null); // Creating a BinaryTreeNode of SkiSegments
		n = node; // Setting n to node
		s.addToRear(n.getData()); // Adding n's data to the rear of s
		
		BinaryTreeNode<SkiSegment> l = n.getLeft(); // Creating a variable storing the skisegment to the left
		BinaryTreeNode<SkiSegment> r = n.getRight(); // Creating a variable storing the skisegment to the right
		
		if ((l==null)&&(r==null)) { // If both l and r are null...
			return; // Do nothing
		}
		
		else if (l==null) { // If only l is null...
			skiNextSegment(r,s); // Repeat skiNextSegment with r
		}
		
		else if (r==null) { // If only r is null...
			skiNextSegment(l,s); // Repeat skiNextSegment with l
		}
		
			
			
		else if ((l.getData() instanceof JumpSegment) && (r.getData() instanceof JumpSegment)) { // If both l's data and r's data are JumpSegments...
			JumpSegment ljump = (JumpSegment) l.getData(); // Get l's data...
			JumpSegment rjump = (JumpSegment) r.getData(); // Get r's data...
				
			if (ljump.getHeight()>rjump.getHeight()) { // If the left jump is greater height...
				skiNextSegment(l,s); // Repeat skiNextSegment with l
			}
			else { // Otherwise...
				skiNextSegment(r,s); // Repeat skiNextSegment with r
			}
				
		}
			
		else if (l.getData() instanceof JumpSegment) { // If only l's data is a JumpSegment...
			skiNextSegment(l,s); // Repeat skiNextSegment with l
		}
		else if (r.getData() instanceof JumpSegment) { // If only r's data is a JumpSegment...
			skiNextSegment(r,s); // Repeat skiNextSegment with r
		}
		else if ((l.getData() instanceof SlalomSegment) && (r.getData() instanceof SlalomSegment)) { // If both l's data and r's data are SlalomSegments...
			SlalomSegment lslalom = (SlalomSegment) l.getData(); // Creating a SlalomSegment with l's data
				
			if (lslalom.getDirection().equals("L")) { // If the direction of lslalom is leeward...
				skiNextSegment(l,s); // Repeat skiNextSegment with l
			}
			else { // Otherwise...
				skiNextSegment(r,s); // Repeat skiNextSegment with r
			}
		}
			
		else if ((l.getData() instanceof SlalomSegment) && (r.getData() instanceof SkiSegment)) { // If l's data is a SlalomSegments and r's data is a SkiSegment...
			SlalomSegment lslalom = (SlalomSegment) l.getData(); // Creating a SlalomSegment with l's data
				
			if (lslalom.getDirection().equals("L")) { // If lslalom's direction is leeward...
				skiNextSegment(l,s); // Repeat skiNextSegment with l
			}
			else { // Otherwise...
				skiNextSegment(r,s); // Repeat skiNextSegment with r
			}
				
		}
			
		else if ((l.getData() instanceof SkiSegment) && (r.getData() instanceof SlalomSegment)) { // If l's data is a SkiSegment and r's data is a SlalomSegment...
			SlalomSegment rslalom = (SlalomSegment) r.getData(); // Creating a SlalomSegment with r's data
				
			if (rslalom.getDirection().equals("L")) { // If rslalom's direction is leeward...
				skiNextSegment(r,s); // Repeat skiNextSegment with r
			}
			else { // Otherwise...
				skiNextSegment(l,s); // Repeat skiNextSegment with l
			}
		}
			
		else { // Otherwise...
			skiNextSegment(r,s); // Repeat skiNextSegment with r
		}
			
			
		
		
	}
	
}
