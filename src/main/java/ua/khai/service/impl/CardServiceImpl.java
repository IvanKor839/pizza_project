package ua.khai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.CardProductAddition;
import ua.khai.entity.Product;
import ua.khai.entity.user.Personal;
import ua.khai.repository.CardProductAdditionRepository;
import ua.khai.repository.CardRepository;
import ua.khai.service.AdditionService;
import ua.khai.service.CardService;
import ua.khai.service.ProductService;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardProductAdditionRepository cardProductAdditionRepository;
    private final ProductService productService;
    private final AdditionService additionService;
    private final CrudRepositoryHelper<Card, CardRepository> crudRepositoryHelper;

    public CardServiceImpl(CardRepository cardRepository, CardProductAdditionRepository cardProductAdditionRepository, ProductService productService, AdditionService additionService, CrudRepositoryHelper<Card, CardRepository> crudRepositoryHelper) {
        this.cardRepository = cardRepository;
        this.cardProductAdditionRepository = cardProductAdditionRepository;
        this.productService = productService;
        this.additionService = additionService;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }


    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Card entity) {
        crudRepositoryHelper.create(cardRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Card entity) {
        crudRepositoryHelper.update(cardRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(cardRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Card> findById(Long id) {
        return crudRepositoryHelper.findById(cardRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Card> findTopByPersonalOrderByCreatedDesc(Personal personal) {
        return cardRepository.findTopByPersonalOrderByCreatedDesc(personal);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean addProduct(Long productId, Addition addition, Personal personal) {
        boolean isExist = false;
        Product product = productService.findById(productId).get();
        Optional<Card> cards = cardRepository.findByPersonalAndVisibleTrue(personal);
        if (cards.isPresent()) {
            Set<CardProductAddition> set = cards.get().getCardProductAdditions();
            for (CardProductAddition cardProductAddition : set) {
               Optional<Addition> additionOptional = Optional.ofNullable(cardProductAddition.getAddition());
                Addition addition1 = additionOptional.orElse(null);
                if (cardProductAddition.getProduct()
                        .equals(product) &&  ((addition1==null && addition==null) || Objects.equals(addition1, addition))) {
                    isExist = true;
                    cardProductAddition.setQuantity(cardProductAddition.getQuantity() + 1);
                }
            }
            if(!isExist){
                CardProductAddition cardProductAddition = new CardProductAddition();
                cardProductAddition.setProduct(product);
                cardProductAddition.setAddition(addition);
                cardProductAddition.setCard(cards.get());
                cardProductAddition.setQuantity(1);
                set.add(cardProductAddition);
                cards.get().setCardProductAdditions(set);
                cardProductAdditionRepository.save(cardProductAddition);
            }


        } else {
            cards = Optional.of(new Card());
            cards.get().setPersonal(personal);
            cards.get().setQuantity(0);
            Set<CardProductAddition> set = new HashSet<>();
            CardProductAddition cardProductAddition = new CardProductAddition();
            cardProductAddition.setProduct(product);
            cardProductAddition.setAddition(addition);
            cardProductAddition.setCard(cards.get());
            cardProductAddition.setQuantity(1);
            set.add(cardProductAddition);
            cards.get().setCardProductAdditions(set);
            cardProductAdditionRepository.save(cardProductAddition);

        }
        cards.get().setQuantity(cards.get().getQuantity()+1);
        cardRepository.save(cards.get());
        return true;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public BigDecimal updateQuantity(Integer quantity, Long cardId, Long productId, Long additionId) {
        cardRepository.updateQuantity(quantity, cardId, productId, additionId);
        BigDecimal result = new BigDecimal("0");
        Product product = productService.findById(productId).get();
        if(additionId !=null){
            Addition addition = additionService.findById(additionId).get();
           return  result.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)))
                   .add(addition.getPrice().multiply(BigDecimal.valueOf(quantity)));
        } else {
            return  result.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void updateQuantityCard(Integer quantity, Long cardId) {
        cardRepository.updateQuantityCard(quantity, cardId);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Card> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(cardRepository, request);
    }
}
