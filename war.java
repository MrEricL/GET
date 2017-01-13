import java.util.ArrayList;
import cs1.Keyboard;

public class war implements casinorules{

    public ArrayList<String> deck= new ArrayList<String>();   
    //background stuff
    public int difficulty;
    public double  money;
    public double bet;

    public double winnings=0;
    public int turns;

    //overloaded construct

    public war (int x, double y, double z){
	difficulty=x;
	money=y;
	bet=z;
    }

    //runs---------------------------------------------------------
    

    public double  play(){
	start();
	if (difficulty==1) startez();
	else starthard();
	go();
	System.out.println("Total winnings: $"+ winnings);
	System.out.println("\n\n\n");
	return winnings;	
    }
    //------------------------------------------------------------

    
    //start_________________________________________________________
    public void start(){
	int times=0;
	System.out.println("Casino war is very short. How many times would you like to play");
	try {
	    times=Keyboard.readInt();
	    turns=times;
	    bet/=(turns*1.00);
	}
	catch(Exception e){
	    System.out.println("Try again!\n");
	    start();
	    return;	
	}
	
    }
    
    public void startez(){
	int x=2;
	int y=0;
	while (x < 11){
	    for (int i=0; i < 4; i++){		
		if (i%4.0 == 0) deck.add(y+i,""+x+"♦");
		if (i%4.0==1) deck.add(y+i,""+x+"♣");
		if (i%4.0==2) deck.add(y+i,""+x+"♥");
		if (i%4.0==3) deck.add( y+i, ""+x+"♠");
	    }
	    x+=1;
	    y+=4;
	}
	while (x<15){
	    if (x==11){
		for (int i=0; i < 4; i++){
		    if (i%4.0 == 0) deck.add(y+i,"JACK♦");
		    if (i%4.0==1) deck.add(y+i,"JACK♣");
		    if (i%4.0==2) deck.add(y+i,"JACK♥");
		    if (i%4.0==3) deck.add( y+i, "JACK♠");
		}	
	    }
	    if (x==12){
		for (int i=0; i < 4; i++){
		    if (i%4.0 == 0) deck.add(y+i,"QUEEN♦");
		    if (i%4.0==1) deck.add(y+i,"QUEEN♣");
		    if (i%4.0==2) deck.add(y+i,"QUEEN♥");
		    if (i%4.0==3) deck.add( y+i, "QUEEN♠");
		}	
	    }
	    if (x==13){
		for (int i=0; i < 4; i++){
		    if (i%4.0 == 0) deck.add(y+i,"KING♦");
		    if (i%4.0==1) deck.add(y+i,"KING♣");
		    if (i%4.0==2) deck.add(y+i,"KING♥");
		    if (i%4.0==3) deck.add( y+i, "KING♠");
		}	
	    }	    

	    if (x==14){
		for (int i=0; i < 4; i++){
		    if (i%4.0 == 0) deck.add(y+i,"ACE♦");
		    if (i%4.0==1) deck.add(y+i,"ACE♣");
		    if (i%4.0==2) deck.add(y+i,"ACE♥");
		    if (i%4.0==3) deck.add( y+i, "ACE♠");
		}	
	    }
	    x+=1;
	    y+=4;
	}
    }

