package my.assignment.billing.service;

import my.assignment.billing.data.dto.OrderDto;

/**
 * Created by bkothari on 26/05/18.
 */
public interface OrderService {

    void updateDiscountOnOrder(OrderDto orderDto);

}
