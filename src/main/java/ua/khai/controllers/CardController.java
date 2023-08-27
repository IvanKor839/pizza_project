package ua.khai.controllers;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.khai.dto.request.OrderRequestDto;
import ua.khai.dto.response.OrderResponseDto;
import ua.khai.dto.response.PageData;
import ua.khai.entity.Addition;
import ua.khai.entity.Card;
import ua.khai.entity.user.Admin;
import ua.khai.entity.user.Personal;
import ua.khai.entity.user.User;
import ua.khai.facade.OrderFacade;
import ua.khai.repository.*;
import ua.khai.service.CardService;
import ua.khai.service.PersonalCrudService;

import java.io.IOException;
import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CardController extends AbstractController {

    @Autowired
    final private CardService cardService;

    @Autowired
    final private PersonalCrudService personalCrudService;
    @Autowired
    final private AdditionRepository additionRepository;
    @Autowired
    final private UserRepository<User> userRepository;
    @Autowired
    final private PersonalRepository personalRepository;
    @Autowired
    final private AdminRepository adminRepository;
    @Autowired
    final private OrderFacade orderFacade;

    public CardController(CardService cardService, PersonalCrudService personalCrudService, AdditionRepository additionRepository, UserRepository<User> userRepository, PersonalRepository personalRepository, AdminRepository adminRepository, OrderFacade orderFacade) {
        this.cardService = cardService;
        this.personalCrudService = personalCrudService;
        this.additionRepository = additionRepository;
        this.userRepository = userRepository;
        this.personalRepository = personalRepository;
        this.adminRepository = adminRepository;
        this.orderFacade = orderFacade;
    }
    private final HeaderName[] columnNames = new HeaderName[] {
            new HeaderName("#", null, null),
            new HeaderName("date", "date", "created"),
            new HeaderName("status", "status", "active"),
            new HeaderName("adress", "adress", "adress"),
            new HeaderName("payment", "payment", "isPaied"),
            new HeaderName("card", "card", "card"),
    };

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
    @GetMapping("/order/{card}")
    public String redirectToNewOrderPage(Model model, @PathVariable Card card, Principal userSpring) {
        Personal user = personalRepository.findByEmail(userSpring.getName());
        Admin admin = adminRepository.findFirstByOrderByCreated();
        model.addAttribute("order", new OrderRequestDto());
        model.addAttribute("card", card);
        model.addAttribute("user", user);
        model.addAttribute("admin", admin);
        return "pages/personal/product/order_new";
    }

    @PostMapping("/create")
    public String createNewOrder(RedirectAttributes attributes, @ModelAttribute("order") OrderRequestDto dto) {
        orderFacade.create(dto);
        dto.getCard().setVisible(false);
        cardService.update(dto.getCard());
        return "redirect:/admin/orders";
    }

    @GetMapping("/order/all")
    public String findAllForPersonal(Model model, WebRequest webRequest) throws IOException {
        PageData<OrderResponseDto> response = orderFacade.findAll(webRequest);
        initDataTable(response, columnNames, model);
        model.addAttribute("createUrl", "/all");
        model.addAttribute("createNew", "/{card}");
        model.addAttribute("cardHeader", "All Order");
        return "pages/admin/product/order_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "admin/orders");
    }

}
