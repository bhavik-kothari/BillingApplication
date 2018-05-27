package my.assignment.billing.util;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.dto.ProductOrderDto;
import my.assignment.billing.data.dto.UserDto;
import my.assignment.billing.data.enums.CategoryEnum;
import my.assignment.billing.data.enums.QuantityMeasuredInType;
import my.assignment.billing.data.enums.UserType;
import my.assignment.billing.data.models.ProductEntity;
import my.assignment.billing.data.models.UserEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bkothari on 26/05/18.
 */
public final class PrepareDataHelper {

    public static OrderDto populateOrder(UserDto userDto, List<ProductOrderDto> productOrderDtos) {
        OrderDto orderDto = new OrderDto();
        orderDto.setUser(userDto);
        orderDto.setProductOrders(productOrderDtos);

        return orderDto;
    }

    public static UserDto populateUser_Active_Employee() {
        UserDto userDto = new UserDto();
        userDto.setUsername("bhavik");
        userDto.setUserType(UserType.EMPLOYEE.name());
        userDto.setActive(true);
        userDto.setDeleted(false);

        return userDto;
    }

    public static UserDto populateUser_Active_Affiliate() {
        UserDto userDto = new UserDto();
        userDto.setUsername("bhavik");
        userDto.setUserType(UserType.AFFILIATE.name());
        userDto.setActive(true);
        userDto.setDeleted(false);

        return userDto;
    }

    public static UserDto populateUser_Active_Customer_2YearsOld() {
        UserDto userDto = new UserDto();
        userDto.setUsername("bhavik");
        userDto.setUserType(UserType.CUSTOMER.name());
        userDto.setActive(true);
        userDto.setDeleted(false);

        Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        calendar.add(Calendar.MONTH, -1);
        Date twoYearsBackDate = calendar.getTime();

        userDto.setRegistrationDate(twoYearsBackDate);
        return userDto;
    }

    public static UserDto populateUser_Active_Customer_Not_2YearsOld() {
        UserDto userDto = new UserDto();
        userDto.setUsername("bhavik");
        userDto.setUserType(UserType.CUSTOMER.name());
        userDto.setActive(true);
        userDto.setDeleted(false);

        Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.MONTH, -11);
        Date twoYearsBackDate = calendar.getTime();

        userDto.setRegistrationDate(twoYearsBackDate);
        return userDto;
    }

    public static UserDto populateUser_InActive() {
        UserDto userDto = new UserDto();
        userDto.setUsername("bhavik");
        userDto.setUserType(UserType.EMPLOYEE.name());
        userDto.setActive(false);
        userDto.setDeleted(false);

        return userDto;
    }

    public static List<ProductOrderDto> populateProductOrderList_Success() {
        List<ProductOrderDto> productOrderDtos = new ArrayList<>();
        productOrderDtos.add(new ProductOrderDto(1L, 1));
        productOrderDtos.add(new ProductOrderDto(3L, 5));
        productOrderDtos.add(new ProductOrderDto(4L, 100));

        return productOrderDtos;
    }

    public static List<ProductOrderDto> populateProductOrderList() {
        List<ProductOrderDto> productOrderDtos = new ArrayList<>();
        productOrderDtos.add(new ProductOrderDto(1L, 1));

        return productOrderDtos;
    }

    public static List<ProductDto> populateProductsList_Success() {
        List<ProductDto> productDtos = new ArrayList<>();

        productDtos.add(populateProductDto(1L, "Refrigerator", CategoryEnum.ELECTRONICS.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.PIECES.name(), 10, new BigDecimal(20000)));

        productDtos.add(populateProductDto(3L, "Milk", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.LITRES.name(), 600, new BigDecimal(10)));

        productDtos.add(populateProductDto(4L, "Rice", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.KGS.name(), 10000, new BigDecimal(50)));

        return productDtos;
    }

    public static List<ProductDto> populateProductsList_All() {
        List<ProductDto> productDtos = new ArrayList<>();

        productDtos.add(populateProductDto(1L, "Refrigerator", CategoryEnum.ELECTRONICS.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.PIECES.name(), 10, new BigDecimal(20000)));

        productDtos.add(populateProductDto(2L, "Television", CategoryEnum.ELECTRONICS.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.PIECES.name(), 20, new BigDecimal(25000)));

        productDtos.add(populateProductDto(3L, "Milk", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.LITRES.name(), 600, new BigDecimal(10)));

        productDtos.add(populateProductDto(4L, "Rice", CategoryEnum.GROCERY.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.KGS.name(), 10000, new BigDecimal(50)));

        productDtos.add(populateProductDto(5L, "Lipstick", CategoryEnum.COSMETICS.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.PIECES.name(), 500, new BigDecimal(25)));

        productDtos.add(populateProductDto(6L, "Makeup Kit", CategoryEnum.COSMETICS.name(), "Short Desc", "Long Desc",
                QuantityMeasuredInType.PIECES.name(), 0, new BigDecimal(250)));

        return productDtos;
    }

    public static List<ProductDto> populateProductsList_NoStock() {
        List<ProductDto> productDtos = new ArrayList<>();


        return productDtos;
    }

    public static ProductDto populateProductDto(long id, String name, String category, String shortDesc, String longDesc,
                                                String quantityMeasuredIn, int quantity, BigDecimal sellingPrice ) {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setCategory(category);
        productDto.setName(name);
        productDto.setShortDescription(shortDesc);
        productDto.setLongDescription(longDesc);
        productDto.setQuantityMeasuredInType(quantityMeasuredIn);
        productDto.setQuantityInStock(quantity);
        productDto.setSellingPrice(sellingPrice);

        return productDto;
    }

    public static ProductEntity populateProductEntity(long id, String name, String category, String shortDesc, String longDesc,
                                                      String quantityMeasuredIn, int quantity, BigDecimal sellingPrice ) {
        ProductEntity product = new ProductEntity();
        product.setProductId(id);
        product.setCategory(category);
        product.setProductName(name);
        product.setShortDescription(shortDesc);
        product.setLongDescription(longDesc);
        product.setQuantityMeasuredInType(quantityMeasuredIn);
        product.setQuantityInStock(quantity);
        product.setSellingPrice(sellingPrice);

        return product;
    }

    public static UserEntity populateUserEntity() {
        UserEntity user = new UserEntity();
        user.setUsername("bhavik");
        user.setUserType(UserType.EMPLOYEE.name());
        user.setActive(true);
        user.setDeleted(false);

        return user;
    }
}
