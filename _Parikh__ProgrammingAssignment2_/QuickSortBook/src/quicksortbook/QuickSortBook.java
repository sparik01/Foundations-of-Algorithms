/* Sheetal Parikh
 * Programming Assignment 2 - Question d
 * Regular Quicksort - Using the CLRS book's algorithm in which the last element is the pivot
 */
package quicksortbook;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author SheetalParikh
 */
public class QuickSortBook {

    public static int n = 50;                                   //adjust this value to change the size of the array
    static int Swaps = 0;
    static int Comparisons = 0;
        
    public static void main(String args[]) {
        //testing sorted arrays - first array is n = 50 and second is n = 100
        //int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
        //int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        
        System.out.println("Array size = "+n);                                   //remove when testing sorted array
        //System.out.println("Array Size = 50");                                 //add when testing sorted array
        int array[] = new int[n];                                                //remove when testing sorted array
        int n = array.length - 1;
       
        Random rand = new Random();                                              //generating random numbers for array
        for (int i = 0; i < array.length; i++) {    
            array[i] = rand.nextInt(100);                                        //update number for large input
        }

        System.out.println("\nOriginal:");                                      //printing original unsorted array
        print(array);
            
        Quicksort(array, 0, n-1);                                               //printing array after quicksort
        System.out.println("\n\nAfter Quicksort:");
        print(array);
            
        System.out.println("\n\nSwaps: " + Swaps);
        System.out.println("Comparisons: " + Comparisons);
    }    

    
    public static int partition(int array[], int left, int right) {         
        int pivot = array[right];                                               //setting pivot as rightmost element
        int i = (left - 1);                                                     //index for smaller element

            for (int j = left; j < right; j++) {                                //if current smaller than or equal to pivot 
                if (array[j] <= pivot) {
                    i++;

                    int temp = array[j];                                        // then swap array[i] and array[j]
                    array[j] = array[i];
                    array[i] = temp;
                            Swaps++;
		}
                        Comparisons++;
            }
                         
		int temp = array[i + 1];                                        // swap array[i+1] with pivot
		array[i + 1] = array[right];
		array[right] = temp;
                    Swaps++;
                    return i+1;
	}

    public static void Quicksort(int array[], int left, int right) {            //regular Quicksort  
        if (left < right) {

        int q = partition(array, left, right);
            Quicksort(array, left, q - 1);
            Quicksort(array, q + 1, right);
        }
    }
    
    public static void print(int array[]) {                                     //method to print array
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }     
}

