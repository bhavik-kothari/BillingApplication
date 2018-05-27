package my.assignment.billing.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bkothari on 26/05/18.
 */
public class ProductDto implements Serializable {

    private long id;
    private String name;
    private String category;

    private String shortDescription;
    private String longDescription;

    private String quantityMeasuredInType;
    private int quantityInStock;

    private BigDecimal sellingPrice;

    public ProductDto() {
        //nothing needed here...
    }

    public ProductDto(long id, String name, String category, String shortDescription, String longDescription, String quantityMeasuredInType, int quantityInStock, BigDecimal sellingPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.quantityMeasuredInType = quantityMeasuredInType;
        this.quantityInStock = quantityInStock;
        this.sellingPrice = sellingPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getQuantityMeasuredInType() {
        return quantityMeasuredInType;
    }

    public void setQuantityMeasuredInType(String quantityMeasuredInType) {
        this.quantityMeasuredInType = quantityMeasuredInType;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
