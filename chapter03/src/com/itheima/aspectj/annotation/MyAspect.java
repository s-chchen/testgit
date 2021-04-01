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
		System.out.print("前置通知.......");		
		System.out.print("目标类是："+joinPoint.getTarget());		
		System.out.println(",被注入增强处理的目标方法是："+joinPoint.getSignature().getName());		
	}
	@AfterReturning("myPointCut()")
	public void myAfterReturing(JoinPoint joinPoint) {
		System.out.print("后置通知.......");		
		System.out.print("目标类是："+joinPoint.getTarget());		
		System.out.println(",被注入增强处理的目标方法是："+joinPoint.getSignature().getName());
	}
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕开启......检查权限......");		
		System.out.print("目标类是："+proceedingJoinPoint.getTarget());		
		System.out.println(",被注入增强处理的目标方法是："+proceedingJoinPoint.getSignature().getName());		
		Object obj=proceedingJoinPoint.proceed();		
		System.out.println("环绕结束......日志记录......");		
		return obj;
	}
	@AfterThrowing(value="myPointCut()",throwing = "e")
	public void myAftreThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常通知：出错了"+e.getMessage());			
	}
	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("最终通知：模拟方法结束后的释放资源...");					
	}
}
