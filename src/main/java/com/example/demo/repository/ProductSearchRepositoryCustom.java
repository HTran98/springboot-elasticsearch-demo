package com.example.demo.repository;

import com.example.demo.entity.document.ProductDocument;

import java.util.List;

public interface ProductSearchRepositoryCustom {
    List<ProductDocument> searchByNameWithStock(String name);
}
