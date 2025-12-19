package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
@Tag(name = "Damage Claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/file/{parcelId}")
    @Operation(summary = "File damage claim")
    public DamageClaim fileClaim(@PathVariable Long parcelId,
                                 @RequestBody DamageClaim claim) {
        return damageClaimService.fileClaim(parcelId, claim);
    }

    @PutMapping("/evaluate/{claimId}")
    @Operation(summary = "Evaluate damage claim")
    public DamageClaim evaluateClaim(@PathVariable Long claimId) {
        return damageClaimService.evaluateClaim(claimId);
    }

    @GetMapping("/{claimId}")
    @Operation(summary = "Get claim by ID")
    public DamageClaim getClaim(@PathVariable Long claimId) {
        return damageClaimService.getClaim(claimId);
    }
}
