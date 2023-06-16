package ua.khai.entity;

import jakarta.persistence.*;
import ua.khai.entity.user.Admin;
import ua.khai.entity.user.Personal;

import java.util.Objects;
import java.util.Set;

@Entity(name = "ordered")
public class Order extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Personal personal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admin admin;

    private String adress;

    private Boolean isPaied;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    public Order() {
        super();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getPaied() {
        return isPaied;
    }

    public void setPaied(Boolean paied) {
        isPaied = paied;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    private String active;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(personal, order.personal) && Objects.equals(admin, order.admin) && Objects.equals(adress, order.adress) && Objects.equals(isPaied, order.isPaied) && Objects.equals(card, order.card) && Objects.equals(active, order.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personal, admin, adress, isPaied, card, active);
    }*/
}
