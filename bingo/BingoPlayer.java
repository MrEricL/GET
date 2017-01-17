// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class BingoPlayer {

    private String name;
    private int[][] card;

    // keep track of numbers marked on card
    private ArrayList<Integer> B;
    private ArrayList<Integer> I;
    private ArrayList<Integer> N;
    private ArrayList<Integer> G;
    private ArrayList<Integer> O;

    // Overloaded constructor
    public BingoPlayer( String _name, int diff ) {
	int range;
	name = _name;
	range = 25 * diff;
	card = new int[5][5];
	for ( int i = 0; i < card.length; i += 1 ) {
	    for ( int x = 0; x < card[i].length; x += 1 ) {
		// The range of the ints in the card will be [1, range+1)
		card[i][x] = (int)( 1 + range * Math.random() );
	    }
	}
	card[2][2] = 0; // free space
	B = new ArrayList<Integer>();
	I = new ArrayList<Integer>();
	N = new ArrayList<Integer>();
	G = new ArrayList<Integer>();
	O = new ArrayList<Integer>();
    }

    // printableCard() returns printable version of bingo card
    public String printableCard() {
	String retStr;
	retStr = "B   I   N   G   O\n\n";
	for ( int[] x : card ) {
	    for ( int y : x ) {
		retStr += y;
		// space out columns
		if ( y < 10) {
		    retStr += "   ";
		}
		else {
		    retStr += "  ";
		}
	    }
	    retStr += "\n\n";
	}
	return retStr;
    }

    // Mark each number on the card that matches the number and letter called.
    // returns true if card is marked, false otherwise
    public boolean checkCard( int letter, int number ) {
	boolean retBool;
	retBool = false;
	for ( int i = 0; i < card[letter].length; i += 1 ) {
	    if ( card[letter][i] == number ) {
		if ( letter == 0 ) {
		    B.add( number );
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
		card[letter][i] = 0; // marks space on card
		retBool = true;
	    } // end if loop
	} // end for loop
	return retBool;
    } // end checkCard()

    public boolean checkBingo() {
	return checkRows() || checkColumns() || checkDiagonals();
    }

    // main method for testing purposes
    public static void main( String[] args ) {
	BingoPlayer yo;
	yo = new BingoPlayer( "pat", 1 );
	System.out.println( yo.printableCard() );
    }
}
