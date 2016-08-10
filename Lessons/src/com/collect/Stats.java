//this class is designed to compute the average for any numeric array (i.e. it extends Number and has the most precise
//return type = double for the average() method)
package com.collect;

public class Stats<T extends Number> {
	private T[] nums;

	public T[] getNums() {
		return nums;
	}

	public void setNums(T[] nums) {
		this.nums = nums;
	}
	public double average(){
		double sum = 0.0;
		double avg = 0.0;
		for(T num:nums){
			sum += num.doubleValue();
		}
		avg = sum/nums.length;
		return avg;
	}
}
