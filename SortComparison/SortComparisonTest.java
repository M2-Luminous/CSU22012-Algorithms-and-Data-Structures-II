import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 *                        Insert		     Selection		    Quick		       Merge Rec		  Merge It
 *  1000 random           2                  2                  3                  1                  26
 *  1000 few unique       3                  1                  1                  0                  16
 *  1000 nearly ordered   1                  2                  0                  0                  15
 *  1000 reverse order    1                  0                  0                  0                  16
 *  1000 sorted           0                  0                  1                  0                  15
 *  10000 random          4                  15                 3                  0                  1895
 *  a. Which of these sorting algorithms does the order of input have an impact on? Why?
 *  
 *     insertion sort will experience influence when the input is reverse ordered because insertion sort
 *     can sort out a sorted array quickly but need to spend a large amount of time sorting a reverse array
 *     as it is a worst case.
 *     
	b. Which algorithm has the biggest difference between the best and worst performance, based
	   on the type of input, for the input of size 1000? Why?
	   
	   insertion sort have the biggest difference because it need to spend a large amount of time sort out a reverse order
	   array while sorting a sorted array quickly.
	   quick sort have a big difference too because it is design to sort numbers quickly when the input is bad, but 
	   not for the ideal input
	   
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	   based on the input size? Please consider only input files with random order for this answer.
	   
	   merge sort iteration have the worst scalability.
	   merge sort recursive have the best scalability.
	   
	d. Did you observe any difference between iterative and recursive implementations of merge sort?
	
	   iterative merge sort always cost much more time than the recursive one 
	
	e. Which algorithm is the fastest for each of the 6 input files?
	
		merge sort recursive is the fastest one among all 6 input files
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    
    @Test
    public void testInsertionSort(){
        // test non-empty list
        
        double[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
        
        SortComparison.insertionSort(sortedArray);
        assertArrayEquals(sortedArray, SortComparison.insertionSort(sortedArray), 10);        
                
        double[] testArray1 = {9,8,7,6,5,4,3,2,1,0};
        SortComparison.insertionSort(testArray1);
        assertArrayEquals(sortedArray, SortComparison.insertionSort(testArray1), 10);
        
        double[] testArray2 = {7,9,6,2,4,5,3,1,0,8};
        SortComparison.insertionSort(testArray2);
        assertArrayEquals(sortedArray, SortComparison.insertionSort(testArray2), 10);

        double[] testArray3 = {6,4,2,5,3,7,9,8,0,1};
        SortComparison.insertionSort(testArray3);
        assertArrayEquals(sortedArray, SortComparison.insertionSort(testArray3), 10);
        
        double[] testArray4 = {5,9,7,1,2,4,3,0,6,8};
        SortComparison.insertionSort(testArray4);
        assertArrayEquals(sortedArray, SortComparison.insertionSort(testArray4), 10);
        
        double[] testArray5 = {1,1,1,1,1,1,1,1,1,1};
        SortComparison.insertionSort(testArray5);
        assertArrayEquals(testArray5, SortComparison.insertionSort(testArray5), 10);
        
        double[] testArray6 = {1};
        SortComparison.insertionSort(testArray6);
        assertArrayEquals(testArray6, SortComparison.insertionSort(testArray6), 1);
        
        double[] testArray7 = new double[0];
        SortComparison.insertionSort(testArray7);
        assertArrayEquals(testArray7, SortComparison.insertionSort(testArray7), 0);

    }
    
    @Test
    public void testSelectionSort(){
        // test non-empty list
        
        double[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
        
        SortComparison.selectionSort(sortedArray);
        assertArrayEquals(sortedArray, SortComparison.selectionSort(sortedArray), 10); 
                
        double[] testArray1 = {9,8,7,6,5,4,3,2,1,0};
        SortComparison.selectionSort(testArray1);
        assertArrayEquals(sortedArray, SortComparison.selectionSort(testArray1), 10);
        
        double[] testArray2 = {7,9,6,2,4,5,3,1,0,8};
        SortComparison.selectionSort(testArray2);
        assertArrayEquals(sortedArray, SortComparison.selectionSort(testArray2), 10);

        double[] testArray3 = {6,4,2,5,3,7,9,8,0,1};
        SortComparison.selectionSort(testArray3);
        assertArrayEquals(sortedArray, SortComparison.selectionSort(testArray3), 10);
        
        double[] testArray4 = {5,9,7,1,2,4,3,0,6,8};
        SortComparison.selectionSort(testArray4);
        assertArrayEquals(sortedArray, SortComparison.selectionSort(testArray4), 10);
        
        double[] testArray5 = {1,1,1,1,1,1,1,1,1,1};
        SortComparison.selectionSort(testArray5);
        assertArrayEquals(testArray5, SortComparison.selectionSort(testArray5), 10);
        
        double[] testArray6 = {1};
        SortComparison.selectionSort(testArray6);
        assertArrayEquals(testArray6, SortComparison.selectionSort(testArray6), 1);
        
        double[] testArray7 = new double[0];
        SortComparison.selectionSort(testArray7);
        assertArrayEquals(testArray7, SortComparison.selectionSort(testArray7), 0);

    }

    @Test
    public void testQuickSort(){
        // test non-empty list
        
        double[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
        
        SortComparison.quickSort(sortedArray);
        assertArrayEquals(sortedArray, SortComparison.quickSort(sortedArray), 10); 
                
        double[] testArray1 = {9,8,7,6,5,4,3,2,1,0};
        SortComparison.quickSort(testArray1);
        assertArrayEquals(sortedArray, SortComparison.quickSort(testArray1), 10);
        
        double[] testArray2 = {7,9,6,2,4,5,3,1,0,8};
        SortComparison.quickSort(testArray2);
        assertArrayEquals(sortedArray, SortComparison.quickSort(testArray2), 10);

        double[] testArray3 = {6,4,2,5,3,7,9,8,0,1};
        SortComparison.quickSort(testArray3);
        assertArrayEquals(sortedArray, SortComparison.quickSort(testArray3), 10);
        
        double[] testArray4 = {5,9,7,1,2,4,3,0,6,8};
        SortComparison.quickSort(testArray4);
        assertArrayEquals(sortedArray, SortComparison.quickSort(testArray4), 10);
        
        double[] testArray5 = {1,1,1,1,1,1,1,1,1,1};
        SortComparison.quickSort(testArray5);
        assertArrayEquals(testArray5, SortComparison.quickSort(testArray5), 10);
        
        double[] testArray6 = {1};
        SortComparison.quickSort(testArray6);
        assertArrayEquals(testArray6, SortComparison.quickSort(testArray6), 1);
        

    }
    
    @Test
    public void testMergeSortR(){
        // test non-empty list
        
        double[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
        
        SortComparison.mergeSortRecursive(sortedArray, 0, 10-1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(sortedArray, 0, 10-1), 10); 
                
        double[] testArray1 = {9,8,7,6,5,4,3,2,1,0};
        SortComparison.mergeSortRecursive(testArray1, 0, 10-1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(testArray1, 0, 10-1), 10);
        
        double[] testArray2 = {7,9,6,2,4,5,3,1,0,8};
        SortComparison.mergeSortRecursive(testArray2, 0, 10-1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(testArray2, 0, 10-1), 10);

        double[] testArray3 = {6,4,2,5,3,7,9,8,0,1};
        SortComparison.mergeSortRecursive(testArray3, 0, 10-1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(testArray3, 0, 10-1), 10);
        
        double[] testArray4 = {5,9,7,1,2,4,3,0,6,8};
        SortComparison.mergeSortRecursive(testArray4, 0, 10-1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(testArray4, 0, 10-1), 10);
        
        double[] testArray5 = {1,1,1,1,1,1,1,1,1,1};
        SortComparison.mergeSortRecursive(testArray5, 0, 10-1);
        assertArrayEquals(testArray5, SortComparison.mergeSortRecursive(testArray5, 0, 10-1), 10);
        
        double[] testArray6 = {1};
        SortComparison.mergeSortRecursive(testArray6, 0, 1-1);
        assertArrayEquals(testArray6, SortComparison.mergeSortRecursive(testArray6, 0, 1-1), 1);
        

    }
    
    @Test
    public void testMergeSortI(){
        // test non-empty list
        
        double[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
        
        SortComparison.mergeSortIterative(sortedArray);
        assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(sortedArray), 10); 
                
        double[] testArray1 = {9,8,7,6,5,4,3,2,1,0};
        SortComparison.mergeSortIterative(testArray1);
        assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(testArray1), 10);
        
        double[] testArray2 = {7,9,6,2,4,5,3,1,0,8};
        SortComparison.mergeSortIterative(testArray2);
        assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(testArray2), 10);

        double[] testArray3 = {6,4,2,5,3,7,9,8,0,1};
        SortComparison.mergeSortIterative(testArray3);
        assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(testArray3), 10);
        
        double[] testArray4 = {5,9,7,1,2,4,3,0,6,8};
        SortComparison.mergeSortIterative(testArray4);
        assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(testArray4), 10);
        
        double[] testArray5 = {1,1,1,1,1,1,1,1,1,1};
        SortComparison.mergeSortIterative(testArray5);
        assertArrayEquals(testArray5, SortComparison.mergeSortIterative(testArray5), 10);
        
        double[] testArray6 = {1};
        SortComparison.mergeSortIterative(testArray6);
        assertArrayEquals(testArray6, SortComparison.mergeSortIterative(testArray6), 1);
        

    }
    
    
    
}

