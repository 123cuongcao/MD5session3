package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ra.academy.dto.ProductDto;
import ra.academy.model.Product;
import ra.academy.service.ProductService;
import ra.academy.service.UploadService;

import java.util.List;

@RestController
@RequestMapping(value = "api/v3/product", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    private final UploadService uploadService;

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }


    @PutMapping("/{id}")
    public Product doEdit(@PathVariable Long id, @RequestBody ProductDto dto) {
        Product product = new Product(id, dto.getName(), dto.getPrice(), uploadService.uploadFile(dto.getImage()));
        return product;
    }

    @PostMapping("/add")
    public Product doAdd(@RequestBody ProductDto dto) {
        return service.add(dto);
    }

    @DeleteMapping("/{id}")
    public String doDelete(@PathVariable Long id) {
        if (service.findById(id) != null) {
            return "ko tồn tại sản phẩm";
        }
        service.delete(id);
        return "Đã xóa";
    }


}
