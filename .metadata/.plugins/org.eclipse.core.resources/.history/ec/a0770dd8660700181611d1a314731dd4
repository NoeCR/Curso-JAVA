package JadenCastingStrings;

public class JadenCaseTry {

	public static void main(String[] args) {
		toJadenCase(null);

	}


	public static String toJadenCase(String phrase) {
		if(phrase == "" || phrase == null) {
			return null;			
		}else {
			String phraseMod = "";
			String [] parts = phrase.split(" ");
			for(int i = 0; i<parts.length; i++) {
				if(i<parts.length-1) {
					phraseMod += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ";
				}else {
					phraseMod += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);	
				}			
			}

			return phraseMod;
		}
	}
}
