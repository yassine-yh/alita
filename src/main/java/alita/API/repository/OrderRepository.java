package alita.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import alita.API.entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Find orders by supplier ID
    List<Order> findBySupplierId(Long supplierId);

    // Find orders by status (e.g., pending, confirmed)
    List<Order> findByStatus(String status);
}