// ������ ���� ����

package com.mirim.aoptest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "�� ���۵Ǿ����ϴ�.");
		
		long st = System.currentTimeMillis();    // ����ð� ��������
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "�� ����Ǿ����ϴ�.");
			System.out.println(signatureStr + "����ð� : " + (et-st));
		}
	}

	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice ����!");
	}
	
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("afterAdvice ����!");
	}
	
	public void afterReturnAdvice(JoinPoint joinpoint) {
		System.out.println("afterReturnAdvice ����!");
	}
	
	public void afterThrowingAdvice(JoinPoint joinpoint) {
		System.out.println("afterThrowingAdvice ����!");
	}
}
