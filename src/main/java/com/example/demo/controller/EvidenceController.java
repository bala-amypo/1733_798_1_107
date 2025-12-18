package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@Tag(name = "Evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    // POST /api/evidence/upload/{claimId}
    @PostMapping("/upload/{claimId}")
    public Evidence uploadEvidence(@PathVariable Long claimId,
                                   @RequestBody Evidence evidence) {
        return evidenceService.uploadEvidence(claimId, evidence);
    }

    // GET /api/evidence/claim/{claimId}
    @GetMapping("/claim/{claimId}")
    public List<Evidence> getEvidence(@PathVariable Long claimId) {
        return evidenceService.getEvidenceForClaim(claimId);
    }
}
