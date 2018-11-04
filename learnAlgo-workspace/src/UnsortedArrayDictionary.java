import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedArrayDictionary<K, V>
{
    private Entry<K, V>[] dictionary; // array of unsorted entries
    private int numberOfEntries;
    private final static int DEFAULT_INITIAL_CAPACITY = 6;
    
    public UnsortedArrayDictionary() {
	this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor
    
    public UnsortedArrayDictionary(int initialCapacity) {
	// the cast is safe because the new array contains null entries
	@SuppressWarnings("unchecked")
	    Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[initialCapacity];
	dictionary = tempDictionary;
	numberOfEntries = 0;
    } // end constructor
    
    public V add(K key, V value)  {
	V result = null;
	int keyIndex = locateIndex(key);
	if (keyIndex < numberOfEntries) {
	    // key found, return and replace old value 
	    result = dictionary[keyIndex].getValue(); // old value
	    dictionary[keyIndex].setValue(value); 		// replace value
   	}
   	else {  
	    ensureCapacity();
	    // add at end of array
	    dictionary[numberOfEntries] = new Entry<K, V>(key, value); 
	    numberOfEntries++;
	} // end if
	
	return result;
    } // end add
    
    public V remove(K key) {
   	V result = null;
   	int keyIndex = locateIndex(key);
   	
   	if (keyIndex < numberOfEntries) {
	    result = dictionary[keyIndex].getValue();
	    dictionary[keyIndex] = dictionary[numberOfEntries - 1]; // replace removed entry with last entry
	    numberOfEntries--;
   	} // end if
   	// else result is null
   	
	return result;
  } // end remove

  public V getValue(K key) {
      V result = null;
      
      int keyIndex = locateIndex(key);
      
      if (keyIndex < numberOfEntries) {
	  result = dictionary[keyIndex].getValue();
      } // end if
      
      return result;
  } // end getValue
  
  public boolean contains(K key) {
      return getValue(key) != null; 
  } // end contains
  
  public boolean isEmpty() {
      return numberOfEntries == 0;
  } // end isEmpty
  
  public int getSize() {
      return numberOfEntries;
  } // end getSize
  
  public final void clear() { 
      numberOfEntries = 0;
  } // end clear
  
  public Iterator<K> getKeyIterator() {
      return new KeyIterator();
  } // end getKeyIterator
  
  public Iterator<V> getValueIterator() {
      return new ValueIterator();
  } // end getValueIterator
  
  // Returns the index of the entry that contains the given search key, or 
  // numberOfEntries if no such entry exists.
  private int locateIndex(K key) {
      // sequential search
      int index = 0;
      while ( (index < numberOfEntries) && !key.equals(dictionary[index].getKey()) )
	  index++;
      
      return index;
  } // end locateIndex
  
  // Doubles the size of the array dictionary if it is full
  private void ensureCapacity() {
      if (numberOfEntries == dictionary.length)
	  dictionary = Arrays.copyOf(dictionary, 2 * dictionary.length);
  } // end ensureCapacity
  
  // Same as SortedArrayDictionary
  private class KeyIterator implements Iterator<K> {
      private int currentIndex;
      
      private KeyIterator() {
	  currentIndex = 0;
      } // end default constructor
      
      public boolean hasNext()  {
	  return currentIndex < numberOfEntries;
      } // end hasNext
      
      public K next() {
	  K result = null;
	  
	  if (hasNext()) {
	      Entry<K,V> currentEntry = dictionary[currentIndex];
	      result = currentEntry.getKey();
	      currentIndex++;
	  }
	  else
	      throw new NoSuchElementException();
	  
	  return result;
      } // end next
      
      public void remove(){
	  throw new UnsupportedOperationException();
      } // end remove
  } // end KeyIterator 
  
  private class ValueIterator implements Iterator<V> {
      private int currentIndex;
      
      private ValueIterator() {
	  currentIndex = 0;
      } // end default constructor
      
      public boolean hasNext() {
	  return currentIndex < numberOfEntries;
      } // end hasNext
      
      public V next() {
	  V result = null;
	  
	  if (hasNext()) {
	      Entry<K,V> currentEntry = dictionary[currentIndex];
	      result = currentEntry.getValue();
	      currentIndex++;
	  }
	  else
	      throw new NoSuchElementException();
	  return result;
      } // end next
      
      public void remove() {
	  throw new UnsupportedOperationException();
      } // end remove
  } // end getValueIterator
  
  private class Entry<S, T> {
      private S key;
      private T value;
      
      private Entry(S searchKey, T dataValue) {
	  key = searchKey;
	  value = dataValue;
      } // end constructor
      
      private S getKey() {
	  return key;
      } // end getKey
      
      private T getValue() {
	  return value;
      } // end getValue
      
      private void setValue(T dataValue) {
	  value = dataValue;
      } // end setValue
  } // end Entry
} // end UnsortedArrayDictionary
