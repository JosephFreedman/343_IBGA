import java.util.ArrayList;
import java.util.Random;

//builds and manages the deck used for the game
public class Deck {
	
	//holds copy of the main deck
	static ArrayList<Card> mDeck = new ArrayList<Card>();
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
	static int[] gRes = { 5, 3 };
	static int[] gInc = { 1, 1 };
	static String[][] gAlignments = { {"Violent", "Weird"}, {"Peaceful", "Liberal"}, {}, {} };
	static int[] gAbility = { 0, 1, 0, 0, 0, 0, 0 , 2, 0, 3, 0, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 6, 7, 0, 0, 0, 0, 0, 0, 8,
	 9, 10, 0, 0, 11, 12, 13, 14, 15, 0, 16, 0, 0, 0, 17, 18, 0, 19, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 21, 0, 0, 0, 0,
	 22, 0, 0, 23, 24, 25, 0, 0, 26, 27, 0, 0, 0, 0, 28, 0, 0, 29, 0 };
	//holds data for action cards
	static String[] aNames = { "Assassination", "Bribery", "Computer Espionage", "Deep Agent", "Interference", 
	 "Market Manipulation", "Media Campaign", "Murphy's Law", "Secrets Man Was Not Meant To Know", 
	 "Senate Investigating Committee", "Slush Fund", "Swiss Bank Account", "Whispering Campaign", "White Collar Crime" };
	
	//constructs the deck from various card classes
	public static ArrayList<Card> genDeck() {
		//adds all groups to deck
		for(int i=0;i<gNames.length;i++) {
			Group nCard = new Group();
			nCard.setType("Group");
			nCard.setName(gNames[i]);
			nCard.setEffectNum(gAbility[i]);
			nCard.setAll(gPower[i], gTrans[i], gRes[i], gInc[i], gAlignments[i]);
			mDeck.add(nCard);
		}
		
		//TODO add illuminati groups
		
		
		//adds all action cards to the deck
		for(int i=0;i<aNames.length;i++) {
			ActionCard nCard = new ActionCard();
			nCard.setType("Action");
			nCard.setName(aNames[i]);
			nCard.setEffectNum(i);
			mDeck.add(nCard);
		}
		
		return mDeck;
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
