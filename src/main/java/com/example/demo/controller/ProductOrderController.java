package com.example.demo.controller;

import com.example.demo.entity.ProductOrder;
import com.example.demo.repository.ProductOrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class ProductOrderController {

    private final ProductOrderRepository repository;

    public ProductOrderController(ProductOrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ProductOrder create(@RequestBody ProductOrder order) {
        return repository.save(order);
    }

    @PutMapping("/{id}")
    public ProductOrder update(@PathVariable Long id, @RequestBody ProductOrder order) {
        //order.getProduct().setId(id);
        return repository.save(order);
    }

    @GetMapping
    public List<ProductOrder> getAll() {
        return repository.findAll();
    }
}