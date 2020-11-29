package ru.rickSanchez.lesson_2.spring_mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ru.rickSanchez.lesson_2.spring_mvc.model.Product;
import ru.rickSanchez.lesson_2.spring_mvc.repositories.ProductRepositories;

@Service
public class ProductService {
    private ProductRepositories productRepositoriey;

    public List<Product> getAllProducts(){
        return productRepositoriey.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productRepositoriey.saveOrUpdate(product);
    }

    public Product findById(Long id) {
        return productRepositoriey.findById(id);
    }

    @Autowired
    public void setProductRepository(ProductRepositories productRepositories) {
        this.productRepositoriey = productRepositories;
    }
}
