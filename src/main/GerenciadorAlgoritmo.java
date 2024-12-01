package main;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlgoritmo {
	
	Algoritmo al = new Algoritmo();
	
	
	
	private void escolherLista(List<Integer> array, int num, String alg) {
		long tempoInicio = 0;
        int resultado = 0;
        long tempoFim = 0;
        
        if(array == null) {
            System.out.println("Array está NULO");
            return;
        }
        
        switch(alg) {
        case "binary":
            tempoInicio = System.nanoTime();
            resultado = al.binarySearchInt(array, 0, array.size() - 1, num);
            tempoFim = System.nanoTime();
            break;
        case "interpolation":
            tempoInicio = System.nanoTime();
            resultado = al.interpolationSearch(array, num);
            tempoFim = System.nanoTime();
            break;
        case "jump":
            tempoInicio = System.nanoTime();
            resultado = al.jumpSearch(array, num);
            tempoFim = System.nanoTime();
            break;
        case "exponential":
            tempoInicio = System.nanoTime();
            resultado = al.exponentialSearch(array, num);
            tempoFim = System.nanoTime();
            break;
        case "ternary":
            tempoInicio = System.nanoTime();
            resultado = al.ternarySearch(array, 0, array.size() - 1, num);
            tempoFim = System.nanoTime();
            break;
        default:
            throw new IllegalArgumentException("Algoritmo Inválido");
        }
        
        System.out.println("Tempo de Execução: " + formatTime(tempoFim - tempoInicio) + " segundos");
        if(resultado != -1){
            System.out.println("Número " + num + " encontrado no índice " + resultado);
        } else {
            System.out.println("Não foi possível encontrar o número " + num + " no array");
        }
	}
	
	private void escolherOrdenacao(List<Integer> arr, String alg) {
		long tempoInicio = 0;
        long tempoFim = 0;
        boolean permitir = true;

        if (arr == null) {
            System.out.println("Array está NULO");
            return;
        } else {
            System.out.println("Array antes da ordenação:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }

        List<Integer> arrCopia = new ArrayList<>(arr); // Criando uma cópia do array

        switch (alg) {
            case "shell":
                // Shell
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.shellSortShell(arrCopia, arrCopia.size());
                tempoFim = System.nanoTime();
                System.out.println("\n\nTempo de Execução do Shell Sort: " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                // Knuth
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.shellSortKnuth(arrCopia, arrCopia.size());
                tempoFim = System.nanoTime();
                System.out.println("\nTempo de Execução do Knuth Shell Sort: " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                // Hibbard
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.shellSortHibbard(arrCopia, arrCopia.size());
                tempoFim = System.nanoTime();
                System.out.println("\nTempo de Execução do Hibbard Shell Sort: " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                permitir = false;
                break;

            case "merge":
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.mergeSortInt(arrCopia);
                tempoFim = System.nanoTime();
                System.out.println("\n\nNúmero de Comparações: " + Algoritmo.getComparisonCount());
                break;

            case "selection":
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.selectionSort(arrCopia, arrCopia.size());
                tempoFim = System.nanoTime();
                System.out.println("\n\nNúmero de Comparações: " + Algoritmo.getComparisonCount());
                break;

            case "bucket":
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.bucketSortInt(arrCopia, arrCopia.size());
                tempoFim = System.nanoTime();
                System.out.println("\n\nNúmero de Comparações: " + Algoritmo.getComparisonCount());
                break;

            case "radix":
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.radixSort(arrCopia, 10);
                tempoFim = System.nanoTime();
                System.out.println("\n\nTempo de Execução Base 10: " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.radixSort(arrCopia, 2);
                tempoFim = System.nanoTime();
                System.out.println("Tempo de Execução Base 2: " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                permitir = false;
                break;

            case "quick":
                // Primeiro Pivô
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.quickSortInt(arrCopia, 0, arrCopia.size() - 1, "first");
                tempoFim = System.nanoTime();
                System.out.println("\n\nTempo de Execução (Primeiro Pivô): " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                // Pivô do Meio
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.quickSortInt(arrCopia, 0, arrCopia.size() - 1, "middle");
                tempoFim = System.nanoTime();
                System.out.println("Tempo de Execução (Pivô do Meio): " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                // Último Pivô
                arrCopia = new ArrayList<>(arr);  // Resetando o array
                Algoritmo.resetComparisonCount();
                tempoInicio = System.nanoTime();
                arrCopia = al.quickSortInt(arrCopia, 0, arrCopia.size() - 1, "last");
                tempoFim = System.nanoTime();
                System.out.println("Tempo de Execução (Último Pivô): " + formatTime(tempoFim - tempoInicio) + " segundos");
                System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");

                permitir = false;
                break;

            default:
                throw new IllegalArgumentException("Algoritmo Inválido");
        }

        if (permitir) {
            System.out.println("Tempo de Execução: " + formatTime(tempoFim - tempoInicio) + " segundos\n");
        }

        System.out.println("Array após a ordenação:");
        if (arrCopia != null) {
            for (int num : arrCopia) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Não foi possível ordenar o array. Array é nulo");
        }

        permitir = true;
        Algoritmo.resetComparisonCount();
	}

	
	private void escolherLista(List<String> arr, String alg) {
		long tempoInicio = 0;
	    long tempoFim = 0;
	    boolean permitir = true;
	    
	    if (arr == null || arr.isEmpty()) {
	        System.out.println("Array está NULO");
	        return;
	    }
	    
	    System.out.println("Array antes da ordenação");
	    if (arr != null) {
	        for (int i = 0; i < arr.size(); i++) {
	            if (i != arr.size() - 1) {
	                System.out.print(arr.get(i) + " - ");
	            } else {
	                System.out.print(arr.get(i));
	            }
	        }
	    }
	    
	    switch (alg) {
	        case "quickString":
	            Algoritmo.resetComparisonCount();
	            tempoInicio = System.nanoTime();
	            arr = al.quickSortString(arr, 0, arr.size() - 1, "first");
	            tempoFim = System.nanoTime();
	            System.out.println("\n\nTempo de Execução (Primeiro Pivô): " + formatTime(tempoFim - tempoInicio) + " segundos");
	            System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");
	            
	            Algoritmo.resetComparisonCount();
	            tempoInicio = System.nanoTime();
	            arr = al.quickSortString(arr, 0, arr.size() - 1, "middle");
	            tempoFim = System.nanoTime();
	            System.out.println("Tempo de Execução (Pivô do Meio): " + formatTime(tempoFim - tempoInicio) + " segundos");
	            System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");
	            
	            Algoritmo.resetComparisonCount();
	            tempoInicio = System.nanoTime();
	            arr = al.quickSortString(arr, 0, arr.size() - 1, "last");
	            tempoFim = System.nanoTime();
	            System.out.println("Tempo de Execução (Último Pivô): " + formatTime(tempoFim - tempoInicio) + " segundos");
	            System.out.println("Número de Comparações: " + Algoritmo.getComparisonCount() + "\n");
	            
	            permitir = false;
	            break;
	        
	        case "mergeString":
	            tempoInicio = System.nanoTime();
	            arr = al.mergeSortString(arr);
	            tempoFim = System.nanoTime();
	            break;
	        
	        default:
	            throw new IllegalArgumentException("Algoritmo Inválido");
	    }
	    
	    if (permitir) {
	        System.out.println("\n\nTempo de Execução: " + formatTime(tempoFim - tempoInicio) + " segundos\n");
	    }
	    
	    System.out.println("Array após a ordenação");
	    if (arr != null) {
	        for (int i = 0; i < arr.size(); i++) {
	            if (i != arr.size() - 1) {
	                System.out.print(arr.get(i) + " - ");
	            } else {
	                System.out.print(arr.get(i));
	            }
	        }
	    }
	    
	    permitir = true;
	    Algoritmo.resetComparisonCount();
	}
	
	private void escolherLista(List<String> array, String word, String type) {
		long tempoInicio = 0;
	    int resultado = -1;
	    long tempoFim = 0;
	    
	    if (array == null || array.isEmpty()) {
	        System.out.println("Array está NULO ou Vazio");
	        return;
	    }
	    
	    switch (type) {
	        case "binaryString":
	            tempoInicio = System.nanoTime();
	            resultado = al.binarySearchList(array, word);
	            tempoFim = System.nanoTime();
	            break;
	        
	        default:
	            throw new IllegalArgumentException("Algoritmo Inválido");
	    }
	    
	    System.out.println("Tempo de Execução: " + formatTime(tempoFim - tempoInicio) + " segundos");
	    if (resultado != -1) {
	        String palavraEncontrada = array.get(resultado);
	        System.out.println("Palavra " + palavraEncontrada + " encontrada no índice " + resultado);
	    } else {
	        System.out.println("Não foi possível encontrar a palavra " + word + " no array");
	    }
	}

	// Binary Search (int)
	void bSearchInt(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		
		System.out.println("\nBinary Search (Int)\n");
		
		runSearch(arrayS, arrayM, arrayB, numS, numM, numB, type);
	}
	
	// Binary Search (list)
	void bSearchList(List<String> arraySmall, String word, String type) {
		System.out.println("\nBinary Search (String)\n");
		
		escolherLista(arraySmall, word, type);
	}
	
	// Interpolation Search
	void iSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		System.out.println("\nInterpolation Search\n");

		runSearch(arrayS, arrayM, arrayB, numS, numM, numB, type); 
	}
	
	// Jump Search
	void jSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		System.out.println("\nJump Search\n");
	    
		runSearch(arrayS, arrayM, arrayB, numS, numM, numB, type);   
	}
	
	// Exponential Search
	void eSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		System.out.println("\nExponential Search\n");
		
		runSearch(arrayS, arrayM, arrayB, numS, numM, numB, type);   
	}
	
	// Ternary Search
	void tSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		System.out.println("\nTernary Search\n");
	    
		runSearch(arrayS, arrayM, arrayB, numS, numM, numB, type);	    
	}
	
	// Shell Sort
	void sSort(List<Integer> arraySmall, String type) {
		
		System.out.println("\nShell Sort\n");
		
		escolherOrdenacao(arraySmall, type);
		
		System.out.println();
	}
	
	// Merge Sort (int)
	void mSortInt(List<Integer> arraySmall, String type) {
		System.out.println("\nMerge Sort Int\n");
		
		escolherOrdenacao(arraySmall, type); // merge
		
		System.out.println();
	}
	
	// Merge Sort (list)
	void mSortList(List<String> arraySmall, String type) {
		System.out.println("\nMerge Sort String\n");
		
		escolherLista(arraySmall, type); // mergeString
		
		System.out.println();
	}
	
	// Selection Sort
	void selecSort(List<Integer> arraySmall, String type) {
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
		escolherOrdenacao(arraySmall, type);
		
		System.out.println("\n------------------------------------------------");
				
		System.out.println("Medium Array\n");
		escolherOrdenacao(mediumArray, type);
		
		System.out.println("\n------------------------------------------------");		

		System.out.println("Big Array\n"); 
		escolherOrdenacao(bigArray, type);
		
		System.out.println();
		
	}
	
	// Bucket Sort (float)
	void bSortFloat(List<Float> array) {
		System.out.println("\nBucket Sort (Float)\n");
		// float[] array = {0.42f, 0.32f, 0.23f, 0.52f, 0.43f, 0.35f, 0.51f, 0.13f, 0.64f, 0.05f};
	    
	    System.out.println("Array antes da ordenação");
	    if (array != null) {
	        for (float num : array) {
	            System.out.print(num + " ");
	        }
	    }
	    
	    long tempoInicio = System.nanoTime();
	    array = al.bucketSortFloat(array, array.size(), 0, 1);
	    long tempoFim = System.nanoTime();
	    System.out.println("\n\nTempo de Execução: " + formatTime(tempoFim - tempoInicio) + " segundos\n");
	    
	    System.out.println("Array grande após a ordenação");
	    if (array != null) {
	        for (float num : array) {
	            System.out.print(num + " ");
	        }
	    } else {
	        System.out.println("Não foi possível ordenar o array. Array é nulo");
	    }
	    
	    System.out.println();  
	}
	
	// Bucket Sort (int)
	void bSortInt(List<Integer> arraySmall, String type) {
		System.out.println("\nBucket Sort (Int)\n");
		
		escolherOrdenacao(arraySmall, type); // bucket
	
		System.out.println();	
	}
	
	// Radix Sort
	void rSort(List<Integer> arraySmall, String type) {
		System.out.println("\nRadix Sort\n");
		//int[] array = {23, 45, 61, 89, 12, 34, 56, 78, 91, 67, 10000, 23456, 45678, 87654, 12345, 56789, 98765, 34567, 54321, 87612, 1234567890, 1234567891, 1029384756, 1231231231, 1253256224, 1974252153};
		
		escolherOrdenacao(arraySmall, type); // radix
				
		System.out.println();
	}
	
	// Quick Sort (int)
	void qSortInt(List<Integer> arraySmall, List<Integer> aOrderedArraySmall, String type) {
		System.out.println("\nQuick Sort\n");
		
		// Ordered Array (First, Middle and Last Pivot)
		System.out.println("Array quase ordenado\n");
		escolherOrdenacao(aOrderedArraySmall, type); // quick
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Array desordenado\n");
		escolherOrdenacao(arraySmall, type); // quick
		
		System.out.println();
		
	}
	
	// Quick Sort (list)
	void qSortList(List<String> arraySmall, String type) {
		System.out.println("\nQuick Sort String\n");
		
		escolherLista(arraySmall, type); // quickString
		
		System.out.println();		
	}
	
	private void runSearch(List<Integer> arrayS, List<Integer> arrayM, List<Integer> arrayB, int numS, int numM, int numB, String type) {
		System.out.println("Lista Pequena");	
	    escolherLista(arrayS, numS, type);
	    
	    System.out.println("\nLista Média");
	    escolherLista(arrayM, numM, type);
	    
	    System.out.println("\nLista Grande");
	    escolherLista(arrayB, numB, type);
	}
	
	private String formatTime(long nanoseconds) {
	    double seconds = nanoseconds / 1_000_000_000.0;
	    return String.format("%.6f", seconds); // Formats to 6 decimal places
	}

}
