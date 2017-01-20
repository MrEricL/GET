//WORK ON PRINTING THE ACE
//WORK ON FITING THE CHOICE WITH THE BOTS
import java.util.ArrayList;
import cs1.Keyboard;
import java.lang.*;


public class blackjack implements casinorules {
    public ArrayList<String> deck= new ArrayList<String>(); //want to be 312 or 52
    // the bots
    public String[] listOfPeeps= {"you", "Jack", "Lois", "Will", "Robin","Emily"};
    public ArrayList<String> jack= new ArrayList<String>();
    public ArrayList<String> lois= new ArrayList<String>();
    public ArrayList<String> will= new ArrayList<String>();
    public ArrayList<String> robin= new ArrayList<String>();
    public ArrayList<String> emily= new ArrayList<String>();

    //easy bots
    public int jackDraw=(int)(Math.random()*3);
    public int loisDraw=(int)(Math.random()*3);
    public int willDraw=(int)(Math.random()*3);
    public int robinDraw=(int)(Math.random()*3);
    public int emilyDraw=(int)(Math.random()*3);

    //bot taunt

    public String[] tauntPick = {"You seem to be out of your league.", "Who would hit on that?", "Are you blind or are you blind?", "This game is way too easy!","Clever move!","My eighty year old nan could play better than that!","Wow! That was such a good move.","Ah yes, another rookie, another win for me."};

    public String[] tauntWin = {"GG EZ\nGIT GUD SCRUB","Why that was simply to be expected.","Finally more money for drugs!","That was a wonderful game everyone!","My oh my!",};

    public String[] tauntLose={"You card counting scum!","You just got lucky!","Hmmmm... My disposable income is in the millions~","@!#%","Pfffff... Beginner's luck.",";)\n","Good job!"};



    // diff bot
    
    public boolean botdone=false;
    public boolean playerdone=false;

    public ArrayList results = new ArrayList<Integer>();

    //the player	
    public ArrayList<String> player= new ArrayList<String>();
    
    //background stuff
    public int difficulty;
    public double  money;
    public double bet;
    public boolean win=false;
    public int winnumb;

    public blackjack(int x, double  y, double z){
	difficulty=x;
	money=y;
	bet=z;
    }
    
    public double play(){
	//	if (difficulty==1) start2();
	//	else start();
	start();
	//	System.out.println(deck);
	//	System.out.println(deck.size());
	deal();
	go();
	printall(); //comment out?
	if (win){
	    return (bet*5.0/winnumb);
	}
	else{
	    return bet*-1;
	}
    }
    /*
		
 ♦♣♥♠
     */

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
    //harder

