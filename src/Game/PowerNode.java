package Game;

import java.util.ArrayList;

//Emulates a card in the power structure
public class PowerNode {

	int order;
	Card nCard;
	char attachment;
	PowerNode previous;
	ArrayList<PowerNode> next;
	
	public PowerNode(Card pCard, char pAttach, PowerNode pPrev) {
		nCard = pCard;
		attachment = pAttach;
		previous = pPrev;
		next = null;
		updateOrder();
	}
	
	public int updateOrder() {
		int count = 0;
		PowerNode current = this;
		while(current.getPrevious()!=null) {
			current = current.previous;
			count++;
		}
		order = count;
		return count;
	}
	
	public int getOrder() {
		return order;
	}
	
	public Card getCard() {
		return nCard;
	}
	
	public Group getGroup() {
		return (Group) nCard;
	}
	
	public char getAttachment() {
		return attachment;
	}
	
	public void setAttachment(char pAttach) {
		attachment = pAttach;
	}
	
	public PowerNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(PowerNode pNode) {
		previous = pNode;
	}
	
	public ArrayList<PowerNode> getNext() {
		return next;
	}
	
	public void addNext(PowerNode pNode) {
		next.add(pNode);
	}
	
	public void removeNext(PowerNode pNode) {
		next.remove(pNode);
	}
	
	//returns an array list of all child nodes
	public ArrayList<PowerNode> getAllNodes() {
		ArrayList<PowerNode> allNodes = new ArrayList<PowerNode>();
		if(this.getNext().isEmpty()) {
			allNodes.add(this);
		}
		else {
			for(PowerNode child : this.getNext()) {
				allNodes.addAll(child.getAllNodes());
			}
		}
		return allNodes;
	}
	
}
