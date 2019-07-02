package Game;

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
	
	
//	----------------------------------------------------------
//	I may use this code in the future but currently its a WIP
//	----------------------------------------------------------
//	
//	
//	//returns array list of all nodes in structure
//	public ArrayList<Game.PowerNode> totalNodes() {
//		ArrayList<Game.PowerNode> allNodes = new ArrayList<Game.PowerNode>();
//		Game.PowerNode current = source;
//		Game.PowerNode cPrevious = source;
//		boolean finished = false;
//		allNodes.add(current);
//		while(!finished) {
//			if(!current.getNext().isEmpty()) { current = cPrevious; }
//			else {
//				ArrayList<Game.PowerNode> nList = current.getNext();
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
//	//lists all valid positions in a power structure
//	public char[][] validAdditions() {
//		char[][] positions;
//		for(int i=0;i<) {
//			
//		}
//		
//		return positions;
//	}
	
	
	//method to list valid positions a node and its subsidiaries can be placed
	public String[] validAdditions(PowerNode pNode) {
		String[] originalPos = pNode.getGroup().getExits();
		if(!originalPos.equals(null) && pNode.getNext().size()>0) {
			ArrayList<String> valPos = new ArrayList<String>();
			for(int i=0;i<originalPos.length;i++) { valPos.add(originalPos[i]); }
			ArrayList<PowerNode> children = pNode.getNext();
			for(int i=0;i<children.size();i++) {
				valPos.remove(children.get(i).getGroup().getEntrance());
				//removal of subsidiaries not yet finished
			}
			originalPos = (String[]) valPos.toArray();
		}
		
		return originalPos;
	}
	
}
