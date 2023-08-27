package ua.khai.controllers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.dto.request.ProductRequestDto;
import ua.khai.dto.response.PageData;
import ua.khai.dto.response.ProductResponseDto;
import ua.khai.entity.ProductType;
import ua.khai.facade.ProductFacade;
import ua.khai.service.ProductTypeService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController extends AbstractController{

    private final HeaderName[] columnNames = new HeaderName[] {
            new HeaderName("#", null, null),
            new HeaderName("image", null, null),
            new HeaderName("product name", "productName", "name"),
            new HeaderName("size", "size", "size"),
            new HeaderName("weight", "weight", "weight"),
            new HeaderName("created", "created", "created"),
            new HeaderName("price", "price", "price"),
            new HeaderName("details", null, null),
            new HeaderName("delete", null, null),
            new HeaderName("add", null, null)
    };

    @Autowired
    private final ProductFacade productFacade;
    @Autowired
    private final ProductTypeService productTypeService;

    public AdminProductController(ProductFacade productFacade, ProductTypeService productTypeService) {
        this.productFacade = productFacade;
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public String findAll(Model model, WebRequest webRequest) throws IOException {
        PageData<ProductResponseDto> response = productFacade.findAll(webRequest);
       initDataTable(response, columnNames, model);
        model.addAttribute("createUrl", "/admin/products/all");
        model.addAttribute("createNew", "/admin/products/new");
        model.addAttribute("cardHeader", "All Products");
        return "pages/admin/product/product_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "admin/products");
    }

    @GetMapping("/new")
    public String redirectToNewBookPage(Model model) {
        List<ProductType> types =  productTypeService.findAll();
        model.addAttribute("product", new ProductRequestDto());
        model.addAttribute("types", types);
        return "pages/admin/product/product_new";
    }

    @PostMapping("/create")
    public String createNewProduct(RedirectAttributes attributes, @ModelAttribute("product") ProductRequestDto dto) {
        productFacade.create(dto);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete{id}")
    public String delete(@PathVariable @Min(value = 1, message = "id can not be zero") Long id) {
        productFacade.delete(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/details{id}")
    public String details(@PathVariable @NotBlank(message = "id can not be empty") String id, Model model) {

            Long productId = Long.parseLong(id);
            ProductResponseDto dto = productFacade.findById(productId);
            model.addAttribute("product", dto);
            return "pages/admin/product/product_details";

    }

}
