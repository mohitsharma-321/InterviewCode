package com.company.interviewcode.service;

import com.company.interviewcode.dto.InventoryRequest;
import com.company.interviewcode.models.Inventory;
import com.company.interviewcode.models.InventoryTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class InventoryService {
    private final Inventory inventory = new Inventory("Licious ki Inventory ", 500);

    private final CopyOnWriteArrayList<InventoryTransaction> transactions = new CopyOnWriteArrayList<>();

    private final AtomicLong txId = new AtomicLong(1);

    private final ReentrantLock lock = new ReentrantLock(true);

    public Inventory getInventory() {
        return inventory;
    }
    public Inventory updateInventory(InventoryRequest request) {
        lock.lock();

        try{
//            lock.lock();
            long before = request.getQuantity();
            InventoryTransaction.OperationType op = request.getOperationType();

            switch(op) {
                case DEDUCT -> {
                    if(inventory.getQuantity() < request.getQuantity()) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insufficient quantity !!");
                    }
                    inventory.setQuantity((int) (before - request.getQuantity()));
                }
                case ADD,RETURN -> inventory.setQuantity((int) (before + request.getQuantity()));

                default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid OperationType !!");

            }

            transactions.add(InventoryTransaction.builder()
                                                 .id(txId.getAndIncrement())
                                                 .quantity(request.getQuantity())
                                                 .remarks(request.getRemarks())
                                                 .build());
            return inventory;
        } finally {
            lock.unlock();
        }

    }
}
