    public void start2(){
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



    //deals all the cards out for each player

    public void deal(){
	int x=0;
	int cardsize = deck.size();
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

	
    }


    //prints the values of the bots
    public void printcards(){
	System.out.print ("You have " );
	for (int i=0; i< player.size(); i++){
	    System.out.print (player.get(i)+" ");
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
    //print cards final
    public void printall(){
	String a;
	String b;
	String c;
	String d;
	String e;
	String f;
	System.out.println ("\n____The Cards____");
	//a
        a="You have ";
	for (int i=0; i< player.size(); i++){
	    a+=player.get(i)+" ";

	}

	//b
        b="Jack has ";
	for (int i=0; i< jack.size(); i++){
	  b+=jack.get(i)+" ";

	}
	//	System.out.print (" -> " + check(jack));	
	//	System.out.println();

	//c
        c="Lois has ";
	for (int i=0; i< lois.size(); i++){
	    c+=lois.get(i)+" ";

	}
	//	System.out.print (" -> " + check(lois));	
	//	System.out.println();

	//d
	d="Will has " ;
	for (int i=0; i< will.size(); i++){
	    d+=will.get(i)+" ";

	}
	//	System.out.print (" -> " + check(will));	
	//	System.out.println();

	//e

        e="Robin has ";
	for (int i=0; i< robin.size(); i++){
	    e+=robin.get(i)+" ";

	}
	//	System.out.print (" -> " + check(robin));	
	//	System.out.println();

	//f
       f="Emily has " ;
	for (int i=0; i< emily.size(); i++){
	   f+=emily.get(i)+" ";

	}
	//	System.out.print (" -> " + check(emily));	
	//	System.out.println();

	int leng=0;

	if(a.length() > leng) leng = a.length();
	if(b.length() > leng) leng = b.length();
	if(c.length() > leng) leng = c.length();
	if(d.length() > leng) leng = d.length();
	if(e.length() > leng) leng = e.length();
	if(f.length() > leng) leng = f.length();

	while (a.length() < leng) a+=" ";
	while (b.length() < leng) b+=" ";
	while (c.length() < leng) c+=" ";
	while (d.length() < leng) d+=" ";
	while (e.length() < leng) e+=" ";
	while (f.length() < leng) f+=" ";

	System.out.print (a+" -> " + check(player));
	System.out.println();	
	System.out.print (b+" -> " + check(jack));
	System.out.println();
	System.out.print (c+" -> " + check(lois));
	System.out.println();	
	System.out.print (d+" -> " + check(will));
	System.out.println();
	System.out.print (e+" -> " + check(robin));
	System.out.println();	
	System.out.print (f+" -> " + check(emily));
	System.out.println("\n");
	slp(3.55);
    }


    //running aspect
    public void go(){
	String ans;
	
	System.out.println ("\n~~~ BEGIN ~~~ ");

	while (!playerdone || !botdone){
	    if (!playerdone){
		if (check(player) > 21){
		    System.out.println("Look's like you're busted!!!\n");
		    playerdone=true;
		}
	    }
	    if (!playerdone){
		
		System.out.println("~~~~~~~~~~~~\n");
		printcards();
		System.out.println ("Would you like a hit?");
		System.out.println("(y/n)\n");
		//y/n
		try {
		    ans= Keyboard.readWord();
		    System.out.println();		
		    if (ans.equals("y") || ans =="y"){
			int x= (int)(Math.random()*deck.size());
			player.add(deck.get(x));
			System.out.println ("You got a " + deck.get(x));
			    System.out.println();
			if (deck.get(x).substring(0,3)=="ACE"){
			    player.add( aceC(deck.get(x)));
			}
			else	player.add(deck.get(x));
			deck.remove(x);	
		    }
		    else {
			playerdone=true;
		    }
		}
		catch (Exception e) {
		    return;		
		}
		if ((Math.random()*100) <= 75){
		    int g = (int)(Math.random()*listOfPeeps.length-1);
		    int k= (int)(Math.random()*tauntPick.length);
		    System.out.println("\n\n"+listOfPeeps[g+1]+": "+tauntPick[k]+"\n\n");
		}		
	    }
	    if (!botdone){
		if (difficulty==1) ezbot();
		if (difficulty==2) medbot();
		if (difficulty==3) hardbot();
	    }
	    slp(0.5);	
	}
	resultTally();
	closest(results);	
    }

	//ACE Choose


	public String aceC(String y){
	    System.out.println("You have an ACE! You woud you like the value to be 1 or 11?");
			    String c = y;
			    int s;
			    try{
				s=Keyboard.readInt();
				if (s!= 1 && s!=11){
				    System.out.println("\nYou need to choose 1 or 11!\n");
				    return aceC(y);
				}
				else{
				    if (s==1){
					c="#"+c;
				    }
				    else{
					c="%"+c;
				    }
				}
			    }
			    catch (Exception e){
				return aceC(y);
				//	return;
			    }
			    return c;
	}
    //CHECK
    public int check (ArrayList <String> x){
	int total=0;
	int result=0;
	String temp;
	String temp2;
	for (int i=0; i< x.size(); i++){
	    temp=x.get(i).substring(0,1);
	    temp2=x.get(i).substring(0,x.get(i).length()-1);
	    if (temp.equals("%")) total+=11;
	    else if (temp.equals("#")) total+=1;
	    else if (temp.equals("A")) total+=6;
	    else if (temp.equals("K") || temp.equals("Q") || temp.equals("J")) total+=10;
	    else{
		result=Integer.parseInt(temp2);
		total+=result;
	    }
	}
	return total; 
    }

    public int checkBust(ArrayList <String> y){
	ArrayList <String> x = new ArrayList<String>();
	for (int i =0 ; i < y.size(); i++){
	    x.add(y.get(i));
	}
	x.remove(1);
	int total=0;
	int result=0;
	String temp;
	String temp2;
	for (int i=0; i< x.size(); i++){
	    temp=x.get(i).substring(0,1);
	    temp2=x.get(i).substring(0,x.get(i).length()-1);
	    if (temp.equals("K") || temp.equals("Q") || temp.equals("J")|| temp.equals("A")) total+=10;
	    else{
		result=Integer.parseInt(temp2);
		total+=result;
	    }
	}
	return total; 
    }

    public void resultTally(){
	results.add(check(player));
	results.add(check(jack));
	results.add(check(lois));
	results.add(check(will));
	results.add(check(robin));
	results.add(check(emily));

    }

    public void closest (ArrayList<Integer> x){
	ArrayList<Integer> winners = new ArrayList<Integer>();
	int smallest=100;
	ArrayList<Integer>  index= new ArrayList<Integer>();
	ArrayList<Integer> number= new ArrayList <Integer>();
	int temp;
	for (int i=0; i< x.size(); i++){
	    temp=21-x.get(i);
	    if (temp < 0||  temp> 21);
	    else if (temp >= smallest);
	    else smallest=temp;   
	}
	for (int f=0; f<x.size(); f++){
	    temp=21-x.get(f);
	    if (temp==smallest){
		index.add(f);
		number .add(temp);
	    }
	}

	//	System.out.println("The winner is "+ listOfPeeps[index] + ", with a sum of "+ number);
	System.out.println("\n\n\n♦ ♣ ♥ ♠ ♦ ♣ ♥ ♠ ♦ ♣ ♥ ♠ Results ♠ ♣ ♥ ♠ ♦ ♠ ♣ ♥ ♠ ♦ ♠ ♣ ♥ ♠ ♦");
	if (index.size()==0){
	    System.out.println("\nThere were no winners");
	}
        else if (index.size() ==1){
	    System.out.println("\nThe winner is "+ listOfPeeps[index.get(0)] + ", with a sum of "+(21- number.get(0)));	    
	}
	else{
	    System.out.println("\nThe winners are ");	    
	    for (int s=0; s<index.size(); s++){
		System.out.println( listOfPeeps[index.get(s)] +" with  "+(21- number.get(s)));
	    }
	}
	
	if (index.get(0)==0){
	    win=true;
	    winnumb= index.size();	    
	}
	else{
	    System.out.println ("\nYou are not a winner. Your total was "+check(player)+".\nYou lost your bet of $"+bet+".\n\n");
	}

    }




    // THE BOTS________________________________________________________________
    
    //EASY
    public void ezbot(){
	ArrayList<Boolean>  bol = new ArrayList<Boolean>(); 
	    if (jackDraw > 0){
		System.out.print("Jack decided to get hit ");
		editPrint(jack);
		jackDraw--;
		bol.add(false);
		    }
	    else{
		bol.add(true);
	    }	    

	    if (loisDraw > 0){
		System.out.print("Lois decided to get hit " );
		editPrint(lois);	
		loisDraw--;
		bol.add(false);		
		    }
	    else{
		bol.add(true);
	    }	    	    
	    
	    if (willDraw > 0){
		System.out.print("Will decided to get hit ");
		editPrint(will);		
		willDraw--;
		bol.add(false);		
		    }
	    else{
		bol.add(true);
	    }	    	    
	    if (robinDraw > 0){
		System.out.print("Robin decided to get hit ");
		editPrint(robin);		
		robinDraw--;
		bol.add(false);		
		    }
	    else{
		bol.add(true);
	    }	    	    
	    if (emilyDraw > 0){
		System.out.print("Emily decided to get hit ");
		editPrint(emily);		
		emilyDraw--;
		bol.add(false);		
		    }
	    else{
		bol.add(true);
	    }	    	    
	    System.out.println("\n");

	    for (int y=0; y < bol.size(); y++){
		if (!bol.get(y)){		    
		    return;
		}
	    }
	    botdone=true;
    }

    //MEDIUM
    public void medbot(){
	int deckAvg=(int)check(deck)/deck.size();
	int total=0;
	ArrayList<Boolean>  bol = new ArrayList<Boolean>(); 	
	ArrayList<String> hand = new ArrayList <String>();

	//jack
	for (int i=0; i < jack.size(); i++){
	    if (i!=1) hand.add(jack.get(i));
	}
        total= check(hand);
	if (jack.size() < 4 || total<19){
	    if (total+(deckAvg*2) <= 21){
		System.out.print("Jack decided to get hit " );
		editPrint(jack);
	    }
	    bol.add(false);
	}
	else bol.add(true);
	hand.clear();

	
	//lois
	for (int i=0; i < lois.size(); i++){
	    if (i!=1) hand.add(lois.get(i));
	}
        total= check(hand);
	if (lois.size() < 4 || total<19){
	    if (total+(deckAvg*2) <= 21){
		System.out.print("Lois decided to get hit " );
		editPrint(lois);
	    }
	    bol.add(false);
	}
	else bol.add(true);
	hand.clear();
	//will
	for (int i=0; i < will.size(); i++){
	    if (i!=1) hand.add(will.get(i));
	}
        total= check(hand);
	if (will.size() < 4 || total<19){
	    if (total+(deckAvg*2) <= 21){
		System.out.print("Will decided to get hit " );
		editPrint(will);
	    }
	    bol.add(false);
	}
	else bol.add(true);
	hand.clear();
	//robin
	for (int i=0; i < robin.size(); i++){
	    if (i!=1) hand.add(robin.get(i));
	}
        total= check(hand);
	if (robin.size() < 4 || total<19){
	    if (total+(deckAvg*2) <= 21){
		System.out.print("Robin decided to get hit " );		
		editPrint(robin);
	    }
	    bol.add(false);
	}
	else bol.add(true);
	//emily
	for (int i=0; i < emily.size(); i++){
	    if (i!=1) hand.add(emily.get(i));
	}
        total= check(hand);
	if (emily.size() < 4 || total<19){
	    if (total+(deckAvg*2) <= 21){
		System.out.print("Emily decided to get hit " );
		editPrint(emily);
	    }
	    bol.add(false);
	}
	else bol.add(true);
	hand.clear();
	//checker
	    for (int j=0; j< bol.size(); j++){
		if (!bol.get(j)){		    
		    return;
		}
	    }
	    botdone=true;
	
    }


    //HARD

    public void hardbot(){
	int jackHand=check(jack);
	int loisHand=check(lois);
	int willHand=check(will);
	int robinHand=check(robin);
	int emilyHand=check(emily);
	int deckAvg=(int)check(deck)/deck.size();
	int x;
	ArrayList <String> y= new ArrayList<String>();
	ArrayList<Boolean>  bol = new ArrayList<Boolean>(); 	

	if (jackHand < 21){
	    x=(int)(Math.random()*deck.size());
	    y.add(deck.get(x));
	    if (check(y)+jackHand <= 21){
		System.out.println("Jack decided to get hit, the card was "+ deck.get(x));		
		jack.add(deck.get(x));
		deck.remove(x);
		y.remove(0);
		bol.add(false);
	    }
	    else if (jackHand+deckAvg<= 21){
		System.out.print("Jack decided to get hit ");
		editPrint(jack);
		bol.add(false);
	    }
	    else bol.add(true);
	   
	}
	else bol.add(true);

	if (loisHand < 21){
	    x=(int)(Math.random()*deck.size());
	    y.add(deck.get(x));
	    if (check(y)+loisHand <= 21){
		System.out.println("Lois decided to get hit, the card was "+ deck.get(x));		
		lois.add(deck.get(x));
		deck.remove(x);
		y.remove(0);
		bol.add(false);
	    }
	    else if (loisHand+deckAvg<= 21){
		System.out.print("Lois decided to get hit ");
		editPrint(lois);
		bol.add(false);
	    }
	    else bol.add(true);
	   
	}
	else bol.add(true);

	if (willHand < 21){
	    x=(int)(Math.random()*deck.size());
	    y.add(deck.get(x));
	    if (check(y)+willHand <= 21){
		System.out.println("Will decided to get hit, the card was "+ deck.get(x));		
		will.add(deck.get(x));
		deck.remove(x);
		y.remove(0);
		bol.add(false);
	    }
	    else if (willHand+deckAvg<= 21){
		System.out.print("Will decided to get hit ");
		editPrint(will);
		bol.add(false);
	    }
	    else bol.add(true);
	   
	}
	else bol.add(true);
	
	if (robinHand < 21){
	    x=(int)(Math.random()*deck.size());
	    y.add(deck.get(x));
	    if (check(y)+robinHand <= 21){
		System.out.println("Robin decided to get hit, the card was "+ deck.get(x));		
		robin.add(deck.get(x));
		deck.remove(x);
		y.remove(0);
		bol.add(false);
	    }
	    else if (robinHand+deckAvg<= 21){
		System.out.print("Robin decided to get hit ");
		editPrint(robin);
		bol.add(false);
	    }
	    else bol.add(true);
	   
	}
	else bol.add(true);
	
	if (emilyHand < 21){
	    x=(int)(Math.random()*deck.size());
	    y.add(deck.get(x));
	    if (check(y)+emilyHand <= 21){
		System.out.println("Emily decided to get hit, the card was "+ deck.get(x));
		emily.add(deck.get(x));
		deck.remove(x);
		y.remove(0);
		bol.add(false);
	    }
	    else if (emilyHand+deckAvg<= 21){
		System.out.print("Emily decided to get hit ");
		editPrint(emily);
		bol.add(false);
	    }
	    else bol.add(true);
	   
	}
	else bol.add(true);
	

	
	    

	    for (int j=0; j< bol.size(); j++){
		if (!bol.get(j)){		    
		    return;
		}
	    }
	    botdone=true;
    }

    //HELPER
    public void editPrint(ArrayList<String> ed){
	int ray;
	String joe;
	String max;
	for (int o = 0; o < ed.size(); o++){
	    ray = (int)(Math.random()*100);
	    joe=ed.get(o);
	    max=joe.substring(0,1);
	    if (max.equals("A")){
		if (ray>=50){
		    joe = "#"+joe;
		    ed.set(o,joe);
		}
		else{
		    joe = "%"+joe;
		    ed.set(o,joe);
		}
	    }	   
	}
	
	int x;
	x=(int)(Math.random()*deck.size());
	String g = deck.get(x);
	String h=g.substring(0,1);
	if (h.equals("A")){
	    int blah = (int)(Math.random()*100);
	    if (blah>=50) g = "#"+g;
	    else g="%"+g;

	}    
	    ed.add(g);
	    System.out.println("the card was " + deck.get(x));	    
	    deck.remove(x);
    }

    //_________________________________________________________________________
	public void slp(double x){
	    x*=1000;
	    long y= (long)x;
	    try{
		Thread.sleep(y);
	    }
	    catch(InterruptedException e){
	    }
	}
    public static void main (String[] args){
	//	blackjack play = new blackjack();
    }




}
