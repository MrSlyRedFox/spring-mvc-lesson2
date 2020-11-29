package ru.rickSanchez.lesson_2.spring_mvc.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import ru.rickSanchez.lesson_2.spring_mvc.model.Product;

@Repository
public class ProductRepositories {
    private List<Product> products;
    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        products.add(new Product(1L,"apple","fruit","Russia", 20.0));
        products.add(new Product(2L,"orange","fruit","USA", 50.0));
        products.add(new Product(3L,"jam","tasty","Africa", 250.0));
        products.add(new Product(4L,"bread","eat","China", 10.0));
    }


    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() == null) {
            product.setId(products.size()+1L);
            products.add(product);
            return product;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }
        throw new RuntimeException("Error save or update customer");
    }

    public Product findById(Long id){
        for(Product product: products) {
            if(product.getId().equals(id)){
                return product;
            }
        }throw new RuntimeException("Product not found");
    }
}
