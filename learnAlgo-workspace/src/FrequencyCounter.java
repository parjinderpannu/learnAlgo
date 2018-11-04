import java.util.Iterator;
import java.util.Scanner;
public class FrequencyCounter
{
    private BSTDictionary< String, Integer > wordTable;
    
    public FrequencyCounter ()
    {
        wordTable = new BSTDictionary < String, Integer > ();
    } // end default constructor

    public void readFile (Scanner data)
    {
        data.useDelimiter ("\\W+");
        while (data.hasNext ()) {
            String nextWord = data.next ();
            nextWord = nextWord.toLowerCase ();
            Integer frequency = wordTable.getValue (nextWord);
            if (frequency == null) { // add new word to table
                wordTable.add (nextWord, new Integer (1));
            }
            else { // increment count of existing word; replace wordTable entry
                frequency++;
                wordTable.add (nextWord, frequency);
            } // end if
        } // end while
        data.close ();
    } // end readFile
    
    public void display ()
    {
        Iterator < String > keyIterator = wordTable.getKeyIterator ();
        Iterator < Integer > valueIterator = wordTable.getValueIterator ();
        while (keyIterator.hasNext ()) {
            System.out.println (keyIterator.next () + " " +
				valueIterator.next ());
	} // end while
    } // end display
    
} // end FrequencyCounter
