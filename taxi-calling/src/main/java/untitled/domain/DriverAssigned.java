package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DriverAssigned extends AbstractEvent {

    private String driverId;

    public DriverAssigned(Order aggregate) {
        super(aggregate);
    }

    public DriverAssigned() {
        super();
    }
}
