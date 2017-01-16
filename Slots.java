import cs1.Keyboard;

public class Slots implements casinorules{

    protected static final String[] objects = {
	"seven", "seven", "seven",
	"cherry", "cherry", "cherry",
	"crown", "crown", "crown",
	"drink", "drink", "drink",
	"bell", "bell", "bell",
	"candy", "candy", "candy",
	"diamond", "diamond", "diamond",
	"$$$", "$$$", "$$$",
	"dice", "dice", "dice",	
    };

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
	for(int index = 0; index < 3; index += 1){
	    retStr += _objects[index] + "\t";
	    //System.out.println(_objects[index]);
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
	    return player.bet;
	}
	if (selection == 3){
	    numberSlots player = new numberSlots(difficulty, money, bet);
	    player.go();
	    return player.bet;
	}
	go();
	return bet;
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
