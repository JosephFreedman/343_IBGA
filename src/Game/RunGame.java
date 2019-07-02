package Game;

import java.util.ArrayList;

//Runs the game
public class RunGame {

	public RunGame(int players) {
		String[] names = createPlayers(players);

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


        SequenceOfPlay sequenceOfPlay = new SequenceOfPlay();

		boolean quit = false; //makes this elsewhere
		//runs player turns until the game is won or quit is selected
		while(!checkVictory() && !quit) {
		    sequenceOfPlay.run(currentPlayer);


		}



	}

	private String[] createPlayers(int players) {
		String[] playerNames = new String[players];
		for (int i = 0; i < players; i++)
			playerNames[i] = "Player " + (i + 1);
		return playerNames;
	}

	private boolean checkVictory() {
		return false;
	}
}