package com.example.demo.repository;

import com.example.demo.entity.document.ProductDocument;

import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

public class ProductSearchRepositoryCustomImpl implements ProductSearchRepositoryCustom {
    private final ElasticsearchOperations elasticsearchOperations;

    public ProductSearchRepositoryCustomImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<ProductDocument> searchByNameWithStock(String name) {
        Criteria criteria = new Criteria("name").matches(name)
                .and(new Criteria("stockNumber").greaterThan(0));

        Query query = new CriteriaQuery(criteria);
        query.addSort(Sort.by(Sort.Order.desc("summaryOrder")));

        var hits = elasticsearchOperations.search(query, ProductDocument.class);

        return hits.stream()
                .map(hit -> hit.getContent())
                .toList();
    }
}
