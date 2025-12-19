package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
@Tag(name = "Claim Rules")
public class ClaimRuleController {

    private final ClaimRuleService claimRuleService;

    public ClaimRuleController(ClaimRuleService claimRuleService) {
        this.claimRuleService = claimRuleService;
    }

    @PostMapping
    @Operation(summary = "Add new claim rule")
    public ClaimRule addRule(@RequestBody ClaimRule rule) {
        return claimRuleService.addRule(rule);
    }

    @GetMapping
    @Operation(summary = "Get all claim rules")
    public List<ClaimRule> getAllRules() {
        return claimRuleService.getAllRules();
    }
}
