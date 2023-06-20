package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class PaymentMade extends AbstractEvent {

    private String id;
    private String orderId;
    private Double amount;

    public PaymentMade(Payment aggregate) {
        super(aggregate);
    }

    public PaymentMade() {
        super();
    }
}
