package pl.edu.agh.java.exercises.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Consider the leftmost and righmost appearances of some value in an array.
 * We'll say that the "span" is the number of elements between the two
 * inclusive. A single value has a span of 1. Returns the largest span found in
 * the given array. (Efficiency is not a priority.)
 * 
 * Przyjmijmy, że odstęp "span" danej wartości w tablicy to liczba elementów
 * pomiędzy pierwszym i ostatniem jej wystąpieniem, włączając je same. Jeśli
 * wartość pojawia się w tablicy tylko raz, jej "span" jest równe 1. Metoda
 * maxSpan powinna zwracać największy istniejący odstęp w zadanej tablicy.
 * 
 * @see http://codingbat.com/prob/p189576
 */
public class ArraySpan {
	public int maxSpan(int[] array) {
		List<Integer> intList = Arrays.stream(array).boxed().collect(Collectors.toList()); 
		int temp = 0;
		int result = 0;
		for(int i = 0; i < intList.size(); i++) {
			temp =  intList.lastIndexOf(array[i]) - intList.indexOf(array[i]) + 1;
			result = temp > result ? temp : result;
		}
		return result;
	}
}
