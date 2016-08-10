package com.examples.custom;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.println(Calendar.getInstance().getTime());
		}catch(Exception e){System.out.println(e);}
		return SKIP_BODY;
	}

}
