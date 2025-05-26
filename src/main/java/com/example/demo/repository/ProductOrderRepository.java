package com.example.demo.repository;

import com.example.demo.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    @Query("SELECT po.product.id, SUM(po.summaryOrder) FROM ProductOrder po GROUP BY po.product.id")
    List<Object[]> getTotalOrdersPerProduct();
}