package my.assignment.billing.service.impl;

import my.assignment.billing.dao.ProductDao;
import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.dto.ProductOrderDto;
import my.assignment.billing.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkothari on 26/05/18.
 */
@Component
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductDto> getProductsByOrder(List<ProductOrderDto> productOrders) {
        LOGGER.info("getProductsById method started");
        List<ProductDto> newProductDtos = new ArrayList<>();

        if(productOrders != null) {
            for(ProductOrderDto productOrder : productOrders) {
                ProductDto product = productDao.findByProductId(productOrder.getId()).toDto();
                if(product.getQuantityInStock() >= productOrder.getQuantityToOrder()) {
                    newProductDtos.add(product);
                }
            }
        }
        return newProductDtos;
    }

}
