package com.study.security20240312yeonho.handler.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* com.study.security20240312yeonho.web.controller..*..*(..))")
	private void pointCut() {}
	
	@Pointcut("@annotation(com.study.security20240312yeonho.handler.aop.annotation.Timer)")
	private void enableTimer() {}
	
	@Around("pointCut() || enableTimer()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("hihi");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = joinPoint.proceed();
		
		stopWatch.stop();
		
		LOGGER.info("메소드 실행 시간: {}({}) = {} ({}ms)",
				joinPoint.getSignature().getDeclaringType(),
				joinPoint.getSignature().getName(),
				result,
				stopWatch.getTotalTimeSeconds()
				);
				
		return result;
		
	}
}













