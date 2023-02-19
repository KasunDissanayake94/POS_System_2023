package io.reflectoring.pos.service;

import io.reflectoring.pos.model.Inventory;
import io.reflectoring.pos.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public ResponseEntity<Inventory> saveInventory(Inventory inventory){
        try {
            Inventory inventory1 = inventoryRepository.save(new Inventory(inventory.getInventoryId(), inventory.getInventoryName(), inventory.getInventoryCategory()));
            return new ResponseEntity<>(inventory1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Inventory>> getAllInventoriesByName(String name){
        try {
            List<Inventory> inventories = new ArrayList<Inventory>();

            if (name == null)
                inventoryRepository.findAll().forEach(inventories::add);
            else
                inventoryRepository.findByInventoryNameContaining(name).forEach(inventories::add);
            if (inventories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Inventory> getInventoryById(String id){
        Optional<Inventory> inventoryData = inventoryRepository.findById(id);

        if (inventoryData.isPresent()) {
            return new ResponseEntity<>(inventoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Inventory> updateInventory(String id, Inventory inventory){
        Optional<Inventory> inventoryData = inventoryRepository.findById(id);
        if (inventoryData.isPresent()) {
            Inventory inventory1 = inventoryData.get();
            inventory1.setInventoryId(inventory.getInventoryId());
            inventory1.setInventoryName(inventory.getInventoryName());
            inventory1.setInventoryCategory(inventory.getInventoryCategory());
            return new ResponseEntity<>(inventoryRepository.save(inventory1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<HttpStatus> deleteInventory(String id){
        try {
            inventoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteAllInventories(){
        try {
            inventoryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
