public class Pictures {

    public String crown(){
	String ret =  "|\\  /\\  /| \n" +
	              "| \\/  \\/ | \n" +
	              "|________| " ;
	return ret;
    }

    public String apple(){
	String ret = "    /    \n" +
	             "  ---- \n" +
	             " /    \\ \n"+
	            "|      |  \n" +
	    " \\____/ " ;
	return ret;
    }

    public static void main(String[] args){
	Pictures p = new Pictures();
	System.out.println(p.crown());
	System.out.println(p.apple());
    }
}
