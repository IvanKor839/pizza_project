package ua.khai.controllers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.khai.dto.request.OrderRequestDto;
import ua.khai.dto.request.ProductRequestDto;
import ua.khai.dto.response.OrderResponseDto;
import ua.khai.dto.response.PageData;
import ua.khai.entity.Card;
import ua.khai.facade.OrderFacade;
import ua.khai.service.CardService;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("admin/orders")
public class AdminOrderController extends AbstractController{

    private final HeaderName[] columnNames = new HeaderName[] {
            new HeaderName("#", null, null),
            new HeaderName("date", "date", "created"),
            new HeaderName("status", "status", "active"),
            new HeaderName("adress", "adress", "adress"),
            new HeaderName("payment", "payment", "isPaied"),
            new HeaderName("card", "card", "card"),
    };
  /* private final HeaderName[] columnNames = new HeaderName[] {
           new HeaderName("#", null, null),
           new HeaderName("created", "created", "created"),
           new HeaderName("active", "active", "active"),
           new HeaderName("adress", "adress", "adress"),
           new HeaderName("isPaied", "isPaied", "isPaied"),
           new HeaderName("card", "card", "card"),
   };*/

    private final OrderFacade orderFacade;
    private final CardService cardService;

    public AdminOrderController(OrderFacade orderFacade, CardService cardService) {
        this.orderFacade = orderFacade;
        this.cardService = cardService;
    }

    @GetMapping
    public String findAll(Model model, WebRequest webRequest) throws IOException {
        PageData<OrderResponseDto> response = orderFacade.findAll(webRequest);
       initDataTable(response, columnNames, model);
        model.addAttribute("createUrl", "/admin/orders/all");
        model.addAttribute("createNew", "/admin/orders/{card}");
        model.addAttribute("cardHeader", "All Order");
        return "pages/admin/product/order_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "admin/orders");
    }

    @GetMapping("/{card}")
    public String redirectToNewOrderPage(Model model, @PathVariable Card card) {
        model.addAttribute("order", new OrderRequestDto());
        model.addAttribute("card", card);
        return "pages/admin/product/order_new";
    }

    @PostMapping("/create")
    public String createNewOrder(RedirectAttributes attributes, @ModelAttribute("order") OrderRequestDto dto, @RequestParam("file") MultipartFile file) {
        orderFacade.create(dto);
        return "redirect:/admin/orders";
    }

    @GetMapping("/delete{id}")
    public String delete(@PathVariable @Min(value = 1, message = "id can not be zero") Long id) {
        orderFacade.delete(id);
        return "redirect:/admin/orders";
    }

    @GetMapping("/details{id}")
    public String details(@PathVariable @NotBlank(message = "id can not be empty") String id, Model model) {
        try {
            Optional<Card> cards  = cardService.findById(Long.parseLong(id));
            model.addAttribute("cards", cards.get());
            return "pages/admin/product/product_details";
        }catch (NumberFormatException e){
            throw new NumberFormatException("incorrect value id");
        }
    }
}
