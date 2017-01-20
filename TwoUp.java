import cs1.Keyboard;

public class TwoUp{

    private final String[] Coin1 = new String[] {"heads", "tails"};
    private final String[] Coin2 = new String[] {"heads", "tails"};
    private double money, bet;
    private String C1, C2;
    private int ans;

    public TwoUp(double _money, double _bet){
	money = _money;
	bet = _bet;
    }

    public void toss(){
	int c1 = (int)(Math.random() * 2);
	int c2 = (int)(Math.random() * 2);
	C1 = Coin1[c1];
	C2 = Coin2[c2];
    }

    /* same = true */
    public boolean check(){
	if (C1.equals(C2)){ return true; }
	else{ return false; }
    }

    /* 2 heads/tails = true */
    public boolean checkSame( String str ){
        if (C1.equals(str) && check()){ return true; }
	else{ return false; }
    }

    /* Opposites = true */
    public boolean checkOpp(){
	if (check()){ return false; }
	else{ return true; }
    }
    
    /* bet 1:1 */
    public void SingleHead(){
	System.out.println("Tossing... ");
	toss();
	System.out.println("You got the following:");
	System.out.println("\tCoin 1: " + C1);
	System.out.println("\tCoin 2: " + C2);
        if (checkSame("heads")){
	    System.out.println("Two Heads! Keep going!");
	    System.out.println("Tossing... ");
	    toss();
	    System.out.println("You got the following:");
	    System.out.println("\tCoin 1: " + C1);
	    System.out.println("\tCoin 2: " + C2);
	    if(checkSame("tails") || checkOpp()){
		System.out.println("Single Head win!");
	    }
	    else{
		System.out.println("Single Head loss. Better luck next time!");
		bet = 0 - bet;
	    }
	}
	else{
	    System.out.println("Single Head loss. Better luck next time!");
	    bet = 0 - bet;
	}
    }

    /* bet 1:1 */
    public void SingleTail(){
	System.out.println("Tossing... ");
	toss();
	System.out.println("You got the following:");
	System.out.println("\tCoin 1: " + C1);
	System.out.println("\tCoin 2: " + C2);
        if (checkSame("tails")){
	    System.out.println("Two Tails! Keep going!");
	    System.out.println("Tossing... ");
	    toss();
	    System.out.println("You got the following:");
	    System.out.println("\tCoin 1: " + C1);
	    System.out.println("\tCoin 2: " + C2);
	    if(checkSame("heads") || checkOpp()){
		System.out.println("Single Tail win!");
	    }
	    else{
		System.out.println("Single Tail loss. Better luck next time!");
		bet = 0-bet;
	    }
	}
	else{
	    System.out.println("Single Tail loss. Better luck next time!");
	    bet = 0-bet;
	}
    }

    /* bet 15:2
       Spin three heads or three tails*/
    public void SpinnersBet(){
	int counter = 0;
	boolean same = false;
	String face;
	System.out.println("Tossing... ");
	toss();
	System.out.println("You got the following:");
	System.out.println("\tCoin 1: " + C1);
	System.out.println("\tCoin 2: " + C2);
	same = check();
	if(same){
	    face = C1;
	    counter = 1;
	    while (counter < 3){
		System.out.println("Tossing... ");
		toss();
		System.out.println("You got the following:");
		System.out.println("\tCoin 1: " + C1);
		System.out.println("\tCoin 2: " + C2);
		same = check();
		if (!same){
		    counter = 3;
		    System.out.println("Loss!");
		    bet = 0 - bet;
		}
		counter += 1;
	    }
	}
	else{
	    System.out.println("Loss!");
	    bet = 0 - bet;
	}
	if(same){
	    System.out.println("Win!");
	    bet *= 7.5;
	}
    }
    
    /* bet 28:1
       Spin 5 odds in a row */
    public void FiveOdds(){
	int counter = 0;
	boolean opp = true;
	while (counter < 5){
	    System.out.println("Tossing... ");
	    toss();
	    System.out.println("You got the following:");
	    System.out.println("\tCoin 1: " + C1);
	    System.out.println("\tCoin 2: " + C2);
	    opp = checkOpp();
	    if (opp){ counter += 1; }
	    else{ counter = 5; }
	}
        if (opp){
	    System.out.println("Tossing... ");
	    toss();
	    System.out.println("You got the following:");
	    System.out.println("\tCoin 1: " + C1);
	    System.out.println("\tCoin 2: " + C2);
	    if(check()){
		System.out.println("Win!!");
		bet *= 28;
	    }
	    else{
		System.out.println("Loss :( ");
		bet = 0 - bet;
	    }
	}
	else{
	    System.out.println("Loss :( ");
	    bet = 0 - bet;
	}
    }

    public void start(){
	System.out.println("Come in spinner!");
	System.out.println("Choose your bet:");
	System.out.println("\t1. Single Head");
	System.out.println("\t2. Single Tail");
	System.out.println("\t3. Spinner's Bet");
	System.out.println("\t4. Five Odds");
	System.out.print("Your choice: ");
	ans = Keyboard.readInt();
    }

    public void go(){
	if (ans == 1){ SingleHead(); }
	else if (ans == 2){ SingleTail(); }
	else if (ans == 3){ SpinnersBet(); }
	else if (ans == 4){ FiveOdds(); }
    }

    public double play(){
	start();
	go();
	System.out.print("Would you like to continue playing? y or n? ");
	String response = Keyboard.readString().toUpperCase();
	while(!response.equals("Y") && !response.equals("N")){
	    System.out.println("Please type Y or N.");
	    System.out.print("Would you like to continue playing? Y or N? ");
	    response = Keyboard.readWord().toUpperCase();
	}
	if(response.equals("Y")){
	    money += bet;
	    System.out.println("You currently have " + money);
	    if (money > 0){
		System.out.print("How much will you be betting? ");
		double newBet = Keyboard.readDouble();
		while (newBet > money){
		    System.out.println("You don't have that kind of money!!");
		    System.out.println("You currently have " + money);
		    System.out.print("How much will you be betting? ");
		    newBet = Keyboard.readDouble();
		}
		TwoUp player = new TwoUp(money,newBet);
		System.out.print("Well then without further ado, ");
		bet += player.play();
	    }
	    else{
		System.out.println("I don't think you have any money left!");
		System.out.println("Sorry mate, you're not playing any more today!");
	    }
	}
	else{
	    System.out.println("Best of luck on all your endeavors!");
	}
	return bet;
    }

    public static void main(String[] args){
	TwoUp player = new TwoUp(100, 10);
	player.play();
    }
}
