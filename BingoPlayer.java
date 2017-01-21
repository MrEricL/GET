// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

import java.util.ArrayList;

public class BingoPlayer {

    private String name;
    private int[][] card;
    private int multiplier; // determines how much money the player wins

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
		// The interval of the ints in the card will be [1, range+1)
		card[i][x] = (int)( 1 + range * Math.random() );
	    }
	}
	card[2][2] = 0; // free space
	multiplier = 0;
	B = new ArrayList<Integer>();
	I = new ArrayList<Integer>();
	N = new ArrayList<Integer>();
	G = new ArrayList<Integer>();
	O = new ArrayList<Integer>();
    } // end BingoPlayer( String _name, int diff )

    //------------------------Accessors------------------------
    public String getName() {
	return name;
    }
    public int getMultiplier() {
	return multiplier;
    }
    //---------------------------------------------------------

    // printableCard() returns printable version of bingo card
    public String printableCard() {
	String retStr;
	retStr = "B   I   N   G   O\n\n\n";
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
    } // end printableCard()

    // Mark each number on the card that matches the number and letter called.
    // returns true if card is marked, false otherwise
    public boolean checkCard( int letter, int number ) {
	boolean retBool;
	retBool = false;
	// check in each row only the number in the correct letter's column
	for ( int i = 0; i < card.length; i += 1 ) {
	    if ( card[i][letter] == number ) {
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
		card[i][letter] = 0; // marks space on card
		retBool = true;
	    } // end if loop
	} // end for loop
	return retBool;
    } // end checkCard( int letter, int number )

    public boolean checkBingo() {
	multiplier = checkRows() + checkColumns() + checkDiagonals();
	return multiplier > 0;
    }

    public int checkRows() {
	int markCtr;
	for ( int i = 0; i < card.length; i += 1 ) {
	    markCtr = 0;
	    // The following for loop terminates when it comes to an int in the
	    // row that is not 0, rather than iterating through the whole row.
	    for ( int x = 0; x < card[i].length && card[i][x] == 0; x += 1 ) {
		markCtr += 1;
	    }
	    if ( markCtr == card[i].length ) {
		// end method using return statement rather than checking more
		// rows, as parallel rows cannot intersect to form double bingo
		return 1;
	    }
	}
	return 0;
    } // end checkRows()

    public int checkColumns() {
	int markCtr;
	for ( int i = 0; i < card[0].length; i += 1 ) {
	    markCtr = 0;
	    // The following for loop terminates when it comes to an int in the
	    // column that is not 0, rather than iterating through the whole
	    // column.
	    for ( int x = 0; x < card.length && card[x][i] == 0; x += 1 ) {
		markCtr += 1;
	    }
	    if ( markCtr == card.length ) {
		// end method using return statement rather than checking more
		// columns, as parallel columns cannot intersect to form double
		// bingo.
		return 1;
	    }
	}
	return 0;
    } // end checkColumns()

    public int checkDiagonals() {
	int markCtr;
	int numBingos;
	int x;
	markCtr = 0;
	numBingos = 0;
	// first diagonal:
	// This for loop terminates when it comes to an int in the
	// diagonal that is not 0, rather than iterating through the whole
	// diagonal.
	for ( int i = 0; i < card.length && card[i][i] == 0; i += 1 ) {
	    markCtr += 1;
	}
	if ( markCtr == card.length ) {
	    numBingos += 1;
	}
	markCtr = 0;
	// second diagonal:
	// This for loop terminates when it comes to an int in the
	// diagonal that is not 0, rather than iterating through the whole
	// diagonal.
	x = 0;
	for ( int i = card.length - 1; i > -1 && card[x][i] == 0; i -= 1 ) {
	    markCtr += 1;
	    x += 1;
	}
	if ( markCtr == card.length ) {
	    numBingos += 1;
	}
	return numBingos;
    } // end checkDiagonals()

    // main method for testing purposes
    public static void main( String[] args ) {
	BingoPlayer yo;
	yo = new BingoPlayer( "pat", 1 );
	System.out.println( yo.printableCard() );
    }
} // end class BingoPlayer
