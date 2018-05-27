package my.assignment.billing.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by bkothari on 26/05/18.
 */
public class OrderDto implements Serializable {

    private UserDto user;

    private List<ProductOrderDto> productOrders;
    private List<ProductDto> products;

    private Date orderDate;

    private BigDecimal grossAmountBeforeDiscount;
    private BigDecimal discountAmount;
    private BigDecimal netAmountAfterDiscount;

    private boolean discountApplied;
    private String errorMessage;

    public OrderDto() {
        //no code required here..
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProductOrderDto> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderDto> productOrders) {
        this.productOrders = productOrders;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getGrossAmountBeforeDiscount() {
        return grossAmountBeforeDiscount;
    }

    public void setGrossAmountBeforeDiscount(BigDecimal grossAmountBeforeDiscount) {
        this.grossAmountBeforeDiscount = grossAmountBeforeDiscount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getNetAmountAfterDiscount() {
        return netAmountAfterDiscount;
    }

    public void setNetAmountAfterDiscount(BigDecimal netAmountAfterDiscount) {
        this.netAmountAfterDiscount = netAmountAfterDiscount;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(boolean discountApplied) {
        this.discountApplied = discountApplied;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