    public void starthard(){
	int x=2;
	int y=0;

	while (x < 11){
	    for (int i=0; i < 24; i++){
		
		if (i%4.0 == 0) deck.add(y+i,""+x+"♦");
		if (i%4.0==1) deck.add(y+i,""+x+"♣");
		if (i%4.0==2) deck.add(y+i,""+x+"♥");
		if (i%4.0==3) deck.add( y+i, ""+x+"♠");
	    }
	    x+=1;
	    y+=24;
	}
	while (x<15){
	    if (x==11){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck.add(y+i,"JACK♦");
		    if (i%4.0==1) deck.add(y+i,"JACK♣");
		    if (i%4.0==2) deck.add(y+i,"JACK♥");
		    if (i%4.0==3) deck.add( y+i, "JACK♠");
		}	
	    }
	    if (x==12){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck.add(y+i,"QUEEN♦");
		    if (i%4.0==1) deck.add(y+i,"QUEEN♣");
		    if (i%4.0==2) deck.add(y+i,"QUEEN♥");
		    if (i%4.0==3) deck.add( y+i, "QUEEN♠");
		}	
	    }
	    if (x==13){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck.add(y+i,"KING♦");
		    if (i%4.0==1) deck.add(y+i,"KING♣");
		    if (i%4.0==2) deck.add(y+i,"KING♥");
		    if (i%4.0==3) deck.add( y+i, "KING♠");
		}	
	    }	    
	    if (x==14){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck.add(y+i,"ACE♦");
		    if (i%4.0==1) deck.add(y+i,"ACE♣");
		    if (i%4.0==2) deck.add(y+i,"ACE♥");
		    if (i%4.0==3) deck.add( y+i, "ACE♠");
		}	
	    }
	    x+=1;
	    y+=24;
	}
    }
    //_______________________________________________________________

    public void go(){
	int val;
	while(turns>0){
	    val=deal();
	    if (val ==1){
		System.out.println ("You won! You have gained your bet of $" + bet);
		winnings+=bet;
	    }
	    else if (val == -1){
		System.out.println ("You lost! You have lost your bet of $" + bet);
		winnings-=bet;
	    }
	    else{
		System.out.println("It's a tie! Time for war!");
		prepwar();
	    }
	    turns--;
	}
    }

    public int dealTie(){
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	int x=(int)(Math.random()*deck.size());
	String a= deck.get(x); //player
	String b="";
	System.out.println("Your card is " + a);
	deck.remove(x);
	
	    x=(int)(Math.random()*deck.size());
	    b= deck.get(x);//bot
	    System.out.println("Your opponent's card is " + b);
	    deck.remove(x);
	    
	return comp(a,b);

    }

    public int deal(){
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	int x=(int)(Math.random()*deck.size());
	String a= deck.get(x); //player
	String b="";
	System.out.println("Your card is " + a);
	deck.remove(x);
	
	if (Math.random()*100 >= 66){
	    x=(int)(Math.random()*deck.size());
	    deck.remove(x);	    
	    String h=a.substring(0,a.length()-1);
	    int p = (int)( Math.random()*4);
	    if (p==0) h+="♥";
	    else if (p==1) h+="♠";
	    else if (p==2) h+="♣";
	    else h+="♦";
	    b=h;
	    System.out.println("Your opponent's card is " + b);
	}
	else{
	    x=(int)(Math.random()*deck.size());
	    b= deck.get(x);//bot
	    System.out.println("Your opponent's card is " + b);
	    deck.remove(x);
	}
	return comp(a,b);

    }

    public int comp(String a, String b){
	int a1=0;
	int b1=0;
	int result=0;

	String tempa= a.substring(0,1);
	String finala=a.substring(0,a.length()-1);
	String tempb=b.substring(0,1);
	String finalb=b.substring(0,b.length()-1);	
	    if (tempa.equals("J")) a1+=11;
	    else if (tempa.equals("Q")) a1+=12;
	    else if (tempa.equals("K")) a1+=13;
	    else if (tempa.equals("A")) a1+=14;
	    else{
		result=Integer.parseInt(finala);
		a1+=result;
	    }

	
	if (tempb.equals("J")) b1+=11;
	else if (tempb.equals("Q")) b1+=12;
	else if (tempb.equals("K")) b1+=13;
	else if (tempb.equals("A")) b1+=14;
	else{
	    result=Integer.parseInt(finalb);
	    b1+=result;
	}

	if (a1>b1) return 1;
	else if (a1<b1) return -1;
	else return 0;

	
    }


    public void prepwar(){
	int want;
	System.out.println("The values are equal! What would you like to do?");
	System.out.println("1.Bet on winning\n2.Bet on tie\n3.Surrender");
	try{
	    want=Keyboard.readInt();
	    if (want==3){
		System.out.println( "You have surrendered! You lost $" +bet/2);
		winnings-=bet/2;
	    }
	    else if (want==1) war();
	    else tiewar();
	}
	catch(Exception e){
	    System.out.println("Try again! You can fight or you can run! Nothing else!");
	    prepwar();
	    return;
	}
    }

    public void war(){
	int x;
	String z;
	for (int y=0; y< 3; y++){
	    x=(int)(Math.random()*deck.size());
	    z= deck.get(x);
	    System.out.println("The dealer has discarded " + z);
	}
	int val=1;
	System.out.println(deal());
	
	if (val==1) {
	    System.out.println("You have won the war! Your winnings increased by $"+(bet*2));
	    winnings+=bet*2;}
	else if (val==-1){
	    System.out.println("You have lost the war! Your winnings decrease by $"+(bet*2));
	    winnings-=bet*2;
	}	
	else prepwar(2);
    }
    public void tiewar(){

	int x;
	String z;
	for (int y=0; y< 3; y++){
	    x=(int)(Math.random()*deck.size());
	    z= deck.get(x);
	    System.out.println("The dealer has discarded " + z);
	}
	int val=dealTie();
	if (val==0){
	    System.out.println("You have won the war! Your winnings increased by $"+(bet*10));
	    winnings+=bet*10;
	}
	else{
	    System.out.println("You have lost the war! Your winnings decrease by $"+(bet*10));
	    winnings-=bet*10;
	}
    }

    

    public void prepwar(int increase){
	int want;
	System.out.println("The values are equal! What would you like to do?");
	System.out.println("1.Bet on winning\n2.Bet on tie\n3. Surrender");
	try{
	    want=Keyboard.readInt();
	    if (want==3){
		System.out.println( "You have surrendered! You lost $" +(bet*increase)/(2));
		winnings-=bet/2;
	    }
	    else if (want==1) war(increase);
	    else tiewar(increase);
	}
	catch(Exception e){
	    System.out.println("Try again! You can fight or you can run! Nothing else!");
	    prepwar(increase);
	    return;
	}

    }
    public void war(int increase){

	int x;
	String z;
	for (int y=0; y< 3; y++){
	    x=(int)(Math.random()*deck.size());
	    z= deck.get(x);
	    System.out.println("The dealer has discarded " + z);
	}
	int val=deal();
	if (val==1) {
	    System.out.println("You have won the war! Your winnings increased by $"+(bet*2));
	    winnings+=bet*2*increase;}
	else if (val==-1){
	    System.out.println("You have lost the war! Your winnings decrease by $"+(bet*2));
	    winnings-=bet*2*increase;
	}	
	else prepwar(increase*2);
    }


    public void tiewar(int increase){

	int x;
	String z;
	for (int y=0; y< 3; y++){
	    x=(int)(Math.random()*deck.size());
	    z= deck.get(x);
	    System.out.println("The dealer has discarded " + z);
	}
	int val=dealTie();
	if (val==0){
	    System.out.println("You have won the war! Your winnings increased by $"+(bet*10*increase));
	    winnings+=bet*10;
	}
	else{
	    System.out.println("You have lost the war! Your winnings decrease by $"+(bet*10*increase));
	    winnings-=bet*10;
	}
    }
    public static void main(String args[]){

    }
}
