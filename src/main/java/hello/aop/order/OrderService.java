package hello.aop.order;

import hello.aop.order.dto.ItemDTO;
import hello.aop.order.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public int orderItem(String itemId) {
        log.info("[orderService] 실행");
        orderRepository.save(itemId);
        log.info("[orderService] 종료");
        return 1;
    }

    public ResultDTO orderItem2(ItemDTO itemId) {
        log.info("[orderService] 실행");
        orderRepository.save(itemId);
        log.info("[orderService] 종료");
        return new ResultDTO("성공", 200);
    }

    public int editItem(String itemId) {
        log.info("[Service] 실행");
        try {
            orderRepository.edit(itemId);
        } catch (RuntimeException ex) {
            throw new RuntimeException("서비스에서 에러");
//            System.out.println("그냥넘어가기");
        }
        log.info("[Service] 종료");
        return 1;
    }
}
