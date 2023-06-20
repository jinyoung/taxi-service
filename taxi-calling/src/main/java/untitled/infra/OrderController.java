package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "orders/{id}//orders/{orderId}/assign-driver",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order assignDriver(
        @PathVariable(value = "id") String id,
        @RequestBody AssignDriverCommand assignDriverCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/assignDriver  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.assignDriver(assignDriverCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "orders/{id}//orders/{orderId}/complete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order completeOrder(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/completeOrder  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.completeOrder();

        orderRepository.save(order);
        return order;
    }
}
