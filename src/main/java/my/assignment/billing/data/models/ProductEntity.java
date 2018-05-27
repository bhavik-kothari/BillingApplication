package my.assignment.billing.data.models;

import my.assignment.billing.data.ToDto;
import my.assignment.billing.data.dto.ProductDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bkothari on 24/05/18.
 */
@Entity
@Table(name = "product")
public class ProductEntity implements ToDto<ProductDto>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long productId;

    @Column(name = "name", unique = true, nullable = false)
    private String productName;

    @Column(name = "category")
    private String category;

    @Column(name = "short_description", length = 100)
    private String shortDescription;

    @Column(name = "long_description", length = 250)
    private String longDescription;

    @Column(name = "quantity_measured_in_type", nullable = false)
    private String quantityMeasuredInType;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock;

    @Column(name = "selling_price", nullable = false)
    private BigDecimal sellingPrice;

    public ProductEntity() {
        //nothing needed here
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    @Override
    public ProductDto toDto() {
        return new ProductDto(productId, productName, category, shortDescription, longDescription, quantityMeasuredInType, quantityInStock,
                sellingPrice);
    }
}
