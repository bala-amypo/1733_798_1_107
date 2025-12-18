package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Damage Claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    // POST /api/claims/file/{parcelId}
    @PostMapping("/file/{parcelId}")
    public DamageClaim fileClaim(@PathVariable Long parcelId,
                                 @RequestBody DamageClaim claim) {
        return damageClaimService.fileClaim(parcelId, claim);
    }

    // PUT /api/claims/evaluate/{claimId}
    @PutMapping("/evaluate/{claimId}")
    public DamageClaim evaluateClaim(@PathVariable Long claimId) {
        return damageClaimService.evaluateClaim(claimId);
    }

    // GET /api/claims/{claimId}
    @GetMapping("/{claimId}")
    public DamageClaim getClaim(@PathVariable Long claimId) {
        return damageClaimService.getClaim(claimId);
    }
}
