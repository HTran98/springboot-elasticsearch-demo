package com.example.demo.repository;

import com.example.demo.entity.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<ProductDocument, String>, ProductSearchRepositoryCustom {
    List<ProductDocument> findByName(String name);
}