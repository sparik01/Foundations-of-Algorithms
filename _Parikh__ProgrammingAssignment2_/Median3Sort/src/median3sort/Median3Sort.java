/* Sheetal Parikh
 * Programming Assignment 2 - Question d
 * Median of 3 Quicksort First - Using the median of 3 as the pivot and inserting it as first element of array
 */
package median3sort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author SheetalParikh
 */
public class Median3Sort {

        public static int n = 50;                                         //adjust this value to change the size of the array and remove when testing one of the sorted arrays
	static int Swaps = 0;   
	static int Comparisons = 0;

	public static void main(String[] args) {
                //testing sorted arrays - first array is n = 50 and second is n = 100
		//int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
                //int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
                  
                System.out.println("Array size = "+n);                     //remove when testing sorted array
		//System.out.println("Array size = 50");                  //add when testing sorted array
                int array[] = new int[n];                                  // remove when testing sorted array
		int n = array.length-1;                                   
                                                                          //generating random integers for array
		//Random rand = new Random();                             //remove when testing sorted array
		for (int i = 0; i < array.length; i++) {
			//array[i] = rand.nextInt(100);                   //remove when testing sorted ;
		}
                
		System.out.println("\nOriginal:");                       //printing original unsorted array
		print(array);   
                
		System.out.println();                                   //printing aray after replacing pivot with median
		median3QuickSort(array, 0, n);
                
		System.out.println("\n\nAfter Quicksort:");             //printing array after quicksort
		print(array);
                
		System.out.println("\n\nSwaps: " + Swaps);                     
		System.out.println("Comparisons: " + Comparisons);      
	}

	public static int median3Pivot(int array[], int left, int right) {

		int first = array[left];                                                //finding middle value
		int last = array[array.length - 1];
		int middle = (right + left) / 2;

		int[] sortingArray = { array[left], array[middle], array[right] };     //creating array with right, middle, and left elements

		Arrays.sort(sortingArray);                                              //sorting array of 3 elements

		int median = sortingArray[1];                                           //median is 2nd element of array
                System.out.println("\nAfter replacing pivot with median:");

		int temp = array[left];                                                 //swapping with first to be pivot
		array[left] = median;
		if (median == array[right]) {
			array[right] = temp;
                        
		} else if (median == array[middle]) {
			array[middle] = temp;
                     
		}
                
		print(array);                                                           // printing array after replacing pivot with median
		return partition(array, left, right);
	}

	public static void median3QuickSort(int array[], int left, int right) {         //sorting median
		if (left >= right)
			return;
		if (left < right) {
			int q = median3Pivot(array, left, right);
			QuickSort(array, left, right);
		}
	}

	public static void QuickSort(int array[], int left, int right) {                //regular quicksort
		if (right > left) {
			int pivotindex = partition(array, left, right);
			QuickSort(array, left, pivotindex - 1);
			QuickSort(array, pivotindex + 1, right);
		}
	}
        
	public static int partition(int array[], int left, int right) {                 //partitioning array left to right
		int pivot = array[left];                                                //setting pivot as leftmost element
		int i = (left + 1);                                                     // index for smaller element
                int j = right;                                                          // index for larger element
                
                while (j > i) {                                                         
                   
                    while (i <= j && array[i] <= pivot)                                 // search forwards ; increment i if current less than or equal to pivot
                            i++;
                            Comparisons++;
                    
                    
                    while (i <= j && array[j] > pivot)                                  // Search backward from right; increment j if current less than j and j greater than pivot
                            j--;
                            Comparisons++;
                                        
                    if (j > i) { 
                                                            
			int temp = array[j];                                            // swapping array[i] and array[j]
			array[j] = array[i];
			array[i] = temp;
                           Swaps++;
			}
		}
                
                while (j > left && array[j] >= pivot)
			j--;
                        Comparisons++;

		if (pivot > array[j]) {                                                 //swapping pivot with array[left]
                    array[left] = array[j];
                    array[j] = pivot;
                    Swaps++;
                    return j;
                    
                }
		else {
		    return left;

		}
	}

	public static void print(int array[]) {                                         //printing array function
		int n = array.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(array[i] + " ");

		}
	}
	
}  //end program