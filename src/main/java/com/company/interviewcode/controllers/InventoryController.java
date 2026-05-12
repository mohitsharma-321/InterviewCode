package com.company.interviewcode.controllers;

import com.company.interviewcode.dto.InventoryRequest;
import com.company.interviewcode.models.Inventory;
import com.company.interviewcode.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public Inventory getInventory() {
        return inventoryService.getInventory();
    }

    @PatchMapping
    public Inventory updateInventory(@RequestBody InventoryRequest request) {
        return inventoryService.updateInventory(request);
    }

}
