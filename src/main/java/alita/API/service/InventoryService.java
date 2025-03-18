package alita.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alita.API.entity.Inventory;
import alita.API.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Add a new inventory item
    public Inventory addInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Get all inventory items
    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    // Get an inventory item by ID
    public Inventory getInventoryItemById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    // Update an inventory item
    public Inventory updateInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Delete an inventory item by ID
    public void deleteInventoryItem(Long id) {
        inventoryRepository.deleteById(id);
    }

    // Find inventory items by name
    public List<Inventory> findByName(String name) {
        return inventoryRepository.findByProductName(name);
    }

    // Find inventory items with low stock
    public List<Inventory> findByLowStock(int threshold) {
        return inventoryRepository.findByQuantityInStockLessThan(threshold);
    }
}
