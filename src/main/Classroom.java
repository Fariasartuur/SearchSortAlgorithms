package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classroom {
	
	private static List<Student> students = new ArrayList<>();
	
	public Classroom() {
		runClassroom();
	}
	
	private void runClassroom() {
		students.add(new Student("Alice", 92.5f));
        students.add(new Student("Bob", 85.3f));
        students.add(new Student("Charlie", 78.8f));
        students.add(new Student("Diana", 88.2f));
        students.add(new Student("Evan", 95.0f));
        students.add(new Student("Fiona", 67.4f));
        students.add(new Student("George", 74.6f));
        students.add(new Student("Hannah", 81.9f));
        students.add(new Student("Ian", 60.5f));
        students.add(new Student("Julia", 89.7f));        
        
	}
	
	public void searchStudent(float targetGrade, Algorithm al) {
		
		float minGrade = 0f;
        float maxGrade = 100f;
        
        for(Student s : students) {
        	System.out.println(s);
        }
        
        System.out.println("-------------------------------");
        
        bucketSortFloat(students.size(), minGrade, maxGrade);    
        
        for(Student s : students) {
        	System.out.println(s);
        }
        
        System.out.println("-------------------------------");
        List<Float> grades = new ArrayList<>();
		for(Student student : students) {
			grades.add(student.getGrade());
		}
		
		Collections.sort(grades);
        
        
        float result = al.interpolationSearchList(grades, 0, grades.size() - 1, targetGrade);

        if (result != -1) {
            for(Student student : students) {
            	if(student.getGrade() == targetGrade) {
            		System.out.println("Student Found: " + student);
                    return;
            	}
            }
        }
		
		System.out.println("Estudante com nota " + targetGrade + " não encontrado.");
	}
	
	private static void bucketSortFloat(int n, float min, float max) {
		if(n == 0) return;
		
		@SuppressWarnings("unchecked")
		ArrayList<Student>[] buckets = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			buckets[i] = new ArrayList<>();
		}
		
		for(Student s : students) {
			int bucket_idx = (int) ((s.getGrade() - min) / (max - min) * n);
			if (bucket_idx >= n) bucket_idx = n - 1;
			buckets[bucket_idx].add(s);
		}
		
		for(ArrayList<Student> bucket : buckets) {
			bucket.sort((s1, s2) -> Float.compare(s1.getGrade(), s2.getGrade()));
		}
		
		int index = 0;
		for(ArrayList<Student> bucket : buckets) {
			for(Student s : bucket) {
				students.set(index++, s);
			}
		}
	}

	public class Student{
		
		private String name;
		private float grade;
		
		public Student(String name, float grade) {
			this.name = name;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getGrade() {
			return grade;
		}

		public void setGrade(float grade) {
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", grade=" + grade + "]";
		}
		
		
		
		
	}

}
