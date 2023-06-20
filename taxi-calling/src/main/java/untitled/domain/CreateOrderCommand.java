package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CreateOrderCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String customerLocation;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String destinationLocation;
}
