//package com.example.KS_POS.controller;
//
//import com.example.KS_POS.model.Inventory;
//import com.example.KS_POS.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @PostMapping("/inventories")
//    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
//        return inventoryService.saveInventory(inventory);
//    }
//
//    @GetMapping("/inventories")
//    public ResponseEntity<List<Inventory>> getAllInventories(@RequestParam(required = false) String inventoryName){
//        return inventoryService.getAllInventoriesByName(inventoryName);
//
//    }
//
//    @GetMapping("/inventories/{id}")
//    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") String id){
//        return inventoryService.getInventoryById(id);
//
//    }
//
//    @PutMapping("/inventories/{id}")
//    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") String id, @RequestBody Inventory inventory){
//        return inventoryService.updateInventory(id, inventory);
//
//    }
//
//    @DeleteMapping("/inventories/{id}")
//    public ResponseEntity<HttpStatus> deleteInventory(String id) {
//        return inventoryService.deleteInventory(id);
//
//    }
//
//    @DeleteMapping("/inventories")
//    public ResponseEntity<HttpStatus> deleteAllInventories() {
//        return inventoryService.deleteAllInventories();
//
//    }
//}
//
//
//
//
