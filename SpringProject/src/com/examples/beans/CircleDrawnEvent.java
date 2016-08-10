package com.examples.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class CircleDrawnEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	public CircleDrawnEvent(Object source) {
		super(source);
	}
	public String toString(){
		return "Circle drawn.";
	}



}
