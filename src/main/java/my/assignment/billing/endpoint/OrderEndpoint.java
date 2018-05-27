package my.assignment.billing.endpoint;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.exception.BillingException;
import my.assignment.billing.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by bkothari on 26/05/18.
 */
@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEndpoint.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getDiscount", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderDto getDiscountOnOrder(@RequestBody OrderDto order) {
        LOGGER.info("getDiscountOrder method started with order : " + order.toString());

        try {
            orderService.updateDiscountOnOrder(order);
        } catch (BillingException e) {
            LOGGER.error(e.getMessage(), e);
            order.setDiscountApplied(false);
            order.setOrderDate(new Date());
            return order;
        }

        return order;
    }
}
