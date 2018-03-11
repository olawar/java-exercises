package pl.edu.agh.java.exercises.arrays;

import java.util.Arrays;

/**
 * Given an array, return true if there is a place to split the array so that
 * the sum of the numbers on one side is equal to the sum of the numbers on the
 * other side.
 * 
 * Dla zadanej tablicy zwróć true, jeśli da się tak rozmieścić jej elementy, że
 * suma jej elementów w lewej i w prawej połowie będzie równa.
 * 
 * @see http://codingbat.com/prob/p158767
 */
public class ArrayBalance {
	public boolean canBalance(int[] array) {
				
		int cutPoint =  (int) Math.floor((array.length / 2));
		boolean isEqual = array.length % 2 == 0;
		int[] beginning = Arrays.copyOfRange(array, 0, cutPoint);
		int[] end = Arrays.copyOfRange(array, (isEqual ? cutPoint : cutPoint+1), array.length);
		
		if(!isBalance(beginning, end)) {
			for(int i=0; i<beginning.length; i++) {
				int temp=beginning[i];
					
				for(int j=0; j<end.length; j++) {
					beginning[i] = end[j];
					end[j] = temp;
					if(isBalance(beginning, end)) {
						return true;
					}
				}
			}
			
			if (!isEqual && array.length > 1) {
				for(int i=0; i<beginning.length; i++) {
					int temp=beginning[i];
							
					int ignore = array[cutPoint];
					beginning[i] = ignore;					
					
					if(!isBalance(beginning, end)) {
						for(int k=0; k<end.length; k++) {
							beginning[i] = end[k];
							end[k] = ignore;
							if(!isBalance(beginning, end)) {
								beginning[i] = temp;
								end[k] = ignore;
								if(isBalance(beginning, end) ) {
									return true;
								};
							}
						}
					} else {
						return true;
					}				
				} 
			} 
			return false;
		} 
		return true;

	}
	
	private Boolean isBalance(int[] array1, int[] array2) {
	
		int sum1 = Arrays.stream(array1).reduce(0, Integer::sum);
		int sum2 = Arrays.stream(array2).reduce(0, Integer::sum);		
		return sum1 == sum2;
		
	}
}
