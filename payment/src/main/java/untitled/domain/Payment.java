package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.PaymentApplication;
import untitled.domain.PaymentMade;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String orderId;

    private Double amount;

    @PostPersist
    public void onPostPersist() {
        PaymentMade paymentMade = new PaymentMade(this);
        paymentMade.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
