package ua.khai.repository;

import org.springframework.stereotype.Repository;
import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.CardProductAddition;
import ua.khai.entity.Product;
import ua.khai.entity.user.Personal;

import java.util.Optional;

@Repository
public interface CardProductAdditionRepository extends BaseRepository<CardProductAddition>{

    Optional<CardProductAddition> findByCardAndProductAndAddition(Card card, Product product, Addition addition);


}
