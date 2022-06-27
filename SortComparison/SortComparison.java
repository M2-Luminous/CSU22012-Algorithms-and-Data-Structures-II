import java.io.BufferedReader;
import java.io.FileReader;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        //todo: implement the sort
    	for(int i = 1; i < a.length; i++) {
    		int j = i - 1;
    		int i2 = i;
    		double dummy = a[i];
    		while(j >= 0 && a[j] > dummy) {
    			a[i2] = a[j];
    			a[j] = dummy;
    			j--;
    			i2--;
    		}
    	}
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         //todo: implement the sort
    	for(int i = 0; i < a.length; i++) {
    		int imin = i;
    		for(int j = i + 1; j < a.length; j++) {
    			if(a[imin] > a[j])
    				imin = j;
    		}
    		double tmp = a[i];
    		a[i] = a[imin];
    		a[imin] = tmp;
    	}
    	return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     
    static double [] quickSort (double a[], int left, int right){
	
		 //todo: implement the sort
    	int i, j;
    	double piviot, temp;
    	i = left;
    	j = right;
    	piviot = a[(left + right) / 2];
    	
    	do
    	{
    		while((a[i] < piviot) && (i < right)) {
    			i++;
    		}
    		while((piviot < a[j]) && (j > left)) {
    			j--;
    		}
    			
    		if(i <= j) {
    			temp = a[i];
    			a[i] = a[j];
    			a[j] = temp;
    			i++;
    			j--;
    		}
    	}
    	while(i <= j);
    	
    	if(left < j) {
    		quickSort(a, left, j);
    	}
    	
    	if(i < right) {
    		quickSort(a, i, right);
    	}
    	
    	return a;
    }//end quicksort
*/
    
    static double [] quickSort (double a[]){
    	  //todo: implement the sort
    	recursiveQuick(a, 0, a.length-1);
    		return a;
    }
    
    private static void recursiveQuick(double[] a, int lo, int hi) {
    	if(hi <= lo) return;
    		int pivotPos = partition(a, lo, hi);
    	    recursiveQuick(a, lo, pivotPos-1);
    	    recursiveQuick(a, pivotPos+1, hi);
    }
    
    private static int partition(double[] a, int lo, int hi) {
    	int i = lo;
    	int j = hi+1;
    	double pivot = a[lo];
    	while(true) {
    		while((a[++i]<pivot)) {
    			if(i == hi) break;
    	    }
    	    while((pivot<a[--j])) {
    	    	if(j == lo) break;
    	    }
    	    if(i >= j) break;
    	    	double temp = a[i];
    	        a[i] = a[j];
    	        a[j] = temp;
    	}
    	a[lo] = a[j];
    	a[j] = pivot;
    	return j;
    }
    	    //end quicksort
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     

    static double[] mergeSortIterative (double a[], int left, int mid, int right) {
		 //todo: implement the sort
    	double b[] = new double[a.length];
    	
    	int i = left;
    	int j = mid + 1;
    	int k = left;
    	while(i < mid && j <= right) {
    		if(a[i] < a[j]) {
    			b[k] = a[i];
    			i++;
    		}
    		else {
    			b[k] = a[j];
    			j++;
    		}
    		k++;
    	}
    	if(i > mid) {
    		while(j <= right) {
    				b[k] = a[j];
    				k++;
    				j++;
    			}
    	}
    	else {
    		while( i <= mid) {
    			b[k] = a[i];
    			k++;
    			i++;
    		}
    	}
    	for( k = left; k <= right; k++) {
    		a[k] = b[k];
    	}
    	return a;
	
    }//end mergesortIterative
    
    */
    
    static double[] mergeSortIterative (double a[]) {
    	  //todo: implement the sort
    	double[] aux = new double[a.length];
    		for( int sz = 1; sz < a.length ; sz = sz + sz) {
    			for(int lo = 0; lo < a.length - sz ; lo += sz + sz) {
    				merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length-1));
    			}
    	    }
    return a;
    }
    
    private static void merge (double[] a,double[] aux,int lo,int mid,int hi) {
    	for(int k = lo; k <= hi;k ++)
    		aux[k] = a[k];        
        	int i = lo,j = mid+1;
        for(int k = lo; k <= hi; k ++) {
        	if(i > mid) a[k] = aux[j++];
        	else if(j > hi) a[k] = aux[i++];
        	else if(aux[j] < aux[i]) a[k] = aux[j++];
        	else a[k] = aux[i++];
        }
    }
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[], int left, int right) {
    	//todo: implement the sort
    	if(left < right) {
    		int mid = (left + right) / 2;
    		mergeSortRecursive(a, left, mid);
    		mergeSortRecursive(a, mid + 1, right);
    		mergeSortIterative(a);
    	}
    	return a;
	
   }//end mergeSortRecursive
    	
    


