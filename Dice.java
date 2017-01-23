import cs1.Keyboard;

public class Dice implements casinorules{

    private final int[] Dice = {1,2,3,4,5,6,7,8,9,10,11,12};
    private int[] Dice1;
    private int[] Dice2;
    private int face1, face2, guess1, guess2, difficulty;
    private double money, bet, winnings;
    private boolean win = false;
    private static final String reset = "\u001B[0m";
    private static final String red = "\u001B[31m";
    private static final String green = "\u001B[32m";

    public Dice(){
	money = 0;
	bet = 0;
	// Dice1 = new int[] {1, 1};
	// Dice2 = new int[] {2, 2};
	Dice1 = new int[] {1,2,3,4,5,6};
	Dice2 = new int[] {1,2,3,4,5,6};
    }

    public Dice(int diff, double _money, double _bet){
	difficulty = diff;
	Dice1 = new int[3 * (difficulty + 1)];
	Dice2 = new int[3 * (difficulty + 1)];
	for (int index = 0; index < (3 * (difficulty + 1)); index += 1){
	    Dice1[index] = Dice[index];
	    Dice2[index] = Dice[index];
	}
	face1 = 1;
	face2 = 1;
	money = _money;
	bet = _bet;
	
    }

    public void roll(){
	face1 = Dice1[(int)(Math.random() * Dice1.length)];
	face2 = Dice2[(int)(Math.random() * Dice2.length)];
    }

    public void check(){
	if (guess1 == face1 && guess2 == face2){
	    win = true;
	}
	else if (guess1 == face2 && guess2 == face1){
	    win = true;
	}
    }
	
    public void start(){
	System.out.println("Welcome to the Dice game!");
	System.out.print("Guess what one die will roll: ");
	guess1 = Keyboard.readInt();
	while  (guess1 > Dice1.length || guess1 < 0) {
	    System.out.println ("Invalid input, try again!");
	    System.out.print("Guess what one die will roll: ");
	    guess1 = Keyboard.readInt();
	}
	System.out.print("Guess what the other die will roll: ");
	guess2 = Keyboard.readInt();
	while  (guess2 > Dice2.length || guess2 < 0) {
	    System.out.println ("Invalid input, try again!");
	    System.out.print("Guess what the other die will roll: ");
	    guess2 = Keyboard.readInt();
	}
    }

    public void go(){
	System.out.println("Rolling..... ");
	roll();
	System.out.println("You rolled a " + face1 + " and a " + face2 + "!");
	check();
	if (win){
	    System.out.println(green + "Congrats you won!" + reset);
	    bet *= 2;
	}
	else{
	    System.out.println(red + "Better luck next time buddy" + reset);
	    bet = 0 - bet;
	}
	System.out.println("bet : " + bet);
    }

    public double play(){
	start();
	go();
	System.out.print("Care for another roll? Y or N? ");
	String ans = Keyboard.readString().toUpperCase();
	while(!ans.equals("Y") && !ans.equals("N")){
	    System.out.println("Please type Y or N.");
	    System.out.print("Care for another roll? Y or N? ");
	    ans = Keyboard.readWord().toUpperCase();
	}
	if (ans.equals("Y")){
	    money += bet;
	    System.out.println("You currently have " + cn(money));
	    if (money > 0){
		System.out.print("How much will you be betting? ");
		double newBet = Keyboard.readDouble();
		while (newBet > money){
		    System.out.println("You don't have that kind of money!!");
		    System.out.println("You currently have " + cn(money));
		    System.out.print("How much will you be betting? ");
		    newBet = Keyboard.readDouble();
		}
		Dice newPlay = new Dice(difficulty, money, bet);
		bet += newPlay.play();
	    }
	    else{
		System.out.println("I don't think you have any money left!");
	    }
	    return bet;
	}
	else{
	    System.out.println("Best of luck in your endeavors!");
	    return bet;
	}
    }

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
	    x=x.substring(0,indexDec+4);

	}
	return "$" + x;
    }

    //tester
    public static void main(String[] args){
	Dice mike = new Dice(3, 10, 1);
	mike.play();
    }

}
