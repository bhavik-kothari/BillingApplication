package my.assignment.billing.service;

import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.dto.ProductOrderDto;

import java.util.List;

/**
 * Created by bkothari on 26/05/18.
 */
public interface ProductService {

    List<ProductDto> getProductsByOrder(List<ProductOrderDto> productOrders);

}
