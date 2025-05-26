package com.example.demo.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@NoArgsConstructor
@Setter
@Document(indexName = "users")
public class UserDocument {
    @Id
    private String id;

    private String name;
    private String email;
}
