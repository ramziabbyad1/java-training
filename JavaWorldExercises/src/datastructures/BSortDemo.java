package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;


public class BSortDemo {
	static int[] distinctRandArray(int n) {
		List<Integer> nums = new ArrayList<>();
		for(int i=0; i <= n; i++) {
			nums.add(i);
		}
		Collections.shuffle(nums);
		return ArrayUtils.toPrimitive(nums.toArray(new Integer[n]));
	}
	
	private static void swap(int[] arr, int i, int k) {
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}
	
	private static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr.length - i - 1; k++) {
				if(arr[k] > arr[k+1]) {
					swap(arr, k, k+1);
				}
				System.out.println(" pass = " + i+ " k = "+ k);
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] input = distinctRandArray(10);
		System.out.println(Arrays.toString(input));
		bubbleSort(input);
		System.out.println(Arrays.toString(input));
		
	}

}
