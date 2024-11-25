package main;

public class AlgorithmsManager {
	
	static void runSearch(int[] array, int num, String alg) {
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
		    result = Algorithms.binarySearchInt(array, 0, array.length - 1, num);
		    endTime = System.nanoTime();
			break;
		case "interpolation":
			startTime = System.nanoTime();
		    result = Algorithms.interpolationSearch(array, 0, array.length - 1, num);
		    endTime = System.nanoTime();
			break;
		case "jump":
			startTime = System.nanoTime();
		    result = Algorithms.jumpSearch(array, 0, array.length, num);
		    endTime = System.nanoTime();
			break;
		case "exponential":
			startTime = System.nanoTime();
		    result = Algorithms.exponentialSearch(array, array.length, num);
		    endTime = System.nanoTime();
			break;
		case "ternary":
			startTime = System.nanoTime();
		    result = Algorithms.ternarySearch(array, 0, array.length - 1, num);
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
	
	static void runSort(int[] arr, String alg) {
		long startTime = 0;
		long endTime = 0;
		boolean allow = true;
		
		if(arr == null) {
			System.out.println("Array is NULL");
			return;
		} else {
			System.out.println("Array before Sort");
			for(int num : arr) {
				System.out.print(num + " ");
			}
		}
		
		switch(alg) {
		case "shell":
			// Shell
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.shellSortShell(arr, arr.length);
			endTime = System.nanoTime();
			System.out.println("\n\nShell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			// Knuth
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.shellSortKnuth(arr, arr.length);
			endTime = System.nanoTime();
			System.out.println("\nKnuth Shell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			// Hibbard
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.shellSortHibbard(arr, arr.length);
			endTime = System.nanoTime();
			System.out.println("\nHibbard Shell Sort Execution Time: " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			allow = false;
			break;
		case "merge":
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.mergeSortInt(arr);
			endTime = System.nanoTime();
			System.out.println("\n\nComparison Number: " + Algorithms.getComparisonCount());

			break;
		case "selection":
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.selectionSort(arr, arr.length);
			endTime = System.nanoTime();
			System.out.println("\n\nComparison Number: " + Algorithms.getComparisonCount());

			break;
		case "bucket":
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.bucketSortInt(arr, arr.length);
			endTime = System.nanoTime();
			System.out.println("\n\nComparison Number: " + Algorithms.getComparisonCount());

			break;
		case "radix":
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.radixSort(arr, 10);
			endTime = System.nanoTime();
			System.out.println("\n\nBase 10 Execution Time: " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.radixSort(arr, 2);
			endTime = System.nanoTime();
			System.out.println("Base 2 Execution Time: " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			allow = false;
			break;
		case "quick":
			// First Pivot
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortInt(arr, 0, arr.length - 1, "first");
			endTime = System.nanoTime();
			System.out.println("\n\nExecution Time (First Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			// Middle Pivot
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortInt(arr, 0, arr.length - 1, "middle");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Middle Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			// Last Pivot
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortInt(arr, 0, arr.length - 1, "last");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Last Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			allow = false;
			break;
		default:
            throw new IllegalArgumentException("Invalid Algorithm");	
		}
		
		if(allow) {
			System.out.println("Execution Time: " + formatTime(endTime - startTime) + " seconds\n");
		}
		
		System.out.println("Array after Sort");
		if(arr != null) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("Couldn't sort the array. Array is null");
		}
		
		allow = true;
		Algorithms.resetComparisonCount();
	}
	
	static void runString(String[] arr, String alg) {
		long startTime = 0;
		long endTime = 0;
		boolean allow = true;
		
		if(arr == null) {
			System.out.println("Array is NULL");
			return;
		}
		
		System.out.println("Array before Sort");
		if(arr != null) {
			for(int i = 0; i < arr.length; i++) {
				if(i != arr.length - 1) {
					System.out.print(arr[i] + " - ");
				} else {
					System.out.print(arr[i]);
				}
			}
		}
		
		switch(alg) {
		case "quickString":		
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortString(arr, 0, arr.length - 1, "first");
			endTime = System.nanoTime();
			System.out.println("\n\nExecution Time (First Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortString(arr, 0, arr.length - 1, "middle");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Middle Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			Algorithms.resetComparisonCount();
			startTime = System.nanoTime();
			arr = Algorithms.quickSortString(arr, 0, arr.length - 1, "last");
			endTime = System.nanoTime();
			System.out.println("Execution Time (Last Pivot): " + formatTime(endTime - startTime) + " seconds");
			System.out.println("Comparison Number: " + Algorithms.getComparisonCount() + "\n");
			
			allow = false;
			break;
		case "mergeString":
			startTime = System.nanoTime();
			arr = Algorithms.mergeSortString(arr);
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
			for(int i = 0; i < arr.length; i++) {
				if(i != arr.length - 1) {
					System.out.print(arr[i] + " - ");
				} else {
					System.out.print(arr[i]);
				}
			}
		}
		
		allow = true;
		Algorithms.resetComparisonCount();
	}
	
	static void bSearchInt() {
		System.out.println("\nBinary Search (Int)\n");
		int[] arrayS = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20};
		int[] arrayM = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52};
		int[] arrayB = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140};
	    
		int numS = 15;
		int numM = 28;
		int numB = 72;
		
	    System.out.println("Small List");	
	    runSearch(arrayS, numS, "binary");
	    
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, "binary");
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, "binary");
	  
	}
	
	static void bSearchString() {
		System.out.println("\nBinary Search (String)\n");
		String[] array = {"apple", "banana", "grape", "kiwi", "lemon", "mango", "orange", "pear", "pineapple", "watermelon"};
		String word = "orange";
		
		Long startTime = System.nanoTime();
	    int result = Algorithms.binarySearchString(array, 0, array.length - 1, word);
	    Long endTime = System.nanoTime();
	    
	    System.out.println("Execution Time: " + formatTime(endTime - startTime) + " seconds");
		if(result != -1){
		      System.out.println("Word "+ word +" found at the index "+ result);
		} else {
		      System.out.println("Couldn't find the word "+ word +" at the array");
		}
	}
	
	static void iSearch() {
		System.out.println("\nInterpolation Search\n");
		int[] arrayS = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20};
		int[] arrayM = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52};
		int[] arrayB = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140};
	    
