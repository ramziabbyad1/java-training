package generic;

public final class Max<T extends Number>{
	private T max;
	public Max(T[] arr, T begin, T end){
		max = max(arr, begin, end);
	}
	
	public T max(T[] arr, T begin, T end){
		T max = begin;
		boolean found = false;
		int len = arr.length;
		if(len > 1){
			for(int i=0; i< len; i++){
				if(arr[i].doubleValue() > max.doubleValue() && arr[i].doubleValue() < end.doubleValue()){
					found = true;
					max = arr[i];
				}
			}
		}
		if(found == true){
			return max;
		}
		else{
			System.out.println("Not in range");
			return max;
		}
	}

	public T getMax() {
		return max;
	}

	
}
