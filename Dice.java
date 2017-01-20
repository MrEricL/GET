import cs1.Keyboard;

public class Dice implements casinorules{

    private final int[] Dice = {1,2,3,4,5,6,7,8,9,10,11,12};
    private int[] Dice1;
    private int[] Dice2;
    private int face1, face2, guess1, guess2, difficulty;
    private double money, bet, winnings;
    private boolean win = false;

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
	// System.out.println("Here are your results : ");
	// System.out.println("\tDice 1 : " + face1);
	// System.out.println("\tDice 2 : " + face2);
	System.out.println("You rolled a " + face1 + " and a " + face2 + "!");
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
	    winnings = bet;
	    money += bet;
	    System.out.println("You currently have " + money);
	    if (money > 0){
		System.out.print("How much will you be betting? ");
		bet = Keyboard.readDouble();
		while (bet > money){
		    System.out.println("You don't have that kind of money!!");
		    System.out.println("You currently have " + money);
		    System.out.print("How much will you be betting? ");
		    bet = Keyboard.readDouble();
		}
		Dice newPlay = new Dice(difficulty, money, bet);
		winnings += newPlay.play();
		System.out.println("winnings : " + winnings);
	    }
	    else{
		System.out.println("I don't think you have any money left!");
	    }
	    return winnings;
	}
	else{
	    System.out.println("Best of luck in your endeavors!");
	    return bet;
	}
    }

    //tester
    public static void main(String[] args){
	Dice mike = new Dice(3, 10, 1);
	mike.play();
    }

}
