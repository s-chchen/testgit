package com.itheima.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Pointcut("execution(* com.itheima.jdk.*.*(..))")
	private void myPointCut() {	}
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("ǰ��֪ͨ.......");		
		System.out.print("Ŀ�����ǣ�"+joinPoint.getTarget());		
		System.out.println(",��ע����ǿ�����Ŀ�귽���ǣ�"+joinPoint.getSignature().getName());		
	}
	@AfterReturning("myPointCut()")
	public void myAfterReturing(JoinPoint joinPoint) {
		System.out.print("����֪ͨ.......");		
		System.out.print("Ŀ�����ǣ�"+joinPoint.getTarget());		
		System.out.println(",��ע����ǿ�����Ŀ�귽���ǣ�"+joinPoint.getSignature().getName());
	}
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("���ƿ���......���Ȩ��......");		
		System.out.print("Ŀ�����ǣ�"+proceedingJoinPoint.getTarget());		
		System.out.println(",��ע����ǿ�����Ŀ�귽���ǣ�"+proceedingJoinPoint.getSignature().getName());		
		Object obj=proceedingJoinPoint.proceed();		
		System.out.println("���ƽ���......��־��¼......");		
		return obj;
	}
	@AfterThrowing(value="myPointCut()",throwing = "e")
	public void myAftreThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ��������"+e.getMessage());			
	}
	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("����֪ͨ��ģ�ⷽ����������ͷ���Դ...");					
	}
}
