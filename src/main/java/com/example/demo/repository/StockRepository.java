package com.example.demo.repository;

import com.example.demo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT s.product.id, SUM(s.stockNumber) FROM Stock s GROUP BY s.product.id")
    List<Object[]> getTotalStockPerProduct();
}