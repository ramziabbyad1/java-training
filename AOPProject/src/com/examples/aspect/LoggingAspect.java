package com.examples.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	@Before("allGetters()")
	public void LoggingAdvice(){
		System.out.println("Logging advice exectured");
	}
	@Before("execution(* com.examples.beans.Circle.*(..))")
	public void AnotherAdvice(JoinPoint jp){
		System.out.println("another advice executed"+jp);
	}
	@Pointcut("within (com.examples.beans.*)")
	public void allGetters(){}
	
	@Pointcut("within (com.examples.beans.Circle)")
	public void allCircles(){}
	
	//@AfterReturning("execution(public void draw())")
	@AfterThrowing("execution(public void draw())")
	public void afterAdvice(){
		System.out.println("After advice executed");
	}
	@Before("args(name)")
	public void stringArgsMethods(String name){
		System.out.println("Advice with one String args value passed: " + name);
	}
	@Around("execution (public void draw())")
	public Object aroundAdvice(ProceedingJoinPoint pjp){
		Object o=null;
		try{
			System.out.println("Before: around advice.");
			o = pjp.proceed();
			System.out.println("After: around advice run.");
		}catch(Throwable t){t.printStackTrace();}
		return o;
	}
}
