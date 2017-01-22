import cs1.Keyboard;
import java.util.ArrayList;
public class keno  {

    //background stuff
    public int difficulty=1;
    public double  money;
    public double bet;
    //   public int[][] board = new int[8][10];
    public ArrayList <Integer> board = new ArrayList <Integer>();
    public ArrayList <Integer> board2 = new ArrayList <Integer>();
    public int times;
    public ArrayList <Integer> picks = new ArrayList <Integer>();
    public ArrayList <Integer> draws = new ArrayList <Integer>();
    
    public double win;

    public int correct=0;
    

    public keno(){
	play();
    }

    public keno (int x){
	difficulty=x;
    }

    public double  play(){
	start();
	enter();
	//	go();
	printnumb();
	printer(board);
	draw();
	fin();
	winnings();
	picked();
	System.out.print("You have selected " + times+" draws ");
	System.out.println("and have got "+ correct+" correct");
	System.out.println("You have won "+ cn(win));
	    
	return win;

    }

    public void start(){
	int time;
	System.out.println("\nHow many spots would you like to play (1-10)?\n");

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

	if (difficulty==1) start1();
	else if (difficulty==2) start2();
	else start3();
	printer(board);
    }


    public void start1(){
        int i=0;
	while (i < 30){
	    board.add(i+1);
	    i++;
	}
        int z=0;
	while (z < 30){
	    board2.add(z+1);
	    z++;
	}
    }
    public void start2(){
        int i=0;
	while (i < 60){
	    board.add(i+1);
	    i++;
	}
        int z=0;
	while (z < 60){
	    board2.add(z+1);
	    z++;
	}
    }
    public void start3(){
        int i=0;
	while (i < 80){
	    board.add(i+1);
	    i++;
	}
        int z=0;
	while (z < 80){
	    board2.add(z+1);
	    z++;
	}	
    }
    


    public void go(){
	int x;

	while (picks.size() < times){
	    printnumb();
	    System.out.println("What number would you like to pick?");
	    try{
		x= Keyboard.readInt();
		if (!check(x) || x < 1 || x > board.size() ){
		    sopln("Invalid input");
		    go();
		    return;
		}
		else{
		    picks.add(x);
		    board.set(x,0);
		}

	    }
	    catch (Exception e){
		System.out.println("Try again");
		go();
		return;
	    }	
	}

    }

    // printers ______________________________________________

    public void printnumb(){
	System.out.print("Your numbers:" );
	for (int x = 0 ; x < picks.size(); x++){
	    System.out.print(" "+picks.get(x));
	}
	System.out.println("\n");

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
	System.out.println("\n\nWould you like the computers to pick your numbers? (y/n)\n");

	try {
	    x=Keyboard.readWord();   
	    if (!x.equals("y") && !x.equals( "n")){
		System.out.println("Invalid input. Try again.");
		enter();
		return;
	    }

	    if (x.equals("y")) compenter();
	    else go();
	}
	catch (Exception e){
	    System.out.println("Error. Try again.\n\n");
	    enter();
	    return;
	}

    }

    public void compenter(){
	int x;

	for (int i=0; i < times; i++){
	    x = (int) (Math.random() *board.size());
	    if (check(x)){
		picks.add(x);
		board.set(x-1, 00);
	    }
	    else i--;
	}

    }

    public boolean check(int x){
	boolean bol = true;
	for (int i = 0 ; i < picks.size(); i++){
	    if (x == picks.get(i)){
	        bol = false;
		break;
	    }
	}
	return bol;
    }
    public boolean checkv2(int x){
	boolean bol = true;
	for (int i = 0 ; i < draws.size(); i++){
	    if (x == draws.get(i)){
	        bol = false;
		break;
	    }
	}
	return bol;
    }

    //drawing

    public void draw(){
	int i=0;
	int x;
	
	while (i < times){
	    x= (int)(Math.random() * board2.size());
	    
	    printball(board2.get(x));
	    draws.add( board2.get(x));
	    board2.remove(x);
	    i++;
	}

    }

    public void printball (int x){
	sopln("  * * ");
	sopln("*  "+x+"  *");
	sopln("   * * \n");	      
	slp(0.4);
    }

    public void fin (){
	int y=0;
	boolean bol;
	
	for (int i = 0; i < picks.size(); i ++){
	    bol = checkv2(picks.get(i));
	    if (!bol) y++;
	}
	correct=y;

    }

    public void picked(){

	System.out.print ("The balls that were picked are: ");
	for (int i=0; i < picks.size(); i++){
	    System.out.print(picks.get(i)+" ");
	}
	System.out.println();
    }

    // beyond lazy


    public void sop(String x){
	System.out.print(x);

    }

    public void sopln (String x){
	System.out.println(x);
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

    //helper function don't mind
	public void slp(double x){
	    x*=1000;
	    long y= (long)x;
	    try{
		Thread.sleep(y);
	    }
	    catch(InterruptedException e){
	    }
	}       

    public void winnings(){
	if (correct==1 && times==1) win=2.0;
	else if(correct ==2 && times==2) win = 10.0;
	else if(correct==3 && times==3) win=25.0;
	else if(correct==2 && times==3) win = 2;
	else if(times==4 && correct == 4) win=500.0;
	else if(times==4 && correct == 3)win=5.0;
	else if(times==4 && correct == 2)win=1.0;
	else if(times==5 && correct == 5)win=500.0;
	else if(times==5 && correct == 4)win=15.0;
	else if(times==5 && correct == 3)win=2;
	else if(times==6 && correct == 6)win=1500;
	else if(times==6 && correct == 5)win=50;
	else if(times==6 && correct == 4)win=5;
	else if(times==6 && correct == 3)win=1;
	else if(times==7 && correct == 7)win=5000;
	else if(times==7 && correct == 6)win=150;
	else if(times==7 && correct == 5)win=15;
	else if(times==7 && correct == 4)win=2;
	else if(times==7 && correct == 3)win=1;
	else if(times==8 && correct == 8)win=15000;
	else if(times==8 && correct == 7)win=400;
	else if(times==8 && correct == 6)win=50;
	else if(times==8 && correct == 5)win=10;
	else if(times==8 && correct == 4)win=2;
	else if(times==9 && correct == 9)win=25000;
	else if(times==9 && correct == 8)win=2500;
	else if(times==9 && correct == 7)win=200;
	else if(times==9 && correct == 6)win=25;
	else if(times==9 && correct == 5)win=4;
	else if(times==9 && correct == 4)win=1;
	else if(times==10 && correct == 10)win=200000;
	else if(times==10 && correct == 9)win=10000;
	else if(times==10 && correct == 8)win=500;
	else if(times==10 && correct == 7)win=50;
	else if(times==10 && correct == 6)win=10;
	else if(times==10 && correct == 5)win=3;
	else if(times==10 && correct == 0)win=3;
	else win=0;	
    }

    public static void main (String[] args){
	//	keno thing = new keno();


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
