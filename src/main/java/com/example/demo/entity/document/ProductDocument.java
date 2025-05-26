package com.example.demo.entity.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "products")
@Getter
@Setter
public class ProductDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "vi_en_analyzer")
    private String name;

    @Field(type = FieldType.Integer)
    private Integer stockNumber;

    @Field(type = FieldType.Integer)
    private Integer summaryOrder;

    public ProductDocument() {}

    public ProductDocument(String id, String name, Integer stockNumber, Integer summaryOrder) {
        this.id = id;
        this.name = name;
        this.stockNumber = stockNumber;
        this.summaryOrder = summaryOrder;
    }

    // Getters and setters
}