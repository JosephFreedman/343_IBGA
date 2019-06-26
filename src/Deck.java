import java.util.ArrayList;

//builds and manages the deck used for the game
public class Deck {
	
	//holds copy of the main deck
	static ArrayList<Card> mDeck = new ArrayList<Card>();
	//holds data for standard groups
	static String[] gNames = { "American Autoduel Association", "Antiwar Activists", "Big Media", "Boy Sprouts", "California", "CFL-AIO", "C.I.A.", "Comic Books", "Congressional Wives", "Convenience Stores", "Copy Shops", "Democrats", "Eco-Guerrillas", "Empty Vee", "Fast Food Chains", "F.B.I.", "Fiendish Fluoridators", "Flat Earthers", "Fnord Motor Company", "Fraternal Orders", "Girlie Magazines", "Goldfish Fanciers", "Hollywood", "Intellectuals", "KKK", "Libertarians", "Loan Sharks", "Local Police Departments", "The Men In Black", "Moonies", "Moral Minority", "Morticians", "Multinational Oil Companies", "Nephews of God", "New York", "Nuclear Power Companies", "Parent/Teacher Agglomeration", "Pentagon", "The Phone Company", "Post Office", "Professional Sports", "Psychiatrists", "Punk Rockers", "Republicans", "Robot Sea Monsters", "Society for Creative Anarchism", "South American Nazis", "Texas", "Tabacco & Liquor Companies", "Trekkies", "Triliberal Commission", "Underground Newspapers", "The United Nations", "Yuppies" };
	static int[] gPower = { 1, 0 };
	static int[] gTrans = { 0, 0 };
	static int[] gRes = { 5, 3 };
	static int[] gInc = { 1, 1 };
	static String[][] gAlignments = { {"Violent", "Weird"}, {"Peaceful", "Liberal"}, {}, {} };
	
	//constructs the deck from various card classes
	public static ArrayList<Card> genDeck() {
		//adds all normal groups to deck
		for(int i=0;i<gNames.length;i++) {
			Group nCard = new Group();
			nCard.setType("Group");
			nCard.setName(gNames[i]);
			nCard.setAll(gPower[i], gTrans[i], gRes[i], gInc[i], gAlignments[i]);
			mDeck.add(nCard);
		}
		
		//TODO add special groups
		//TODO add illuminati groups
		//TODO add action cards
		
		return mDeck;
	}
	
}
