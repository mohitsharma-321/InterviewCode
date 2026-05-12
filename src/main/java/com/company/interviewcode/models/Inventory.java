package com.company.interviewcode.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory {
    private Long Id;
    private String productName;
    private int quantity;

    public Inventory(String liciousKiInventory, int i) {
        this.productName = liciousKiInventory;
        this.quantity = i
    }
}
