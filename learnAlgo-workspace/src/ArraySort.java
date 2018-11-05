import java.util.Arrays;

public class ArraySort
{
	
    public static <T extends Comparable<? super T>>
			     void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n - 1);
    } 

    public static <T extends Comparable<? super T>>
			     void mergeSort(T[] a, int first, int last) {
		@SuppressWarnings("unchecked")
	    T[] tempArray = (T[])new Comparable<?>[a.length];
	    mergeSort(a, tempArray, first, last);
    } 
	
    private static <T extends Comparable<? super T>>
			      void mergeSort(T[] a, T[] tempArray, int first, int last)
    {
		if (first < last) {  // sort each half
			int mid = (first + last) / 2;// index of midpoint
			mergeSort(a, first, mid);  // sort left half array[first..mid]
			mergeSort(a, mid + 1, last); // sort right half array[mid+1..last]
	    
			if (a[mid].compareTo(a[mid + 1]) > 0)     
				merge(a, tempArray, first, mid, last); // merge the two halves
			//	else skip merge step
		} 
    } 
    
    private static <T extends Comparable<? super T>> 
			      void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;
	
		// while both subarrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // next available location in
		// tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) {  
	    
			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {  
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			}
			else {  
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}  
		}  
	
		// finish off the nonempty subarray
	
		// finish off the first subarray, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			tempArray[index] = a[beginHalf1];
	
		// finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			tempArray[index] = a[beginHalf2];
	
		// copy the result back into the original array
		for (index = first; index <= last; index++)
			a[index] = tempArray[index];
	}
    /**
     * 
     * @param a array of integers
     * @return missing integer
     */
    public static int findMissing(int[] a) {
    		int sum = 0;
    		int sumWithMissingNo = ((a.length+1)*(a.length+2))/2;
    		for(int i=0; i<a.length;i++) {
    			sum = a[i]+sum;
    		}
		return sumWithMissingNo - sum;
	}
    
    /**
     * 
     * @param a array of integers
     * @param n size of array
     */
    public static void countingSort(int[] a, int n ) {
    		int[] count = new int[n];
    		int current = 0;
    		
    		for(int i=0;i<a.length;i++) {
    			++count[a[i]-1];
    		}
    		
    		for(int i=0;i<count.length;i++) {
    			Arrays.fill(a, current, current + count[i], i+1);
    			current += count[i];
    		}
    		
//    		System.out.println(count.toString());
    	
    }
    // find Median

    
    public static int findMedian(int[] a) {
    		return findKSmallest(a,a.length/2);
    }
 
    
    public static int findKSmallest(int[] a, int k) {
    		int right = a.length-1;
    		int kthSmallest = a[0];
    		
    		if(k > 0 && k<= right+1) {
    			
    			Integer[] aInt1 = Arrays.stream(a).boxed().toArray(Integer[]::new);
    			int pos = partitionL(aInt1, 0, right);
    			a = Arrays.stream(aInt1).mapToInt(Integer::intValue).toArray();;
    			
    			if(pos == k-1) {
    				kthSmallest = a[pos];
    				return kthSmallest;
    			}
    			
    			if(pos>k-1) {
    				int[] aInt2 = new int[pos];
        			System.arraycopy(a, 0, aInt2, 0, pos);
        			kthSmallest = findKSmallest(aInt2,k);
        			return kthSmallest;
    			}
    			else {
    				int[] aInt3 = new int[right - pos];
        			System.arraycopy(a, pos+1, aInt3, 0, right-pos);
        			kthSmallest = findKSmallest(aInt3,k-pos-1);
        			return kthSmallest;  
    			}
    						
    		}
    		return -1;
    }
       
   
    // Quick Sort
    
    // Median-of-three privot selection
    // Sort by comparison
    private static <T extends Comparable<? super T>>
			      void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
		// Note similarity to bubble sort
		order(a, first, mid); // make a[first] <= a[mid]
		order(a, mid, last);  // make a[mid] <= a[last]
		order(a, first, mid); // make a[first] <= a[mid]
    } 

    private static <T extends Comparable<? super T>>
			      void order(T[] a, int i, int j)
    {
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
    } 
    
    
    private static void swap(Object[] array, int i, int j)
    {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp; 
    } 
    
    // Partitioning with pivot at last index
    public static int partitionL(Integer [] a, int left, int right) 
	{ 
		int x = a[right], index = left; 
		for (int j = left; j <= right - 1; j++) 
		{ 
			if (a[j] <= x) 
			{ 
				swap(a,index,j);
				index++; 
			} 
		} 
		swap(a,index,right);
		return index; 
	}
    // Partitioning
    
    private static <T extends Comparable<? super T>>
			      int partition(T[] a, int first, int last)
    {
		int mid = (first + last)/2;
		sortFirstMiddleLast(a, first, mid, last);

		// move pivot to next-to-last position in array
		swap(a, mid, last - 1);
		int pivotIndex = last - 1;
		T pivot = a[pivotIndex];

		// determine subarrays Smaller = a[first..endSmaller]
		// and                 Larger  = a[endSmaller+1..last-1]
		// such that entries in Smaller are <= pivot and 
		// entries in Larger are >= pivot; initially, these subarrays are empty
	
		int indexFromLeft = first + 1; 
		int indexFromRight = last - 2;
	
		boolean done = false;
		while (!done) {
			// starting at beginning of array, leave entries that are < pivot;
			// locate first entry that is >= pivot; you will find one,
			// since last entry is >= pivot
			while (a[indexFromLeft].compareTo(pivot) < 0)
				indexFromLeft++;
			
			// starting at end of array, leave entries that are > pivot; 
			// locate first entry that is <= pivot; you will find one, 
			// since first entry is <= pivot
			
			while (a[indexFromRight].compareTo(pivot) > 0)
				indexFromRight--;
					   
			if (indexFromLeft < indexFromRight)
			{
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else 
				done = true;
		} // end while
	
		// place pivot between Smaller and Larger subarrays
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		
		return pivotIndex; 
    } 
    public static <T extends Comparable<? super T>>
			     void quickSort(T[] a, int n) {
		quickSort(a, 0, n - 1);
    } 
    
    public static <T extends Comparable<? super T>>
			     void quickSort(T[] a, int first, int last) {
		// perform recursive step if 2 or more elements
		if(first < last) {
			// create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(a, first, last);
			
			// sort subarrays Smaller and Larger
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		} 
    }
}
