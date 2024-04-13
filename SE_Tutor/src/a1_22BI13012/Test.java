package a1_22BI13012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test{
	public static void main(String[] args) {
		Student VuAnh = new Student(13012, "VuAnh", "0989675548", "IA20 Ciputra");
		UndergradStudent VuAnh2 = new UndergradStudent(1301200, "Lam", "0989675548", "IA20 Ciputra");
		PostgradStudent VuAnh3 = new PostgradStudent(130120001, "Tuan", "0989675548", "IA20 Ciputra", 3.9f);
		PostgradStudent VuAnh4 = new PostgradStudent(130120000, "An", "0989675548", "IA20 Ciputra", 3.2f);
		
		List<Student> students= new ArrayList<Student>();
		students.add(VuAnh);
		students.add(VuAnh2);
		students.add(VuAnh3);
		students.add(VuAnh4);
		System.out.println(students);
		
		// sorts
		Collections.sort(students);
		System.out.println(students);
	}
}
