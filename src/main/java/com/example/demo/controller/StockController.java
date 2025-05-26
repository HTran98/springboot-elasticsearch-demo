package com.example.demo.controller;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockRepository repository;

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return repository.save(stock);
    }

    @PutMapping("/{id}")
    public Stock update(@PathVariable Long id, @RequestBody Stock stock) {
        //stock.setId(id);
        return repository.save(stock);
    }

    @GetMapping
    public List<Stock> getAll() {
        return repository.findAll();
    }
}