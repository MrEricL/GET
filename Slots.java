public class Slots{

    private static final String[] objects = {
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",
	"", "", "",	
    };

    private String[] _objects;
    private int difficulty;
    private double money;
    private double bet;

    public Slots() {
	_objects = new String[objects.length];
	for (int index = 0; index < objects.length; index += 1){
	    _objects[index] = objects[index];
	}
    }

    public Slots(int len, int _money, int _bet){
	difficulty = len;
	money = _money;
	bet = _bet;
	_objects = new String[len * 3];
	for (int index = 0; index < len*3; index += 1){
	    _objects[index] = objects[index];
	}
    }

    public String toString(){
	String retStr = "";
	for(int index = 0; index < 3; index += 1){
	    retStr += _objects[index] + "\t";
	}
	return retStr;
    }

    private void swap (int one, int two){
	String oldOne = _object[one];
	String oldTwo = _object[two];
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

    public void changeMoney(){
	if (miniWin()){
	    money += bet;
	}
	else{
	    money -= bet;
	}
    }
}
