package com.collect;

public class MyGeneric<T> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	public void showType(){
		System.out.println("Type: " + obj.getClass().getName());
	}
	
}
