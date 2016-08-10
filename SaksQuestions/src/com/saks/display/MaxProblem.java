package com.saks.display;

public class MaxProblem {
	public static int max(int[] numbers) throws Exception{
		if(numbers == null || numbers.length == 0) {
			throw new Exception("Input array is empty.  Please use a non-empty array of ints.");
		}
		int max = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] nll = null;
		try {
			System.out.println(max(nll));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] empty = {};
		try {
			System.out.println(max(empty));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] single = {2000};
		try {
			System.out.println(max(single));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] multi = {-100, 10, 55, 9, -200, 3, 105, 99};
		try {
			System.out.println(max(multi));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
