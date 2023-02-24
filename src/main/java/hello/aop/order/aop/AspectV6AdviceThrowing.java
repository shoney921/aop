package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV6AdviceThrowing {

    @AfterThrowing(value = "execution(* hello.aop.order..*Service.*(..))", throwing = "ex")
    public void doThrowingSerivce(JoinPoint joinPoint, Exception ex) {
        log.info("[doThrowingSerivce] {} message={}", joinPoint.getSignature(),
                ex.getMessage());
    }
    @AfterThrowing(value = "execution(* hello.aop.order..*Repository.*(..))", throwing = "ex")
    public void doThrowingRepository(JoinPoint joinPoint, Exception ex) {
        log.info("[doThrowingRepository] {} message={}", joinPoint.getSignature(),
                ex.getMessage());
    }

//    @Around(value = "execution(* hello.aop.order..*Repository.*(..))")
//    public void doAround(ProceedingJoinPoint joinPoint) {
//        try {
//            joinPoint.proceed();
//        } catch (Exception ex) {
//            log.info("[Exception] {} message={}", joinPoint.getSignature(),
//                    ex.getMessage());
//        } catch (Throwable ex) {
//            log.info("[Throwable] {} message={}", joinPoint.getSignature(),
//                    ex.getMessage());
//        }
//    }
}
