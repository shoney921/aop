package hello.aop.order;

import hello.aop.order.aop.*;
import hello.aop.order.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
@Import(AspectV6Advice_test.class)
@SpringBootTest
class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void appInfo() {
        //AopUtils로 AopProxy인지 확인할 수 있다.
        log.info("isAopProxy, orderService={}",
                AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}",
                AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success() {
        orderService.orderItem("lego");
    }

    @Test
    void success2() {
        orderService.orderItem2(new ItemDTO("lego",32));
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }

}