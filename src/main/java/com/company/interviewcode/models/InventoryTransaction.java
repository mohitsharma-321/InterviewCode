package com.company.interviewcode.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class InventoryTransaction {
    private long id;
    private long quantity;
    private String remarks;

    public enum OperationType {
        ADD,
        DEDUCT,
        RETURN
    }

}
