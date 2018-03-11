package pl.edu.agh.java.exercises.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

		boolean isEven = array.length % 2 == 0;		
		int totalSum =  Arrays.stream(array).reduce(0, Integer::sum);
		Arrays.sort(array);
		List<Integer> intList = Arrays.stream(array).boxed().collect(Collectors.toList());
		
		if(isEven) {
			return isBalance(intList, totalSum);			
		} else {			
			for(int i=0; i<intList.size(); i++) {	
				List<Integer> tempList = Arrays.stream(array).boxed().collect(Collectors.toList());
				tempList.remove(i); 
				totalSum = tempList.stream().reduce(0, Integer::sum);
				if (isBalance(tempList, totalSum)) {
					return true;
				}		 
			}
		}
		return false;
	}
	
	private Boolean isBalance(List<Integer> intList, int totalSum) {
		if (totalSum % 2 != 0) {
			return false;
		} else {
			int partialSum = 0;
			for (int i=intList.size()-1; i>=0; i--) {
				if(intList.get(i) <= totalSum/2 - partialSum && intList.size() > intList.size()/2) {
					partialSum += intList.get(i);
					intList.remove(i);
				}
			}
			return partialSum == intList.stream().reduce(0,  Integer::sum);
		}		
	}
}
