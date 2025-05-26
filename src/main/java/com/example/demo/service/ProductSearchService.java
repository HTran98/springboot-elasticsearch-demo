package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.document.ProductDocument;
import com.example.demo.repository.ProductSearchRepositoryCustomImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchService {
    private final ProductSearchRepositoryCustomImpl productSearchRepositoryCustom;

    public ProductSearchService(ProductSearchRepositoryCustomImpl productSearchRepositoryCustom) {
        this.productSearchRepositoryCustom = productSearchRepositoryCustom;
    }

    public List<ProductDocument> search(String name) {
       return  productSearchRepositoryCustom.searchByNameWithStock(name);
    }
}
