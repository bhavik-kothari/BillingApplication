package my.assignment.billing.endpoint;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.exception.BillingException;
import my.assignment.billing.service.OrderService;
import my.assignment.billing.util.PrepareDataHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by bkothari on 26/05/18.
 */
@RunWith(MockitoJUnitRunner.class)
public final class OrderEndpointTest {

    @InjectMocks
    private OrderEndpoint orderEndpoint;

    private OrderDto orderDto;

    @Mock
    OrderService orderService;

    @Before
    public void init() {
        orderDto = PrepareDataHelper.populateOrder(PrepareDataHelper.populateUser_Active_Employee(),
                PrepareDataHelper.populateProductOrderList_Success());
    }

    @Test
    public void testGetDiscountOnOrder_Success() {
        Mockito.doNothing().when(orderService).updateDiscountOnOrder(Mockito.any(OrderDto.class));

        OrderDto result = null;
        try {
            result = orderEndpoint.getDiscountOnOrder(orderDto);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetDiscountOnOrder_Failure() {
        Mockito.doThrow(new BillingException("Billing exception thrown!")).doNothing().when(orderService).updateDiscountOnOrder(Mockito.any(OrderDto.class));

        OrderDto result = null;
        try {
            result = orderEndpoint.getDiscountOnOrder(orderDto);
        } catch (Exception e) {
            Assert.assertNotNull(e);
        }
        Assert.assertNotNull(result);
    }

}
