package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algoritmo {

	private static int comparisonCount = 0;

	// Binary Search
	int binarySearchInt(List<Integer> arr, int first, int last, int num) {
		if(arr.size() == 0 || arr == null) return -1;

		int count = 0;

		while(first <= last) {
			count++;
			int mid = first + (last - first) / 2;

			if(arr.get(mid) == num) {
				System.out.println("Binary: Numero encontrado em "+ count +" tentativas");
				return mid;
			}

			if(arr.get(mid) < num){
				first = mid + 1;
			}

			if(arr.get(mid) > num){
				last = mid - 1;
			}
		}

		return -1;
	}

	int binarySearchList(List<String> arr, String word) {
		if (arr == null || arr.isEmpty()) return -1;

		int first = 0;
		int last = arr.size() - 1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			String midList = arr.get(mid);

			int comparison = word.compareTo(midList);
			if (comparison == 0) {
				return mid;
			} else if (comparison < 0) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}

		return -1;
	}	

	// Interpolation Search
	int interpolationSearch(List<Integer> arr, int num){
		if(arr.size() == 0 || arr == null) return -1;

		int first = 0;
		int last = arr.size() - 1;
		int count = 0;

		while(first <= last && num >= arr.get(first) && num <= arr.get(last)){
			count++;
			int pos = first + ((num - arr.get(first)) * (last - first)) / (arr.get(last) - arr.get(first));


			if(arr.get(pos) == num){
				System.out.println("Interpolation: Numero encontrado em "+ count +" tentativas");
				return pos;
			}

			if(arr.get(pos) < num){
				first = pos + 1;
			}

			if(arr.get(pos) > num){
				last = pos - 1;
			}
		}

		return -1;
	}

	float interpolationSearchList(List<Float> arr, float num) {
		if(arr.isEmpty() || arr == null) return -1;

		int first = 0;
		int last = arr.size() - 1;
		int count = 0;

		while(first <= last && num >= arr.get(first) && num <= arr.get(last)) {
			count++;
			int pos = first + (int) (((num - arr.get(first)) * (last - first)) / (arr.get(last) - arr.get(first)));

			if(arr.get(pos).equals(num)) {
				System.out.println("Interpolation: Numero encontrado em "+ count +" tentativas");
				return pos;
			}

			if(arr.get(pos) < num) {
				first = pos + 1;
			}

			if(arr.get(pos) > num) {
				last = pos - 1;
			}
		}

		return -1;
	}

	// Jump Search
	int jumpSearch(List<Integer> arr, int num) {
		if(arr.isEmpty() || arr == null) return -1;

		int prev = 0;
		int n = arr.size();
		int step = (int)Math.sqrt(n);
		int count = 0;

		while (prev < n && arr.get(Math.min(step, n) - 1) < num) {
			count++;
			prev = step;
			step += (int) Math.sqrt(n);

			if (prev >= n){
				return -1;
			}
		}

		for (int i = prev; i < Math.min(step, n); i++) {
			count++;
			if (arr.get(i) == num) {
				System.out.println("Jump: Numero encontrado em "+ count +" tentativas");
				return i;
			}
		}

		return -1;
	}

	// Exponential Search
	int exponentialSearch(List<Integer> arr, int num) {
		if(arr.isEmpty()  || arr == null) return -1;

		int count = 1;
		int n = arr.size();


		if (arr.get(0) == num) {
			System.out.println("Exponential: Numero encontrado em "+ count +" tentativas");
			return 0;
		}


		int i = 1;
		while (i < n && arr.get(i) <= num) {
			count++;
			i = i * 2;
		}

		int result = binarySearchInt(arr, i / 2, Math.min(i, n), num);

		if (result >= 0) {
			System.out.println("Exponential: Numero encontrado em "+ count +" tentativas");
			return result;
		} 

		return -1;
	}

	// Ternary Search
	int ternarySearch(List<Integer> arr, int left, int right, int num) {
		if(arr.isEmpty() || arr == null) return -1;

		int count = 0;

		if(right >= left) {
			count++;

			int mid1 = left + (right - left) / 3;
			int mid2 = right - (right - left) / 3;

			if(arr.get(mid1) == num) { 
				System.out.println("Ternary: Numero encontrado em "+ count +" tentativas");
				return mid1;
			}
			if(arr.get(mid2) == num) {
				System.out.println("Ternary: Numero encontrado em "+ count +" tentativas");
				return mid2;
			}

			if(num < arr.get(mid1)) {
				return ternarySearch(arr, left, mid1 - 1, num);
			} else if(num > arr.get(mid2)) {
				return ternarySearch(arr, mid2 + 1, right, num);
			} else {
				return ternarySearch(arr, mid1 + 1, mid2 - 1, num);
			}
		}

		return -1;
	}

	// Shell Sort (Shell)
	List<Integer> shellSortShell(List<Integer> arr, int n) {
		if(n == 0) return null;

		for(int gap = n/2; gap > 0; gap /= 2) {
			for(int i = gap; i < n; i++) {
				int temp = arr.get(i);
				int j;

				for(j = i;j >= gap && arr.get(j - gap) > temp; j -= gap) {
					arr.set(j, arr.get(j - gap));
					comparisonCount++;
				}

				arr.set(j, temp);
			}
		}
		return arr;
	}

	// Shell Sort (Knuth)
	List<Integer> shellSortKnuth(List<Integer> arr, int n) {
		if(n == 0) return null;

		int gap = 1;
		while (gap < n / 3) {
			gap = 3 * gap + 1;
		}

		while(gap > 0) {
			for(int i = gap; i < n; i++) {
				int temp = arr.get(i);
				int j;

				for(j = i;j >= gap && arr.get(j - gap) > temp; j -= gap) {
					arr.set(j, arr.get(j - gap));
					comparisonCount++;
				}

				arr.set(j, temp);
			}

			gap = gap / 3;
		}
		return arr;
	}

	// Shell Sort (Hibbard)
	List<Integer> shellSortHibbard(List<Integer> arr, int n) {
		if(n == 0) return null;

		int[] gaps = generateHibbardSequence(n);

		for(int gap : gaps) {
			for(int i = gap; i < n; i++) {
				int temp = arr.get(i);
				int j;

				for(j = i;j >= gap && arr.get(j - gap) > temp; j -= gap) {
					arr.set(j, arr.get(j - gap));
					comparisonCount++;
				}

				arr.set(j, temp);
			}
		}
		return arr;
	}

	private int[] generateHibbardSequence(int n) {
		int k = 1;
		int gap = (int) Math.pow(2, k) - 1;
		List<Integer> gaps = new ArrayList<>();

		while(gap < n) {
			gaps.add(gap);
			k++;
			gap = (int) Math.pow(2, k) - 1;
		}

		Collections.reverse(gaps);
		return gaps.stream().mapToInt(Integer::intValue).toArray();
	}

	// Merge Sort Int
	List<Integer> mergeSortInt(List<Integer> arr) {
		if(arr.size() <= 1) return arr;

		int mid = arr.size() / 2;
		List<Integer> left = arr.subList(0, mid);
		List<Integer> right = arr.subList(mid, arr.size()); 

		left = mergeSortInt(left);
		right = mergeSortInt(right);


		return mergeInt(left, right);
	}

	private List<Integer> mergeInt(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>(left.size() + right.size());
		int i = 0, j = 0;

		while(i < left.size() && j < right.size()) {
			comparisonCount++;
			if(left.get(i) <= right.get(j)) {
				result.add(left.get(i));
				i++;
			} else {		
				result.add(right.get(j));
				j++;
			}
		}

		result.addAll(left.subList(i, left.size()));
		result.addAll(right.subList(j, right.size()));

		return result;
	}

	// Merge Sort String
	List<String> mergeSortString(List<String> arr) {
		if(arr.size() <= 1) return arr;

		int mid = arr.size() / 2;
		List<String> left = arr.subList(0, mid);
		List<String> right = arr.subList(mid, arr.size());

		left = mergeSortString(left);
		right = mergeSortString(right);

		return mergeString(left, right);
	}

	private List<String> mergeString(List<String> left, List<String> right) {
		List<String> result = new ArrayList<>(left.size() + right.size());
		int i = 0, j = 0;

		while(i < left.size() && j < right.size()) {
			if(left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
				result.add(left.get(i));
				i++;
			} else {
				result.add(right.get(j));
				j++;
			}
		}

		while(i < left.size()) {
			result.add(left.get(i));
			i++;
		}

		while(j < right.size()) {
			result.add(right.get(j));
			j++;
		}

		return result;
	}

	// Selection Sort
	List<Integer> selectionSort(List<Integer> arr, int n) {
		if(n == 0) return null;

		for(int i = 0; i < n - 1; i++) {
			int min_idx = i;

			for(int j = i + 1; j < n; j++) {
				comparisonCount++;
				if(arr.get(j) < arr.get(min_idx)) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				int temp = arr.get(i);
				arr.set(i, arr.get(min_idx));
				arr.set(min_idx, temp);
			}
		}

		return arr;
	}

	// Bucket Sort Float
	List<Float> bucketSortFloat(List<Float> arr, int n, float min, float max) {
		if(n == 0) return null;

		@SuppressWarnings("unchecked")
		List<Float>[] buckets = new List[n];

		for(int i = 0; i < n; i++) {
			buckets[i] = new ArrayList<>();
		}

		for(float num : arr) {
			int bucket_idx = (int) ((num - min) / (max - min) * n);
			if (bucket_idx >= n) bucket_idx = n - 1;
			buckets[bucket_idx].add(num);
		}

		for(int i = 0; i < n; i++) {
			Collections.sort(buckets[i]);
		}

		arr.clear();
		for (int i = 0; i < n; i++) {
			arr.addAll(buckets[i]);
		}

		return arr;
	}

	// Bucket Sort Int
	List<Integer> bucketSortInt(List<Integer> arr, int n) {
		if(n == 0) return null;

		int maxValue = findMax(arr);

		int numBuckets = (int) Math.sqrt(n);

		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[numBuckets];

		for(int i = 0; i < numBuckets; i++) {
			buckets[i] = new ArrayList<>();
		}

		for (int num : arr) {

			int bucket_idx = (int) ((num / (float) (maxValue + 1)) * numBuckets);
			comparisonCount++;

			if (bucket_idx == numBuckets) {
				bucket_idx--;
			}

			buckets[bucket_idx].add(num);
		}

		for(int i = 0; i < numBuckets; i++) {
			Collections.sort(buckets[i]);
		}

		List<Integer> sortedArr = new ArrayList<>();
		for(int i = 0; i < numBuckets; i++) {
			sortedArr.addAll(buckets[i]);
		}

		return sortedArr;
	}

	// Radix Sort
	List<Integer> radixSort(List<Integer> arr, int base) {
		if(arr == null || arr.isEmpty() || base <= 1) return null;


		int max = findMax(arr);
		for(int exp = 1; max / exp > 0; exp *= base) {
			countingSort(arr, exp, base);
		}

		return arr;
	}

	private void countingSort(List<Integer> arr, int exp, int base) {
		int n = arr.size();
		List<Integer> output = new ArrayList<>(n); 
		int[] count = new int[base];

		for(int i = 0; i < n; i++) {
			output.add(0);
		}

		for(int i = 0; i < n; i++) {
			int digit = (arr.get(i) / exp) % base;
			count[digit]++;
			comparisonCount++;
		}

		for(int i = 1; i < base; i++) {
			count[i] += count[i - 1];
		}

		for(int i = n - 1; i >= 0; i--) {
			int digit = (arr.get(i) / exp) % base;
			output.set(count[digit] - 1, arr.get(i)); 
			count[digit]--;
			comparisonCount++;
		}

		for (int i = 0; i < n; i++) {
			arr.set(i, output.get(i));
		}

	}

	// Quick Sort
	List<Integer> quickSortInt(List<Integer> arr, int first, int last, String pivotChoice) {

		if(first < last) {
			int pivot = partitionInt(arr, first, last, pivotChoice);

			quickSortInt(arr, first, pivot - 1, pivotChoice);
			quickSortInt(arr, pivot + 1, last, pivotChoice);
		}

		return arr;
	}

	private int partitionInt(List<Integer> arr, int first, int last, String pivotChoice) {
		int pivot;

		switch(pivotChoice) {
		case "first":
			pivot = arr.get(first);
			break;
		case "middle":
			int middle = first + (last - first) / 2;
			pivot = arr.get(middle);
			swapInt(arr, middle, last);
			break;
		case "last":
			pivot = arr.get(last);
			break;
		default:
			throw new IllegalArgumentException("Invalid Pivot Criterion");	
		}

		int i = first - 1;
		int j = first;

		while (j < last) {
			comparisonCount++;
			if (arr.get(j) < pivot) {
				i++;
				swapInt(arr, i, j);
			}
			j++;
		}

		swapInt(arr, i + 1, last);
		return i + 1;
	}

	List<String> quickSortString(List<String> arr, int first, int last, String pivotChoice){
		if(first < last) {
			int pivot = partitionString(arr, first, last, pivotChoice);

			quickSortString(arr, first, pivot - 1, pivotChoice);
			quickSortString(arr, pivot + 1, last, pivotChoice);
		}

		return arr;
	}

	private int partitionString(List<String> arr, int first, int last, String pivotChoice) {
		String pivot;

		switch(pivotChoice) {
		case "first":
			pivot = arr.get(first);
			break;
		case "middle":
			int middle = first + (last - first) / 2;
			pivot = arr.get(middle);
			swapString(arr, middle, last);
			break;
		case "last":
			pivot = arr.get(last);
			break;
		default:
			throw new IllegalArgumentException("Invalid Pivot Criterion");	
		}

		int i = first - 1;
		int j = first;

		while (j < last) {
			comparisonCount++;
			if (arr.get(j).compareTo(pivot) < 0) {
				i++;
				swapString(arr, i, j);
			}
			j++;
		}

		swapString(arr, i + 1, last);
		return i + 1;

	}
	
	private void swapInt(List<Integer> arr, int a, int b) {
		int temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}

	private void swapString(List<String> arr, int a, int b) {
		String temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}

	private int findMax(List<Integer> arr) {
		int max = arr.get(0);
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	public static void resetComparisonCount() {
		comparisonCount = 0;
	}

	public static int getComparisonCount() {
		return comparisonCount;
	}

}