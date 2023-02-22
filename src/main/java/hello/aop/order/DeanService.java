package hello.aop.order;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeanService {

    public void externalMethod(String input) {
        log.info("외부 메서드 시작");
        internalMethod(input);
        log.info("외부 메서드 완료");
    }

    public void internalMethod(String input) {
        log.info("내부 메서드 시작");
        log.info("내부 메서드 완료");
    }

}
