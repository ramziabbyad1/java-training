package com.sortedset;

public class Certificate implements Comparable<Certificate> {
	private int id;
	private String name;
	public Certificate(){}
	public Certificate(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Certificate that) {
		final int BEFORE = -1;
		final int AFTER = 1;
		if(that==null)	return BEFORE;
		String thisCertificate = this.getName();
		String thatCertificate = that.getName();
		if(thisCertificate==null)	return AFTER;
		else if(thatCertificate==null)	return BEFORE;
		else{
			return thisCertificate.compareTo(thatCertificate);
		}
		
		
	}

}
