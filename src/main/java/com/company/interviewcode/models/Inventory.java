package com.company.interviewcode.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
    // This is inventory only with multiple objects of products.
    // Not written in this form -
    // inventory class -> List<Products> as a field in it.
    // It is same !!
    private Long Id;
    private String productName;
    private int quantity;

    public Inventory(String liciousKiInventory, int i) {
        this.productName = liciousKiInventory;
        this.quantity = i;
    }
}
