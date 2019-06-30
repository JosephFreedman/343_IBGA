import java.util.ArrayList;

//Models the power structure of a player
public class PowerStructure {
	
	//holds the illuminati card for the structure
	PowerNode source;
	
	public PowerStructure(IlluminatiCard iCard) {
		PowerNode nNode = new PowerNode((Card)iCard, ' ', null);
		source = nNode;
	}
	
	//adds pCard to this structure as an extension of pNode in direction pAttach
	public void addCard(Group pCard, PowerNode pNode, char pAttach) {
		PowerNode nNode = new PowerNode ((Card)pCard, pAttach, pNode);
		pNode.addNext(nNode);
	}
	
	//removes a given Node
	public void removeNode(PowerNode pNode) {
		pNode.getPrevious().removeNext(pNode);
	}
	
	//transfers a node "pTrans" (and its extensions) out of this power structure and into another
	//structure under a selected node "pDest"
	public void transferGroup(PowerNode pTrans, PowerNode pDest) {
		pTrans.getPrevious().removeNext(pTrans);
		pTrans.setPrevious(pDest);
		pDest.addNext(pTrans);
		pDest.updateOrder();
	}
	
//	//returns array list of all nodes in structure
//	public ArrayList<PowerNode> totalNodes() {
//		ArrayList<PowerNode> allNodes = new ArrayList<PowerNode>();
//		PowerNode current = source;
//		PowerNode cPrevious = source;
//		boolean finished = false;
//		allNodes.add(current);
//		while(!finished) {
//			if(!current.getNext().isEmpty()) { current = cPrevious; }
//			else {
//				ArrayList<PowerNode> nList = current.getNext();
//				int child = 1;
//				int totalChildren = nList.size();
//				
//				
//			}
//			
//		}
//		
//		return allNodes;
//	}
//	
//	
// 
//	
//	
//	//lists all valid positions in a power structure
//	public char[][] validAdditions() {
//		char[][] positions;
//		for(int i=0;i<) {
//			
//		}
//		
//		return positions;
//	}
	
	//overloads method to list valid positions a node and its subsidiaries can be placed
	public char[] validAdditions(PowerNode pNode) {
		char[] positions = pNode.getGroup().getExits();
		if(!positions.equals(null)) {
			for(int i=0;i<positions.length;i++) {
				if(positions[i]) { ; }
			}
		}
		
		return positions;
	}
	
}
