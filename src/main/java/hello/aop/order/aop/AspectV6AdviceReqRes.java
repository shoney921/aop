package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6AdviceReqRes {

    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService() && args(req,..)", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result, Object req) {
        System.out.println("[request1] req = " + req);
        System.out.println("[request2] joinPoint.getArgs = " + joinPoint.getArgs()[0]);
        System.out.println("[response1] " + result);
        log.info("[return] {} return={}", joinPoint.getSignature(), result);
    }
}
