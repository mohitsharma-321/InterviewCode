package com.company.interviewcode.dto;

import com.company.interviewcode.models.InventoryTransaction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequest {
    private  long quantity;
    private String remarks;
    private InventoryTransaction.OperationType operationType;
}
