package alita.API.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import alita.API.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Find a supplier by email
    Supplier findByEmail(String email);

    // Find a supplier by phone number
    Supplier findByPhone(String phone);
}