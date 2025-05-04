package com.ecommerce.category;

import com.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author - artest - 03rd May 2025 
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
