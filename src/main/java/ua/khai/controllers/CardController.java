package ua.khai.controllers;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.user.Personal;
import ua.khai.entity.user.User;
import ua.khai.repository.AdditionRepository;
import ua.khai.repository.UserRepository;
import ua.khai.service.CardService;
import ua.khai.service.PersonalCrudService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CardController {

    @Autowired
    final private CardService cardService;

    @Autowired
    final private PersonalCrudService personalCrudService;

    @Autowired
    final private AdditionRepository additionRepository;

    @Autowired
    final private UserRepository<User> userRepository;

    public CardController(CardService cardService, PersonalCrudService personalCrudService, AdditionRepository additionRepository, UserRepository<User> userRepository) {
        this.cardService = cardService;
        this.personalCrudService = personalCrudService;
        this.additionRepository = additionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/card")
    public String showCard(Model model, Principal userSpring) {
       try{
           User user = userRepository.findByEmail(userSpring.getName());
           Personal personal = personalCrudService.findById(user.getId()).get();
           Optional<Card> cards  = cardService.findTopByPersonalOrderByCreatedDesc(personal);
           model.addAttribute("cards", cards.get());
           return "pages/card";
       }catch (NumberFormatException e){
           throw new NumberFormatException("incorrect value id");
       }
    }

    @GetMapping("/personal/products/add/{productId}/{id}")
    public String addCard(@PathVariable @NotBlank(message = "id can not be empty") String id ,@PathVariable @NotBlank(message = "id can not be empty") String productId, Principal userSpring) {
        try{
            User user = userRepository.findByEmail(userSpring.getName());
            Personal personal = personalCrudService.findById(user.getId()).get();
            if(Objects.equals(id, "0")){
                cardService.addProduct(Long.parseLong(productId), null, personal);
            }else {
                Optional<Addition> addition = additionRepository.findById(Long.parseLong(id));
                cardService.addProduct(Long.parseLong(productId), addition.get(), personal);
            }

            return "redirect:/personal/products";
        }catch (NumberFormatException e){
            throw new NumberFormatException("incorrect value id");
        }
    }

    @PostMapping("/personal/products/update/{cardId}/{productId}/{additionId}/{quantity}/{quantityCard}")
    public float updateQuantity(@PathVariable @NotBlank(message = "id can not be empty") String cardId,
                                     @PathVariable @NotBlank(message = "id can not be empty") String productId,
                                     @PathVariable @NotBlank(message = "id can not be empty") String additionId,
                                     @PathVariable @NotBlank(message = "id can not be empty") String quantity,
                                     @PathVariable @NotBlank(message = "id can not be empty") String quantityCard,
                                     Model model,
                                     Principal userSpring) {
        try{
            User user = userRepository.findByEmail(userSpring.getName());
            Personal personal = personalCrudService.findById(user.getId()).get();
            Optional<Card> cards  = cardService.findTopByPersonalOrderByCreatedDesc(personal);
            model.addAttribute("cards", cards.get());
            cardService.updateQuantityCard(Integer.parseInt(quantityCard), Long.parseLong(cardId));
            if(Long.parseLong(additionId) == 0){
                return cardService.updateQuantity(Integer.parseInt(quantity), Long.parseLong(cardId), Long.parseLong(productId), null).floatValue();
            }else {
               return cardService.updateQuantity(Integer.parseInt(quantity), Long.parseLong(cardId), Long.parseLong(productId), Long.parseLong(additionId)).floatValue();

            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("incorrect value id");
        }
    }

}
