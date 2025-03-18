package alita.API.controller;

import alita.API.entity.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alita.API.entity.Prescription;
import alita.API.service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Add a new prescription
    @PostMapping
    public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription) {
        Prescription newPrescription = prescriptionService.addPrescription(prescription);
        return ResponseEntity.ok(newPrescription);
    }

    // Get all prescriptions
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return ResponseEntity.ok(prescriptions);
    }

    // Get a prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return ResponseEntity.ok(prescription);
    }

    // Update a prescription
    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        prescription.setPrescription_id(id); // Ensure the ID matches the path variable
        Prescription updatedPrescription = prescriptionService.updatePrescription(prescription);
        return ResponseEntity.ok(updatedPrescription);
    }

    // Delete a prescription by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }

    // Find prescriptions by pharmacist ID
    @GetMapping("/pharmacist/{pharmacistId}")
    public ResponseEntity<List<Prescription>> findByPharmacistId(@PathVariable Pharmacist pharmacistId) {
        List<Prescription> prescriptions = prescriptionService.findByPharmacist(pharmacistId);
        return ResponseEntity.ok(prescriptions);
    }

    // Find prescriptions by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Prescription>> findByStatus(@PathVariable String status) {
        List<Prescription> prescriptions = prescriptionService.findByStatus(status);
        return ResponseEntity.ok(prescriptions);
    }
}
