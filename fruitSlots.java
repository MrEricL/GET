public class fruitSlots extends Slots {

    private static final String[] FRUITS = {
	"apple", "apple", "apple",
	"grape", "grape", "grape",
	"grapefruit", "grapefruit", "grapefruit",
	"watermelon", "watermelon", "watermelon",
	"pomegranate", "pomegranate", "pomegranate",
	"durian", "durian", "durian",
	"orange", "orange", "orange",
	"lemon", "lemon", "lemon",
	"cherry", "cherry", "cherry",
    };

    public fruitSlots(int len, double _money, double _bet){
        difficulty = len;
	money = _money;
	bet = _bet;
	_objects = new String[len * 9];
	for (int index = 0; index < len*9; index += 1){
	    _objects[index] = FRUITS[index];
	}
    }

    public boolean appleJackpot(){
	if (jackpot() && _objects[0].equals("apple")){
	    return true; }
	else { return false; }
    }

    public void go(){
	super.go();
	if (appleJackpot()){
	    System.out.println("APPLE JACKPOT!!!!! " +
			       "Double your winnings!\n");
	    bet *= 2;
	}
    }
}
