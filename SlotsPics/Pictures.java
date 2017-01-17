public class Pictures {

    public String crown(){
	String ret =  "|\\  /\\  /| \n" +
	              "| \\/  \\/ | \n" +
	              "|________| " ;
	return ret;
    }

    public static void main(String[] args){
	Pictures p = new Pictures();
	System.out.println(p.crown());
    }
}
