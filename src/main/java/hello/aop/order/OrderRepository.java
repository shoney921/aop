package hello.aop.order;

import hello.aop.order.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepository {

    public String save(String itemId) {
        log.info("[orderRepository] 실행"); //저장 로직
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!"); }
        log.info("[orderRepository] 종료"); //저장 로직
        return "ok";
    }

    public String save(ItemDTO itemId) {
        log.info("[orderRepository] 실행"); //저장 로직
        if (itemId.getName().equals("ex")) {
            throw new IllegalStateException("예외 발생!"); }
        log.info("[orderRepository] 종료"); //저장 로직
        return "ok";
    }
}
