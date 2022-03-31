package com.project.web.store.controller;

import com.project.web.store.models.Product;
import com.project.web.store.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImp productServiceImp;


    @GetMapping(value = "/product/all")
    public ModelAndView getAllProducts(Product product) {
        ModelAndView mav = new ModelAndView("product-list");
        mav.addObject("products", productServiceImp.getAllProducts());
        mav.addObject("productId", product.getId());
        return mav;
    }

    @GetMapping("/product/{id}")
    public ModelAndView getById(@PathVariable("id") Long id, Product product) {
        ModelAndView mav = new ModelAndView("product-page");
        mav.addObject("product", productServiceImp.getBy(id));
        mav.addObject("productId", product.getId());
        return mav;
    }

    @GetMapping("/product/add")
    public ModelAndView createProductForm(Model model) {
        ModelAndView mav = new ModelAndView("product-add");
        model.addAttribute("product", new Product());
        return mav;
    }

    @PostMapping("/product/add")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView mav = new ModelAndView("product-add");
        mav.addObject("product", productServiceImp.createProduct(product));
        mav.setViewName("redirect:/product/all");
        return mav;
    }

    @GetMapping("/product/edit/{id}")
    public ModelAndView updateProductForm(@PathVariable("id") Long id, Product product) {
        ModelAndView mav = new ModelAndView("product-edit");
        mav.addObject("product", productServiceImp.getBy(id));
        return mav;
    }

    @PatchMapping("/product/edit/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        ModelAndView mav = new ModelAndView("product-edit");
        productServiceImp.updateProduct(id, product);
        mav.setViewName("redirect:/product/all");
        return product;
    }

    @DeleteMapping("/product/delete/{id}")
    void deleteProduct(@PathVariable Long id) {
        productServiceImp.deleteProduct(id);
    }
}
