package ua.khai.controllers;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.dto.response.PageData;
import ua.khai.dto.response.ProductResponseDto;
import ua.khai.entity.Addition;
import ua.khai.facade.ProductFacade;
import ua.khai.service.AdditionService;
import ua.khai.util.WebUtil;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/personal/products")
public class PersonalProductController extends AbstractController{

    private final HeaderName[] columnNames = new HeaderName[] {
            new HeaderName("#", null, null),
            new HeaderName("image", null, null),
            new HeaderName("product name", "productName", "name"),
            new HeaderName("size", "size", "size"),
            new HeaderName("weight", "weight", "weight"),
            new HeaderName("created", "created", "created"),
            new HeaderName("price", "price", "price"),
            new HeaderName("details", null, null),
            new HeaderName("add to card", null, null),
    };

    private final ProductFacade productFacade;
    private final AdditionService additionService;

    public PersonalProductController(ProductFacade productFacade, AdditionService additionService) {
        this.productFacade = productFacade;
        this.additionService = additionService;
    }

    @GetMapping
    public String findAll(Model model, WebRequest webRequest) throws IOException {
        DataTableRequest dataTableRequest = WebUtil.generateDataTableRequestByWebRequest(webRequest);
        DataTableResponse<Addition> addition = additionService.findAll(dataTableRequest);
        PageData<ProductResponseDto> response = productFacade.findAll(webRequest);
       initDataTable(response, columnNames, model);
        model.addAttribute( "addition", addition);
        model.addAttribute("createUrl", "/personal/products/all");
        model.addAttribute("cardHeader", "All Products");
        return "pages/personal/product/product_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "personal/products");
    }

    @GetMapping("/details{id}")
    public String details(@PathVariable @NotBlank(message = "id can not be empty") String id, Model model) {
        try {
            Long productId = Long.parseLong(id);
            ProductResponseDto dto = productFacade.findById(productId);
            model.addAttribute("product", dto);
            return "pages/admin/product_details";
        } catch (NumberFormatException e) {
            throw new NumberFormatException("incorrect value id");
        }
    }

}
