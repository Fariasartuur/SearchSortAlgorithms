package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	AlgorithmsManager am = new AlgorithmsManager();
	Algorithm al = new Algorithm();
	
	List<Integer> listS = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20));
    List<Integer> listM = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52));
    List<Integer> listB = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140));
    List<Integer> arraySmall = new ArrayList<>(List.of(45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99));
    List<Integer> aOrderedArraySmall = new ArrayList<>(List.of(8, 11, 12, 14, 21, 23, 34, 36, 38, 42, 50, 55, 56, 65, 67, 76, 78, 87, 89, 90, 99));
	
	public static void main(String[] args) {
		Main main = new Main();
		
		// main.run();

		int op = -1;
		
		do {
			
			System.out.println("Chose your option");
			System.out.println("1 - Search Algorithms");
			System.out.println("2 - Sort Algorithms");
			System.out.println("0 - EXIT");
			
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				main.searchMenu();
				break;
			case 2:
				main.sortMenu();
				break;
			case 0:
				break;
			default:
	            throw new IllegalArgumentException("Invalid Option");
				
			}
			
		}while(op != 0);
		

		sc.close();
	}
	
	void printList(List<Integer> list) {
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
	
	int[] askNumber() {
		int[] array = new int[3];
		
		printList(listS);
		System.out.print("Insert a number to search: ");
		array[0] = sc.nextInt();
		printList(listM);
		System.out.print("Insert a number to search: ");
		array[1] = sc.nextInt();
		printList(listB);
		System.out.print("Insert a number to search: ");
		array[2] = sc.nextInt();
		
		return array;
	}
	
	void searchMenu() {	
		int op = -1;
		int[] array = new int[3];
		
		do {
			
			System.out.println("Chose your option");
			System.out.println("1 - Binary Search");
			System.out.println("2 - Interpolation Search");
			System.out.println("3 - Jump Search");
			System.out.println("4 - Exponential Search");
			System.out.println("5 - Ternary Search");
			System.out.println("0 - RETURN");
			
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				array = askNumber();
				
				am.bSearchInt(listS, listM, listB, array[0], array[1], array[2], "binary", al);
				break;
			case 2:
				array = askNumber();
				
				am.iSearch(listS, listM, listB, array[0], array[1], array[2], "interpolation", al);	
				break;
			case 3:
				array = askNumber();
				
				am.jSearch(listS, listM, listB, array[0], array[1], array[2], "jump", al);
				break;
			case 4:
				array = askNumber();
				
				am.eSearch(listS, listM, listB, array[0], array[1], array[2], "exponential", al);
				break;
			case 5:
				array = askNumber();
				
				am.tSearch(listS, listM, listB, array[0], array[1], array[2], "ternary", al);
				break;
			case 0:
				break;
			default:
	            throw new IllegalArgumentException("Invalid Option");
			}
			
		}while(op != 0);
	}
	
	void sortMenu() {
		
		int op = -1;
		
		do {
			System.out.println("Chose your option");
			System.out.println("1 - Shell Sort");
			System.out.println("2 - Merge Sort");
			System.out.println("3 - Selection Sort");
			System.out.println("4 - Bucket Sort");
			System.out.println("5 - Radix Sort");
			System.out.println("6 - Quick Sort");
			System.out.println("0 - RETURN");
			
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 0:
				break;
			}
			
		}while(op != 0);
		
	}
	
	void run() {
		
		new AlgorithmsManager();
		Library library = new Library();
		Classroom classroom = new Classroom();
		classroom.searchStudent(81.9f, al);
		library.searchBook("978-1503280786", al);
		
		
		System.out.print("================================================");
		am.bSearchInt(listS, listM, listB, 15, 28, 72, "binary", al);
		System.out.print("================================================");
		am.bSearchList(al);
		System.out.print("================================================");
		am.iSearch(listS, listM, listB, 15, 28, 72, "interpolation", al);
		System.out.print("================================================");
		am.jSearch(listS, listM, listB, 15, 28, 72, "jump", al);
		System.out.print("================================================");
		am.eSearch(listS, listM, listB, 15, 28, 72, "exponential", al);
		System.out.print("================================================");
		am.tSearch(listS, listM, listB, 15, 28, 72, "ternary", al);
		System.out.print("================================================");	
		am.sSort(arraySmall, "shell", al);
		System.out.print("================================================");
		am.mSortInt(arraySmall, "merge", al);
		System.out.print("================================================");
		am.mSortString(al);
		System.out.print("================================================");
		am.selecSort(arraySmall, "selection", al);
		System.out.print("================================================");
		am.bSortFloat(al);
		System.out.print("================================================");
		am.bSortInt(arraySmall, "bucket", al);
		System.out.print("================================================");
		am.rSort(arraySmall, "radix", al);
		System.out.print("================================================");
		am.qSortInt(arraySmall, aOrderedArraySmall, "quick", al);
		System.out.print("================================================");
		am.qSortString(al);
		System.out.println("================================================");

	}

}
