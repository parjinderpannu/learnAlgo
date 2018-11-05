
public class ArraySortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("**********P1**************");
		System.out.println("Using following array");
		int[] a1= {3,6,5,1,4};
		for(int i=0;i<a1.length;i++) {
			System.out.printf("%4d",a1[i]);
		}
		System.out.println();
		System.out.println("ArraySort.findMissing(a1): "+ArraySort.findMissing(a1));
		
		System.out.println();
		int[] a2= {4,7,5,2,6,1};
		for(int i=0;i<a2.length;i++) {
			System.out.printf("%4d",a2[i]);
		}
		System.out.println();
		System.out.println("ArraySort.findMissing(a2): "+ArraySort.findMissing(a2));
		
		System.out.println();
		System.out.println("**********P2**************");
		System.out.println("Using following array");
		int[] a3 = {9,2,4,8,9,4,3,2,8,1,2,7,2,5};
		
		for(int i=0;i<a3.length;i++) {
			System.out.printf("%4d",a3[i]);
		}
		System.out.println();
		System.out.println("a3 after ArraySort.countingSort(a3, 9)");
		ArraySort.countingSort(a3, 9);
		System.out.println();
		for(int i=0;i<a3.length;i++) {
			System.out.printf("%4d",a3[i]);
		}
		System.out.println("\nWorst Case running time for countingSort()"
				+ " in terms of m (length of array a) and n is O(m*n)");
		

		System.out.println();
		System.out.println("**********P3**************");
		System.out.println("Using following array");
		
		int[] a5 = {9,1,3,4,5,7,8,6,2,11,11,34,97,58};
		
		for(int i=0;i<a5.length;i++) {
			System.out.printf("%4d",a5[i]);
		}
		System.out.println();
		System.out.println("ArraySort.findKSmallest(a5, 1): "+ArraySort.findKSmallest(a5, 1));
		System.out.println("ArraySort.findKSmallest(a5, 4): "+ArraySort.findKSmallest(a5, 4));
		System.out.println("ArraySort.findKSmallest(a5, 7): "+ArraySort.findKSmallest(a5, 7));
		System.out.println("ArraySort.findKSmallest(a5, 10): "+ArraySort.findKSmallest(a5, 10));
		System.out.println("ArraySort.findKSmallest(a5, 14): "+ArraySort.findKSmallest(a5, 14));
		
		System.out.println();
		System.out.println("ArraySort.findMedian(a5): "+ArraySort.findMedian(a5));
	
		
		
		

	}

}
