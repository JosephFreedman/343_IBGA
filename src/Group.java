import java.util.ArrayList;

//Subclass of card, models groups without abilities
public class Group extends Card {
	
	//group attributes
	int power, tPower, resistance, income;
	ArrayList<String> alignments;
	
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
	
	//sets all variables for the group
	public void setAll(int p, int t, int r, int i, String[] a) {
		power = p;
		tPower = t;
		resistance = r;
		income = i;
		for(int j=0;j<a.length;j++) { alignments.add(a[j]); }
	}
}
