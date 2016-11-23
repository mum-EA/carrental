package edu.mum.cs544.abccarrental.aop;

import java.lang.reflect.InvocationTargetException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.lang.annotation.Around;


@Aspect
public class UserAspect {
	
	@Autowired
	MethodName methodNames;
	
//	
//	 @Value("#{'${}'.split(',')}") 
//	private String methodName;

	@Around("execution(* edu.mum.cs544.abccarrental.controller.MainController.*(..))")
	public void mainControllerAdvice(ProceedingJoinPoint joinPoint){
		java.lang.reflect.Method method = null;
		String methodName = joinPoint.getSignature().getName();
		String methodOperationName = null;
		System.out.println(methodOperationName.toString());
		try {
			  method = methodNames.getClass().getMethod(methodName, MethodName.class);
			} catch (SecurityException e) {
				
			}
			  catch (NoSuchMethodException e) { 
				  
			  }
		try {
			methodOperationName = (String) method.invoke(methodNames);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Action done is: "+ methodOperationName);

		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}