public class suddenDeathSlots extends Slots{

    private static final String[] kill = {
	"angel", "angel", "angel",
	"angel", "angel", "angel",
	"skull", "skull", "skull",
	"angel", "angel", "angel",
	"sword", "sword", "sword",
	"ghost", "ghost", "ghost",
	"skull", "skull", "skull",
	"zombie", "zombie", "zombie",
    };

    public suddenDeathSlots(int len, double _money, double _bet){
        difficulty = len;
	money = _money;
	bet = _bet;
	_objects = new String[len * 9];
	for (int index = 0; index < len*9; index += 1){
	    _objects[index] = kill[index];
	}
    }

    public boolean Death(){
	if (jackpot() && _objects[0].equals("skull")){ return true; }
	else{ return false; }
    }

    public boolean Die(){
	if (jackpot() && _objects[0].equals("zombie")){ return true; }
	else{ return false; }
    }

    public void go(){
	super.go();
	if (Death()){
	    
}
