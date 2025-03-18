package alita.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alita.API.entity.Supplier;
import alita.API.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Add a new supplier
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Get all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Get a supplier by ID
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    // Update a supplier
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Delete a supplier by ID
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    // Find a supplier by email
    public Supplier findByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    // Find a supplier by phone number
    public Supplier findByPhone(String phone) {
        return supplierRepository.findByPhone(phone);
    }
}