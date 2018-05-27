package my.assignment.billing.data.dto;

import java.io.Serializable;

/**
 * Created by bkothari on 26/05/18.
 */
public class ProductOrderDto implements Serializable {

    private long id;
    private int quantityToOrder;

    public ProductOrderDto() {}

    public ProductOrderDto(long id, int quantityToOrder) {
        this.id = id;
        this.quantityToOrder = quantityToOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantityToOrder() {
        return quantityToOrder;
    }

    public void setQuantityToOrder(int quantityToOrder) {
        this.quantityToOrder = quantityToOrder;
    }
}
