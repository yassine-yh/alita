package alita.API.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alita.API.entity.Inventory;
import alita.API.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Add a new inventory item
    @PostMapping
    public ResponseEntity<Inventory> addInventoryItem(@RequestBody Inventory inventory) {
        Inventory newInventory = inventoryService.addInventoryItem(inventory);
        return ResponseEntity.ok(newInventory);
    }

    // Get all inventory items
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        List<Inventory> inventoryItems = inventoryService.getAllInventoryItems();
        return ResponseEntity.ok(inventoryItems);
    }

    // Get an inventory item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryItemById(@PathVariable Long id) {
        Inventory inventory = inventoryService.getInventoryItemById(id);
        return ResponseEntity.ok(inventory);
    }

    // Update an inventory item
    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventoryItem(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setInventory_id(id); // Ensure the ID matches the path variable
        Inventory updatedInventory = inventoryService.updateInventoryItem(inventory);
        return ResponseEntity.ok(updatedInventory);
    }

    // Delete an inventory item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long id) {
        inventoryService.deleteInventoryItem(id);
        return ResponseEntity.noContent().build();
    }

    // Find inventory items by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Inventory>> findByName(@PathVariable String name) {
        List<Inventory> inventoryItems = inventoryService.findByName(name);
        return ResponseEntity.ok(inventoryItems);
    }

    // Find inventory items with low stock
    @GetMapping("/low-stock/{threshold}")
    public ResponseEntity<List<Inventory>> findByLowStock(@PathVariable int threshold) {
        List<Inventory> lowStockItems = inventoryService.findByLowStock(threshold);
        return ResponseEntity.ok(lowStockItems);
    }
}
