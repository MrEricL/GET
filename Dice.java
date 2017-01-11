public class Dice{

    private final int[] Dice = [1,2,3,4,5,6];
    private int[] Dice1 = new int[6];
    private int[] Dice2 = new int[6];
    private int face1, face2, guess1, guess2;
    private double money, bet;

    public Dice(int _money, int _bet){
	for (int index = 0; index < 6; index += 1){
	    Dice1[index] = Dice[index];
	    Dice2[index] = Dice[index];
	}
	face1 = 1;
	face2 = 1;
	money = _money;
	bet = _bet;
	
    }

    public void roll(){
	

}
