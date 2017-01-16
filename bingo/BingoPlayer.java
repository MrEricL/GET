// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

public class BingoPlayer {

    private int[][] card;

    // Default constructor
    public BingoPlayer() {
	for ( int i = 0; i < card.length; i += 1 ) {
	    for ( int x = 0; x < card[i].length; x += 1 ) {
		card[i][x] = 1 + 24 * Math.random();
    }

    // Fills cards with random numbers
    public void fillCard(){
    }

    public static void main( String[] args ) {
    }
}
