package alita.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import alita.API.entity.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    // Find a pharmacist by username
    Pharmacist findByUsername(String username);

    Pharmacist findByName(String name);
}
