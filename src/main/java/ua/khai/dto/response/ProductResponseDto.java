package ua.khai.dto.response;

import org.apache.commons.collections4.CollectionUtils;
import ua.khai.entity.CardProductAddition;
import ua.khai.entity.Product;
import ua.khai.entity.ProductType;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

public class ProductResponseDto extends ResponseDto {

    private String productName;
    private String picture;
    private BigDecimal price;
    private Integer size;
    private Integer weight;
    private Set<CardProductAddition> cardProductAdditions = Collections.emptySet();
    private ProductType productType;

    public ProductResponseDto() { }

    public ProductResponseDto(Product product) {
        setId(product.getId());
        setCreated(product.getCreated());
        setUpdated(product.getUpdated());
        setVisible(product.getVisible());
        this.productName = product.getName();
        this.picture = product.getPicture();
        this.price = product.getPrice();
        this.size = product.getSize();
        this.weight = product.getWeight();
        if (product.getProductType() != null) {
            this.productType = product.getProductType();
        }
        if (CollectionUtils.isNotEmpty(product.getOrderProductAdditions())) {
            this.cardProductAdditions = product.getOrderProductAdditions();
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<CardProductAddition> getOrderProductAdditions() {
        return cardProductAdditions;
    }

    public void setOrderProductAdditions(Set<CardProductAddition> cardProductAdditions) {
        this.cardProductAdditions = cardProductAdditions;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
