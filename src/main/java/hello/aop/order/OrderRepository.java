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

    // input 값으로 Dto 전달하는 method
    public String save(ItemDTO itemId) {
        log.info("[orderRepository] 실행"); //저장 로직
        if (itemId.getName().equals("ex")) {
            throw new IllegalStateException("예외 발생!"); }
        log.info("[orderRepository] 종료"); //저장 로직
        return "ok";
    }

    // Exception이 Repository에서 발생하고, Service에서 받아서 다시 throw 할 때, 2번 발생하는지 확인하기 위함
    public String edit(String itemId) {
        log.info("[edit] 실행");
        if (itemId.equals("ex")) {
            throw new IllegalStateException("레파지토리 익셉션");
        }
        log.info("[edit] 종료");
        return "ok";
    }
}
