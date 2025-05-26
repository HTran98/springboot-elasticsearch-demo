package com.example.demo.service;


import com.example.demo.entity.document.ProductDocument;
import com.example.demo.repository.ProductOrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductSearchRepository;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductSyncService {

    private final ProductRepository productRepo;
    private final ProductOrderRepository orderRepo;
    private final StockRepository stockRepo;
    private final ProductSearchRepository esRepo;

    public ProductSyncService(
        ProductRepository productRepo,
        ProductOrderRepository orderRepo,
        StockRepository stockRepo,
        ProductSearchRepository esRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.stockRepo = stockRepo;
        this.esRepo = esRepo;
    }

    public void syncToElasticsearch() {
        Map<Long, Integer> orderMap = orderRepo.getTotalOrdersPerProduct().stream()
            .collect(Collectors.toMap(r -> (Long) r[0], r -> ((Long) r[1]).intValue()));

        Map<Long, Integer> stockMap = stockRepo.getTotalStockPerProduct().stream()
            .collect(Collectors.toMap(r -> (Long) r[0], r -> ((Long) r[1]).intValue()));

        List<ProductDocument> docs = productRepo.findAll().stream()
            .map(p -> new ProductDocument(
                p.getId().toString(),
                p.getName(),
                stockMap.getOrDefault(p.getId(), 0),
                orderMap.getOrDefault(p.getId(), 0)
            )).collect(Collectors.toList());

        esRepo.saveAll(docs);
    }
}