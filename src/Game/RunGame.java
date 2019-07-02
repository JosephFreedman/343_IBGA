package Game;

import UI.MainGameScreen;
import java.util.ArrayList;

//Runs the game
public class RunGame {
	private MainGameScreen mainGameScreen;

	PlayerNode currentPlayer;
	ArrayList<Card> mDeck, iDeck, nDeck;

	public RunGame(MainGameScreen mainGameScreen, int players) {
		this.mainGameScreen = mainGameScreen;

		String[] names = createPlayers(players);

		boolean finished = false;
		//builds card decks
		ArrayList<Card> mDeck = Deck.genMainDeck();
		ArrayList<Card> iDeck = Deck.genIllDeck(players);
		ArrayList<Card> nDeck = new ArrayList<>();

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

		//sets up neutral deck
		int nCounter = 0, nIncrement = 0;;
		while(nCounter<5) {
			if(mDeck.get(nIncrement) instanceof Group) {
				nDeck.add(mDeck.get(nIncrement));
				mDeck.remove(nIncrement);
				nCounter++;
			}
			else { nIncrement++; }
		}
		mDeck = Deck.shuffle(mDeck);

		beginTheGame();

		SequenceOfPlay sequenceOfPlay = new SequenceOfPlay(mainGameScreen);

		//runs player turns until the game is won or quit is selected
		while(!finished) {
			sequenceOfPlay.run(currentPlayer);

			currentPlayer = currentPlayer.getNext();
			collectIncome(currentPlayer);
			draw(currentPlayer);
			//actionPhase(currentPlayer);
			addTargets();
			finished = checkVictory(currentPlayer);
		}


	}

	private String[] createPlayers(int players) {
		String[] playerNames = new String[players];
		for (int i = 0; i < players; i++)
			playerNames[i] = "Player " + (i + 1);
		return playerNames;
	}

	private boolean checkVictory(PlayerNode currentPlayer) {
		return false;
	}

	private void beginTheGame() {
		mainGameScreen.getChatScreen().print("Beginning the Game...");
	}
	
	//draws a card for the given player
	public void draw(PlayerNode pNode) {
		if(mDeck.get(0) instanceof ActionCard) { pNode.addToHand(mDeck.remove(0)); }
		else { nDeck.add(mDeck.remove(0)); }
	}
	
	//draws additional neutral groups if needed
	public void addTargets() {
		int i = 0;
		while(nDeck.size()<2) {
			if(mDeck.get(i) instanceof Group) { nDeck.add(mDeck.remove(i)); }
			else { i++; }
		}
		mDeck = Deck.shuffle(mDeck);
	}
	
	//collects income for all cards a player owns
	public void collectIncome(PlayerNode playerNode) {
		ArrayList<PowerNode> playerCards = playerNode.getPStruct().getSource().getAllNodes();
		for(PowerNode powNode : playerCards) {
			powNode.getGroup().addCurrency(powNode.getGroup().getIncome());
		}
	}
	
	
}