package com.example.demo.controller;

import com.example.demo.entity.document.ProductDocument;
import com.example.demo.repository.ProductSearchRepository;
import com.example.demo.service.ProductSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class ProductSearchController {

    private final ProductSearchService productSearchService;

    public ProductSearchController(ProductSearchService productSearchService) {
        this.productSearchService = productSearchService;
    }

    @GetMapping
    public List<ProductDocument> search(@RequestParam String name) {
        return productSearchService.search(name);
    }
}