package alita.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import alita.API.entity.Inventory;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductName(String productName);

    List<Inventory> findByQuantityInStockLessThan(int quantityInStockIsLessThan);
}
