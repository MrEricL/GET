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
	_objects = new String[len * 18];
	for (int index = 0; index < len*9; index += 1){
	    _objects[index] = objects[index];
	}
	for (int index = len*9; index < len*18; index += 1){
	    _objects[index] = FRUITS[index - len*9];
	}
    }

    public static void main(String[] args){
	fruitSlots finn = new fruitSlots(3, 100, 10);
	finn.play();
    }
	
}
