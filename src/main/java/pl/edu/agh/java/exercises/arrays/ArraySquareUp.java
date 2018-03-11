package pl.edu.agh.java.exercises.arrays;

import java.util.stream.IntStream;

/**
 * Given n>=0, create an array length n*n with the following pattern, shown here
 * and in the unit tests: for n=3 : {0, 0, 1, 0, 2, 1, 3, 2, 1}
 * 
 * Dla zadanego n>=0 zwróć tablicę o długości n*n utworzoną wg wzoru podanego
 * tutaj oraz w testach jednostkowych: dla n=3: {0, 0, 1, 0, 2, 1, 3, 2, 1}
 * 
 *
 * @see http://codingbat.com/prob/p155405
 */
public class ArraySquareUp {
	public int[] squareUp(int n) {
		int[] result = new int[n*n];
		int[] temp = new int[n];
		
		for (int i=0; i<n; i++ ) {
			temp[i] = 0;			
		}
		
		for (int i=1; i<=n; i++ ) {			
			for (int c=1; c<=n; c++) {
				if(c==i) {					
					temp[c-1] = i;			
				}
				result[i*n - c] = temp[c-1];
			}
		}
		return result;
	}
}
