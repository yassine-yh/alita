package alita.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alita.API.entity.Order;
import alita.API.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Add a new order
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get an order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update an order
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order by ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Find orders by supplier ID
    public List<Order> findBySupplierId(Long supplierId) {
        return orderRepository.findBySupplierId(supplierId);
    }

    // Find orders by status
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
}