package ua.khai.dto.request;

import ua.khai.entity.ProductType;

import java.math.BigDecimal;

public class ProductRequestDto extends RequestDto {

    private String productName;
    private String picture;
    private BigDecimal price;
    private Integer size;
    private Integer weight;
    private ProductType productType;

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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "productName='" + productName + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", weight=" + weight +
                ", productType=" + productType +
                '}';
    }
}
