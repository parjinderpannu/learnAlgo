public class Person implements Comparable<Person>{
    String name;
    String id;
    public Person(String n, String i) {
	name = n;
	id = i;
    }
    public int compareTo(Person p) {
	return name.compareTo(((Person)p).name);	
    }
}

class Test {
    public static void main(String [] a) {
	Person p1 = new Person("abc", "123");
	Person p2 = new Person("abc", "456");
	Person p3 = new Person("cde", "789");
	System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2));
	System.out.println("p1.compareTo(p3) = " + p1.compareTo(p3));
	BinarySearchTree<Person> b = new BinarySearchTree<Person>(p1);
	b.add(p2);
	b.add(p3);
	
	System.out.println("b.contains(p1) = " + b.contains(p1));
	System.out.println("b.contains(p2) = " + b.contains(p2));
    }

}

