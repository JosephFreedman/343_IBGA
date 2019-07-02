package Game;

//Models a card object
public abstract class Card {
	
	//holds the card type i.g. illuminati, action, group, sp.group
	String type, name;
	int effectNum;
	
	public String getType() {
		return type;
	}
	
	public void setType(String pType) {
		type = pType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String pName) {
		name = pName;
	}
	
	public int getEffectNum() {
		return effectNum;
	}
	
	public void setEffectNum(int pENum) {
		effectNum = pENum;
	}
	
	//override-able function for special abilities
	public abstract void ability();
	
}
