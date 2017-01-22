import cs1.Keyboard;

public class Slots implements casinorules{

    protected static final String reset = "\u001B[0m";
    protected static final String black = "\u001B[30m";
    protected static final String red = "\u001B[31m";
    protected static final String green = "\u001B[32m";
    protected static final String yellow = "\u001B[33m";
    protected static final String blue = "\u001B[34m";
    protected static final String purple = "\u001B[35m";
    protected static final String cyan = "\u001B[36m";

    protected static final String[] objects = {
	"seven", "seven", "seven",
	red + "cherry" + reset, red + "cherry" + reset, red + "cherry" + reset,
	yellow + "crown" + reset, yellow + "crown" + reset, yellow + "crown" + reset,
	"drink", "drink", "drink",
	"bell", "bell", "bell",
	"candy", "candy", "candy",
	"diamond", "diamond", "diamond",
	green + "$$$" + reset, green + "$$$" + reset, green + "$$$" + reset,
	"dice", "dice", "dice",	
    };

    
    protected static final String white = "\u001B[37m";

    protected String[] _objects;
    protected int difficulty;
    protected double money;
    protected double bet;
    private int selection;

    //for the visual
    int times=13;
    //------------

    public Slots() {
	_objects = new String[objects.length];
	for (int index = 0; index < objects.length; index += 1){
	    _objects[index] = objects[index];
	}
    }

    public Slots(int len, double _money, double _bet){
	difficulty = len;
	money = _money;
	bet = _bet;
	_objects = new String[len * 9];
	for (int index = 0; index < len*9; index += 1){
	    _objects[index] = objects[index];
	}
    }

    public String toString(){
	String retStr = "";
	String color = white;
	if (miniWin()){ color = green; }
	if (jackpot()){ color = yellow; }
	for(int index = 0; index < 3; index += 1){
	    retStr += color +  _objects[index] + reset + "\t";
	}
	return retStr;
    }

    private void swap (int one, int two){
	String oldOne = _objects[one];
	String oldTwo = _objects[two];
	_objects[one] = oldTwo;
	_objects[two] = oldOne;
    }

    public void spin(){
	int index1, index2;
	for (int counter = 0; counter < 1000; counter += 1){
	    index1 = (int)(Math.random() * _objects.length);
	    index2 = (int)(Math.random() * _objects.length);
	    swap(index1, index2);
	}
    }

    public void spinPrint(){
	int a = (int)(Math.random()*_objects.length);
	String x = _objects[a];
	int b = (int)(Math.random()*_objects.length);
	String y = _objects[b];
	int c  =  (int)(Math.random()*_objects.length);
	String z = _objects[c];



	int h =(int)( Math.random() * _objects.length);
	String j = _objects[h];
	int g= (int) (Math.random() * 100);

	if (times > 0 && g > 85){
	    System.out.println (j+"\t"+j+"\t"+j+"\n");
	}
	    
	else if (times > 0 && times > 5){
	    System.out.print(x+"\t");
	    System.out.print(y+"\t");
	    System.out.print(z+"\n\n");
	}
	else if (times > 0 && times > 2){
	    System.out.print(x+"\t");
	    slp(0.1);
	    System.out.print(y+"\t");
	    slp(0.1);
	    System.out.print(z+"\n\n");
	    slp(0.1);
	}
	else if (times > 0){
	    System.out.print(x+"\t");
	    slp(0.8);
	    System.out.print(y+"\t");
	    slp(0.8);
	    System.out.print(z+"\n\n");
	    slp(0.8);

	}
	else return;
	slp(0.25);
	times--;
	spinPrint();
	
    }

    public boolean jackpot() {
	boolean jackpot = false;
	if (_objects[0].equals(_objects[1])){
	    if(_objects[1].equals(_objects[2])){
		jackpot = true;
	    }
	}
	return jackpot;
    }

    public boolean miniWin() {
	boolean win = false;
	if (jackpot()){
	    win = true;
	}
	else{
	    if (!_objects[0].equals(_objects[1])){
		if (!_objects[1].equals(_objects[2])){
		    if (!_objects[0].equals(_objects[2])){
		        win = true;
		    }
		}
	    }
	}
	return win;
    }

    public void start(){
	System.out.println("Which slots would you like to play?");
	System.out.println("\t1. Regular");
	System.out.println("\t2. Fruits");
	System.out.println("\t3. Numbers");
	System.out.println("\t4. Death");
	selection = Keyboard.readInt();
    }

    public void go(){
	System.out.println("Spinning.....");
	spinPrint();
	spin();
	slp(1.5);
	System.out.println(this);
	if (miniWin()){
	    if (jackpot()){
		System.out.println("\n\nJACKPOT!!!!!!!\n");
		bet *= 2;
	    }
	    else{
		System.out.println("\nMini Win!!!!!\n");
	    }
	}
	else{
	    System.out.println("No winnings :( ");
	    bet = 0 - bet;
	}
    }

    public double play(){
	start();
	if (selection == 2){
	    fruitSlots player = new fruitSlots(difficulty, money, bet);
	    player.go();
	    bet =  player.bet;
	}
	else if (selection == 3){
	    numberSlots player = new numberSlots(difficulty, money, bet);
	    player.go();
	    bet = player.bet;
	}
	else if (selection == 4){
	    suddenDeathSlots player = new suddenDeathSlots(difficulty, money, bet);
	    player.go();
	    bet = player.bet;
	}
	else{
	    go();
	}
	
	System.out.print("Care for another spin? Y or N? ");
	String ans = Keyboard.readString().toUpperCase();
	while(!ans.equals("Y") && !ans.equals("N")){
	    System.out.println("Please type Y or N.");
	    System.out.print("Care for another spin? Y or N? ");
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
		Slots newPlay = new Slots(difficulty, money, bet);
		bet += newPlay.play();
	    }
	}
	return bet;
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

    public static void main(String[] args){
	Slots mike = new Slots(1,80,10);
	mike.play();
	//System.out.println(mike.toString());
    }
}
