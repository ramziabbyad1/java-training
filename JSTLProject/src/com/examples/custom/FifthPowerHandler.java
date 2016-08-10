package com.examples.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FifthPowerHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	private int number;
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.print(Math.pow(number, 5));
		}catch(Exception e){System.out.println(e);}
		return SKIP_BODY;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
