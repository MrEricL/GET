
import java.util.ArrayList;
import cs1.Keyboard;
import java.lang.*;


public class blackjack {
    public ArrayList deck= new ArrayList<String>(); //want to be 312
    // the bots
    public String[] listOfPeeps= {"you", "Jack", "Lois", "Will", "Robin","Emily"};
    public ArrayList jack= new ArrayList<String>();
    public ArrayList lois= new ArrayList<String>();
    public ArrayList will= new ArrayList<String>();
    public ArrayList robin= new ArrayList<String>();
    public ArrayList emily= new ArrayList<String>();

    public boolean botdone=true;
    public boolean playerdone=false;

    public ArrayList results = new ArrayList<Integer>();

    //the player	
    public ArrayList player= new ArrayList<String>();
    
    //background stuff
    public int difficulty;
    public double  money;
    public double bet;

    public blackjack(int x, double  y){
	difficulty=x;
	money=y;
    }
    
    public void play(){
	start();
	deal();
	go();
    }


    //creates the deck of cards
    public void start(){
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
    //deals all the cards out for each player

    public void deal(){
	int x=0;
	int cardsize = 311;
	//for the players
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    player.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}
	//for the bots
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    jack.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}	
	
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    lois.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    will.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}	
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    robin.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}
	for (int i=0; i < 2; i++){
	    x=(int)(Math.random()*cardsize);
	    emily.add(deck.get(x));
	    deck.remove(x);
	    cardsize--;
	}
	System.out.println("\n\n~~~ YOU ARE NOW PLAYING BLACKJACK ~~~\n");	
	printcards();

	
    }


    //prints the values of the bots
    public void printcards(){
	System.out.print ("You have " );
	for (int i=0; i< player.size(); i++){
	    if (i!=1) System.out.print (player.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();	

	System.out.print ("Jack has " );
	for (int i=0; i< jack.size(); i++){
	    if (i!=1) System.out.print (jack.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();

	System.out.print ("Lois has " );
	for (int i=0; i< lois.size(); i++){
	    if (i!=1) System.out.print (lois.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();

	System.out.print ("Will has " );
	for (int i=0; i< will.size(); i++){
	    if (i!=1) System.out.print (will.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();

	System.out.print ("Robin has " );
	for (int i=0; i< robin.size(); i++){
	    if (i!=1) System.out.print (robin.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();

	System.out.print ("Emily  has " );
	for (int i=0; i< emily.size(); i++){
	    if (i!=1) System.out.print (emily.get(i)+" ");
	    else System.out.print ("? ");

	}
	System.out.println();	

    }

    public void go(){
	String ans;
	
	System.out.println ("\n ~~~ BEGIN ~~~ \n\n");

	while (!playerdone){
	    if (!playerdone){
		System.out.println ("Would you like a hit?\n");

		try {
		    ans= Keyboard.readWord();
		    System.out.println();		
		    if (ans.equals("y")){
			int x= (int)(Math.random()*312-1);
			player.add(deck.get(x));
			deck.remove(x);		
		    }

		    else {
			playerdone=true;
			System.out.println(player);

			/* int result;
			   String x=(player.get(0)).toString();//
			   System.out.println(x);
			   x=x.substring(0);
			   System.out.println(x);		    
			   result=Integer.parseInt(x.substring(0,1));
			   System.out.println(result);*/

		    }
	    
		}
		catch (Exception e) {
		    return;		
		}			   
	    }

	    //AI COMPONENT
	}
	results.add(check(player));
	results.add(check(jack));
	results.add(check(lois));
	results.add(check(will));
	results.add(check(robin));
	results.add(check(emily));
	closest(results);
	
    }
    //work on this
    public int check (ArrayList <String> x){
	int total=0;
	int result=0;
	String temp;
	for (int i=0; i< x.size(); i++){
	    temp=x.get(i).toString();
	    if (!isInteger(temp.substring(0,1))) total+=10;
	    else{
		result=Integer.parseInt(temp.substring(0,1));
		total+=result;
	    }
	}
	return total; 
    }

	//helper dont worry bout this
   public static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try
      {
         Integer.parseInt(s);
 
         // s is a valid integer
 
         isValidInteger = true;
      }
      catch (NumberFormatException ex)
      {
         // s is not an integer
      }
 
      return isValidInteger;
   }


    public void closest (ArrayList<Integer> x){
	int smallest=100;
	int index=0;
	int number=0;
	int temp;
	for (int i=0; i< x.size(); i++){
	    temp=Math.abs(21-x.get(i));
	    if (temp < smallest) {
		smallest=temp;
		index=i;
		number=x.get(i);
	    }
	}

	System.out.println("The winner is "+ listOfPeeps[index] + ", with a sum of "+ number);

    }

    public static void main (String[] args){
	//	blackjack play = new blackjack();
    }




}
