package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    GerenciadorAlgoritmo am = new GerenciadorAlgoritmo();
    Algoritmo al = new Algoritmo();


    List<String> listInsertedString = new ArrayList<>();
	List<Float> listInsertedFloat = new ArrayList<>();
	List<Integer> listInsertedInt = new ArrayList<>();
	
	List<Float> arrayF = new ArrayList<>(List.of(0.42f, 0.32f, 0.23f, 0.52f, 0.43f, 0.35f, 0.51f, 0.13f, 0.64f, 0.05f));
	List<Integer> listS = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20));
    List<Integer> listM = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52));
    List<Integer> listB = new ArrayList<>(List.of(2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 58, 60, 62, 65, 70, 72, 80, 85, 90, 95, 100, 110, 120, 130, 140));
    List<Integer> array = new ArrayList<>(List.of(45, 23, 78, 56, 12, 67, 89, 34, 90, 21, 50, 36, 42, 87, 14, 8, 65, 38, 76, 11, 55, 99));
    List<Integer> aOrderedArraySmall = new ArrayList<>(List.of(8, 11, 12, 14, 21, 23, 34, 36, 38, 42, 50, 55, 56, 65, 67, 76, 78, 87, 89, 90, 99));
    
    List<String> arrayString = new ArrayList<>(List.of("maca", "banana", "uva", "kiwi", "limao", "manga", "laranja", "pera", "abacaxi", "melancia"));
    List<String> names = new ArrayList<>(List.of("maria", "joao", "ana", "carlos", "beatriz", "pedro"));

    public static void main(String[] args) {
    	Main main = new Main();

        // Tire o comentario para rodar todos os algoritmos
    	
        // main.run();

        int opcao = -1;

        do {

            System.out.println("Escolha sua opção");
            System.out.println("1 - Search Algorithms");
            System.out.println("2 - Sort Algorithms");
            System.out.println("0 - SAIR");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	main.menuBusca();
                    break;
                case 2:
                	main.menuOrdenacao();
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida");

            }

        } while (opcao != 0);

        scanner.close();
    }

    void menuBusca() {
        int opcao = -1;
        int[] array = new int[3];

        do {

            System.out.println("Escolha sua opção");
            System.out.println("1 - Binary Search");
            System.out.println("2 - Interpolation Search");
            System.out.println("3 - Jump Search");
            System.out.println("4 - Exponential Search");
            System.out.println("5 - Ternary Search");
            System.out.println("0 - VOLTAR");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha sua opção");
                    System.out.println("1 - Inteiro");
                    System.out.println("2 - String");

                    int opcaoB = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoB == 1) {
                    	array = pedirNumeros();

                        am.bSearchInt(listS, listM, listB, array[0], array[1], array[2], Constantes.BINARY_SEARCH);
                    } else if (opcaoB == 2) {
                        System.out.println(arrayString);
                        System.out.print("Insira uma palavra para buscar: ");
                        String palavra = scanner.nextLine();

                        am.bSearchList(arrayString, palavra, Constantes.BINARY_SEARCH_STRING);
                    } else {
                        System.out.println("Opção inválida");
                        break;
                    }
                    break;
                case 2:
                	
                    array = pedirNumeros();

                    am.iSearch(listS, listM, listB, array[0], array[1], array[2], Constantes.INTERPOLATION_SEARCH);
                    break;
                case 3:
                    array = pedirNumeros();

                    am.jSearch(listS, listM, listB, array[0], array[1], array[2], Constantes.JUMP_SEARCH);
                    break;
                case 4:
                    array = pedirNumeros();

                    am.eSearch(listS, listM, listB, array[0], array[1], array[2], Constantes.EXPONENTIAL_SEARCH);
                    break;
                case 5:
                    array = pedirNumeros();

                    am.tSearch(listS, listM, listB, array[0], array[1], array[2], Constantes.TERNARY_SEARCH);
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida");
            }

        } while (opcao != 0);
    }

    void menuOrdenacao() {

        int opcao = -1;

        do {
            System.out.println("Escolha sua opção");
            System.out.println("1 - Shell Sort");
            System.out.println("2 - Merge Sort");
            System.out.println("3 - Selection Sort");
            System.out.println("4 - Bucket Sort");
            System.out.println("5 - Radix Sort");
            System.out.println("6 - Quick Sort");
            System.out.println("0 - VOLTAR");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listInsertedInt.clear();
                    listInsertedInt = pedirArrayInteiros();

                    am.sSort(listInsertedInt, Constantes.SHELL_SORT);
                    break;
                case 2:
                    System.out.println("Escolha sua opção");
                    System.out.println("1 - Inteiro");
                    System.out.println("2 - String");

                    int opcaoM = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoM == 1) {
                        listInsertedInt.clear();
                        listInsertedInt = pedirArrayInteiros();

                        am.mSortInt(listInsertedInt, Constantes.MERGE_SORT);
                    } else if (opcaoM == 2) {
                        listInsertedString.clear();
                        listInsertedString = pedirArrayStrings();

                        am.mSortList(listInsertedString, Constantes.MERGE_SORT_STRING);
                    } else {
                        System.out.println("Opção inválida");
                        break;
                    }

                    break;
                case 3:
                    listInsertedInt.clear();
                    listInsertedInt = pedirArrayInteiros();

                    am.selecSort(listInsertedInt, Constantes.SELECTION_SORT);
                    break;
                case 4:
                    System.out.println("Escolha sua opção");
                    System.out.println("1 - Inteiro");
                    System.out.println("2 - Float");
                    
                    int opcaoB = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoB == 1) {
                    	listInsertedInt.clear();
                        listInsertedInt = pedirArrayInteiros();

                        am.bSortInt(listInsertedInt, Constantes.BUCKET_SORT);
                    } else if (opcaoB == 2) {
                    	listInsertedFloat.clear();
                    	listInsertedFloat = pedirArrayFloats();

                        am.bSortFloat(listInsertedFloat);
                    } else {
                        System.out.println("Opção inválida");
                        break;
                    }
                    //arrumar
                    
                    break;
                case 5:
                    listInsertedInt.clear();
                    listInsertedInt = pedirArrayInteiros();

                    am.rSort(listInsertedInt, Constantes.RADIX_SORT);
                    break;
                case 6:
                    System.out.println("Escolha sua opção");
                    System.out.println("1 - Inteiro");
                    System.out.println("2 - String");

                    int opcaoQ = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoQ == 1) {
                        listInsertedInt.clear();
                        listInsertedInt = pedirArrayInteiros();

                        List<Integer> listaOrdenadaQuase = quaseOrdenarLista(listInsertedInt);

                        am.qSortInt(listInsertedInt, listaOrdenadaQuase, Constantes.QUICK_SORT);
                    } else if (opcaoQ == 2) {
                        listInsertedString.clear();
                        listInsertedString = pedirArrayStrings();

                        am.qSortList(listInsertedString, Constantes.QUICK_SORT_STRING);
                    } else {
                        System.out.println("Opção inválida");
                        break;
                    }
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida");
            }

        } while (opcao != 0);
    }
    
    void run() {
		System.out.println("================================================");
		Library library = new Library();
		library.searchBook("978-1503280786", al);
		System.out.println("================================================");
		Classroom classroom = new Classroom();
		classroom.searchStudent(81.9f, al);
		System.out.print("================================================");
		am.bSearchInt(listS, listM, listB, 15, 28, 72, Constantes.BINARY_SEARCH);
		System.out.print("================================================");
		am.bSearchList(arrayString, "laranja", Constantes.BINARY_SEARCH_STRING);
		System.out.print("================================================");
		am.iSearch(listS, listM, listB, 15, 28, 72, Constantes.INTERPOLATION_SEARCH);
		System.out.print("================================================");
		am.jSearch(listS, listM, listB, 15, 28, 72, Constantes.JUMP_SEARCH);
		System.out.print("================================================");
		am.eSearch(listS, listM, listB, 15, 28, 72, Constantes.EXPONENTIAL_SEARCH);
		System.out.print("================================================");
		am.tSearch(listS, listM, listB, 15, 28, 72, Constantes.TERNARY_SEARCH);
		System.out.print("================================================");	
		am.sSort(array, Constantes.SHELL_SORT);
		System.out.print("================================================");
		am.mSortInt(array, Constantes.MERGE_SORT);
		System.out.print("================================================");
		am.mSortList(names, Constantes.MERGE_SORT_STRING);
		System.out.print("================================================");
		am.selecSort(array, Constantes.SELECTION_SORT);
		System.out.print("================================================");
		am.bSortFloat(arrayF);
		System.out.print("================================================");
		am.bSortInt(array, Constantes.BUCKET_SORT);
		System.out.print("================================================");
		am.rSort(array, Constantes.RADIX_SORT);
		System.out.print("================================================");
		am.qSortInt(array, aOrderedArraySmall, Constantes.QUICK_SORT);
		System.out.print("================================================");
		am.qSortList(names, Constantes.QUICK_SORT_STRING);
		System.out.println("================================================");

	}

    int[] pedirNumeros() {
    	System.out.println(listS);
    	System.out.println(listM);
    	System.out.println(listB);
        int[] array = new int[3];

        System.out.println("Digite três números para as buscas");
        for (int i = 0; i < 3; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    List<Integer> pedirArrayInteiros() {
    	List<Integer> numbers = new ArrayList<>();

        System.out.println("Insira numeros inteiros. Digite 'parar' para terminar.");

        while (true) {
            System.out.print("Insira um numero: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("parar")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Input invalido. Por Favor, Insira um numero ou 'parar' para terminar.");
            }
        }

        return numbers;
    }
    
    List<Float> pedirArrayFloats() {
        List<Float> floats = new ArrayList<>();

        System.out.println("Insira numeros flutuantes. Digite 'parar' para terminar.");

        while (true) {
            System.out.print("Insira um numero: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                float number = Float.parseFloat(input);
                floats.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Input invalido. Por Favor, Insira um numero ou 'parar' para terminar.");
            }
        }

        return floats;
    }

    List<String> pedirArrayStrings() {
    	List<String> strings = new ArrayList<>();

        System.out.println("Insira palavras. Digite 'parar' para terminar.");

        while (true) {
            System.out.print("Insira a palavra: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("parar")) {
                break;
            }

            strings.add(input);
        }

        return strings;
    }

    List<Integer> quaseOrdenarLista(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        
        Collections.sort(sortedList);

        Random rand = new Random();
        int swapCount = 2;

        for (int i = 0; i < swapCount; i++) {
            int index1 = rand.nextInt(sortedList.size());
            int index2 = rand.nextInt(sortedList.size());

            Collections.swap(sortedList, index1, index2);
        }

        return sortedList;
    }
}
