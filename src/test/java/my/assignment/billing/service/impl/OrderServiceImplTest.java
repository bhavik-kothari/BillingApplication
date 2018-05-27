package my.assignment.billing.service.impl;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.exception.BillingException;
import my.assignment.billing.service.OrderService;
import my.assignment.billing.service.ProductService;
import my.assignment.billing.service.UserService;
import my.assignment.billing.util.PrepareDataHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by bkothari on 26/05/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    private OrderService orderService;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    private OrderDto orderDto;

    @Before
    public void init() {
        orderService = new OrderServiceImpl(userService, productService, "0.3", "0.1", "0.05");
    }

    @Test
    public void testUpdateDiscountOrder_Failure_UserNotActive() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_InActive(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_InActive());

        try {
            orderService.updateDiscountOnOrder(orderDto);
        } catch (BillingException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testUpdateDiscountOrder_Failure_InCompleteOrder() {
        orderDto = PrepareDataHelper.populateOrder(null,
                PrepareDataHelper.populateProductOrderList_Success());
        try {
            orderService.updateDiscountOnOrder(orderDto);
        } catch (BillingException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testUpdateDiscountOrder_Failure_ProductsNotFound() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Employee(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_Active_Employee());

        try {
            orderService.updateDiscountOnOrder(orderDto);
        } catch (BillingException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testUpdateDiscountOrder_Success_EmployeeDiscount() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Employee(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_Active_Employee());
        when(productService.getProductsByOrder(Mockito.anyList())).thenReturn(PrepareDataHelper.populateProductsList_Success());

        orderService.updateDiscountOnOrder(orderDto);

        Assert.assertNotNull(orderDto.getDiscountAmount());
        Assert.assertTrue("Discount Applied", orderDto.isDiscountApplied());
    }

    @Test
    public void testUpdateDiscountOrder_Success_AffiliateDiscount() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Affiliate(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_Active_Affiliate());
        when(productService.getProductsByOrder(Mockito.anyList())).thenReturn(PrepareDataHelper.populateProductsList_Success());

        orderService.updateDiscountOnOrder(orderDto);

        Assert.assertNotNull(orderDto.getDiscountAmount());
        Assert.assertTrue("Discount Applied", orderDto.isDiscountApplied());
    }

    @Test
    public void testUpdateDiscountOrder_Success_CustomerDiscount_2YearsOld() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Customer_2YearsOld(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_Active_Customer_2YearsOld());
        when(productService.getProductsByOrder(Mockito.anyList())).thenReturn(PrepareDataHelper.populateProductsList_Success());

        orderService.updateDiscountOnOrder(orderDto);

        Assert.assertNotNull(orderDto.getDiscountAmount());
        Assert.assertTrue("Discount Applied", orderDto.isDiscountApplied());
    }

    @Test
    public void testUpdateDiscountOrder_Success_CustomerDiscount_Not_2YearsOld() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Customer_Not_2YearsOld(),
                PrepareDataHelper.populateProductOrderList_Success());

        when(userService.getUserByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUser_Active_Customer_Not_2YearsOld());
        when(productService.getProductsByOrder(Mockito.anyList())).thenReturn(PrepareDataHelper.populateProductsList_Success());

        orderService.updateDiscountOnOrder(orderDto);

        Assert.assertNotNull(orderDto.getDiscountAmount());
        Assert.assertTrue("Discount Applied", orderDto.isDiscountApplied());
    }

}
