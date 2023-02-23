package hello.aop.order;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeanService {
    @Lazy
    @Autowired
    DeanService deanService;

    public void externalMethod(String input) {
        log.info("외부 메서드 시작");
        deanService.internalMethod(input);
        log.info("외부 메서드 완료");
    }

    public void internalMethod(String input) {
        log.info("내부 메서드 시작");
        log.info(input);
        log.info("내부 메서드 완료");
    }
}
