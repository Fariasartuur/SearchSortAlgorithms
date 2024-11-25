package main;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	private static List<Student> students = new ArrayList<>();
	
	public void runClassroom() {
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
        
        float targetGrade = 81.9f;
        
        int resultIndex = interpolationSearch(students, 0, students.size() - 1, targetGrade);

        if (resultIndex != -1) {
            System.out.println("Student found: " + students.get(resultIndex));
        } else {
            System.out.println("Student with grade " + targetGrade + " not found.");
        }
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
	
	private static int interpolationSearch(List<Student> arr, int first, int last, Float num){
	    if(arr.isEmpty()) return -1;
	    
	    int count = 0;

	    while(first <= last && num >= arr.get(first).getGrade() && num <= arr.get(last).getGrade()){
	    	count++;
	    	int pos = first + (int) (((num - arr.get(first).getGrade()) * (last - first)) / (arr.get(last).getGrade() - arr.get(first).getGrade()));

	    	if(arr.get(pos).getGrade() == num){
	    		System.out.println("Student found in "+ count +" attempts");
	    		return pos;
	    	}

	    	if(arr.get(pos).getGrade() < num){
	    		first = pos + 1;
	    	}

	    	if(arr.get(pos).getGrade() > num){
	    		last = pos - 1;
	    	}
	    }

	    return -1;
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
