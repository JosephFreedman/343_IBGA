package Game;

import java.util.ArrayList;
import java.util.Random;

//builds and manages the deck used for the game
public class Deck {
	
	//holds deck copies
	static ArrayList<Card> mDeck = new ArrayList<Card>();
	static ArrayList<Card> iDeck = new ArrayList<Card>();
	//holds data for standard groups
	static String[] gNames = { "American Autoduel Association", "Anti-Nuclear Activists", "Antiwar Activists", 
	 "Big Media", "Boy Sprouts", "California", "CFL-AIO", "Chinese Campaign Donors", "C.I.A.", "Clone Arrangers", 
	 "Comic Books", "Congressional Wives", "Convenience Stores", "Copy Shops", "Cycle Ganges", "Democrats", 
	 "Eco-Guerrillas", "Empty Vee", "Evil Geniuses for a Better Tomorrow", "Fast Food Chains", "F.B.I.", 
	 "Federal Reserve", "Feminists", "Fiendish Fluoridators", "Flat Earthers", "Fnord Motor Company", 
	 "Fraternal Orders", "Girlie Magazines", "Goldfish Fanciers", "Gun Lobby", "Hackers", "Health Food Stores", 
	 "Hollywood", "Intellectuals", "International Cocaine Smugglers", "International Communist Conspiracy", 
	 "I.R.S.", "Junk Mail", "KGB", "KKK", "L-4 Society", "Libertarians", "Loan Sharks", "Local Police Departments", 
	 "Madison Avenue", "The Mafia", "The Men In Black", "Militia", "Moonies", "Moral Minority", "Morticians", 
	 "Multinational Oil Companies", "Nephews of God", "New York", "Nuclear Power Companies", "Orbital Mind Control Lasers", 
	 "Parent/Teacher Agglomeration", "Pentagon", "The Phone Company", "Phone Phreaks", "Post Office", 
	 "Professional Sports", "Psychiatrists", "Punk Rockers", "Recyclers", "Republicans", "Robot Sea Monsters", 
	 "Science Fiction Fans", "Semiconscious Liberation Army", "S.M.O.F.", "Society for Creative Anarchism", 
	 "South American Nazis", "Survivalists", "Tabloids", "Texas", "Tabacco & Liquor Companies", "Trekkies", 
	 "Triliberal Commission", "TV Preachers", "Underground Newspapers", "The United Nations", "Video Games", "Yuppies" };
	static int[] gPower = { 1, 2, 0, 4, 0, 5, 6, 3, 6, 6, 1, 1, 1, 1, 0, 5, 0, 3, 0, 2, 4, 5, 2, 3, 1, 2, 3, 2, 0, 1, 1,
	 1, 2, 0, 3, 7, 5, 1, 2, 2, 1, 1, 5, 0, 3, 7, 0, 2, 2, 2, 0, 6, 0, 7, 4, 4, 0, 6, 5, 0, 4, 2, 0, 0, 2, 4, 0, 0, 0, 1,
	 0, 4, 0, 2, 6, 4, 0, 5, 3, 1, 1, 2, 1 };
	static int[] gTrans = { 0, 0, 0, 3, 0, 0, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1,
	 0, 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0,
	 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 };
	static int[] gRes = { 5, 5, 3, 6, 3, 4, 5, 2, 5, 6, 1, 4, 4, 3, 4, 4, 6, 3, 6, 4, 6, 7, 2, 5, 2, 4, 5, 2, 4, (0), 4, 3,
	 0, 3, 5, 8, 5, 3, 6, 5, 2, 4, 5, 4, 3, 7, 6, 4, 4, 1, 4, 4, 4, 8, 4, 5, 5, 6, 6, 1, 3, 4, 6, 4, 2, 4, 6, 5, 8, 1, 4, 
	 6, 6, 3, 6, 3, 4, 6, 6, 5, 3, 3, 4 };//(0) is Gun Lobby card which has variable res from its power
	static int[] gInc = { 1, 1, 1, 3, 1, 5, 3, 3, 0, 1, 2, 1, 3, 4, 0, 3, 1, 4, 3, 3, 0, 6, 1, 1, 1, 2, 2, 3, 1, 1, 2, 2, 5,
	 1, 5, 6, (0), 2, 0, 1, 0, 1, 6, 1, 2, 6, 1, 2, 3, 2, 1, 8, 2, 3, 3, 0, 1, 2, 3, 1, -1, 3, 2, 1, 3, 4, 2, 1, 0, 0, 1, 2, 
	 2, 3, 4, 3, 3, 3, 4, 0, 3, 7, 5 };//(0) is I.R.S. card which collects 2MB from each player if possible
	static String[][] gAlignments = { {"Violent", "Weird"}, {"Liberal"}, {"Peaceful", "Liberal"}, {"Liberal", "Straight"},
	 {"Straight", "Peaceful"}, {"Liberal", "Weird", "Government"}, {"Liberal"}, {"Communist"}, {"Government", "Violent"}, 
	 {"Violent", "Communist", "Criminal"}, {"Weird", "Violent"}, {"Conservative", "Straight"}, {"Straight"}, {"Peaceful"}, 
	 {"Violent", "Weird"}, {"Liberal"}, {"Liberal", "Violent", "Weird"}, {}, {"Violent", "Weird"}, {"Straight"}, 
	 {"Government", "Straight"}, {"Government"}, {"Liberal"}, {"Communist", "Fanatic"}, {"Weird", "Conservative"}, {"Peaceful"}, 
	 {"Conservative"}, {"Liberal"}, {"Peaceful", "Fanatic"}, {"Conservative", "Violent"}, {"Weird", "Fanatic"}, {"Liberal"}, 
	 {"Liberal"}, {"Weird", "Fanatic"}, {"Criminal"}, {"Communist"}, {"Criminal", "Government"}, {"Criminal"}, 
	 {"Communist", "Violent"}, {"Conservative", "Violent"}, {"Weird"}, {"Fanatic"}, {"Criminal", "Violent"}, 
	 {"Conservative", "Straight", "Violent"}, {}, {"Criminal", "Violent"}, {"Criminal", "Weird"}, {"Violent", "Conservative"}, 
	 {"Peaceful", "Fanatic"}, {"Conservative", "Straight", "Fanatic"}, {"Straight", "Peaceful"}, {}, {"Conservative", "Fanatic"}, 
	 {"Violent", "Criminal", "Government"}, {"Conservative"}, {"Communist"}, {"Peaceful", "Conservative", "Straight"}, 
	 {"Government", "Violent", "Straight"}, {}, {"Criminal", "Liberal"}, {"Government"}, {"Violent", "Fanatic"}, {"Weird"}, {"Weird"}, 
	 {"Liberal"}, {"Conservative"}, {"Violent", "Communist"}, {"Weird"}, {"Criminal", "Violent", "Liberal", "Weird", "Communist"}, 
	 {"Weird"}, {"Violent", "Weird"}, {"Conservative", "Violent"}, {"Conservative", "Violent", "Fanatic"}, {"Weird"}, 
	 {"Violent", "Conservative", "Government"}, {"Straight"}, {"Weird", "Fanatic"}, {"Liberal", "Straight"}, {"Straight", "Fanatic"}, 
	 {"Communist", "Liberal"}, {"Liberal"}, {}, {"Conservative"} };
	static int[] gAbility = { 0, 1, 0, 0, 0, 0, 0 , 2, 0, 3, 0, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 6, 7, 0, 0, 0, 0, 0, 0, 8,
	 9, 10, 0, 0, 11, 12, 13, 14, 15, 0, 16, 0, 0, 0, 17, 18, 0, 19, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 21, 0, 0, 0, 0,
	 22, 0, 0, 23, 24, 25, 0, 0, 26, 27, 0, 0, 0, 0, 28, 0, 0, 29, 0 };
	static String[] gEntrance = {"w","w","w","e","w", "w"};
	static String[][] gExits = {{"e"}, {"n"}, null, {"n","s","w"}, null, {"n","s"}};
	//holds data for illuminati cards
	static String[] iNames = { "The Society of Assassins", "The Network", "The Discordian Society", "THe UFOs",
	 "The Servants of Cthulhu", "The Gnomes of Zurich", "The Bavarian Illuminati", "The Bermuda Triangle" };
	static int[] iPower = {8, 7, 8, 6, 9, 7, 10, 8};
	static int[] iInc = {8, 9, 8, 8, 7, 12, 9, 9 };
	//holds data for action cards
	static String[] aNames = { "Assassination", "Bribery", "Computer Espionage", "Deep Agent", "Interference", 
	 "Market Manipulation", "Media Campaign", "Murphy's Law", "Secrets Man Was Not Meant To Know", 
	 "Senate Investigating Committee", "Slush Fund", "Swiss Bank Account", "Whispering Campaign", "White Collar Crime" };
	
