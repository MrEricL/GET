import cs1.Keyboard;

public class Dice implements casinorules{

    private final int[] Dice = {1,2,3,4,5,6};
    private int[] Dice1 = new int[6];
    private int[] Dice2 = new int[6];
    private int face1, face2, guess1, guess2;
    private double money, bet;
    private boolean win = false;

    public Dice(double _money, double _bet){
	for (int index = 0; index < 6; index += 1){
	    Dice1[index] = Dice[index];
	    Dice2[index] = Dice[index];
	}
	face1 = 1;
	face2 = 1;
	money = _money;
	bet = _bet;
	
    }

    public void roll(){
	face1 = Dice1[(int)(Math.random() * 6)];
	face2 = Dice2[(int)(Math.random() * 6)];
    }

    public void check(){
	if (guess1 == face1 && guess2 == face2){
	    win = true;
	}
    }

    public void start(){
	System.out.println("Welcome to the Dice game!");
	System.out.print("Guess what dice 1 will roll: ");
	guess1 = Keyboard.readInt();
	while  (guess1 > 6 || guess1 < 0) {
	    System.out.println ("Invalid input, try again!");
	    System.out.print("Guess what dice 1 will roll: ");
	    guess1 = Keyboard.readInt();
	}
	System.out.print("Guess what dice 2 will roll: ");
	guess2 = Keyboard.readInt();
	while  (guess2 > 6 || guess2 < 0) {
	    System.out.println ("Invalid input, try again!");
	    System.out.print("Guess what dice 2 will roll: ");
	    guess2 = Keyboard.readInt();
	}
    }

    public double play(){
	System.out.println("Rolling..... ");
	roll();
	System.out.println("Here are your results : ");
	System.out.println("\tDice 1 : " + face1);
	System.out.println("\tDice 2 : " + face2);
	check();
	if (win){
	    System.out.println("Congrats you won!");
	    //money += bet;
	    bet *= 2;
	}
	else{
	    System.out.println("Better luck next time buddy");
	    //money -= bet;
	    bet = 0 - bet;
	}
	return bet;
    }

    public void go(){
	start();
	play();
    }

    public static void main(String[] args){
	Dice mike = new Dice(800, 40);
	mike.go();
    }

}
