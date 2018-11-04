import java.util.Iterator;

public class UnsortedArrayDictionaryDriver {
    public static void main(String[] args)  {
		testDictionary();
    }  // end main

    public static void display(UnsortedArrayDictionary<String, String> dictionary) {
		Iterator<String>   keyIterator   = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();
		
		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	} // end display
		
	public static void testDictionary() {
		String dirk   = "Dirk";
		String abel   = "Abel";
		String miguel = "Miguel";
		String tabbie = "Tabatha";
		String tom    = "Tom";
		String sam    = "Sam";
		String reiss  = "Reiss";
		String bette  = "Bette";
		String carole = "Carole";
		String derek  = "Derek";
		String nancy  = "Nancy";
		String bogus  = "Bo"; 
		
		// create a dictionary 
		System.out.println("Creating dictionary:\n");
		UnsortedArrayDictionary<String, String> nameList = new UnsortedArrayDictionary<String, String>();
		
		System.out.println("\n\nTesting isEmpty():\n");
		if(nameList.isEmpty() == true)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// test add		
		System.out.println("\n\nTesting add():\n");

		nameList.add(dirk,   "555-1234");
		nameList.add(abel,   "555-5678");
		nameList.add(miguel, "555-9012");
		nameList.add(tabbie, "555-3456");
		nameList.add(tom,    "555-5555");
		nameList.add(sam,    "555-7890");
		nameList.add(reiss,  "555-2345");
		nameList.add(bette,  "555-7891");
		nameList.add(carole, "555-7892");
		nameList.add(derek,  "555-7893");
		nameList.add(nancy,  "555-7894");
		System.out.println("\n\nTesting getSize():\n");
		if(nameList.getSize() == 11)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		display(nameList);
		
		// test getValue
		System.out.println("\n\nTesting getValue():\n");
		System.out.println("\nSam:    " + nameList.getValue(sam)    + " should be 555-7890");
		System.out.println("\nTom:    " + nameList.getValue(tom)    + " should be 555-5555");
		System.out.println("\nReiss:  " + nameList.getValue(reiss)  + " should be 555-2345");
			
		// test contains
		System.out.println("\n\n\nTesting contains():\n");
		
		if ( nameList.contains(sam) )
			System.out.println("\nSam is in dictionary - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( nameList.contains(abel) )
			System.out.println("\nAbel is in dictionary - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( nameList.contains(miguel) )
			System.out.println("\nMiguel is in dictionary - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( nameList.contains(tom) )
			System.out.println("\nTom is in dictionary - OK");
		else 
			System.out.println("Error in contains()");
		
		if (!nameList.contains(bogus))
			System.out.println("\nBo is not in dictionary - OK");
		else 
			System.out.println("Error in contains()");
		
		// remove first item
		System.out.println("\n\n\nRemoving first item Dirk - Dirk's number is " + 
				   nameList.remove(dirk) + " should be 555-1234");
		
		// test replacing value
		System.out.println("Replacing phone number of Reiss and Miguel:\n");
		String oldNumber = nameList.add(reiss,  "555-5432");
		System.out.println("Reiss's old number " + oldNumber + " is replaced by 555-5432");
		oldNumber = nameList.add(miguel, "555-2109");     
		System.out.println("Miguel's old number " + oldNumber + " is replaced by 555-2109");
		
		System.out.println("\n" + nameList.getSize() + 
				   " (should be 10) items in dictionary, as follows:\n");
		display(nameList);
			
		// remove interior and last items
		System.out.println("\n\nRemoving interior item Reiss and last item Nancy:\n");
		nameList.remove(reiss);
		nameList.remove(nancy);
		
		// remove Bo (not in dictionary)				
		System.out.println("\nRemoving Bo (not in dictionary):\n");
		String result = nameList.remove(bogus);
		if (result == null)
			System.out.println("Bo was not found in the dictionary.");
		else
			System.out.println("Error in remove().");
		
		System.out.println("\n\n" + nameList.getSize() + 
				   " (should be 8) items in dictionary, as follows:\n");
		display(nameList);
		
		// test clear
		System.out.println("\n\nTesting clear():\n");
		nameList.clear();
		
		System.out.println("Dictionary should be empty; isEmpty() returns " + 
				   nameList.isEmpty());
    } // testDictionary
    
   
}  // end Driver
