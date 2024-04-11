package Tutor3.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		Person a = new Person(2, "C");
		Person b = new Person(4, "A");
		Person c = new Person(3, "D");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(a);
		persons.add(b);
		persons.add(c);
		
		System.out.println(persons);
		
		
		//sorts
		Collections.sort(persons);
		System.out.println(persons);
	}
}
