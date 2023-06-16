package ua.khai.service;

import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.user.Personal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CardService extends BaseCrudService<Card>{

    Optional<Card> findTopByPersonalOrderByCreatedDesc(Personal personal);


    boolean addProduct(Long productId, Addition additions, Personal personal );
    BigDecimal updateQuantity(Integer quantity, Long cardId, Long productId, Long additionId);
    void updateQuantityCard(Integer quantity, Long cardId);

}
