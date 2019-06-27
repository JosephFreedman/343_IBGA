//Emulates a card in the power structure
public class PowerNode {

	int order;
	Card nCard;
	PowerNode previous, next;
	
	public PowerNode(Card pCard, PowerNode pPrev, PowerNode pNext) {
		nCard = pCard;
		previous = pPrev;
		next = pNext;
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
	
	
	
}
