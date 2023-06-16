package ua.khai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "card_product_addition")
public class CardProductAddition extends BaseEntity {

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "addition_id")
    private Addition addition;

    private Integer quantity;

    public CardProductAddition() {
        super();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Addition getAddition() {
        return addition;
    }

    public void setAddition(Addition addition) {
        this.addition = addition;
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
        if(this.addition ==null){
            return result.add(this.product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
        return result.add(this.product.getPrice().multiply(BigDecimal.valueOf(quantity)))
                .add(this.addition.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardProductAddition that = (CardProductAddition) o;
        return Objects.equals(card, that.card) && Objects.equals(product, that.product) && Objects.equals(addition, that.addition) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), card, product, addition, quantity);
    }
}
