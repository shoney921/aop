package hello.aop.order;

import hello.aop.order.aop.AspectV6AdviceThrowing;
import hello.aop.order.aop.DeanAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(DeanAdvice.class)
@SpringBootTest
class DeanServiceTest {

    @Autowired
    DeanService deanService;

    @Test
    void test() {
        deanService.externalMethod("TEST");
    }

}