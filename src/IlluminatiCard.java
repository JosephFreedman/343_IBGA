//models an Illuminati card
public class IlluminatiCard extends Card {
	
	int power, tPower, income, currency = 0;
	char[] exits;
	
	//holds a pseudo-library of functions that are used based on effectNum
	public void ability() {
		
		//this holds the first card effect
		if(this.getEffectNum()==1) {
			//implementation of the Illuminati's power
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
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int pIncome) {
		income = pIncome;
	}
	
	public char[] getExits() {
		return exits;
	}
	
	public void setExits(char[] pExits) {
		exits = pExits;
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
