package ua.khai.entity;

import jakarta.persistence.*;
import ua.khai.entity.user.Personal;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "card")
public class Card extends BaseEntity{

    @ManyToOne( fetch = FetchType.LAZY)
    private Personal personal;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "card")
    private Order order;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "card")
    private Set<CardProductAddition> cardProductAdditions;

    private Integer quantity;

    public Card() {
        super();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<CardProductAddition> getCardProductAdditions() {
        return cardProductAdditions;
    }

    public void setCardProductAdditions(Set<CardProductAddition> cardProductAdditions) {
        this.cardProductAdditions = cardProductAdditions;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public BigDecimal getTotal(){
        BigDecimal result = new BigDecimal("0");
        for (CardProductAddition card: cardProductAdditions ) {
            result = result.add(card.getTotal());
        }
        return result;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Card card = (Card) o;
        return Objects.equals(personal, card.personal) && Objects.equals(order, card.order) && Objects.equals(cardProductAdditions, card.cardProductAdditions) && Objects.equals(quantity, card.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personal, order, cardProductAdditions, quantity);
    }*/
}
