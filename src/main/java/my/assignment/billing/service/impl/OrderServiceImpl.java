package my.assignment.billing.service.impl;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.dto.UserDto;
import my.assignment.billing.data.enums.UserType;
import my.assignment.billing.exception.BillingException;
import my.assignment.billing.service.OrderService;
import my.assignment.billing.service.ProductService;
import my.assignment.billing.service.UserService;
import my.assignment.billing.util.CalculateBillUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bkothari on 26/05/18.
 */
@Component
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Value("${employee.discount}")
    private String employeeDiscount;

    @Value("${affiliate.discount}")
    private String affiliateDiscount;

    @Value("${customer.discount}")
    private String customerDiscount;

    public OrderServiceImpl() {}

    public OrderServiceImpl(UserService userService, ProductService productService, String employeeDiscount, String affiliateDiscount, String customerDiscount) {
        this.userService = userService;
        this.productService = productService;

        this.employeeDiscount = employeeDiscount;
        this.affiliateDiscount = affiliateDiscount;
        this.customerDiscount = customerDiscount;
    }

    @Override
    public void updateDiscountOnOrder(OrderDto orderDto) {
        LOGGER.info("updateDiscountOnOrder method started");

        if(orderDto == null || orderDto.getUser() == null || orderDto.getProductOrders() == null || CollectionUtils.isEmpty(orderDto.getProductOrders())) {
            throw new BillingException("Order details are incomplete");
        }

        UserDto user = userService.getUserByUsername(orderDto.getUser().getUsername());
        if(user == null || !user.isActive() || user.isDeleted()) {
            throw new BillingException("Username is invalid or not authorised ");
        }

        List<ProductDto> productDtos = productService.getProductsByOrder(orderDto.getProductOrders());
        if(productDtos == null || CollectionUtils.isEmpty(productDtos)) {
            throw new BillingException("No products found");
        }

        orderDto.setUser(user);
        orderDto.setProducts(productDtos);
        orderDto.setOrderDate(new Date());

        updateOrderWithDiscount(orderDto);
        LOGGER.info("updateDiscountOnOrder method complete");
    }

    private void updateOrderWithDiscount(OrderDto orderDto) {

        Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        Date twoYearsBackDate = calendar.getTime();

        if(UserType.EMPLOYEE.name().equalsIgnoreCase(orderDto.getUser().getUserType())) {
            CalculateBillUtil.applyPercentDiscount(orderDto, employeeDiscount);
        } else if (UserType.AFFILIATE.name().equalsIgnoreCase(orderDto.getUser().getUserType())) {
            CalculateBillUtil.applyPercentDiscount(orderDto, affiliateDiscount);
        } else if(UserType.CUSTOMER.name().equalsIgnoreCase(orderDto.getUser().getUserType()) &&
                twoYearsBackDate.after(orderDto.getUser().getRegistrationDate())) {
            CalculateBillUtil.applyPercentDiscount(orderDto, customerDiscount);
        } else {
            CalculateBillUtil.applyPercentDiscount(orderDto, "0");
        }

        CalculateBillUtil.applyOtherDiscount(orderDto);
    }


}
