package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class DeanAdvice {
    @Around("execution(* hello.aop.order.DeanService.externalMethod(..))")
    public void aopExternal(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP 외부 메서드 실행");
        joinPoint.proceed();
        log.info("AOP 외부 메서드 종료");
    }

    @Around("execution(* hello.aop.order.DeanService.internalMethod(..))")
    public void aopInternal(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP 내부 메서드 실행");
        joinPoint.proceed();
        log.info("AOP 내부 메서드 종료");
    }
}
