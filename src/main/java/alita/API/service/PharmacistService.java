package alita.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alita.API.entity.Pharmacist;
import alita.API.repository.PharmacistRepository;

import java.util.List;

@Service
public class PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    // Add a new pharmacist
    public Pharmacist addPharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    // Get all pharmacists
    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepository.findAll();
    }

    // Get a pharmacist by ID
    public Pharmacist getPharmacistById(Long id) {
        return pharmacistRepository.findById(id).orElse(null);
    }

    // Update a pharmacist
    public Pharmacist updatePharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    // Delete a pharmacist by ID
    public void deletePharmacist(Long id) {
        pharmacistRepository.deleteById(id);
    }

    // Find a pharmacist by username
    public Pharmacist findByUsername(String username) {
        return pharmacistRepository.findByUsername(username);
    }

    // Find a pharmacist by email
    public Pharmacist findByEmail(String email) {
        return pharmacistRepository.findByName(email);
    }
}