/* 


    public static void main(String[] args) {
    	try {
    		
        	FileReader reader1 = new FileReader("numbers1000.txt");
        	BufferedReader bReader1 = new BufferedReader(reader1);
        	double[] array1 = new double[10000];
        	String tmp1 = null;
        	while((tmp1 = bReader1.readLine()) != null) {
        		int i = 0;
        		array1[i++] = Double.valueOf(tmp1);
        	}
        	
        	bReader1.close();
        	double time1 = System.currentTimeMillis();
        	insertionSort(array1);        	
        	double t1 = System.currentTimeMillis() - time1;
        	time1 = System.currentTimeMillis();
        	selectionSort(array1);
        	double t2 = System.currentTimeMillis() - time1;
        	time1 = System.currentTimeMillis();
        	quickSort(array1);
        	double t3 = System.currentTimeMillis() - time1;
        	time1 = System.currentTimeMillis();
        	mergeSortIterative(array1);
        	double t4 = System.currentTimeMillis() - time1;
        	time1 = System.currentTimeMillis();
        	mergeSortRecursive(array1, 0, array1.length-1);
        	double t5 = System.currentTimeMillis() - time1;
        	System.out.print(t1 + "\n" + t2 + "\n" + t3 + "\n" + t4 + "\n" + t5);
        	
        	System.out.print("\n"+"\n");
        	
        	FileReader reader2 = new FileReader("numbers1000Duplicates.txt");
        	BufferedReader bReader2 = new BufferedReader(reader2);
        	double[] array2 = new double[10000];
        	String tmp2 = null;
        	while((tmp2 = bReader2.readLine()) != null) {
        		int i = 0;
        		array2[i++] = Double.valueOf(tmp2);
        	}
        	bReader2.close();
        	double time2 = System.currentTimeMillis();
        	insertionSort(array2);
        	double t6 = System.currentTimeMillis() - time2;
        	time2 = System.currentTimeMillis();
        	selectionSort(array2);
        	double t7 = System.currentTimeMillis() - time2;
        	time2 = System.currentTimeMillis();
        	quickSort(array2);
        	double t8 = System.currentTimeMillis() - time2;
        	time2 = System.currentTimeMillis();
        	mergeSortIterative(array2);
        	double t9 = System.currentTimeMillis() - time2;
        	time2 = System.currentTimeMillis();
        	mergeSortRecursive(array2, 0, array2.length-1);
        	double t10 = System.currentTimeMillis() - time2;
        	System.out.print(t6 + "\n" + t7 + "\n" + t8 + "\n" + t9 + "\n" + t10);
        	
        	System.out.print("\n"+"\n");
        	
        	
        	FileReader reader3 = new FileReader("numbersNearlyOrdered1000.txt");
        	BufferedReader bReader3 = new BufferedReader(reader3);
        	double[] array3 = new double[10000];
        	String tmp3 = null;
        	while((tmp3 = bReader3.readLine()) != null) {
        		int i = 0;
        		array3[i++] = Double.valueOf(tmp3);
        	}
        	bReader3.close();
        	double time3 = System.currentTimeMillis();
        	insertionSort(array3);
        	double t11 = System.currentTimeMillis() - time3;
        	time3 = System.currentTimeMillis();
        	selectionSort(array3);
        	double t12 = System.currentTimeMillis() - time3;
        	time3 = System.currentTimeMillis();
        	quickSort(array3);
        	double t13 = System.currentTimeMillis() - time3;
        	time3 = System.currentTimeMillis();
        	mergeSortIterative(array3);
        	double t14 = System.currentTimeMillis() - time3;
        	time3 = System.currentTimeMillis();
        	mergeSortRecursive(array3, 0, array3.length-1);
        	double t15 = System.currentTimeMillis() - time3;
        	System.out.print(t11 + "\n" + t12 + "\n" + t13 + "\n" + t14 + "\n" + t15);
        	
        	System.out.print("\n"+"\n");
        	
        	
        	FileReader reader4 = new FileReader("numbersReverse1000.txt");
        	BufferedReader bReader4 = new BufferedReader(reader4);
        	double[] array4 = new double[10000];
        	String tmp4 = null;
        	while((tmp4 = bReader4.readLine()) != null) {
        		int i = 0;
        		array4[i++] = Double.valueOf(tmp4);
        	}
        	bReader4.close();
        	double time4 = System.currentTimeMillis();
        	insertionSort(array4);
        	double t16 = System.currentTimeMillis() - time4;
        	time4 = System.currentTimeMillis();
        	selectionSort(array4);
        	double t17 = System.currentTimeMillis() - time4;
        	time4 = System.currentTimeMillis();
        	quickSort(array4);
        	double t18 = System.currentTimeMillis() - time4;
        	time4 = System.currentTimeMillis();
        	mergeSortIterative(array4);
        	double t19 = System.currentTimeMillis() - time4;
        	time4 = System.currentTimeMillis();
        	mergeSortRecursive(array4, 0, array4.length-1);
        	double t20 = System.currentTimeMillis() - time4;
        	System.out.print(t16 + "\n" + t17 + "\n" + t18 + "\n" + t19 + "\n" + t20);
        	
        	System.out.print("\n"+"\n");
        	
        	
        	FileReader reader5 = new FileReader("numbersSorted1000.txt");
        	BufferedReader bReader5 = new BufferedReader(reader5);
        	double[] array5 = new double[10000];
        	String tmp5 = null;
        	while((tmp5 = bReader5.readLine()) != null) {
        		int i = 0;
        		array5[i++] = Double.valueOf(tmp5);
        	}
        	bReader5.close();
        	double time5 = System.currentTimeMillis();
        	insertionSort(array5);
        	double t21 = System.currentTimeMillis() - time5;
        	time5 = System.currentTimeMillis();
        	selectionSort(array5);
        	double t22 = System.currentTimeMillis() - time5;
        	time5 = System.currentTimeMillis();
        	quickSort(array5);
        	double t23 = System.currentTimeMillis() - time5;
        	time5 = System.currentTimeMillis();
        	mergeSortIterative(array5);
        	double t24 = System.currentTimeMillis() - time5;
        	time5 = System.currentTimeMillis();
        	mergeSortRecursive(array5, 0, array5.length-1);
        	double t25 = System.currentTimeMillis() - time5;
        	time5 = System.currentTimeMillis();
        	System.out.print(t21 + "\n" + t22 + "\n" + t23 + "\n" + t24 + "\n" + t25);
        	
        	System.out.print("\n"+"\n");

        	
        	FileReader reader6 = new FileReader("numbers10000.txt");
        	BufferedReader bReader6 = new BufferedReader(reader6);
        	double[] array6 = new double[10000];
        	String tmp6 = null;
        	while((tmp6 = bReader6.readLine()) != null) {
        		int i = 0;
        		array6[i++] = Double.valueOf(tmp6);
        	}
        	bReader6.close();
        	double time6 = System.currentTimeMillis();
        	insertionSort(array6);
        	double t26 = System.currentTimeMillis() - time6;
        	time6 = System.currentTimeMillis();
        	selectionSort(array6);
        	double t27 = System.currentTimeMillis() - time6;
        	time6 = System.currentTimeMillis();
        	quickSort(array6);
        	double t28 = System.currentTimeMillis() - time6;
        	time6 = System.currentTimeMillis();
        	mergeSortIterative(array6);
        	double t29 = System.currentTimeMillis() - time6;
        	time6 = System.currentTimeMillis();
        	mergeSortRecursive(array6, 0, array6.length-1);
        	double t30 = System.currentTimeMillis() - time6;
        	time6 = System.currentTimeMillis();
        	System.out.print(t26 + "\n" + t27 + "\n" + t28 + "\n" + t29 + "\n" + t30);
        	
        	
    	}
    	catch(Exception e){
    		System.out.print("throw exception");
    	}
        //todo: do experiments as per assignment instructions
    }

*/
 }//end class

