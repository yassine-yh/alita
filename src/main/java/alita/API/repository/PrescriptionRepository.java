package alita.API.repository;


import alita.API.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import alita.API.entity.Prescription;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPharmacist(Pharmacist pharmacist);

    // Find prescriptions by status (e.g., pending, processed)
    List<Prescription> findByStatus(String status);
}