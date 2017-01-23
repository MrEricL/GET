public class suddenDeathSlots extends Slots{

    private static final String[] kill = {
	"angel", "angel", "angel",
	"rock", "rock", "rock",
	"skull", "skull", "skull",
	"rock", "rock", "rock",
	"sword", "sword", "sword",
	"ghost", "ghost", "ghost",
	"rock", "rock", "rock",
	"skull", "skull", "skull",
	red + "zombie" + reset, red + "zombie" + reset, red + "zombie" + reset,
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

    public void helper(){
	String x;
	for (int i = 0; i < 3; i ++){
	    x = _objects[i];
	    if (x.equals("angel")){
		bet += 10;
		System.out.println("You got an angel! +10 on earnings!");
	    }
	    if (x.equals("rock")){
		bet += 1;
		System.out.println("You got a rock! +10 on earnings!");
	    }
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

    public boolean spook(){
	if (jackpot() && _objects[0].equals("ghost")){ return true; }
	else{ return false; }
    }

    public boolean die(){
	if (jackpot() && _objects[0].equals("zombie")){ return true; }
	else{ return false; }
    }

    public String toString(){
	String retStr = "";
	String color = white;
	if (miniWin()){ color = green; }
	if (jackpot()){
	    if (die() || attack() || danger() || spook()){ color = red; }
	    else{ color = yellow; }
	}

	for(int index = 0; index < 3; index += 1){
	    retStr += color +  _objects[index] + reset + "\t";
	}
	return retStr;
    }


    public void go(){
	super.go();
	if (danger()){
	    System.out.println(red + "Danger! " +
			       "Earn only half what you bet." + reset);
	    bet /= 4;
	}
	if (attack()){
	    System.out.println(red + "Attacked by swords! " +
			       "Only earn what you bet." + reset);
	    bet /= 2;
	}
	if (spook()){
	    System.out.println(red + "Ghost Swarm! How spooky~ " +
			       "Lose 1/4 of your earnings." + reset);
	    bet *= (3/4);
	}
	if (die()){
	    System.out.println(red + "You've been overpowered by zombies! " +
			       "You lose 2* what you bet." + reset);
	    bet *= -2;
	}
	helper();
    }

    public static void main(String[] args){
	suddenDeathSlots mike = new suddenDeathSlots(3, 10, 10);
	mike.go();
    }
}
