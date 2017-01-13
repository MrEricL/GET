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
	_objects = new String[len * 6];
	double randomizer;
	for (int index = 0; index < _objects.length; index += 1){
	    randomizer = Math.random()*10;
	    if (randomizer < 5){
	    }
	}
    }
	
}
