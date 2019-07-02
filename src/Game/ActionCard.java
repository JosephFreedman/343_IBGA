package Game;

//Serves as both a model of an action card and a library of their abilities
public class ActionCard extends Card {
	
	//holds a pseudo-library of functions that are used based on effectNum
	public void ability() {
		
		//this holds the first card effect
		if(this.getEffectNum()==1) {
			//implementation of the 'Assassination' ability (sets a players roll to 2)
			//Example code: Combat.setRoll(2);
		}
		
		//this holds the second card effect
		if(this.getEffectNum()==2) {
			//implementation of the 'Bribery' ability (automatically control an uncontrolled group, costs an action)
			//Example code: SeqOfPlay.getCurrentPlayer().addUncontrolled();
			//				SeqOfPlay.getCurrentPlayer().IncAction();
		}
		
	}
	
}
