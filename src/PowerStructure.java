import java.util.ArrayList;
import java.util.List;

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
	
	//method to list valid positions a node can be placed
	public String[] validAdditions(PowerNode pNode) {
		String[] originalPos = pNode.getGroup().getExits();
		if(!originalPos.equals(null) && pNode.getNext().size()>0) {
			ArrayList<String> valPos = new ArrayList<String>();
			for(int i=0;i<originalPos.length;i++) { valPos.add(originalPos[i]); }
			ArrayList<PowerNode> children = pNode.getNext();
			for(int i=0;i<children.size();i++) {
				valPos.remove(children.get(i).getGroup().getEntrance());
			}
			originalPos = (String[]) valPos.toArray();
		}
		return originalPos;
	}
	
	public PowerNode getSource() {
		return source;
	}
	
}
