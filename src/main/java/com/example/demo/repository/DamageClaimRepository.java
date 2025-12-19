package com.example.demo.repository;

import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DamageClaimRepository extends JpaRepository<DamageClaim, Long> {

    // ✅ REQUIRED by tests
    List<DamageClaim> findByParcel_Id(Long parcelId);

    // ✅ REQUIRED by tests (explicit)
    Optional<DamageClaim> findById(Long claimId);
}
