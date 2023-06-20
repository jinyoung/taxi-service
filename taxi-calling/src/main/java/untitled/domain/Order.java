package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.TaxiCallingApplication;
import untitled.domain.OrderCreated;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String customerLocation;

    private String destinationLocation;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = TaxiCallingApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void assignDriver(AssignDriverCommand assignDriverCommand) {
        //implement business logic here:

        DriverAssigned driverAssigned = new DriverAssigned(this);
        driverAssigned.publishAfterCommit();
    }

    public void completeOrder() {
        //implement business logic here:

        OrderCompleted orderCompleted = new OrderCompleted(this);
        orderCompleted.publishAfterCommit();
    }
}
