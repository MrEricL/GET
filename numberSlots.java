public class numberSlots extends Slots {

    private static final String[] NUMBERS = {
	"one", "one", "one",
	"two", "two", "two",
	"three", "three", "three",
	"four", "four", "four",
	"five", "five", "five",
	"ten", "ten", "ten",
	"fifty", "fifty", "fifty",
	"hundred", "hundred", "hundred",
	yellow + "thousand" + reset, yellow + "thousand" + reset, yellow + "thousand" + reset,
    };

    public numberSlots(int len, double _money, double _bet){
        difficulty = len;
	money = _money;
	bet = _bet;
	_objects = new String[len * 9];
	for (int index = 0; index < len*9; index += 1){
	    _objects[index] = NUMBERS[index];
	}
    }

    public boolean thousandWin(){
	if (jackpot() && _objects[0] == "thousand"){
	    return true; }
	else{ return false; }
    }

    public void go(){
	super.go();
	if (thousandWin()){
	    System.out.println(yellow + "THOUSAND JACKPOT!!! " +
			       "Add 1000 to your winnings!" + reset);
	    bet += 1000;
	}
    }
    
}
