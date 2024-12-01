package main;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmsManager {
	
	List<String> arrayString = new ArrayList<>();
	List<String> names = new ArrayList<>(List.of("Maria", "João", "Ana", "Carlos", "Beatriz", "Pedro"));
	

	public AlgorithmsManager() {
		runWords();
	}
	
	void runSearch(List<Integer> array, int num, String alg, Algorithm al) {
		long startTime = 0;
		int result = 0;
		long endTime = 0;
		
		if(array == null) {
			System.out.println("Array is NULL");
			return;
		}
		
		switch(alg) {
		case "binary":
			startTime = System.nanoTime();
		    result = al.binarySearchInt(array, 0, array.size() - 1, num);
		    endTime = System.nanoTime();
			break;
		case "interpolation":
			startTime = System.nanoTime();
		    result = al.interpolationSearch(array, 0, array.size() - 1, num);
		    endTime = System.nanoTime();
			break;
		case "jump":
			startTime = System.nanoTime();
		    result = al.jumpSearch(array, 0, array.size(), num);
		    endTime = System.nanoTime();
			break;
		case "exponential":
			startTime = System.nanoTime();
		    result = al.exponentialSearch(array, array.size(), num);
		    endTime = System.nanoTime();
			break;
		case "ternary":
			startTime = System.nanoTime();
		    result = al.ternarySearch(array, 0, array.size() - 1, num);
		    endTime = System.nanoTime();
			break;
		default:
            throw new IllegalArgumentException("Invalid Algorithm");	
		}
		
		System.out.println("Execution Time: " + formatTime(endTime - startTime) + " seconds");
		if(result != -1){
		      System.out.println("Number "+ num +" found at the index "+ result);
		} else {
		      System.out.println("Couldn't find the number "+ num +" at the array");
		}
		
	}
	
	void runSort(List<Integer> arr, String alg, Algorithm al) {
	    long startTime = 0;
	    long endTime = 0;
	    boolean allow = true;

	    if (arr == null) {
	        System.out.println("Array is NULL");
	        return;
	    } else {
	        System.out.println("Array before Sort");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }

	    List<Integer> arrCopy = new ArrayList<>(arr); // Criando a cópia do array antes de qualquer ordenação

	    switch (alg) {
	        case "shell":
	            // Shell
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.shellSortShell(arrCopy, arrCopy.size());
	            endTime = System.nanoTime();
	            System.out.println("\n\nShell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            // Knuth
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.shellSortKnuth(arrCopy, arrCopy.size());
	            endTime = System.nanoTime();
	            System.out.println("\nKnuth Shell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            // Hibbard
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.shellSortHibbard(arrCopy, arrCopy.size());
	            endTime = System.nanoTime();
	            System.out.println("\nHibbard Shell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            allow = false;
	            break;

	        case "merge":
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.mergeSortInt(arrCopy);
	            endTime = System.nanoTime();
	            System.out.println("\n\nComparison Number: " + Algorithm.getComparisonCount());
	            break;

	        case "selection":
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.selectionSort(arrCopy, arrCopy.size());
	            endTime = System.nanoTime();
	            System.out.println("\n\nComparison Number: " + Algorithm.getComparisonCount());
	            break;

	        case "bucket":
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.bucketSortInt(arrCopy, arrCopy.size());
	            endTime = System.nanoTime();
	            System.out.println("\n\nComparison Number: " + Algorithm.getComparisonCount());
	            break;

	        case "radix":
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.radixSort(arrCopy, 10);
	            endTime = System.nanoTime();
	            System.out.println("\n\nBase 10 Execution Time: " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.radixSort(arrCopy, 2);
	            endTime = System.nanoTime();
	            System.out.println("Base 2 Execution Time: " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            allow = false;
	            break;

	        case "quick":
	            // First Pivot
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.quickSortInt(arrCopy, 0, arrCopy.size() - 1, "first");
	            endTime = System.nanoTime();
	            System.out.println("\n\nExecution Time (First Pivot): " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            // Middle Pivot
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.quickSortInt(arrCopy, 0, arrCopy.size() - 1, "middle");
	            endTime = System.nanoTime();
	            System.out.println("Execution Time (Middle Pivot): " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            // Last Pivot
	            arrCopy = new ArrayList<>(arr);  // Reset array
	            Algorithm.resetComparisonCount();
	            startTime = System.nanoTime();
	            arrCopy = al.quickSortInt(arrCopy, 0, arrCopy.size() - 1, "last");
	            endTime = System.nanoTime();
	            System.out.println("Execution Time (Last Pivot): " + formatTime(endTime - startTime) + " seconds");
	            System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");

	            allow = false;
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid Algorithm");
	    }

	    if (allow) {
	        System.out.println("Execution Time: " + formatTime(endTime - startTime) + " seconds\n");
	    }

	    System.out.println("Array after Sort");
	    if (arrCopy != null) {
	        for (int num : arrCopy) {
	            System.out.print(num + " ");
	        }
	    } else {
	        System.out.println("Couldn't sort the array. Array is null");
	    }

	    allow = true;
	    Algorithm.resetComparisonCount();
	}

	
	void runString(List<String> arr, String alg, Algorithm al) {
		long startTime = 0;
		long endTime = 0;
		boolean allow = true;
		
		if(arr == null) {
			System.out.println("Array is NULL");
			return;
		}
		
		System.out.println("Array before Sort");
		if(arr != null) {
			for(int i = 0; i < arr.size(); i++) {
				if(i != arr.size() - 1) {
					System.out.print(arr.get(i) + " - ");
				} else {
					System.out.print(arr.get(i));
				}
			}
		}
		
		switch(alg) {
		case "quickString":		
			Algorithm.resetComparisonCount();
			startTime = System.nanoTime();
			arr = al.quickSortString(arr, 0, arr.size() - 1, "first");
			endTime = System.nanoTime();
			System.out.println("\n\nExecution Time (First Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");
			
			Algorithm.resetComparisonCount();
			startTime = System.nanoTime();
			arr = al.quickSortString(arr, 0, arr.size() - 1, "middle");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Middle Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");
			
			Algorithm.resetComparisonCount();
			startTime = System.nanoTime();
			arr = al.quickSortString(arr, 0, arr.size() - 1, "last");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Last Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithm.getComparisonCount() + "\n");
			
			allow = false;
			break;
		case "mergeString":
			startTime = System.nanoTime();
			arr = al.mergeSortString(arr);
			endTime = System.nanoTime();
			break;
		default:
            throw new IllegalArgumentException("Invalid Algorithm");	
		}
		
		if (allow) {
			System.out.println("\n\nExecution Time: " + formatTime(endTime - startTime) + " seconds\n");
		}
		
		System.out.println("Array after Sort");
		if(arr != null) {
			for(int i = 0; i < arr.size(); i++) {
				if(i != arr.size() - 1) {
					System.out.print(arr.get(i) + " - ");
				} else {
					System.out.print(arr.get(i));
				}
			}
		}
		
		allow = true;
		Algorithm.resetComparisonCount();
	}
	
	void runWords() {
		arrayString.add("apple");
		arrayString.add("banana");
		arrayString.add("grape");
		arrayString.add("kiwi");
		arrayString.add("lemon");
		arrayString.add("mango");
		arrayString.add("orange");
		arrayString.add("pear");
		arrayString.add("pineapple");
		arrayString.add("watermelon");
	}
	
	void bSearchInt(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type, Algorithm al) {
		
		System.out.println("\nBinary Search (Int)\n");
		
	    System.out.println("Small List");	
	    runSearch(arrayS, numS, type, al);
	    
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, type, al);
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, type, al);
	  
	}
	
	void bSearchList(Algorithm al) {
		System.out.println("\nBinary Search (String)\n");
		System.out.println(arrayString);
		String word = "orange";
		
		Long startTime = System.nanoTime();
	    String result = al.binarySearchList(arrayString, 0, arrayString.size() - 1, word);
	    Long endTime = System.nanoTime();
	    
	    System.out.println("Execution Time: " + formatTime(endTime - startTime) + " seconds");
		if(result != null){
		      System.out.println("Word Found: "+ word);
		} else {
		      System.out.println("Couldn't find the word "+ word +" at the array");
		}
	}
	
	void iSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type, Algorithm al) {
		System.out.println("\nInterpolation Search\n");

		System.out.println("Small List");
		runSearch(arrayS, numS, type, al);
	    
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, type, al);
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, type, al);
	    
	}
	
	void jSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type, Algorithm al) {
		System.out.println("\nJump Search\n");
	    
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, type, al);
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, type, al);
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, type, al);
	    
	}
	
	void eSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type, Algorithm al) {
		System.out.println("\nExponential Search\n");
		
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, type, al);
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, type, al);
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, type, al);
	    
	   
	}
	
	void tSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type, Algorithm al) {
		System.out.println("\nTernary Search\n");
	    
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, type, al);
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, type, al);
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, type, al);	    
	}
	
	void sSort(List<Integer> arraySmall, String type, Algorithm al) {
		
		System.out.println("\nShell Sort\n");
		
		runSort(arraySmall, "shell", al); // shell
		
		System.out.println();
		
	}
	
	void mSortInt(List<Integer> arraySmall, String type, Algorithm al) {
		System.out.println("\nMerge Sort Int\n");
		
		
		runSort(arraySmall, "merge", al); // merge
		
		System.out.println();
	}
	
	void mSortString(Algorithm al) {
		System.out.println("\nMerge Sort String\n");
		
		runString(names, "mergeString", al);	
		
		System.out.println();
	}
	
	void selecSort(List<Integer> arraySmall, String type, Algorithm al) {
		System.out.println("\nSelection Sort\n");
		List<Integer> mediumArray = new ArrayList<>();
		for(int i = 0; i < 50; i++) {
			mediumArray.add((int) (Math.random() * 50));
		}
		List<Integer> bigArray = new ArrayList<>();
		for(int i = 0; i < 250; i++) {
			bigArray.add((int) (Math.random() * 250));
		}
				
		System.out.println("Small Array\n");
		runSort(arraySmall, type, al); // selection
		
		System.out.println("\n------------------------------------------------");
				
		System.out.println("Medium Array\n");
		runSort(mediumArray, type, al); // selection
		
		System.out.println("\n------------------------------------------------");		

		System.out.println("Big Array\n"); 
		runSort(bigArray, type, al); // selection
		
		System.out.println();
		
	}
	
	void bSortFloat(Algorithm al) {
		System.out.println("\nBucket Sort (Float)\n");
		float[] array = {0.42f, 0.32f, 0.23f, 0.52f, 0.43f, 0.35f, 0.51f, 0.13f, 0.64f, 0.05f};
		
		System.out.println("Array before Sort");
		if(array != null) {
			for(float num : array) {
				System.out.print(num + " ");
			}
		}
		
		long startTime = System.nanoTime();
		array = al.bucketSortFloat(array, array.length, 0, 1);
		long endTime = System.nanoTime();
		System.out.println("\n\nExecution Time: " + formatTime(endTime - startTime) + " seconds\n");
		
		System.out.println("Big Array after Sort");
		if(array != null) {
			for(float num : array) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("Couldn't sort the array. Array is null");
		}
		
		System.out.println();	
	}
	
	void bSortInt(List<Integer> arraySmall, String type, Algorithm al) {
		System.out.println("\nBucket Sort (Int)\n");
		
		runSort(arraySmall, type, al); // bucket
	
		System.out.println();	
	}
	
	void rSort(List<Integer> arraySmall, String type, Algorithm al) {
		System.out.println("\nRadix Sort\n");
		//int[] array = {23, 45, 61, 89, 12, 34, 56, 78, 91, 67, 10000, 23456, 45678, 87654, 12345, 56789, 98765, 34567, 54321, 87612, 1234567890, 1234567891, 1029384756, 1231231231, 1253256224, 1974252153};
		
		runSort(arraySmall, type, al); // radix
				
		System.out.println();
	}
	
	void qSortInt(List<Integer> arraySmall, List<Integer> aOrderedArraySmall, String type, Algorithm al) {
		System.out.println("\nQuick Sort\n");
		
		// Ordered Array (First, Middle and Last Pivot)
		System.out.println("Almost Ordered Array\n");
		runSort(aOrderedArraySmall, type, al); // quick
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Disordered Array\n");
		runSort(arraySmall, type, al); // quick
		
		System.out.println();
		
	}
	
	void qSortString(Algorithm al) {
		System.out.println("\nQuick Sort String\n");
		
		runString(names, "quickString", al);
		
		System.out.println();		
	}
	
	private String formatTime(long nanoseconds) {
	    double seconds = nanoseconds / 1_000_000_000.0;
	    return String.format("%.6f", seconds); // Formats to 6 decimal places
	}

}
