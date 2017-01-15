// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

public abstract class Bingo {

    // Commented out:
    /*========================
    // Variables for overloaded constructor
    private int difficulty;
    private double money;

    // Declare player and opponents' bingo cards.
    private int[][] p1card;
    private int[][] opp1card;
    private int[][] opp2card;
    ========================*/

    protected int[5][5] card;

    // Letter and number called by the bingo person
    // (not sure what the official name for the bingo person is)
    protected int calledLetter; // is an int because it is used for indexing into the card array
    protected int calledNumber;

    // Overloaded constructor
    public Bingo( diff ) {
	for ( int i = 0; i < card.length; i += 1 ) {
	    for ( int x = 0; x < card[i].length; x += 1 ) {
		card[i][x] = 
    }

    // Fills cards with random numbers
    public void fillCard(){
    }
}
