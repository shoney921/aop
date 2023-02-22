package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class DeanAdvice {

    @Pointcut("execution(* hello.aop.order.DeanService.externalMethod(..))")
    private void pointCut() {
    }

    @Around("pointCut()")
    public void aopExternal(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP 실행");
        joinPoint.proceed();
        log.info("AOP 종료");
    }
}
