package com.examples.beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Circle implements ApplicationEventPublisherAware{
	private String name;
	private int radius;
	private ApplicationEventPublisher publisher;
	public void draw(){
		System.out.println(getName()+" circle drawn with radius : "+getRadius());
		CircleDrawnEvent event = new CircleDrawnEvent(this);
		publisher.publishEvent(event);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void myinit(){
		System.out.println("circle bean initializing...");
	}
	public void mydestroy(){
		System.out.println("circle bean destroyed...");
	}
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}
	
	
}
