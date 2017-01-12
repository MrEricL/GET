// Period 4
// Team GET
// Gian Tricarico, Eric Li, Truc Dao

public class Bingo {

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

    // Letter and number called by the bingo person
    // (not sure what the official name is)
    private int calledLetter; // is an int because method converts letter to number for indexing in the array
    private int calledNumber;

    // Overloaded constructor
    public Bingo( diff, mon, b ) {
	fillCard();
    }

    // Fills cards with random numbers
    public void fillCard(){
    }
}
