package com.example.demo.repository;

import com.example.demo.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    boolean existsByTrackingNumber(String trackingNumber);

    Parcel findByTrackingNumber(String trackingNumber);
}
