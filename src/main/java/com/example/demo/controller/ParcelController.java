package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
@Tag(name = "Parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    // POST /api/parcels
    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel) {
        return parcelService.addParcel(parcel);
    }

    // GET /api/parcels/tracking/{trackingNumber}
    @GetMapping("/tracking/{trackingNumber}")
    public Parcel getParcel(@PathVariable String trackingNumber) {
        return parcelService.getByTrackingNumber(trackingNumber);
    }
}
