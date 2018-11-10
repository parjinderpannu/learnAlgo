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
//	   boolean found = false;
//	   Node newNode = new Node(key,value);
//	   Node currentNode = firstNode;
//	   
//	   if(isEmpty()) {
//		   firstNode = newNode;
//		   numberOfEntries++;
//	   }
//	   else {
//		   while(!found && (currentNode!=null)) {
//			   if(currentNode.next == null)
//				   break;
//			   if(key.equals(currentNode.getKey())) {
//				   found = true;
//				   result = currentNode.getValue();
//				   currentNode.setValue(value);
//				   return result;
//			   }
//			   else
//				   currentNode = currentNode.getNextNode();
//		   } // end while 
//		   if(currentNode.next==null) {
//			   currentNode.next = newNode;
//			   numberOfEntries++;
//		   }
//	   }
//	   

	   
		 
		      if( firstNode == null){
		        Node N = new Node(key,value);
		        firstNode = N;
		        numberOfEntries++;
		      }
		      else{
		        Node N = firstNode;
		        while( N != null){
		          if(N.next == null){
		            break;
		          }
		          if(key.equals(N.getKey())) {
					   result = N.getValue();
					   N.setValue(value);
					   return result;
				   }
		          N = N.next;
		        }
		        N.next = new Node(key,value);
		        numberOfEntries++;
		      }
			   return result;
   } // end add

   public V remove(K key) {
	   V result = null;
	   int count = 1;
//	   Node currentNode = firstNode;
	   Node nodeBefore = null;
//	   
//	   if(numberOfEntries ==1 && key.equals(currentNode.getKey())) { //first node
//		   result = currentNode.getValue();
//		   firstNode = firstNode.next;
//		   currentNode.next = null;
//		   numberOfEntries--;
//	   }
//	   else {
//		   while(!key.equals(currentNode.next.getKey()) && currentNode.next != null) {
//			   nodeBefore = currentNode;
//			   currentNode = currentNode.getNextNode();
//			   count++;
//		   }
//		   if(count<numberOfEntries) { // another node except first & last
//			  result = currentNode.getValue();
//			  currentNode.next = currentNode.next.next; 
//			  numberOfEntries--;
//		   }
//		   else if(count == numberOfEntries) { // last node
//			   result = currentNode.getValue();
//			   currentNode = nodeBefore;
//			   nodeBefore.next = null;
//			   numberOfEntries--;
//		   }
//		   
//	   }
	   
	 
		      if(numberOfEntries <= 1){//removes first element
		        Node N = firstNode;
		        result = N.getValue();
		        firstNode = firstNode.next;
		        N.next = null;
		        numberOfEntries--;
		      }
		      else{//removes the first and anyother element
		        Node N = firstNode;
		        if(N.key.equals(key)){
		        	result = N.getValue();
		        	firstNode = N.next;
		          numberOfEntries--;
		        }
		        else{
		          while(!N.next.key.equals(key)){
		        	    nodeBefore = N;
		            N = N.next;
		            count++;
		            if(count >=numberOfEntries && !N.key.equals(key)) {
		            		return null;
		            }		     
		          }
		          result = N.getValue();
		          N.next = N.next.next;
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
			return (currentNode.next != null);
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
			return (currentNode.next != null);
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
		
