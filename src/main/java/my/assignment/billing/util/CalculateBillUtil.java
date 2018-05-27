package my.assignment.billing.util;

import my.assignment.billing.data.dto.OrderDto;
import my.assignment.billing.data.dto.ProductDto;
import my.assignment.billing.data.enums.CategoryEnum;

import java.math.BigDecimal;

/**
 * Created by bkothari on 26/05/18.
 */

public final class CalculateBillUtil {

    private CalculateBillUtil() {
        //nothing used here
    }

    public static void applyPercentDiscount(OrderDto orderDto, String percentDiscountStr) {

        BigDecimal grossAmount = BigDecimal.ZERO;
        BigDecimal discountAmount = BigDecimal.ZERO;
        BigDecimal percentDiscount = new BigDecimal(percentDiscountStr);

        boolean isDiscountApplied = false;

        if(orderDto.getProducts() != null) {
            for(ProductDto productDto : orderDto.getProducts()) {
                if(productDto.getSellingPrice() != null) {
                    grossAmount = grossAmount.add(productDto.getSellingPrice());

                    if(percentDiscount.doubleValue() > 0L && !CategoryEnum.GROCERY.name().equalsIgnoreCase(productDto.getCategory())) {
                        discountAmount = productDto.getSellingPrice().multiply(percentDiscount);
                        isDiscountApplied = true;
                    }
                }
            }
        }
        orderDto.setGrossAmountBeforeDiscount(grossAmount);
        orderDto.setDiscountAmount(discountAmount);
        orderDto.setDiscountApplied(isDiscountApplied);
        orderDto.setNetAmountAfterDiscount(grossAmount.subtract(discountAmount));
    }

    public static void applyOtherDiscount(OrderDto orderDto) {
        if(orderDto.getNetAmountAfterDiscount().longValue() > 100L) {
            BigDecimal tempCount = orderDto.getNetAmountAfterDiscount().divide(new BigDecimal(100));
            tempCount = tempCount.setScale(0, BigDecimal.ROUND_HALF_UP);
            BigDecimal otherDiscount = tempCount.multiply(new BigDecimal(5));

            orderDto.setDiscountAmount(orderDto.getDiscountAmount().add(otherDiscount));
            orderDto.setDiscountApplied(true);
            orderDto.setNetAmountAfterDiscount(orderDto.getNetAmountAfterDiscount().subtract(otherDiscount));
        }
    }
}
