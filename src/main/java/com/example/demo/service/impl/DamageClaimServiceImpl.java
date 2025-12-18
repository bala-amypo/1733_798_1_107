package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepository;
    private final DamageClaimRepository damageClaimRepository;
    private final ClaimRuleRepository claimRuleRepository;

    // REQUIRED CONSTRUCTOR ORDER:
    // (ParcelRepository, DamageClaimRepository, ClaimRuleRepository)
    public DamageClaimServiceImpl(ParcelRepository parcelRepository,
                                 DamageClaimRepository damageClaimRepository,
                                 ClaimRuleRepository claimRuleRepository) {
        this.parcelRepository = parcelRepository;
        this.damageClaimRepository = damageClaimRepository;
        this.claimRuleRepository = claimRuleRepository;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("PENDING");

        return damageClaimRepository.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<ClaimRule> rules = claimRuleRepository.findAll();

        double score = RuleEngineUtil.computeScore(
                claim.getClaimDescription(), rules);

        claim.setScore(score);
        claim.setAppliedRules(rules);

        if (score >= 10) {
            claim.setStatus("APPROVED");
        } else if (score >= 5) {
            claim.setStatus("SUSPICIOUS");
        } else {
            claim.setStatus("REJECTED");
        }

        return damageClaimRepository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }
}
