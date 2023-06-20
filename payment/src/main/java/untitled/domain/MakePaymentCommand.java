package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class MakePaymentCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String orderId;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Double amount;
}
