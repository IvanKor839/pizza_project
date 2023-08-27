package ua.khai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "product")
public class Product extends BaseEntity{

    @ManyToOne( fetch = FetchType.LAZY)
    private ProductType productType;

    private String name;

    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    private Integer weight;

    private String picture;

    private Integer size;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<CardProductAddition> cardProductAdditions;

    public Product() {
        super();
        this.cardProductAdditions = new HashSet<>();
        this.price = new BigDecimal("00.00");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productType, product.productType)
                && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(weight, product.weight) && Objects.equals(picture, product.picture) && Objects.equals(size, product.size) && Objects.equals(cardProductAdditions, product.cardProductAdditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, name, price, weight, picture, size, cardProductAdditions);
    }
}
