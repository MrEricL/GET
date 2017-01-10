import cs1.Keyboard;

public class woo{

    public int difficulty;
    public double money;
    public String name;
    public boolean cont;

    /*    public void editN(String n){
	name = n;}
    public void editD(int d){
    difficulty = d;}*/

    public woo(){
	cont=true;
	begin();
	mon();
	diff();
	while (cont){
	    selection();
	}
	
    }

    
    public void begin(){
	
	System.out.println ("\n\nYou are ?");
	try {
	    name = Keyboard.readWord();
	}
	catch (Exception e) {
	    System.out.println("\n Try again");
	    begin();
	    return;
	    }
	System.out.println ("Nice you meet you " + name);
	System.out.println ("\nYou unfortunately contracted a deathly illness in the jungles of Zambia");
	System.out.println ("Your doctor tells you about a rare and expensive treatment");   
	System.out.println ("But you don't have any family and since the 2008 crisis and healthcare was removed");	
	System.out.println ("You're at your wits end and you decide to go to test your luck at a casino");
	System.out.println("You will gamble your entire lifes saving tonight");
	
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
	else if (difficulty==2) System.out.println("\nThis will emulate real life \n and you will lose\n\n");
	else System.out.println("\nWhat do you want on your tombstone?\n\n");
    }

    public void mon () {
	System.out.println("\n\nHow much money would you like to start with?");	
	System.out.println("Your game  will end when you hit your $1mil goal or when you've  spent all your money");
	System.out.println("(Hit 0 for default amount of 10k)");
	try {
	    money=Keyboard.readDouble();
	}
	catch(Exception e) {
	    mon();
	    return;
	}
	if (money==0) money = 10000;
	if (money >= 700000) {
	    System.out.println("/nYa sure you broke?/n");
	    mon();
	    return;
	}
	
	
    }

    public void selection(){
	int select=0;
	System.out.println("\nWhat game would you like to play?\n1. Blackjacks");
	try{
	    select= Keyboard.readInt();
	}
	catch(Exception e){
	    System.out.println("Please try again!");
	    selection();
	}
	if (select!= 1) {
	    System.out.println("Invalid input");
	    selection();
	    return;
	}
	if (select==1){
	    blackjack game1  = new blackjack(difficulty, money);
	    game1.play();
	}
	

    }

    


    public static void main (String[] args){
	woo play = new woo();


    }



}
