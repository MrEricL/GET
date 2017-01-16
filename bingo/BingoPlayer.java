// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

public class BingoPlayer {

    private int[][] card;

    // Overloaded constructor
    public BingoPlayer( int diff ) {
	int range;
	range = 25 * diff;
	card = new int[5][5];
	for ( int i = 0; i < card.length; i += 1 ) {
	    for ( int x = 0; x < card[i].length; x += 1 ) {
		// The range of the ints in the card will be [1, range+1)
		card[i][x] = (int)( 1 + range * Math.random() );
	    }
	}
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

    // main method for testing purposes
    public static void main( String[] args ) {
	BingoPlayer jebediah;
	jebediah = new BingoPlayer( 1 );
	System.out.println( jebediah.printableCard() );
    }
}
