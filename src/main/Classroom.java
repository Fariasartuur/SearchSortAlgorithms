package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classroom {
	
	private static List<Estudante> estudantes = new ArrayList<>();
	
	public Classroom() {
		runClassroom();
	}
	
	private void runClassroom() {
		estudantes.add(new Estudante("Alice", 92.5f));
        estudantes.add(new Estudante("Bob", 85.3f));
        estudantes.add(new Estudante("Charlie", 78.8f));
        estudantes.add(new Estudante("Diana", 88.2f));
        estudantes.add(new Estudante("Evan", 95.0f));
        estudantes.add(new Estudante("Fiona", 67.4f));
        estudantes.add(new Estudante("George", 74.6f));
        estudantes.add(new Estudante("Hannah", 81.9f));
        estudantes.add(new Estudante("Ian", 60.5f));
        estudantes.add(new Estudante("Julia", 89.7f));        
        
	}
	
	public void searchStudent(float targetGrade, Algoritmo al) {
		
		float minGrade = 0f;
        float maxGrade = 100f;
        
        for(Estudante s : estudantes) {
        	System.out.println(s);
        }
        
        System.out.println("-------------------------------");
        
        bucketSortFloat(estudantes.size(), minGrade, maxGrade);    
        
        for(Estudante s : estudantes) {
        	System.out.println(s);
        }
        
        System.out.println("-------------------------------");
        List<Float> grades = new ArrayList<>();
		for(Estudante student : estudantes) {
			grades.add(student.getNota());
		}
		
		Collections.sort(grades);
        
        
        float result = al.interpolationSearchList(grades, targetGrade);

        if (result != -1) {
            for(Estudante student : estudantes) {
            	if(student.getNota() == targetGrade) {
            		System.out.println("Estudante encontrado: " + student);
                    return;
            	}
            }
        }
		
		System.out.println("Estudante com nota " + targetGrade + " não encontrado.");
	}
	
	private static void bucketSortFloat(int n, float min, float max) {
		if(n == 0) return;
		
		@SuppressWarnings("unchecked")
		ArrayList<Estudante>[] buckets = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			buckets[i] = new ArrayList<>();
		}
		
		for(Estudante s : estudantes) {
			int bucket_idx = (int) ((s.getNota() - min) / (max - min) * n);
			if (bucket_idx >= n) bucket_idx = n - 1;
			buckets[bucket_idx].add(s);
		}
		
		for(ArrayList<Estudante> bucket : buckets) {
			bucket.sort((s1, s2) -> Float.compare(s1.getNota(), s2.getNota()));
		}
		
		int index = 0;
		for(ArrayList<Estudante> bucket : buckets) {
			for(Estudante s : bucket) {
				estudantes.set(index++, s);
			}
		}
	}

	public class Estudante{
		
		private String nome;
		private float nota;
		
		public Estudante(String nome, float nota) {
			this.nome = nome;
			this.nota = nota;
		}

		public String getNome() {
			return nome;
		}

		public float getNota() {
			return nota;
		}

		@Override
		public String toString() {
			return "Estudante [nome=" + nome + ", nota=" + nota + "]";
		}
		
		
		
		
	}

}
