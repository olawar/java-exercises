package pl.edu.agh.java.exercises.strings;

/**
 * Given a string, return the longest substring that appears at both the beginning and end of the string without
 * overlapping. For example, sameEnds("abXab") is "ab".
 * <p>
 * Dla danego ciągu znaków zwróć najdłuższy podciąg, który występuje na początku i na końcu, bez nachodzenia na siebie.
 * Przykłądowo, sameEnds("abXab") to "ab".
 *
 * @see http://codingbat.com/prob/p131516
 */
public class StringSameEnds {
    public String sameEnds(String string) {
    	try {
    		int middle = 0;
    		String beginning = new String();
    		String end = new String();
    		if(string.length() % 2 == 0) {
    			middle = string.length() / 2;
        		end = string.substring(middle);
    		} else {
    			middle = (int) Math.floor((string.length() / 2));
        		end = string.substring(middle + 1);
    		}
    		beginning = string.substring(0, middle);    		
    		String solution = new String();

    		for (int i=1; i<=beginning.length(); i++) {
    			String stringToCheck = beginning.substring(0, i);
    			if(end.contains(stringToCheck) && end.indexOf(stringToCheck) == end.length() - i) {
    				solution = stringToCheck;   	
    			}
    		}    		
    		return solution;   		
    	}  catch(UnsupportedOperationException e) {
    		throw new UnsupportedOperationException();
    	}
    }
}
