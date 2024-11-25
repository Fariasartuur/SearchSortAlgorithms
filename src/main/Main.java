package main;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		run()

		int op = -1;
		
		do {
			
			System.out.println("Chose your option");
			System.out.println("1- Search Algorithms");
			System.out.println("2- Sort Algorithms");
			System.out.println("0 - EXIT");
			
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				searchMenu();
				break;
			case 2:
				sortMenu();
				break;
			case 0:
				break;
			}
			
		}while(op != 0);
		

		sc.close();
	}
	
	static void searchMenu() {
		
		int op = -1;
		
		do {
			
			System.out.println("Chose your option");
			System.out.println("1- Binary Search");
			System.out.println("2- Interpolation Search");
			System.out.println("3- Jump Search");
			System.out.println("4- Exponential Search");
			System.out.println("5- Ternary Search");
			System.out.println("0 - RETURN");
			
			op = sc.nextInt();
			
		}while(op != 0);
	}
	
	static void sortMenu() {
		
		int op = -1;
		
		do {
			
			System.out.println("Chose your option");
			System.out.println("1- Shell Sort");
			System.out.println("2- Merge Sort");
			System.out.println("3- Selection Sort");
			System.out.println("4- Bucket Sort");
			System.out.println("5- Radix Sort");
			System.out.println("5- Quick Sort");
			System.out.println("0 - RETURN");
			
			op = sc.nextInt();
			
		}while(op != 0);
		
	}
	
//	Just remove the comment from the Algorithm you want to see
	static void run() {
//		new Library().runBooks();
//		library.printBooks();
//		new Classroom().runClassroom();
		
//		System.out.print("================================================");
//		AlgorithmsManager.bSearchInt();
//		System.out.print("================================================");
//		AlgorithmsManager.bSearchString();
//		System.out.print("================================================");
//		AlgorithmsManager.iSearch();
//		System.out.print("================================================");
//		AlgorithmsManager.jSearch();
//		System.out.print("================================================");
//		AlgorithmsManager.eSearch();
//		System.out.print("================================================");
//		AlgorithmsManager.tSearch();
//		System.out.print("================================================");
		
//		AlgorithmsManager.sSort();
//		System.out.print("================================================");
//		AlgorithmsManager.mSortInt();
//		System.out.print("================================================");
//		AlgorithmsManager.mSortString();
//		System.out.print("================================================");
//		AlgorithmsManager.selecSort();
//		System.out.print("================================================");
//		AlgorithmsManager.bSortFloat();
//		System.out.print("================================================");
//		AlgorithmsManager.bSortInt();
//		System.out.print("================================================");
//		AlgorithmsManager.rSort();
//		System.out.print("================================================");
//		AlgorithmsManager.qSortInt();
//		System.out.print("================================================");
//		AlgorithmsManager.qSortString();
//		System.out.println("================================================");
//		library.searchBook("978-1503280786");
//		System.out.println("================================================");
	}

}
