package com.example.demo.controller;

import com.example.demo.service.ProductSyncService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sync")
public class SyncController {

    private final ProductSyncService syncService;

    public SyncController(ProductSyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping
    public String sync() {
        syncService.syncToElasticsearch();
        return "Đã đồng bộ thành công!";
    }
}