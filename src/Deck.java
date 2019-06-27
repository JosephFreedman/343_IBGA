import java.util.ArrayList;
import java.util.Random;

//builds and manages the deck used for the game
public class Deck {
	
	//holds deck copies
	static ArrayList<Card> mDeck = new ArrayList<Card>();
	static ArrayList<Card> iDeck = new ArrayList<Card>();
	//holds data for standard groups
	static String[] gNames = { "American Autoduel Association", "Antiwar Activists", "Big Media", "Boy Sprouts", "California", "CFL-AIO", "C.I.A.", "Comic Books", "Congressional Wives", "Convenience Stores", "Copy Shops", "Democrats", "Eco-Guerrillas", "Empty Vee", "Fast Food Chains", "F.B.I.", "Fiendish Fluoridators", "Flat Earthers", "Fnord Motor Company", "Fraternal Orders", "Girlie Magazines", "Goldfish Fanciers", "Hollywood", "Intellectuals", "KKK", "Libertarians", "Loan Sharks", "Local Police Departments", "The Men In Black", "Moonies", "Moral Minority", "Morticians", "Multinational Oil Companies", "Nephews of God", "New York", "Nuclear Power Companies", "Parent/Teacher Agglomeration", "Pentagon", "The Phone Company", "Post Office", "Professional Sports", "Psychiatrists", "Punk Rockers", "Republicans", "Robot Sea Monsters", "Society for Creative Anarchism", "South American Nazis", "Texas", "Tabacco & Liquor Companies", "Trekkies", "Triliberal Commission", "Underground Newspapers", "The United Nations", "Yuppies" };
	static int[] gPower = { 1, 0 };
	static int[] gTrans = { 0, 0 };
	static int[] gRes = { 5, 3 };
	static int[] gInc = { 1, 1 };
	static String[][] gAlignments = { {"Violent", "Weird"}, {"Peaceful", "Liberal"}, {}, {} };
	static int[] gAbility = { 0, 1, 0, 0, 0, 0, 0, 2 };
	//holds data for action cards
	static String[] aNames = { "", "" };
	//holds data for illuminati cards
	static String[] iNames = { "", "" };
	static int[] iPower = {};
	static int[] iInc = {};
	
	//constructs the main deck from various card classes
	public static ArrayList<Card> genMainDeck() {
		//adds all groups to deck
		for(int i=0;i<gNames.length;i++) {
			Group nCard = new Group();
			nCard.setType("Group");
			nCard.setName(gNames[i]);
			nCard.setEffectNum(gAbility[i]);
			nCard.setAll(gPower[i], gTrans[i], gRes[i], gInc[i], gAlignments[i]);
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
		
		return mDeck;
	}
	
	
	//constructs the Illuminati deck
	public static ArrayList<Card> genIllDeck() {
		//adds all illuminati to deck
		for(int i=0;i<iNames.length;i++) {
			IlluminatiCard nCard = new IlluminatiCard();
			nCard.setType("Illuminati");
			nCard.setName(iNames[i]);
			nCard.setPower(iPower[i]);
			nCard.setTPower(iPower[i]);
			nCard.setIncome(iInc[i]);
			nCard.setEffectNum(i);
			iDeck.add(nCard);
		}
		
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
