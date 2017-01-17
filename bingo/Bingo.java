// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class Bingo {

    private String player0name;
    private int difficulty;
    private double bet;

    private BingoPlayer player0, opp0, opp1, opp2, opp3, opp4, opp5, opp6, opp7;

    private ArrayList<BingoPlayer> players;
    // The number of BingoPlayers added to players will depend
    // on the difficulty setting, and operations will only be performed
    // on the BingoPlayers in players.

    private boolean bingo; // indicates whether a player has won
    
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
	players = new ArrayList<BingoPlayer>();
	player0 = new BingoPlayer( player0name, difficulty );
	opp0 = new BingoPlayer( "Erma", difficulty );
	opp1 = new BingoPlayer( "Zeb", difficulty );
	players.add( player0 );
	players.add( opp0 );
	players.add( opp1 );
	if ( difficulty > 1 ) {
	    opp2 = new BingoPlayer( "Gertrude", difficulty );
	    opp3 = new BingoPlayer( "Ebenezer", difficulty );
	    opp4 = new BingoPlayer( "Aretha", difficulty );
	    players.add( opp2 );
	    players.add( opp3 );
	    players.add( opp4 );
	}
	if ( difficulty > 2 ) {
	    opp5 = new BingoPlayer( "Ferdinand", difficulty );
	    opp6 = new BingoPlayer( "Uriah", difficulty );
	    opp7 = new BingoPlayer( "Deanne", difficulty );
	    players.add( opp5 );
	    players.add( opp6 );
	    players.add( opp7 );
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
	while ( !bingo ) {
	    System.out.println( "This is your card:\n\n" );
	    System.out.println( player0.printableCard() );
	    System.out.println( call() );
	    for ( BingoPlayer x : players ) {
		x.checkCard( letter, number );
		if ( x.checkBingo() ) {
		    System.out.println( x.name + ": Bingo!" );
		    bingo = true;
		    System.out.println( "Caller: " + x.name + " has won!\n" );
		    if ( x.equals( player0 ) ) {
			bet *= 6;
		    }
		    else {
			bet *= -1;
		    }
		    System.out.println( x.name + "'s card is shown:\n\n" );
		    System.out.println( x.printableCard() );
		    System.out.println( "Caller: Good game, everybody!" );
		}
	    }
	    // bingo = true;
	}
	return bet;
    }

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

    // main method for testing purposes
    public static void main( String[] args ) {
	Bingo japajoe;
	japajoe = new Bingo( "Kevin", 1, 50.0 );
	japajoe.play();
    }
}
