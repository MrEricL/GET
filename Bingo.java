// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class Bingo implements casinorules {

    private String player0name;
    private int difficulty;
    private double bet;
    private boolean bingo; // indicates whether a player has won
    private boolean win; // indicates whether player0 (the user) has won

    private BingoPlayer player0, opp0, opp1, opp2, opp3, opp4, opp5, opp6, opp7, opp8, opp9, opp10, opp11, opp12, opp13, opp14, opp15, opp16, opp17, opp18, opp19, opp20, opp21, opp22, opp23, opp24, opp25, opp26, opp27, opp28, opp29, opp30, opp31, opp32, opp33, opp34;

    private ArrayList<BingoPlayer> opponents;
    // The number of BingoPlayers added to opponents will depend
    // on the difficulty setting, and operations will only be performed
    // on the BingoPlayers in opponents.
    
    // Letter and number called by the caller
    private int letter; // is an int even though it represents a letter because it is used for indexing into the card array
    private int number;

    // ArrayLists to keep track of numbers called
    private ArrayList<Integer> B;
    private ArrayList<Integer> I;
    private ArrayList<Integer> N;
    private ArrayList<Integer> G;
    private ArrayList<Integer> O;
    
    
    // Overloaded constructor
    public Bingo( String name, int diff, double _bet ) {
	player0name = name;
	difficulty = diff;
	bet = _bet;
	start();
    }
    
    public void start() {
	opponents = new ArrayList<BingoPlayer>();
	player0 = new BingoPlayer( player0name, difficulty );
	opp0 = new BingoPlayer( "Erma", difficulty );
	opp1 = new BingoPlayer( "Zeb", difficulty );
	opp2 = new BingoPlayer( "Gertrude", difficulty );
	opp3 = new BingoPlayer( "Ebenezer", difficulty );
	opp4 = new BingoPlayer( "Aretha", difficulty );
	opp5 = new BingoPlayer( "Ferdinand", difficulty );
	opp6 = new BingoPlayer( "Uriah", difficulty );
	opp7 = new BingoPlayer( "Deanne", difficulty );
	opp8 = new BingoPlayer( "Miles", difficulty );
	opp9 = new BingoPlayer( "Herodotos", difficulty );
	opp10 = new BingoPlayer( "Praskoviya", difficulty );
	// players.add( player0 );
	opponents.add( opp0 );
	opponents.add( opp1 );
	opponents.add( opp2 );
	opponents.add( opp3 );
	opponents.add( opp4 );
	opponents.add( opp5 );
	opponents.add( opp6 );
	opponents.add( opp7 );
	opponents.add( opp8 );
	opponents.add( opp9 );
	opponents.add( opp10 );
	if ( difficulty > 1 ) {
	    opp11 = new BingoPlayer( "Hedviga", difficulty );
	    opp12 = new BingoPlayer( "Arvid", difficulty );
	    opp13 = new BingoPlayer( "Cnaeus", difficulty );
	    opp14 = new BingoPlayer( "Tatiana", difficulty );
	    opp15 = new BingoPlayer( "Sudarshana", difficulty );
	    opp16 = new BingoPlayer( "Mladen", difficulty );
	    opp17 = new BingoPlayer( "Miren", difficulty );
	    opp18 = new BingoPlayer( "Asklepiades", difficulty );
	    opp19 = new BingoPlayer( "Azra", difficulty );
	    opp20 = new BingoPlayer( "Loris", difficulty );
	    opp21 = new BingoPlayer( "Murali", difficulty );
	    opp22 = new BingoPlayer( "Kazimieras", difficulty );
	    opponents.add( opp11 );
	    opponents.add( opp12 );
	    opponents.add( opp13 );
	    opponents.add( opp14 );
	    opponents.add( opp15 );
	    opponents.add( opp16 );
	    opponents.add( opp17 );
	    opponents.add( opp18 );
	    opponents.add( opp19 );
	    opponents.add( opp20 );
	    opponents.add( opp21 );
	    opponents.add( opp22 );
	}
	if ( difficulty > 2 ) {
	    
	    
	}
	// System.out.println( players );
	B = new ArrayList<Integer>();
	I = new ArrayList<Integer>();
	N = new ArrayList<Integer>();
	G = new ArrayList<Integer>();
	O = new ArrayList<Integer>();
    } // end start()

    public double play() {
	bingo = false;
	win = false;
	while ( !bingo ) {
	    go();
	}
	if ( win ) {
	    return player0.getMultiplier() * (opponents.size() + 1) * bet;
	}
	else {
	    return -1 * bet;
	}
    } // end play()

    public void go() {
	System.out.println( "This is your card:\n\n" );
	System.out.println( player0.printableCard() );
	System.out.println( call() );
	player0.checkCard( letter, number );
	if ( player0.checkBingo() ) {
	    bingo = true;
	    win = true;
	    System.out.println( winSequence( player0 ) );
	}
	for ( BingoPlayer x : opponents ) {
	    x.checkCard( letter, number );
	    if ( x.checkBingo() ) {
		bingo = true;
		System.out.println( winSequence( x ) );
	    }
	}
	slp(2.0);
	// bingo = true;
    } // end go()

    public String call() {
	int range;
	String letters;
	String retStr;
	
	// rand int in [0, 5)
	letter = (int)( 5 * Math.random() );

	range = 25 * difficulty;
	// rand int in [1, range +1)
	number = (int)( 1 + range * Math.random() );

	letters = "BINGO";
	retStr = "Caller: ";
	retStr += letters.substring( letter, letter + 1 );
	retStr += " ";
	retStr += number;
	if ( letter == 0 ) {
	    B.add( number );
	    if ( number == 4 ) {
		retStr += "\nEveryone: ...and after!";
	    }
	}
	else if ( letter == 1 ) {
	    I.add( number );
	}
	else if ( letter == 2 ) {
	    N.add( number );
	}
	else if ( letter == 3 ) {
	    G.add( number );
	}
	else {
	    O.add( number );
	}
	return retStr;
    }

    public String winSequence( BingoPlayer player ) {
	String retStr;
	retStr = player.getName() + ": Bingo!\n";
	retStr += "Caller: " + player.getName() + " has won!";
	if ( player.getMultiplier() == 2 ) {
	    retStr += " It's a double bingo!";
	}
	retStr += "\n\n" + player.getName() + "'s card is shown:\n\n\n";
	retStr += player.printableCard();
	retStr += "\n";
	retStr += "Caller: Good game, everybody!\n\n";
	return retStr;
    }
	public void slp(double x){
	    x*=1000;
	    long y= (long)x;
	    try{
		Thread.sleep(y);
	    }
	    catch(InterruptedException e){
	    }
	}    

    // main method for testing purposes
    public static void main( String[] args ) {
	Bingo japajoe;
	japajoe = new Bingo( "Kevin", 1, 50.0 );
	japajoe.play();
    }
}
