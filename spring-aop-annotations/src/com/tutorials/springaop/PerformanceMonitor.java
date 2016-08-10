package com.tutorials.springaop;

import java.util.Date;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PerformanceMonitor {
	private static final Logger logger_c = Logger.getLogger(PerformanceMonitor.class);
	
	private final String MONITOR = "PERFORMANCE_MONITOR";
	private Monitor monitor_i;
	
	@Before("execution(* com.tutorials.springaop.CalculationService.dummyServiceMethod())")
	public void startMonitor(){
		monitor_i = MonitorFactory.start(MONITOR);
	}
	
	@After("execution(* com.tutorials.springaop.CalculationService.dummyServiceMethod())")
	public void stopMonitor(){
		monitor_i.stop();
	}
	
	public int getCallCount(){
		return (int)monitor_i.getHits();
	}
	
	public Date getLastAccess(){
		return monitor_i.getLastAccess();
	}
	
	public double getAverageCallTime(){
		return monitor_i.getAvg()/1000;
	}
	
	public double getLastCallTime(){
		return monitor_i.getLastValue()/1000;
	}
	
	public double getMaximumCallTime(){
		return monitor_i.getMax()/1000;
	}
	
	public double getMinimumCallTime(){
		return monitor_i.getMin()/1000;
	}
	
	public double getTotalCallTime(){
		return monitor_i.getTotal()/1000;
	}
	
	@After("execution(* com.tutorials.springaop.CalculationService.dummyServiceMethod())")
	public void log(JoinPoint joinPoint_p){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("*=========================================");
		sb.append("\n");
		sb.append("*	PERFORMANCE STATISTICS		*");
		sb.append("\n");
		sb.append("*=========================================");
		sb.append("\n");
		sb.append("* Method name : " +joinPoint_p.getSignature().getName());
		sb.append("\n");
		sb.append("* Execution date : " + this.getLastAccess());
		sb.append("* Last Execution Time : ").append(this.getLastCallTime()).append(" secs");
		sb.append("\n");  
		sb.append("* Service Calls: ").append(((this.getCallCount())));  
		sb.append("\n");  
		sb.append("* Avg Execution Time: ").append(this.getAverageCallTime()).append(" sec");  
		sb.append("\n");  
		sb.append("* Total Execution TIme: ").append(this.getTotalCallTime()).append(" sec");  
		sb.append("\n");  
		sb.append("* Min Execution Time: ").append(this.getMinimumCallTime()).append(" sec");  
		sb.append("\n");  
		sb.append("* Max Execution Time: ").append(this.getMaximumCallTime()).append(" sec");  
		sb.append("\n");  
		sb.append("*=========================================");
		
		logger_c.info(sb.toString());
		
	}
}
