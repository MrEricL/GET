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

    public boolean danger(){
	if (jackpot() && _objects[0].equals("skull")){ return true; }
	else{ return false; }
    }

    public boolean attack(){
	if (jackpot() && _objects[0].equals("sword")){ return true; }
	else{ return false; }
    }

    public boolean die(){
	if (jackpot() && _objects[0].equals("zombie")){ return true; }
	else{ return false; }
    }

    public String toString(){
	String retStr = "";
	if (miniWin()){ retStr += green; }
	if (jackpot()){
	    if (die() || attack() || danger()){
		retStr += red;
	    }
	    else{
		retStr += yellow;
	    }
	}
	//else{ retStr += white; }
	for(int index = 0; index < 3; index += 1){
	    retStr += _objects[index] + "\t";
	    //System.out.println(_objects[index]);
	}
	return retStr + reset;

    public void go(){
	super.go();
	if (danger()){
	    System.out.println("Danger!");
	    bet /= 4;
	}
	if (attack()){
	    System.out.println(red + "Attacked by swords!" + red);
	    bet /= 2;
	}
	if (die()){
	    System.out.println(red + "You've been overpowered by zombies!" + red);
	    bet *= -2;
	}
	
	
	    
}
