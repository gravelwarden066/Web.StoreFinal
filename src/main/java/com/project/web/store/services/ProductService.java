package com.project.web.store.services;

import com.project.web.store.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface ProductService {

    List<Product> getAllProducts();

    Product getBy(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
