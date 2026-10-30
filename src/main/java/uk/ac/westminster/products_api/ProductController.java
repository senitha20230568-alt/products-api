package uk.ac.westminster.products_api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

}
