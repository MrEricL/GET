import cs1.Keyboard;


//DO TRY CATCH MORE MONEY


public class Woo{

    public int difficulty;
    public double money;
    public double bet;
    public String name;
    public boolean cont;

    private int blackjackPlay = 0;
    private int dicePlay = 0;
    private int slotsPlay = 0;
    private int TwoUpPlay = 0;
    private int kenoPlay=0;
    private int warPlay=0;
    private int bingoPlay=0;

    public int eventChance=0;

    private int playTotal=0;
    private int playChance;


    public Woo(){
	begin();
	mon();
	diff();
	while (money>0 &&  money <= 1000000){
	    eventChance=(int)(Math.random()*100);
	    if (eventChance >= (80-playChance*7) || playChance > 7){

		event(); // EVENT METHOD NEEDS TO BE ADDED

		playChance-=1;
	    }
	    else{
		selection();
		playTotal+=1;
		playChance+=1;
	    }
	}
	if (money<=0) {
	System.out.println("\n\n\n\n\n\n\n\n+++++++END+++++++\n\nYou have lost your life savings. " +
			   "You can no longer afford treatment.\n" +
			   "Your game has ended\n\n\n\n\n\n\n\n\n\n\n");
	}
	else System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t\t........END........\n\n\n"+
				"You win! You won't go sick! \nOn your way to the hospital you got hit by a car!\n\n\n\n\t\t\t"+
				"\t\t\t~~~~FIN~~~~\n\n\n\n\n\n\n");
    }
 
    public void begin(){
	System.out.println("\n\t\tDo Ya Feel Lucky? The Terminal Casino Adventure\n");
	System.out.println ("\nYou are ?\n");
	//	System.out.println ("(Type your first name)\n");
        name = Keyboard.readString();
	System.out.println ("\n\nNice you meet you " + name);
	//	slp(1.5);
	System.out.println ("\nYou have unfortunately contracted a deathly illness.");
	//	slp(3);
	System.out.println ("Your doctor tells you about a rare and expensive treatment.");
	//	slp(2.7);
	System.out.println ("However you cannot afford it. It cost $1 million for one dose.");
	//	slp(2.7);
	System.out.println ("You don't have anything but that stack of bills under your bed.");   
	//	slp(3.2);
	System.out.println ("Due to a multiple incidents involving credit card fraud, the bank and insurance isn't help you.");	
	//	slp(3.5);
	System.out.println ("You're at your wit's end and you decide to go to test your luck at a casino.");
	//	slp(2);
	System.out.println("You will gamble your entire lifes saving tonight.\n\n\n\n");
	//	slp(4);
	
    }

    public void diff(){
	System.out.println("\n\nPlease select your difficulty\n1. Easy\n2. Medium\n3. Difficult\n");
	try {
	    difficulty=Keyboard.readInt();
	}
	catch (Exception e){
	    System.out.println("\nTry again\n\n\n");
	    diff();
	    return;
	}
	if (difficulty< 1 || difficulty > 3){
	    System.out.println("\nTry again with a valid number\n\n\n");
	    diff();
	    return;
	}
	if (difficulty==1) System.out.println("\nEasy mode? Should I get the baby it's rattle?\n\n");
	else if (difficulty==2) System.out.println("\nMedium mode? This will emulate real life \nand you will lose\n\n");
	else System.out.println("\nHard mode? What do you want on your tombstone?\n\n");
	slp(2.5);
    }

    public void mon () {
	System.out.println("\n\nHow much money would you like to start with?");	
	System.out.println("Your game  will end when you hit your $1mil goal or when you've  spent all your money.");
	System.out.println("(Hit 0 for default amount of $10k)\n");

	try{
         money=Keyboard.readDouble();
	}
	catch(Exception e){
	    System.out.println("\nTry again with a valid amount\n\n\n");
	    mon();
	    return;
	}
	if (money==0) money = 10000.00;
	if (money >= 700000) {
	    System.out.println("\nYa sure you broke?\n");
	    mon();
	    return;
	}
	if (!(money > 0) && !(money < 700000)){
	    System.out.println("\nTry again with a valid amount\n\n\n");
	    mon();
	    return;
	}
	
	
    }

    public void bet(){
	System.out.println("\n\n_______Bet_______");
	if (playTotal <1){
	    System.out.println("\nHow much money would you like to bet?");
	    System.out.println("(You can bet as much as you have)\n");
	}
	else{
	    System.out.print("Amount: ");
	}
	try{
	    bet=Keyboard.readDouble();
	    if (bet > money){
		System.out.println("Ya broke. Enter a bet within the money you have\n");
		bet();
		return;
	    }
	    if (bet==0){
		System.out.println("Ya gotta bet somethin'\n");
		bet();
		return;
	    }
	}
	catch(Exception e){
	    System.out.println("\n Try again with a valid amount\n\n\n");
	    bet();
	    return;		
	}	    
	    
    }

    public void selection(){
	int select=0;
	int blackjackPlay=0; //adds the instructions
	int dicePlay=0;
	int slotsPlay = 0;
	int diff;
	System.out.println("\n\n---------Selection---------\n");
	System.out.println("You have" + cn(money));
	System.out.println("\nWhat game would you like to play?\n1. Blackjack\n2. Dice" +
			   "\n3. Slots\n4. War\n5. Keno\n6. Bingo\n7. Two-Up");
	System.out.println("(To change the difficulty enter 100) \n\n WARNING - Bingo takes quite a while to run.\n\n");
	System.out.print("Your choice : ");
	try{
	    select= Keyboard.readInt();}
	catch (Exception e){
	    System.out.println("Try again\n");
	    selection();
	    return;
	}
	if (select==1){
	    if (blackjackPlay<1){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
		blackjackInstruct();
	    }
	    blackjackPlay+=1;
	    bet();
	    blackjack game = new blackjack(difficulty, money,bet);
	    money+=game.play();
	}
	else if (select == 2){
	    if (dicePlay==0){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
	        diceInstruct();
	    }
	    dicePlay+=1;
	    bet();
	    Dice game2 = new Dice(difficulty,money,bet);
	    money += game2.play();
	}
	else if (select == 3){
	    if(slotsPlay == 0){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
		slotsInstruct();;
	    }
	    slotsPlay = 1;
	    bet();
	    Slots game3 = new Slots(difficulty, money, bet);
	    money += game3.play();
	}
	else if (select ==4){
	    bet();
	    if (warPlay==0){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
	        warInstruct();
	    }	    
	    war game4= new war(difficulty, money, bet);
	    money+=game4.play();
	}
	else if (select==5){
	    money-=1;
	    if (kenoPlay==0){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
	        kenoInstruct();
	    }	    
	    keno game5= new keno(difficulty);
	    money+=game5.play();
	}
	else if ( select == 6 ) {
	    if (bingoPlay==0){
		System.out.println("\nThe instructions will only appear once so read it carefully");
		slp(1.5);
	        bingoInstruct();
	    }
	    bet();
	    Bingo game6 = new Bingo( name, difficulty, bet );
	    money += game6.play();
	}
	else if ( select == 7 ){
	    bet();
	    if ( TwoUpPlay == 0 ) {
		System.out.println( "The instructions will only appear once so read it carefully" );
		slp(1.5);
		TwoUpInstruct();
	    }
	    TwoUpPlay += 1;
	    TwoUp game7 = new TwoUp(money, bet);
	    money += game7.play();
	}
	else if (select==100){
	    diff();
	    System.out.println("The difficulty is changed");
	    selection();
	    return;
	    
	}
	else if (select==1000){
	    System.out.println("Cheat");
	    money+=1000000;
	    selection();
	    return;
	    
	}

	else if (select == 55){
	    System.out.println("Test\n\n\n");
	    playChance=9;
	    return;
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

    public String slpS(double x){
	slp(x);
	return "";

    }

       
	//-----------------------------------------------------------------------------------------------------

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
	    System.out.println ("\n\nYour goal to to get a total of 21.");
	    slp(2.5);
	System.out.println ("Suits don't matter and JACK/QUEEN/KING are all worth 10.");
	slp(3);
	System.out.println("You decide if an ACE is either worth 1 or 11.");
	slp(3);
	    System.out.println ("The game will stop when you don't want to get hit or when your hand is too large.");
	    slp(2.5);

	    
	    if (difficulty==1){
		System.out.println ("\nYou are in easy mode: the game will only use one deck.");
		System.out.println ("The bots are extremely simple and will mainly guess.\n\n");
		slp(3);

	    }
	    if (difficulty==2){
		System.out.println ("\nYou are in medium mode: the game will use six decks");
		System.out.println ("The bots will use basic logic and calculations to make their choice.\n\n");
		slp(3);
	    }
	    if (difficulty==3){
		System.out.println ("You are in hard  mode: the game will use six deck.");
		System.out.println ("The bots are very sophisticated and will almost always win.\n\n");
		slp(3);
	    }
	    slp(2);
    }

    public void diceInstruct(){
	System.out.println("\n\nAttempt to guess what two dices will land one.\n");	
	slp(1.5);
	if (difficulty==1){
	    System.out.println("The faces' values range between 1 and 6\n\n");
	}
	if (difficulty==2){
	    System.out.println("The faces' values range between 1 and 9\n\n");
	}
	if (difficulty==3){
	    System.out.println("The faces' values range between 1 and 12\n\n");
	}
	slp(3);
    }

    public void warInstruct(){

	System.out.println("\nWhen there is a tie, simply choose one of three options.");
	slp(2.5);
	System.out.println("The amount of decks will vary, depending on difficulty from 1-6\n\n");
	slp(2.5);

    }
    public void slotsInstruct(){
	System.out.println("\nSpin the slots to get three values.");
	slp(2);
	System.out.println("Depending on what you spin, you win certain amounts.\n\n");
	slp(2.5);	
    }

    public void kenoInstruct(){
	System.out.println("\nSelect a certain amount of numbers of picks.");
	slp(2.5);
	System.out.println("Depending on how many you pick and if they are correct, you win certain amounts.\n\n");
	slp(2.5);	
    }
    
    public void TwoUpInstruct(){
	System.out.print("\nTwo-Up is a coin toss game. Bets are placed on ");
	slp(2.5);
	System.out.println("each coin toss.\n\n");
	slp(2);	
    }

    public void bingoInstruct(){
	System.out.println("\nYou do not have to do anything. Simply wait for someone to get bingo.");
	System.out.println("The amount of opponents vary, but the higher the difficulty, the greater the number opponents.\n\n");
	slp(2.5);	
	    
    }




    public void event(){
	int x= (int)(Math.random()*100);
	String z;
	if (x >= 50){
	    System.out.println("\n\nYour illness grows worse...");
	    slp(2);
	    System.out.println("\nYou are struck by a blinding headache.");	    
	    System.out.println("Your difficulty level has fluctuated.\n\n\n");
	    difficulty=3;	    
	}
	else{
	    double y = (Math.random()*money/2);
	    for (int i = 0; i < 75; i++){
		System.out.println("█████████████████████████████████████████████████████████████████████");
		slp(0.01);
	    }
	    System.out.println("You blacked out from your illness. You were pickpocketed. You lost around" + cn(y)+".\n\n\n\n");
	    money-=y;
			       
	}
    }

    //Money printing function
    public String cn(double z){
	String x = "" + z;
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
	    x=x.substring(0,indexDec+3);

	}
	return " $" + x;
    }

    
	//---------------------------------------------------------------------------------------------------------------

    public static void main (String[] args){
	Woo play = new Woo();


    }



}
