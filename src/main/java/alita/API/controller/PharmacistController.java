package alita.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alita.API.entity.Pharmacist;
import alita.API.service.PharmacistService;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacists")
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    // Add a new pharmacist
    @PostMapping
    public ResponseEntity<Pharmacist> addPharmacist(@RequestBody Pharmacist pharmacist) {
        Pharmacist newPharmacist = pharmacistService.addPharmacist(pharmacist);
        return ResponseEntity.ok(newPharmacist);
    }

    // Get all pharmacists
    @GetMapping
    public ResponseEntity<List<Pharmacist>> getAllPharmacists() {
        List<Pharmacist> pharmacists = pharmacistService.getAllPharmacists();
        return ResponseEntity.ok(pharmacists);
    }

    // Get a pharmacist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable Long id) {
        Pharmacist pharmacist = pharmacistService.getPharmacistById(id);
        return ResponseEntity.ok(pharmacist);
    }

    // Update a pharmacist
    @PutMapping("/{id}")
    public ResponseEntity<Pharmacist> updatePharmacist(@PathVariable Long id, @RequestBody Pharmacist pharmacist) {
        pharmacist.setPharmacist_id(id); // Ensure the ID matches the path variable
        Pharmacist updatedPharmacist = pharmacistService.updatePharmacist(pharmacist);
        return ResponseEntity.ok(updatedPharmacist);
    }

    // Delete a pharmacist by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {
        pharmacistService.deletePharmacist(id);
        return ResponseEntity.noContent().build();
    }

    // Find a pharmacist by username
    @GetMapping("/username/{username}")
    public ResponseEntity<Pharmacist> findByUsername(@PathVariable String username) {
        Pharmacist pharmacist = pharmacistService.findByUsername(username);
        return ResponseEntity.ok(pharmacist);
    }

    // Find a pharmacist by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Pharmacist> findByEmail(@PathVariable String email) {
        Pharmacist pharmacist = pharmacistService.findByEmail(email);
        return ResponseEntity.ok(pharmacist);
    }
}
