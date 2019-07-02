package Game;

import java.util.ArrayList;

//Holds player information
public class PlayerNode {
	
	String name;
	PowerStructure struct;
	ArrayList<Card> hand;
	int actions;
	PlayerNode next, previous;
	
	public PlayerNode(IlluminatiCard iCard, String pName) {
		name = pName;
		struct = new PowerStructure(iCard);
		hand = new ArrayList<Card>();
		actions = 2;
		next = null;
		previous = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String pName) {
		name = pName;
	}
	
	public PlayerNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(PlayerNode pNode) {
		previous = pNode;
	}
	
	public PlayerNode getNext() {
		return next;
	}
	
	public void setNext(PlayerNode pNode) {
		next= pNode;
	}
	
}
