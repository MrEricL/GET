// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class Bingo {

    private int difficulty;
    private double bet;

    private BingoPlayer player0, opp0, opp1, opp2, opp3, opp4, opp5;

    private ArrayList<BingoPlayer> players;

    // Letter and number called by the bingo person
    // (not sure what the official name for the bingo person is)
    private int calledLetter; // is an int because it is used for indexing into the card array
    private int calledNumber;

    // Overloaded constructor
    public Bingo( diff, b ) {
	difficulty = diff;
	bet = b;
	players = new ArrayList<BingoPlayer>();
	players.add( player0 );
	players.add( opp0 );
	players.add( opp1 );
	if ( difficulty > 1 ) {
	    players.add( opp2 );
	    players.add( opp3 );
	}
	if ( difficulty > 2 ) {
	    players.add( opp4 );
	    players.add( opp5 );
	}
	// Instantiate only the BingoPlayers in players
	for ( int i = 0; i < players.size(); i += 1 ) {
	    players.get( i ) = new BingoPlayer( difficulty );
	}
    }

    // Fills cards with random numbers
    public void fillCard(){
    }
}
