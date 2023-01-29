package hello.aop.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDTO {
    String responseMsg;
    int resultCode;
}
