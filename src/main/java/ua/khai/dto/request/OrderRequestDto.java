package ua.khai.dto.request;

import ua.khai.entity.Card;
import ua.khai.entity.ProductType;
import ua.khai.entity.user.Admin;
import ua.khai.entity.user.Personal;

import java.math.BigDecimal;

public class OrderRequestDto extends RequestDto {

    private Personal personal;
    private Admin admin;
    private String adress;
    private Boolean isPaied;
    private Card card;
    private String active;



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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "personal=" + personal +
                ", admin=" + admin +
                ", adress='" + adress + '\'' +
                ", isPaied=" + isPaied +
                ", card=" + card +
                ", active='" + active + '\'' +
                '}';
    }
}
