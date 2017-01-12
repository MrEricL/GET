import cs1.Keyboard;
public class war implments casinorules{

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
	go();
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
	    bet=winnings/turns;
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

    public starthard(){
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
	while(turns>0){
	    if (deal() ==1){
		System.out.println ("You won! You have gained your bet!");
		winnings+=bet;
	    }
	    else if (deal() == -1){
		System.out.println ("You lost! You have lost your bet!");
		winnings-=bet;
	    }
	    else{
		System.out.println("It's a tie! Time for war!");
		prepwar();
	    }
	    turns--;
	}


    }


    public int deal(){
	int x=(int)(Math.random()*deck.size());
	String a= deck.get(x); //player
	System.out.println("You're card is " + a);

	x=(int)(Math.random()*deck.size());
	String b= deck.get(x);//bot
	System.out.println("You're card is " + b);

	return comparison(a,b);

    }

    public int comparison(String a, String b){
	int a1;
	int b1;
	int results;

	tempa= a.substring(0,1);
	finala=a.substring(0,a.length()-1);
	tempb=b.substring(0,1);
	finalb=b.substring(0,b.length()-1);	

	if (tempa.equals("J")) a1+=11;
	else if (tempa.equals("Q")) a1+=12;
	else if (tempa.equals("K")) a1+=13;
	else if (tempa.equals("A")) a1+=14;
	else{
	    result=Integer.parseInt(finala);
	    a1+=result;
	}
	
	if (tempa.equals("J")) b1+=11;
	else if (tempa.equals("Q")) b1+=12;
	else if (tempa.equals("K")) b1+=13;
	else if (tempa.equals("A")) b1+=14;
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
	System.out.println("1.Bet on winning\n2.Bet on tie\n3. Surrender");
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
	    war();
	    return;
	}

    }












}
