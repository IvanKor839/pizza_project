package ua.khai.dto.response;

import org.apache.commons.collections4.CollectionUtils;
import ua.khai.entity.*;
import ua.khai.entity.user.Admin;
import ua.khai.entity.user.Personal;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

public class OrderResponseDto extends ResponseDto {

    private Personal personal;
    private Admin admin;
    private String adress;
    private Boolean isPaied;
    private Card card;
    private String active;


    public OrderResponseDto() { }

    public OrderResponseDto(Order order) {
        setId(order.getId());
        setCreated(order.getCreated());
        setUpdated(order.getUpdated());
        setVisible(order.getVisible());
        this.personal = order.getPersonal();
        this.admin = order.getAdmin();
        this.adress = order.getAdress();
        this.active = order.getActive();
        this.isPaied = order.getPaied();
        this.card = order.getCard();
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
}
