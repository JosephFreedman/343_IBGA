package Game;

import java.util.ArrayList;

//Subclass of card, models groups without abilities
public class Group extends Card {
	
	//group attributes
	int power, tPower, resistance, income, currency = 0;
	ArrayList<String> alignments;
	//data holding the entrance and exits for card expansions
	String entrance;
	String[] exits;
	
	//holds a pseudo-library of functions that are used based on effectNum
	public void ability() {
		
		//this holds the first card effect
		if(this.getEffectNum()==1) {
			//implementation of the ability
		}
	
	}
	
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int pPower) {
		power = pPower;
	}
	
	public int getTPower() {
		return tPower;
	}
	
	public void setTPower(int pTPower) {
		tPower = pTPower;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public void setResistance(int pResistance) {
		resistance = pResistance;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int pIncome) {
		income = pIncome;
	}
	
	public ArrayList<String> getAlignments() {
		return alignments;
	}
	
	public void addAlignment(String pAlignment) {
		alignments.add(pAlignment);
	}
	
	public String getEntrance() {
		return entrance;
	}
	
	public String[] getExits() {
		return exits;
	}
	
	public void setExits(String[] pExits) {
		exits = pExits;
	}
	
	//sets all variables for the group
	public void setAll(int p, int t, int r, int i, String[] a, String ent, String[] ex) {
		power = p;
		tPower = t;
		resistance = r;
		income = i;
		entrance = ent;
		exits = ex;
		for(int j=0;j<a.length;j++) { alignments.add(a[j]); }
	}
	
	public void addCurrency(int amt) {
		currency += amt;
	}
	
	public void subCurrency(int amt) {
		currency -= amt;
	}
	
	public int getCurrency() {
		return currency;
	}
	
}
