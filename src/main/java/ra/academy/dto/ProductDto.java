package ra.academy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import ra.academy.model.Product;
import ra.academy.validator.NameRequire;

@Data
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public
class ProductDto {
    @NameRequire
    private String name;

    private double price;

    private MultipartFile image;


    public ProductDto(Product product) {
    }
}
