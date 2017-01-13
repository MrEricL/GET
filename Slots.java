public class Slots implements casinorules{

    protected static final String[] objects = {
	"seven", "seven", "seven",
	"cherry", "cherry", "cherry",
	"crown", "crown", "crown",
	"drink", "drink", "drink",
	"bell", "bell", "bell",
	"candy", "candy", "candy",
	"diamond", "diamond", "diamond",
	"$", "$", "$",
	"dice", "dice", "dice",	
    };

    protected String[] _objects;
    protected int difficulty;
    protected double money;
    protected double bet;

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
	System.out.println("Welcome to the Slots machines!");
	//System.out.println("Choose the game that you're going to play:");
    }

    public void go(){
	System.out.println("Spinning.....");
	spin();
	System.out.println(this);
	if (miniWin()){
	    if (jackpot()){
		System.out.println("JACKPOT!!!!!!!");
		bet *= 2;
	    }
	    else{
		System.out.println("Mini Win!!!!!");
	    }
	}
	else{
	    System.out.println("No winnings :( ");
	    bet = 0 - bet;
	}
    }

    public double play(){
	start();
	go();
	return bet;
    }

    public static void main(String[] args){
	Slots mike = new Slots(1,80,10);
	mike.play();
	//System.out.println(mike.toString());
    }
}
