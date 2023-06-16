package ua.khai.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.Product;
import ua.khai.entity.user.Personal;

import java.util.Optional;

@Repository
public interface CardRepository extends BaseRepository<Card>{

    Optional<Card> findTopByPersonalOrderByCreatedDesc(Personal personal);

    Optional<Card> findByPersonalAndVisibleTrue(Personal personal);

    @Query("UPDATE card c set c.quantity = ?1 where c.id = ?2 ")
    @Modifying
    void updateQuantityCard(Integer quantity, Long cardId );

    @Query("UPDATE card_product_addition c set c.quantity = ?1 where c.card.id = ?2 and c.product.id = ?3 and c.addition.id= ?4")
    @Modifying
    void updateQuantity(Integer quantity, Long cardId, Long productId, Long additionId);
   // Optional<Card> findByPersonalAndProductAndAddition(Personal personal, Product product, Addition addition);


}
