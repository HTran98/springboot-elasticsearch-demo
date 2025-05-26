package com.example.demo.repository;

import com.example.demo.entity.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface UserSearchRepository extends ElasticsearchRepository<UserDocument, Long> {
    List<UserDocument> findByNameContaining(String name);
}