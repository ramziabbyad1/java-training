package com.examples;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	//msg is an attribute of the hellotag defintion
	public String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	StringWriter sw = new StringWriter();
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if(getJspBody()!=null){
			out.println("hello");
			getJspBody().invoke(sw);
			String s = sw.toString();
			s = s.toUpperCase();
			if(msg!=null){
				s +="  "+msg;
			}
			out.println("<br/><b><u>"+s+"</b></u>");
		}else{
			out.println("Hello from my custom tag.");
		}		
		
		super.doTag();
	}
}
