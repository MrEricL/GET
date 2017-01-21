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

    private BingoPlayer player0, opp0, opp1, opp2, opp3, opp4, opp5, opp6, opp7, opp8, opp9, opp10, opp11, opp12, opp13, opp14, opp15, opp16, opp17, opp18, opp19, opp20, opp21, opp22, opp23, opp24, opp25, opp26, opp27, opp28, opp29, opp30, opp31, opp32, opp33, opp34, opp35, opp36, opp37, opp38, opp39, opp40, opp41, opp42, opp43, opp44, opp45, opp46, opp47, opp48, opp49, opp50, opp51, opp52, opp53, opp54, opp55, opp56, opp57, opp58, opp59, opp60, opp61, opp62, opp63, opp64, opp65, opp66, opp67, opp68, opp69, opp70;

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

    // sets up game and opponents based on difficulty setting
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
	if ( difficulty > 1 ) {
	    opp23 = new BingoPlayer( "Kaleb", difficulty );
	    opp24 = new BingoPlayer( "Josiane", difficulty );
	    opp25 = new BingoPlayer( "Liesl", difficulty );
	    opp26 = new BingoPlayer( "Vanda", difficulty );
	    opp27 = new BingoPlayer( "Naomi", difficulty );
	    opp28 = new BingoPlayer( "Florianus", difficulty );
	    opp29 = new BingoPlayer( "Lapo", difficulty );
	    opp30 = new BingoPlayer( "Concetta", difficulty );
	    opp31 = new BingoPlayer( "Raphael", difficulty );
	    opp32 = new BingoPlayer( "Madlyn", difficulty );
	    opp33 = new BingoPlayer( "Zahir", difficulty );
	    opp34 = new BingoPlayer( "Joanna", difficulty );
	    opp35 = new BingoPlayer( "Aiman", difficulty );
	    opp36 = new BingoPlayer( "Liselotte", difficulty );
	    opp37 = new BingoPlayer( "Chidiegwu", difficulty );
	    opp38 = new BingoPlayer( "Jeronimo", difficulty );
	    opp39 = new BingoPlayer( "Uther", difficulty );
	    opp40 = new BingoPlayer( "Philippina", difficulty );
	    opp41 = new BingoPlayer( "Eurydike", difficulty );
	    opp42 = new BingoPlayer( "Yechezkel", difficulty );
	    opp43 = new BingoPlayer( "Mina", difficulty );
	    opp44 = new BingoPlayer( "Rosita", difficulty );
	    opp45 = new BingoPlayer( "Ariel", difficulty );
	    opp46 = new BingoPlayer( "Stefania", difficulty );
	    opponents.add( opp23 );
	    opponents.add( opp24 );
	    opponents.add( opp25 );
	    opponents.add( opp26 );
	    opponents.add( opp27 );
	    opponents.add( opp28 );
	    opponents.add( opp29 );
	    opponents.add( opp30 );
	    opponents.add( opp31 );
	    opponents.add( opp32 );
	    opponents.add( opp33 );
	    opponents.add( opp34 );
	    opponents.add( opp35 );
	    opponents.add( opp36 );
	    opponents.add( opp37 );
	    opponents.add( opp38 );
	    opponents.add( opp39 );
	    opponents.add( opp40 );
	    opponents.add( opp41 );
	    opponents.add( opp42 );
	    opponents.add( opp43 );
	    opponents.add( opp44 );
	    opponents.add( opp45 );
	    opponents.add( opp46 );
	} // end if statement
	if ( difficulty > 2 ) {
	    opp47 = new BingoPlayer( "Marion", difficulty );
	    opp48 = new BingoPlayer( "Maja", difficulty );
	    opp49 = new BingoPlayer( "Karoline", difficulty );
	    opp50 = new BingoPlayer( "Feidelm", difficulty );
	    opp51 = new BingoPlayer( "Gordana", difficulty );
	    opp52 = new BingoPlayer( "Geraldo", difficulty );
	    opp53 = new BingoPlayer( "Ayako", difficulty );
	    opp54 = new BingoPlayer( "Eudora", difficulty );
	    opp55 = new BingoPlayer( "Moirrey", difficulty );
	    opp56 = new BingoPlayer( "Sanchia", difficulty );
	    opp57 = new BingoPlayer( "Lyudmil", difficulty );
	    opp58 = new BingoPlayer( "Juliya", difficulty );
	    opp59 = new BingoPlayer( "Chernobog", difficulty );
	    opp60 = new BingoPlayer( "Mordecai", difficulty );
	    opp61 = new BingoPlayer( "Sushila", difficulty );
	    opp62 = new BingoPlayer( "Jaak", difficulty );
	    opp63 = new BingoPlayer( "Marlene", difficulty );
	    opp64 = new BingoPlayer( "Menahem", difficulty );
	    opp65 = new BingoPlayer( "Aineias", difficulty );
	    opp66 = new BingoPlayer( "Yunus", difficulty );
	    opp67 = new BingoPlayer( "Marje", difficulty );
	    opp68 = new BingoPlayer( "Daedalus", difficulty );
	    opp69 = new BingoPlayer( "Nina", difficulty );
	    opp70 = new BingoPlayer( "Kephas", difficulty );
	    opponents.add( opp47 );
	    opponents.add( opp48 );
	    opponents.add( opp49 );
	    opponents.add( opp50 );
	    opponents.add( opp51 );
	    opponents.add( opp52 );
	    opponents.add( opp53 );
	    opponents.add( opp54 );
	    opponents.add( opp55 );
	    opponents.add( opp56 );
	    opponents.add( opp57 );
	    opponents.add( opp58 );
	    opponents.add( opp59 );
	    opponents.add( opp60 );
	    opponents.add( opp61 );
	    opponents.add( opp62 );
	    opponents.add( opp63 );
	    opponents.add( opp64 );
	    opponents.add( opp65 );
	    opponents.add( opp66 );
	    opponents.add( opp67 );
	    opponents.add( opp68 );
	    opponents.add( opp69 );
	    opponents.add( opp70 );
	} // end if statement
	// System.out.println( players );
	B = new ArrayList<Integer>();
	I = new ArrayList<Integer>();
	N = new ArrayList<Integer>();
	G = new ArrayList<Integer>();
	O = new ArrayList<Integer>();
    } // end start()

    // runs bingo game until one or more players have won
    public double play() {
	bingo = false;
	win = false;
	while ( !bingo ) {
	    go();
	}
	if ( win ) {
	    double retDouble;
	    retDouble = player0.getMultiplier() * (opponents.size() + 1) * bet;
	    System.out.println( "You won " + cn( retDouble ) + "!" );
	    return retDouble;
	}
	else {
	    System.out.println( "You lost " + cn( bet ) );
	    return -1 * bet;
	}
    }

    // plays one turn
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
	slp(1.0);
	// bingo = true;
    } // end go()

    // calls a letter and number for the players to mark on their cards
    public String call() {
	int range;
	String letters;
	String retStr;
	
	// rand int in interval [0, 5)
	letter = (int)( 5 * Math.random() );

	range = 25 * difficulty;
	// rand int in interval [1, range +1)
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
    } // end call()

    // for the end of a bingo game, after a player has won
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

    // ------------------------Helper Methods------------------------
    
    // for pausing between print statements
    public void slp(double x){
	x*=1000;
	long y= (long)x;
	try{
	    Thread.sleep(y);
	}
	catch(InterruptedException e){
	}
    }

    // for printing the quantity of money with two decimal places
    public String cn(double z){
	String x = ""+z;
	int indexDec=0;
	int space;

	for (int i=0; i < x.length()-1 ; i++){
	    if (x.substring(i,i+1).equals(".")){
		indexDec=i;
	    }
	}

	space=x.length()-indexDec-2;
	if (space < 2){
	    x+="0";
	}
	else{
	    x=x.substring(0,indexDec+4);

	}
	return "$" + x;
    }
    
    // --------------------------------------------------------------

    // main method for testing purposes
    public static void main( String[] args ) {
	Bingo japajoe;
	japajoe = new Bingo( "Kevin", 1, 50.0 );
	japajoe.play();
    }
} // end class Bingo
