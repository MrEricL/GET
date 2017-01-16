import cs1.Keyboard;
import java.util.ArrayList;
public class keno  {

    //background stuff
    public int difficulty;
    public double  money;
    public double bet;
    //   public int[][] board = new int[8][10];
    public ArrayList <Integer> board = new ArrayList <Integer>();
    public int times;
    public ArrayList <Integer> picks = new ArrayList <Integer>();

    public keno(){
	play();
    }

    public keno (int x, double  y, double z){
	difficulty=x;
	money=y;
	bet=z;
    }

    public void  play(){
	start();
	enter();
	go();

    }

    public void start(){
	int time;
	System.out.println("How many spots would you like to play (1-10)?");

	try{
	    time=Keyboard.readInt();

	    if (time < 1 || time > 10){

		System.out.println ("Try again");
		start();
		return;	    
	    }
	    else {
		times=time;
		System.out.println();
	    }	    
	}
	catch (Exception e){
	    System.out.println("Error. Try again.\n\n");
	    start();
	    return;
	}

        int i=0;
	while (i < 80){
	    board.add(i+1);
	    i++;
	}
	printer(board);
    }

    


    public void go(){
	System.out.println("What number would you like to pick?");

	while (picks.size() < times){

	}


    }

    // printers ______________________________________________

    public void printnumb(){
	System.out.print("Your numbers:" );
	for (int x = 0 ; x < picks.size(); x++){
	    System.out.print(" "+picks.get(x));
	}

    }

    public void printer(ArrayList<Integer> x) {
	System.out.println("\n\t\t\t\t--- Keno ---");	
	int i =0;
	int y=0;
	while (i < x.size()){
	    y=x.get(i);
	    if ( (y-1) % 10 == 0) System.out.println("\n");
	    if (y <10) System.out.print(" " + y+"\t");
	    else System.out.print(y+"\t");
	    i++;
	}
	System.out.println("\n");
	   
    }

    // enter functions

    public void enter(){
	String x;
	System.out.println("Would you like the computers to pick your numbers? (y/n)");

	try {
	    x=Keyboard.readWord();
	    if (x!= "y" || x!= "n"){
		System.out.println("Invalid input. Try again.");
		enter();
		return;
	    }
	}
	catch (Exception e){
	    System.out.println("Error. Try again.\n\n");
	    enter();
	    return;
	}

    }

    public void compenter(){
	


    }

    public boolean check(){



    }


    //actual pickings

    public void pick(){




    }


    public static void main (String[] args){
	keno thing = new keno();


    }

    /* 2D Array Junk

the board
	for (int i = 0; i < board.length; i++){
	    for (int x = 0; x < board[i].length; x++){
		board[i][x] = 1 + x + (10*i) ;
	    }	    
	    }

printing


	System.out.println("\n\t\t\t\t--- Keno ---\n\n");
	for (int i =0 ;i < x.length ; i++){
	    for (int y= 0 ; y < x[i].length ; y++){
		if (x[i][y] < 10) System.out.print (" "+ x[i][y] + "\t");
		else System.out.print (x[i][y] + "\t");
	    }
	    System.out.println();
	    System.out.println();	    
	}
     */



}