	//constructs the main deck from various card classes
	public static ArrayList<Card> genMainDeck() {
		//adds all groups to deck
		for(int i=0;i<gNames.length;i++) {
			Group nCard = new Group();
			nCard.setType("Game.Group");
			nCard.setName(gNames[i]);
			nCard.setEffectNum(gAbility[i]);
			nCard.setAll(gPower[i], gTrans[i], gRes[i], gInc[i], gAlignments[i], gEntrance[i], gExits[i]);
			mDeck.add(nCard);
		}
		
		//adds all action cards to the deck
		for(int i=0;i<aNames.length;i++) {
			ActionCard nCard = new ActionCard();
			nCard.setType("Action");
			nCard.setName(aNames[i]);
			nCard.setEffectNum(i);
			mDeck.add(nCard);
			if(aNames[i].equals("Interference")) { mDeck.add(nCard); }
		}
		
		mDeck = shuffle(mDeck);
		return mDeck;
	}
	
	
	//constructs the Illuminati deck
	public static ArrayList<Card> genIllDeck(int players) {
		char[] exits = {'n','s','e','w'};
		//adds all illuminati to deck
		for(int i=0;i<iNames.length;i++) {
			IlluminatiCard nCard = new IlluminatiCard();
			nCard.setType("Illuminati");
			nCard.setName(iNames[i]);
			nCard.setPower(iPower[i]);
			nCard.setTPower(iPower[i]);
			nCard.setIncome(iInc[i]);
			nCard.setEffectNum(i);
			nCard.setExits(exits);
			iDeck.add(nCard);
		}
		
		iDeck = shuffle(iDeck);
		iDeck = (ArrayList<Card>) iDeck.subList(0, players);
		
		return iDeck;
	}
	
	
	//shuffles a given deck
	public static ArrayList<Card> shuffle(ArrayList<Card> deck) {
		Random rand = new Random();
		for(int i=0;i<deck.size()*10;i++) {
			int card = rand.nextInt(deck.size());
			deck.add(deck.get(card));
			deck.remove(card);
		}
		return deck;
	}
	
}
