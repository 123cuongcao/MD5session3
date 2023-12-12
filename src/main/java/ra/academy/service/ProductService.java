package ra.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.academy.dto.ProductDto;
import ra.academy.model.Product;
import ra.academy.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository repository;

    private final UploadService uploadService;

    public List<Product> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product delete(Long id) {
        Optional<Product> s = repository.findById(id);
        s.ifPresent(product -> repository.deleteById(product.getId()));
        return s.orElse(null);
    }

    public Product add(ProductDto dto) {
        return new Product(dto.getName(), dto.getPrice(), uploadService.uploadFile(dto.getImage()));
    }
}
