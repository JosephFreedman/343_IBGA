import java.util.ArrayList;

//Runs the game
public class RunGame {
	
	public RunGame(int players, String[] names) {
		
		//builds card decks
		ArrayList<Card> mDeck = Deck.genMainDeck();
		ArrayList<Card> iDeck = Deck.genIllDeck(players);
		
		//generates a node loop of players
		PlayerNode first = null, currentPlayer = null;
		for(int i=0;i<players;i++) {
			PlayerNode previousPlayer = currentPlayer;
			currentPlayer = new PlayerNode((IlluminatiCard)iDeck.remove(0), names[i]);
			currentPlayer.setPrevious(previousPlayer);
			previousPlayer.setNext(currentPlayer);
			if(i==0) { first = currentPlayer; }
			if(i==players-1) {
				currentPlayer.setNext(first);
				first.setPrevious(currentPlayer);
			}
		}
		currentPlayer = first;
		
		boolean quit; //makes this elsewhere
		
		//runs player turns until the game is won or quit is selected
		while(!checkVictory() && !quit) {
			
			
			
			
			
		}
		
	}
	
	
}