package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    // REQUIRED CONSTRUCTOR ORDER: (ParcelRepository)
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {
        if (parcel.getWeightKg() == null || parcel.getWeightKg() <= 0) {
            throw new BadRequestException("Weight must be positive");
        }
        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("Tracking number exists");
        }
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        Parcel parcel = parcelRepository.findByTrackingNumber(trackingNumber);
        if (parcel == null) {
            throw new ResourceNotFoundException("Parcel not found");
        }
        return parcel;
    }
}
