package generic;

public class Swap<T> {
	private T[] arr;

	public T[] getArr() {
		return arr;
	}

	public void setArr(T[] arr) {
		this.arr = arr;
	}
	
	void swap(T[] arr, int i1, int i2){
		T temp = arr[i2];
		arr[i2] =arr[i1];
		arr[i1] = temp;
	}
	
}
