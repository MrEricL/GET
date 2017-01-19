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
	    }
	}
	else{
	    System.out.println("Single Head loss. Better luck next time!");
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
	    System.out.println("Win!!");
	    bet += 28;
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
	int ans = Keyboard.readInt();
    }

    public void go(){
	if (ans == 1){ SingleHead(); }
	else if (ans == 2){ SingleTail(); }
	else if (ans == 3){ SpinnersBet(); }
	else{ FiveOdds(); }
    }

    public double play(){
	start();
	go();
	return bet;
    }
}
