package SinCincos;

public class SinCincoOld {

	public static void main(String[] args) {
		dontGiveMeFive(4, 17);

	}

	 public static int dontGiveMeFive(int start, int end)
	  {
		String num ="";
		int cont = 0;
		for(int i=start; i<=end; i++) {
			if(num.valueOf(i).indexOf('5') == -1 ) {
			 System.out.println(i);
			 cont++;
			}
		}
		
		 System.out.println(cont);
		
	    return 0;
	  }
}