		int numS = 15;
		int numM = 28;
		int numB = 72;

		System.out.println("Small List");
		runSearch(arrayS, numS, "interpolation");
	    
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, "interpolation");
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, "interpolation");
	    
	}
	
	static void jSearch() {
		System.out.println("\nJump Search\n");
		int[] arrayS = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20};
		int[] arrayM = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52};
		int[] arrayB = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140};
	    
		int numS = 15;
		int numM = 28;
		int numB = 72;
	    
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, "jump");
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, "jump");
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, "jump");
	    
	}
	
	static void eSearch() {
		System.out.println("\nExponential Search\n");
		int[] arrayS = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20};
		int[] arrayM = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52};
		int[] arrayB = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140};
	    
		int numS = 15;
		int numM = 28;
		int numB = 72;
		
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, "exponential");
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, "exponential");
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, "exponential");
	    
	   
	}
	
	static void tSearch() {
		System.out.println("\nTernary Search\n");
		int[] arrayS = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20};
		int[] arrayM = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52};
		int[] arrayB = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140};
	    
		int numS = 15;
		int numM = 28;
		int numB = 72;
	    
		System.out.println("Small List");	    
	    runSearch(arrayS, numS, "ternary");
		
	    System.out.println("\nMedium List");
	    runSearch(arrayM, numM, "ternary");
	    
	    System.out.println("\nBig List");
	    runSearch(arrayB, numB, "ternary");	    
	}
	
	static void sSort() {
		System.out.println("\nShell Sort\n");
		int[] array = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		
		runSort(array, "shell");
		
		System.out.println();
		
	}
	
	static void mSortInt() {
		System.out.println("\nMerge Sort Int\n");
		int[] array = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		
		runSort(array, "merge");
		
		System.out.println();
	}
	
	static void mSortString() {
		System.out.println("\nMerge Sort String\n");
		String[] names = {"Maria", "João", "Ana", "Carlos", "Beatriz", "Pedro"}; 
		
		runString(names, "mergeString");	
		
		System.out.println();
	}
	
	static void selecSort() {
		System.out.println("\nSelection Sort\n");
		int[] smallArray = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		int[] mediumArray = new int[50];
		for(int i = 0; i < mediumArray.length; i++) {
			mediumArray[i] = (int) (Math.random() * 50);
		}
		int[] bigArray = new int[250];
		for(int i = 0; i < bigArray.length; i++) {
			bigArray[i] = (int) (Math.random() * 250);
		}
				
		System.out.println("Small Array\n");
		runSort(smallArray, "selection");
		
		System.out.println("\n------------------------------------------------");
				
		System.out.println("Medium Array\n");
		runSort(mediumArray, "selection");
		
		System.out.println("\n------------------------------------------------");		

		System.out.println("Big Array\n");
		runSort(bigArray, "selection");
		
		System.out.println();
		
	}
	
	static void bSortFloat() {
		System.out.println("\nBucket Sort (Float)\n");
		float[] array = {0.42f, 0.32f, 0.23f, 0.52f, 0.43f, 0.35f, 0.51f, 0.13f, 0.64f, 0.05f};
		
		System.out.println("Array before Sort");
		if(array != null) {
			for(float num : array) {
				System.out.print(num + " ");
			}
		}
		
		long startTime = System.nanoTime();
		array = Algorithms.bucketSortFloat(array, array.length);
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
	
	static void bSortInt() {
		System.out.println("\nBucket Sort (Int)\n");
		int[] array = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		
		runSort(array, "bucket");
	
		System.out.println();	
	}
	
	static void rSort() {
		System.out.println("\nRadix Sort\n");
		int [] array = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		//int[] array = {23, 45, 61, 89, 12, 34, 56, 78, 91, 67, 10000, 23456, 45678, 87654, 12345, 56789, 98765, 34567, 54321, 87612, 1234567890, 1234567891, 1029384756, 1231231231, 1253256224, 1974252153};
		
		runSort(array, "radix");
				
		System.out.println();
	}
	
	static void qSortInt() {
		System.out.println("\nQuick Sort\n");
		int[] almostOrderedArray = {8, 11, 12, 14, 21, 23, 34, 36, 38, 42, 50, 55, 56, 65, 67, 76, 78, 87, 89, 90, 99};
		int[] disorderedArray = {45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99};
		
		// Ordered Array (First, Middle and Last Pivot)
		System.out.println("Almost Ordered Array\n");
		runSort(almostOrderedArray, "quick");
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Disordered Array\n");
		runSort(disorderedArray, "quick");
		
		System.out.println();
		
	}
	
	static void qSortString() {
		System.out.println("\nQuick Sort String\n");
		String[] names = {"Maria", "João", "Ana", "Carlos", "Beatriz", "Pedro"};
		
		runString(names, "quickString");
		
		System.out.println();		
	}
	
	private static String formatTime(long nanoseconds) {
	    double seconds = nanoseconds / 1_000_000_000.0;
	    return String.format("%.6f", seconds); // Formats to 6 decimal places
	}

}
