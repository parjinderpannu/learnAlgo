import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V>  {
	
	private Node firstNode; // head reference to first node
	private int numberOfEntries;
	
	public UnsortedLinkedDictionary() {
		clear();
	} // end default constructor
	
   public V add(K key, V value) {
	   V result = null;
      if( firstNode == null){
        Node currentNode = new Node(key,value);
        firstNode = currentNode;
        numberOfEntries++;
      }
      else{
        Node curentNode = firstNode;
        while( curentNode != null){
          if(curentNode.next == null){
            break;
          }
          if(key.equals(curentNode.getKey())) {
			   result = curentNode.getValue();
			   curentNode.setValue(value);
			   return result;
		   }
          curentNode = curentNode.next;
        }
        curentNode.next = new Node(key,value);
        numberOfEntries++;
      }
      return result;
   } // end add

   public V remove(K key) {
	   V result = null;
	   int count = 1; 

      if(numberOfEntries <= 1){//removes first element
        Node currentNode = firstNode;
        result = currentNode.getValue();
        firstNode = firstNode.next;
        currentNode.next = null;
        numberOfEntries--;
      }
      else{//removes the first and all other elements
        Node currentNode = firstNode;
        if(currentNode.key.equals(key)){
        	result = currentNode.getValue();
        	firstNode = currentNode.next;
          numberOfEntries--;
        }
        else{
          while(!currentNode.next.key.equals(key)){
            currentNode = currentNode.next;
            count++;
            if(count >=numberOfEntries && !currentNode.key.equals(key)) {
            		return null;
            }		     
          }
          result = currentNode.getValue();
          currentNode.next = currentNode.next.next;
          numberOfEntries--;
        }
      }
	return result;
   } // end remove

   public V getValue(K key) {
	   V result = null;
	   boolean found = false;
	   Node currentNode = firstNode;
	   
	   while(!found && (currentNode!=null)) {
		   if(key.equals(currentNode.getKey())) {
			   found = true;
			   return currentNode.getValue();
		   }
		   else
			   currentNode = currentNode.getNextNode();
	   } // end while
	   return result;
   } // end getValue

	public boolean contains(K key) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(key.equals(currentNode.getKey()))
				found = true;
			else 
				currentNode = currentNode.getNextNode();
		}
		return found;
   } // end contains

   public boolean isEmpty() {
	   boolean result;
	   
	   if(numberOfEntries == 0) {
		   assert firstNode == null;
		   result = true;
	   }
	   else {
		   assert firstNode != null;
		   result = false;
	   }
      return result;
   } // end isEmpty
	
   public int getSize() {
      return numberOfEntries;
   } // end getSize

	public final void clear() { 
		firstNode = null;
		numberOfEntries = 0;
	} // end clear

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	} // end getKeyIterator
	
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	} // end getValueIterator
	
	private class KeyIterator implements Iterator<K>{
		private Node currentNode;
		
		private KeyIterator() {
			currentNode = firstNode;
		}
		
		public boolean hasNext() {
			return (currentNode != null);
		}
		
		public K next() {
			K result = null;
			
			if(hasNext()) {
				result = currentNode.getKey();
				currentNode = currentNode.next;
			}
			else
				throw new NoSuchElementException();
			
			return result;
		}
		public void remove() {
			throw new NoSuchElementException();
		}
	}
	
	private class ValueIterator implements Iterator<V>{
		private Node currentNode;
		
		private ValueIterator() {
			currentNode = firstNode;
		}
		
		public boolean hasNext() {
			return (currentNode != null);
		}
		
		public V next() {
			V result = null;
			
			if(hasNext()) {
				result = currentNode.getValue();
				currentNode = currentNode.next;
			}
			else
				throw new NoSuchElementException();
			
			return result;
		}
		public void remove() {
			throw new NoSuchElementException();
		}
	}

	private class Node {
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
			next = null;	
		} // end constructor
		
		private Node(K searchKey, V dataValue, Node nextNode) {
			key = searchKey;
			value = dataValue;
			next = nextNode;	
		} // end constructor
		
		private K getKey() {
			return key;
		} // end getKey
		
		private V getValue() {
			return value;
		} // end getValue

		private void setValue(V newValue) {
			value = newValue;
		} // end setValue

		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end UnsortedLinkedDictionary
		
