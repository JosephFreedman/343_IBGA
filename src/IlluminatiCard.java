//models an Illuminati card
public class IlluminatiCard extends Card {
	
	int power, tPower, income;
	
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
	
}
