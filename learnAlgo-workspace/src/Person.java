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
	Person p1 = new Person("a", "101");
	Person p2 = new Person("b", "102");
	Person p3 = new Person("c", "103");
	Person p4 = new Person("d", "104");
	Person p5 = new Person("e", "105");
	Person p6 = new Person("f", "106");
	Person p7 = new Person("g", "107");
	Person p8 = new Person("h", "108");
	Person p9 = new Person("i", "109");
	Person p10 = new Person("j", "110");
	Person p11 = new Person("k", "111");
	Person p12 = new Person("l", "112");
	
	
	
	
	
	System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2));
	System.out.println("p1.compareTo(p3) = " + p1.compareTo(p3));
	BinarySearchTree<Person> b = new BinarySearchTree<Person>(p1);
	b.add(p2);
	b.add(p3);
	b.add(p4);
	b.add(p5);
	b.add(p6);
	b.add(p7);
	b.add(p8);
	b.add(p9);
	b.add(p10);
	b.add(p11);
	b.add(p12);
	
	System.out.println("b.contains(p1) = " + b.contains(p1));
	System.out.println("b.contains(p2) = " + b.contains(p2));
    }

}

