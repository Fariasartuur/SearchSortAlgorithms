package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithm {
	
	private static int comparisonCount = 0;

	
	// Interpolation Search
	static int interpolationSearch(int[] arr, int first, int last, int num){
	    if(arr.length == 0) return -1;
	    
	    int count = 0;

	    while(first <= last && num >= arr[first] && num <= arr[last]){
	    	count++;
	    	int pos = first + ((num - arr[first]) * (last - first)) / (arr[last] - arr[first]);

	    	if(arr[pos] == num){
	    		System.out.println("Number found in "+ count +" attempts");
	    		return pos;
	    	}

	    	if(arr[pos] < num){
	    		first = pos + 1;
	    	}

	    	if(arr[pos] > num){
	    		last = pos - 1;
	    	}
	    }

	    return -1;
	  }
	
	static float interpolationSearchList(List<Float> arr, int first, int last, float num) {
		if(arr.isEmpty() || arr == null) return -1;
		
		int count = 0;
		
	    while(first <= last && num >= arr.get(first) && num <= arr.get(last)) {
	    	count++;
	    	int pos = first + (int) (((num - arr.get(first)) * (last - first)) / (arr.get(last) - arr.get(first)));

	    	if(arr.get(pos).equals(num)) {
	    		System.out.println("Student found in "+ count +" attempts");
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
	
	// Binary Search
	static int binarySearchInt(int[] arr, int first, int last, int num) {
		if(arr.length == 0) return -1;
		
		int count = 0;
		
		while(first <= last) {
			count++;
			int mid = first + (last - first) / 2;
			
			if(arr[mid] == num) {
				System.out.println("Number found in "+ count +" attempts");
				return mid;
			}
			
			if(arr[mid] < num){
		        first = mid + 1;
		    }

		    if(arr[mid] > num){
		        last = mid - 1;
		    }
		}
		
		return -1;
	}
	
	static String binarySearchList(List<String> arr, int first, int last, String word) {
		if(arr.isEmpty() || arr == null) return null;
		
		while(first <= last) {
			int mid = first + (last - first) / 2;
			String midList = arr.get(mid);
			
			int comparison = word.compareTo(midList);
			if (comparison == 0) {
	            return midList;
	        } else if (comparison < 0) {
	            last = mid - 1;
	        } else {
	            first = mid + 1;
	        }
		}
		
		return null;
	}
	
	
	// Jump Search
	public static int jumpSearch(int[] arr, int prev, int n, int num) {
 
        int step = (int)Math.sqrt(n);
        int count = 0;
        
        while (prev < n && arr[Math.min(step, n) - 1] < num) {
        	count++;
        	prev = step;
        	step += Math.sqrt(n);
        	
        	if (prev >= n){
        		return -1;
        	}
        }
        
        for (int i = prev; i < Math.min(step, n); i++) {
        	count++;
        	if (arr[i] == num) {
				System.out.println("Number found in "+ count +" attempts");
        		return i;
        	}
        }
        
        return -1;
    }
	
	// Exponential Search
	static int exponentialSearch(int arr[], int n, int num) {
		int count = 1;
		
		if(n == 0) return -1;
			
		if (arr[0] == num) {
			System.out.println("Number found in "+ count +" attempts");
			return 0;
		}


		int i = 1;
		while (i < n && arr[i] <= num) {
			count++;
			i = i * 2;
		}
			
		int result = binarySearchInt(arr, i / 2, Math.min(i, n), num); // Arrays.binarySearch(arr, i / 2, Math.min(i, n), num);

	    if (result >= 0) {
	        System.out.println("Number found in " + count + " attempts");
	        return result;
	    } 
	    
	    return -1;
	}
	
	// Ternary Search
	static int ternarySearch(int arr[],int left, int right, int num) {
		int count = 0;
		
		if(arr.length == 0) return -1;
		
		if(right >= left) {
			count++;
			
			int mid1 = left + (right - left) / 3;
			int mid2 = right - (right - left) / 3;
			
			if(arr[mid1] == num) { 
				System.out.println("Number found in " + count + " attempts");
				return mid1;
			}
			if(arr[mid2] == num) {
				System.out.println("Number found in " + count + " attempts");
				return mid2;
			}
			
			if(num < arr[mid1]) {
				return ternarySearch(arr, left, mid1 - 1, num);
			} else if(num > arr[mid2]) {
				return ternarySearch(arr, mid2 + 1, right, num);
			} else {
				return ternarySearch(arr, mid1 + 1, mid2 - 1, num);
			}
		}
		
		return -1;
	}
	
	// Shell Sort (Shell)
	static int[] shellSortShell(int[] arr, int n) {
		if(n == 0) return null;
		
		for(int gap = n/2; gap > 0; gap /= 2) {
			for(int i = gap; i < n; i++) {
				int temp = arr[i];
				int j;
				
				for(j = i;j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
					comparisonCount++;
				}
				
				arr[j] = temp;
			}
		}
		return arr;
	}
	
	// Shell Sort (Knuth)
	static int[] shellSortKnuth(int[] arr, int n) {
		if(n == 0) return null;
		
		int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;
        }
		
        while(gap > 0) {
        	for(int i = gap; i < n; i++) {
				int temp = arr[i];
				int j;
				
				for(j = i;j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
					comparisonCount++;
				}
				
				arr[j] = temp;
			}
        	
        	gap = gap / 3;
        }
        return arr;
	}
	
	// Shell Sort (Hibbard)
	static int[] shellSortHibbard(int[] arr, int n) {
		if(n == 0) return null;
		
		int[] gaps = generateHibbardSequence(n);
		
		for(int gap : gaps) {
			for(int i = gap; i < n; i++) {
				int temp = arr[i];
				int j;
				
				for(j = i;j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
					comparisonCount++;
				}
				
				arr[j] = temp;
			}
		}
		return arr;
	}
	
	private static int[] generateHibbardSequence(int n) {
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
	static int[] mergeSortInt(int arr[]) {
		if(arr.length <= 1) return arr;
		
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		left = mergeSortInt(left);
		right = mergeSortInt(right);
		
		arr = mergeInt(left, right);
		
		return arr;
	}

	private static int[] mergeInt(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		
		while(i < left.length && j < right.length) {
			comparisonCount++;
			if(left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		
		while(i < left.length) {
			result[k++] = left[i++];
		}
		
		while(j < right.length) {
			result[k++] = right[j++];
		}
		
		return result;
	}
	
	// Merge Sort String
	static String[] mergeSortString(String arr[]) {
		if(arr.length <= 1) return arr;
		
		int mid = arr.length / 2;
		String[] left = Arrays.copyOfRange(arr, 0, mid);
		String[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		left = mergeSortString(left);
		right = mergeSortString(right);
		
		arr = mergeString(left, right);
		
		return arr;
	}

	private static String[] mergeString(String[] left, String[] right) {
		String[] result = new String[left.length + right.length];
		int i = 0, j = 0, k = 0;
		
		while(i < left.length && j < right.length) {
			if(left[i].compareToIgnoreCase(right[j]) <= 0) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		
		while(i < left.length) {
			result[k++] = left[i++];
		}
		
		while(j < right.length) {
			result[k++] = right[j++];
		}
		
		return result;
	}
	
	// Selection Sort
	static int[] selectionSort(int[] arr, int n) {
		if(n == 0) return null;
		
		for(int i = 0; i < n - 1; i++) {
			int min_idx = i;
			
			for(int j = i + 1; j < n; j++) {
				comparisonCount++;
				if(arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
			
			if (min_idx != i) {
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
		}
		
		return arr;
	}
	
	// Bucket Sort Float
	static float[] bucketSortFloat(float[] arr, int n, float min, float max) {
		if(n == 0) return null;
		
		@SuppressWarnings("unchecked")
		ArrayList<Float>[] buckets = new ArrayList[n];
		
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
		
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(float num : buckets[i]) {
				arr[index++] = num;
			}
		}
		
		return arr;
	}
	
	// Bucket Sort Int
	static int[] bucketSortInt(int[] arr, int n) {
		if(n == 0) return null;
		
		int maxValue = findMax(arr);
		
		int numBuckets = (int) Math.sqrt(n);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
		
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
		
		int index = 0;
		for(int i = 0; i < numBuckets; i++) {
			for(int num : buckets[i]) {
				arr[index++] = num;
			}
		}
		
		return arr;
	}
	
	// Radix Sort
	static int[] radixSort(int[]arr, int base) {
		if(arr == null || arr.length == 0 || base <= 1) return null;
		
		
		int max = findMax(arr);
		for(int exp = 1; max / exp > 0; exp *= base) {
			countingSort(arr, exp, base);
		}
		
		return arr;
	}

	private static void countingSort(int[] arr, int exp, int base) {
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[base];
		
		for(int i = 0; i < n; i++) {
			int digit = (arr[i] / exp) % base;
            count[digit]++;
            comparisonCount++;
		}
		
		for(int i = 1; i < base; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = n - 1; i >= 0; i--) {
			int digit = (arr[i] / exp) % base;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
            comparisonCount++;
		}
		
		System.arraycopy(output, 0, arr, 0, n);
		
	}
	
	// Quick Sort
	static int[] quickSortInt(int[]arr, int first, int last, String pivotChoice) {
		
		if(first < last) {
			int pivot = partitionInt(arr, first, last, pivotChoice);
			
			quickSortInt(arr, first, pivot - 1, pivotChoice);
			quickSortInt(arr, pivot + 1, last, pivotChoice);
		}
		
		return arr;
	}
	
	private static int partitionInt(int[] arr, int first, int last, String pivotChoice) {
		int pivot;
		
		switch(pivotChoice) {
		case "first":
			pivot = arr[first];
            break;
		case "middle":
			int middle = first + (last - first) / 2;
            pivot = arr[middle];
            swapInt(arr, middle, last);
            break;
		case "last":
			pivot = arr[last];
            break;
		default:
            throw new IllegalArgumentException("Invalid Pivot Criterion");	
		}
		
		int i = first - 1;
	    int j = first;
		
	    while (j < last) {
	    	comparisonCount++;
	        if (arr[j] < pivot) {
	            i++;
	            swapInt(arr, i, j);
	        }
	        j++;
	    }
		
	    swapInt(arr, i + 1, last);
	    return i + 1;
	}
	
	private static void swapInt(int[]arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
        arr[b] = temp;
	}
	
	static String[] quickSortString(String[] arr, int first, int last, String pivotChoice){
		if(first < last) {
			int pivot = partitionString(arr, first, last, pivotChoice);
			
			quickSortString(arr, first, pivot - 1, pivotChoice);
			quickSortString(arr, pivot + 1, last, pivotChoice);
		}
		
		return arr;
	}
	
	private static int partitionString(String[] arr, int first, int last, String pivotChoice) {
		String pivot;
		
		switch(pivotChoice) {
		case "first":
			pivot = arr[first];
            break;
		case "middle":
			int middle = first + (last - first) / 2;
            pivot = arr[middle];
            swapString(arr, middle, last);
            break;
		case "last":
			pivot = arr[last];
            break;
		default:
            throw new IllegalArgumentException("Invalid Pivot Criterion");	
		}
		
		int i = first - 1;
	    int j = first;
		
	    while (j < last) {
	    	comparisonCount++;
	        if (arr[j].compareTo(pivot) < 0) {
	            i++;
	            swapString(arr, i, j);
	        }
	        j++;
	    }
		
	    swapString(arr, i + 1, last);
	    return i + 1;
		
	}

	private static void swapString(String[] arr, int a, int b) {
		String temp = arr[a];
		arr[a] = arr[b];
        arr[b] = temp;
	}

	private static int findMax(int[] arr) {
        int max = arr[0];
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
