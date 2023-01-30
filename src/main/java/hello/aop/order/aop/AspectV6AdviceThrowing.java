package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV6AdviceThrowing {

    @AfterThrowing(value = "execution(* hello.aop.order..*Service.*(..))", throwing = "ex")
    public void doThrowingSerivce(JoinPoint joinPoint, Exception ex) {
        log.info("[doThrowingSerivce] {} message={}", joinPoint.getSignature(),
                ex.getMessage());
    }
//    @AfterThrowing(value = "execution(* hello.aop.order..*Repository.*(..))", throwing = "ex")
//    public void doThrowingRepository(JoinPoint joinPoint, Exception ex) {
//        log.info("[doThrowingRepository] {} message={}", joinPoint.getSignature(),
//                ex.getMessage());
//    }
}
