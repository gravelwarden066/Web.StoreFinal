package com.project.web.store.services;

import com.project.web.store.exceptions.NotFoundException;
import com.project.web.store.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.web.store.repository.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getBy(Long id) {
        Optional<Product> product = productDao.findById(id);
        if (!product.isPresent()) throw new NotFoundException("Product with id " + id + " does not exist");
        return product.get();
    }

    @Override
    public Product createProduct(Product product) {
        product.setName(product.name);
        product.setQuantity(product.quantity);
        product.setPrice(product.price);
        return productDao.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        productDao.findById(id);
        product.setName(product.name);
        product.setQuantity(product.quantity);
        product.setPrice(product.price);
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
}
