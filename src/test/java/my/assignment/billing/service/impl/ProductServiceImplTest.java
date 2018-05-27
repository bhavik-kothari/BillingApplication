package my.assignment.billing.service.impl;

import my.assignment.billing.dao.ProductDao;
import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.enums.CategoryEnum;
import my.assignment.billing.data.enums.QuantityMeasuredInType;
import my.assignment.billing.util.PrepareDataHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by bkothari on 26/05/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductDao productDao;

    @Test
    public void testGetProductsByOrder_Success() {

        when(productDao.findByProductId(Mockito.anyLong())).thenReturn(PrepareDataHelper.populateProductEntity(1L, "Milk", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                        QuantityMeasuredInType.LITRES.name(), 1, new BigDecimal(25)));

        List<ProductDto> productDtos = productService.getProductsByOrder(PrepareDataHelper.populateProductOrderList());
        Assert.assertNotNull(productDtos);
        Assert.assertTrue(productDtos.size() > 0);
    }

    @Test
    public void testGetProductsByOrder_NotInStock() {

        when(productDao.findByProductId(Mockito.anyLong())).thenReturn(PrepareDataHelper.populateProductEntity(1L, "Milk", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.LITRES.name(), 0, new BigDecimal(25)));

        List<ProductDto> productDtos = productService.getProductsByOrder(PrepareDataHelper.populateProductOrderList());
        Assert.assertNotNull(productDtos);
        Assert.assertTrue(productDtos.size() == 0);
    }

}
