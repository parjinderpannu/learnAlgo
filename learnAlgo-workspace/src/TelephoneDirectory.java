import java.util.Scanner;

class Name implements Comparable<Name>
{
    private String first;
    private String last;
    public Name() {
		first = last = null;
    }
    public Name(String firstName, String lastName) {
		first = firstName;
		last = lastName;
    }
    
    public int compareTo(Name n) {
		int c = first.compareTo(n.first);
		if(c == 0) 
			c = last.compareTo(n.last);
		return c;
    }
}

public class TelephoneDirectory
{
    private BSTDictionary< Name, String > phoneBook;
    public TelephoneDirectory () {
        phoneBook = new BSTDictionary < Name, String > ();
    } // end default constructor


    public void readFile (Scanner data) {
        while (data.hasNext ()) {
            String firstName = data.next ();
            String lastName = data.next ();
            String phoneNumber = data.next ();
            Name fullName = new Name (firstName, lastName);
            phoneBook.add (fullName, phoneNumber);
        } // end while
        data.close ();
    } // end readFile
    
    public String getPhoneNumber (Name personName)
    {
        return phoneBook.getValue (personName);
    } // end getPhoneNumber


    public String getPhoneNumber (String firstName, String lastName)
    {
        Name fullName = new Name (firstName, lastName);
        return phoneBook.getValue (fullName);
    } // end getPhoneNumber
    
} // end TelephoneDirectory
