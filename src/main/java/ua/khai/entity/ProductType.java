package ua.khai.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity(name="type_product")
public class ProductType extends BaseEntity {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductType that)) return false;
        return (this.getType().equals(((ProductType) o).getType()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}

