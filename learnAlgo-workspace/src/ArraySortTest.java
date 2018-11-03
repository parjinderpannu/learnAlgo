
public class ArraySortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1= {3,6,5,1,4};
		int[] a2= {4,7,5,2,6,1};
		System.out.println(ArraySort.findMissing(a1));
		System.out.println(ArraySort.findMissing(a2));
		
		int[] a3 = {9,2,4,8,9,4,3,2,8,1,2,7,2,5};
		ArraySort.countingSort(a3, 9);
		for(int i: a3) {
			System.out.printf("%2d",i);
		}
		System.out.println("\nWorst Case running time for countingSort()"
				+ " in terms of m (length of array a) and n is O(m*n)");
		
//		int[] a4 = {3,2,0,1,6,4,5,4};
		
//		Integer[] a4 = {3,2,0,1,6,4,5,4};
//		
//		ArraySort.quickSort(a4, a4.length);
		
//		int[] a5 = {2,1,3,4,8,7,4,6,9};
//		System.out.println(ArraySort.findKSmallest(a5, 5));
		
	
		
		
		

	}

}
