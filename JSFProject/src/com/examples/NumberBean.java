package com.examples;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean
@RequestScoped
public class NumberBean {
	private Integer userNo;
	private Integer randomNo;
	private String ansString;
	private Integer max = 10;
	private Integer min = 0;
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public NumberBean(){
		Random r = new Random();
		this.randomNo = r.nextInt(11);
		System.out.println("Secret Number : " + this.randomNo);
	}
	public String showResult(){
		return "success";
	}

	public String getAnsString() {
		if(userNo!=null && userNo.compareTo(randomNo)==0){
			ansString = "Congratulations asshold, you fuckin' got it... piece of fucking shit.";
		}else{
			ansString = "Your guess was fucking wrong you fucking dumbass.";
		}
		return ansString;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	
}
