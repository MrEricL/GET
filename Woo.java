import cs1.Keyboard;

public class Woo{

    public int difficulty;
    public double money;
    public double bet;
    public String name;
    public boolean cont;

    /*    public void editN(String n){
	name = n;}
    public void editD(int d){
    difficulty = d;}*/

    public Woo(){
	begin();
	mon();
	diff();
	while (money>0 || money >= 1000000){
	    selection();
	}
	System.out.println("You have lost your life savings. " +
			   "You can no longer afford treatment.\n " +
			   "Your game has ended");
	
    }

    
    public void begin(){
	
	System.out.println ("\nYou are ?");
	System.out.println ("(Type your first name)\n");
        name = Keyboard.readWord();
	System.out.println ("\n\nNice you meet you " + name);
	//	slp(1.5);
	System.out.println ("\nYou unfortunately contracted a deathly illness in the jungles of Zambia");
	//	slp(3);
	System.out.println ("Your doctor tells you about a rare and expensive treatment");
	//	slp(2.7);
	System.out.println ("But you don't have anything but the stack of bills under your couch");   
	//	slp(3.2);
	System.out.println ("You don't have any family and since the 2008 crisis you don't trust banks");	
	//	slp(3.5);
	System.out.println ("You're at your wit's end and you decide to go to test your luck at a casino");
	//	slp(2);
	System.out.println("You will gamble your entire lifes saving tonight");
	//	slp(4);
	
    }

    public void diff(){
	System.out.println("\n\nPlease select your difficulty\n1. Easy\n2. Medium\n3. Difficult\n");
	try {
	    difficulty=Keyboard.readInt();
	}
	catch (Exception e){
	    System.out.println("\n Try again\n\n\n");
	    diff();}
	if (difficulty< 1 || difficulty > 3){
	    System.out.println("\n Try again with a valid number\n\n\n");
	    diff();
	    return;
	}
	if (difficulty==1) System.out.println("\nShould I get the baby it's rattle?\n\n");
	else if (difficulty==2) System.out.println("\nThis will emulate real life \nand you will lose\n\n");
	else System.out.println("\nWhat do you want on your tombstone?\n\n");
    }

    public void mon () {
	System.out.println("\n\nHow much money would you like to start with?");	
	System.out.println("Your game  will end when you hit your $1mil goal or when you've  spent all your money");
	System.out.println("(Hit 0 for default amount of 10k)");
         money=Keyboard.readDouble();
	if (money==0) money = 10000.00;
	if (money >= 700000) {
	    System.out.println("\nYa sure you broke?\n");
	    mon();
	    return;
	}
	
	
    }

    public void bet(){
	System.out.println("\nHow much money would you like to bet?");
	System.out.println("\n(You can bet as much as you have)");
	try{
	    bet=Keyboard.readDouble();
	    if (bet > money){
		System.out.println("Ya broke. Enter an amount within the money you have");
		bet();
		return;
	    }
	    if (bet==0){
		System.out.println("Ya gotta bet somethin'");
		bet();
		return;
	    }
	}
	catch(Exception e){
	    System.out.println("Try again!!!\n\n\n");
	    bet();
	    return;		
	}
	    
	    
    }

    public void selection(){
	int select=0;
	int blackjackPlay=0; //adds the instructions
	int dicePlay=0;
	System.out.println("You have $" + money);
	System.out.println("\nWhat game would you like to play?\n1. Blackjacks\n2. Dice");
	select= Keyboard.readInt();
	if (select==1){
	    if (blackjackPlay==0){
		System.out.println("The instructions will only appear once so read it carefully");
		blackjackInstruct();
		blackjackPlay+=1;
	    }
	    bet();
	    blackjack game = new blackjack(difficulty, money,bet);
	    money+=game.play();
	}
	if (select == 2){
	    if (dicePlay==0){
		System.out.println("The instructions will only appear once so read it carefully");
	        diceInstruct();
		dicePlay+=1;
	    }	    
	    bet();
	    Dice game2 = new Dice(difficulty,money,bet);
	    money += game2.play();
	}
        else{
	    System.out.println("Invalid input");
	    selection();
	    return;
	}
    }
	//HELPER FUNCTIONS------------------------------------------------------------------------------
	//pauses the print statements by seconds
	public void slp(double x){
	    x*=1000;
	    long y= (long)x;
	    try{
		Thread.sleep(y);
	    }
	    catch(InterruptedException e){
	    }
	}

       
	//---------------------------------------------------------------------------------------------------------------

    /*
      HOW TO WRITE INSTRUCTIONS
      public void gamenameInstruct(){
      	System.out.println("");
	if (difficulty==1){
	System.out.println("");
	}
	if (difficulty==2){
	System.out.println("");
	}
	if (difficulty==3){
	System.out.println("");
	}
	slp(time);
      }

     */

    //INSTRUCTIONS
    public void blackjackInstruct(){
	System.out.println ("Blackjack is a classic casino card game.");
	    System.out.println ("Your goal to to get a total of 21");
	System.out.println ("Suits don't matter and JACK/QUEEN/KING/ACE are all worth 10");
	    System.out.println ("The game will stop when you don't want to get hit or when your hand is too large");
	System.out.println("If you win your prize money depends on the other winners");
	System.out.println("If only you win you get your bet by six fold more, or if everyone wins, you get your bet amount");	    	
	    if (difficulty==1){
		System.out.println ("You are in easy mode: the game will only use one deck");
		System.out.println ("The bots are extremely simple and will likely fail");

	    }
	    if (difficulty==2){
		System.out.println ("You are in medium mode: the game will use six decks");
		System.out.println ("The bots will use basic logic and calculations to make their choice");		
	    }
	    if (difficulty==3){
		System.out.println ("You are in hard  mode: the game will use six deck");
		System.out.println ("The bots have seeming omniscience and will likely win");		
	    }
	    slp(10);
    }

    public void diceInstruct(){
	System.out.println("Dice is a very simple game");
	System.out.println("Simply guess two values");	
	System.out.println("Two fair die will be rolled");
	System.out.println("The game then ends depending on whether you get it correct or not");
	System.out.println("If you win, your bet is doubled");	
	if (difficulty==1){
	    System.out.println("The faces' values range between 1 and 6");
	}
	if (difficulty==2){
	    System.out.println("The faces' values range between 1 and 9");
	}
	if (difficulty==3){
	    System.out.println("The faces' values range between 1 and 12");
	}
	slp(6);
    }

    
	//---------------------------------------------------------------------------------------------------------------

    public static void main (String[] args){
	Woo play = new Woo();


    }



}
