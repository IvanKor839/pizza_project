package ua.khai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity(name = "addition")
public class Addition extends BaseEntity{

    private String name;

    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    private String picture;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "addition")
    private Set<CardProductAddition> cardProductAdditions;

    public Addition(){
        super();
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addition addition = (Addition) o;
        return Objects.equals(name, addition.name) && Objects.equals(price, addition.price) && Objects.equals(picture, addition.picture) && Objects.equals(cardProductAdditions, addition.cardProductAdditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, picture, cardProductAdditions);
    }
}
