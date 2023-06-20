package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderCompleted extends AbstractEvent {

    private String orderId;

    public OrderCompleted(Order aggregate) {
        super(aggregate);
    }

    public OrderCompleted() {
        super();
    }
}
