package com.examples.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Power extends TagSupport {

	private static final long serialVersionUID = 1L;
	private int number;
	private int power;
	private int counter;
	private int result=1;
	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		counter++;
		result *= counter;
		if(counter==power){
			return SKIP_BODY;
		}
		return EVAL_BODY_AGAIN;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.print(result);
		}catch(Exception e){e.printStackTrace();}
		return EVAL_PAGE;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

}
