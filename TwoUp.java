public class TwoUp{

    private final String[] Coin1 = new String[] {"heads", "tails"};
    private final String[] Coin2 = new String[] {"heads", "tails"};
    private double money, bet;
    private String C1, C2;
    private boolean win;

    public TwoUp(double _money, double _bet){
	money = _money;
	bet = _bet;
    }

    public void toss(){
	int c1 = (int)(Math.random() * 2);
	int c2 = (int)(Math.random() * 2);
	C1 = Coin1[c1];
	C2 = Coin2[c2];
    }

    public void check(){
	if (C1.equals(C2)){ win = true ; }
	else if (C1.equals("heads") && C2.equals("tails")){ win = true; }
	else if (C2.equals("heads") && C1.equals("tails")){ win = true; }
    }
}
