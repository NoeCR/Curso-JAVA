package SinCincos;

public class SinCincos {

	 public static int dontGiveMeFive(int start, int end)
	  {
			int cont = 0;
			for(int i=start; i<=end; i++) {
				if(String.valueOf(i).indexOf('5') == -1 ) {
				 System.out.println(i);
				 cont++;
				}
			}
	    return cont;
	  }

	
	
}
