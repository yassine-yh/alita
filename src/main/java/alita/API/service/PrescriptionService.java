package alita.API.service;

import alita.API.entity.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alita.API.entity.Prescription;
import alita.API.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Add a new prescription
    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get a prescription by ID
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    // Update a prescription
    public Prescription updatePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Delete a prescription by ID
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    // Find prescriptions by pharmacist ID
    public List<Prescription> findByPharmacist(Pharmacist pharmacist) {
        return prescriptionRepository.findByPharmacist(pharmacist);
    }

    // Find prescriptions by status
    public List<Prescription> findByStatus(String status) {
        return prescriptionRepository.findByStatus(status);
    }
}