// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class Bingo {

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

    

    // Overloaded constructor
    public Bingo( int diff, double b ) {
	difficulty = diff;
	bet = b;
	start();
    }
    
    public void start() {
	players = new ArrayList<BingoPlayer>();
	player0 = new BingoPlayer( difficulty );
	opp0 = new BingoPlayer( difficulty );
	opp1 = new BingoPlayer( difficulty );
	players.add( player0 );
	players.add( opp0 );
	players.add( opp1 );
	if ( difficulty > 1 ) {
	    opp2 = new BingoPlayer( difficulty );
	    opp3 = new BingoPlayer( difficulty );
	    opp4 = new BingoPlayer( difficulty );
	    players.add( opp2 );
	    players.add( opp3 );
	    players.add( opp4 );
	}
	if ( difficulty > 2 ) {
	    opp5 = new BingoPlayer( difficulty );
	    opp6 = new BingoPlayer( difficulty );
	    opp7 = new BingoPlayer( difficulty );
	    players.add( opp5 );
	    players.add( opp6 );
	    players.add( opp7 );
	}
	// System.out.println( players );
    } // end start()

    public double play() {
	bingo = false;
	while ( !bingo ) {
	    System.out.println( "This is your card:\n\n" );
	    System.out.println( player0.printableCard() );
	    System.out.println( call() );
	    bingo = true;
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
	if ( ( letter == 0 ) && ( number == 4 ) ) {
	    retStr += "\nEveryone: ...and after!";
	}
	return retStr;
    }

    // main method for testing purposes
    public static void main( String[] args ) {
	Bingo japajoe;
	japajoe = new Bingo( 1, 50.0 );
	japajoe.play();
    }
}
