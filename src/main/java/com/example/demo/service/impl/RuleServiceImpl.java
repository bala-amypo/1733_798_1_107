package com.example.demo.service.impl;

import com.example.demo.model.Rule;
import com.example.demo.repository.RuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;

    public RuleServiceImpl(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public Rule addRule(Rule rule) {

        // ✅ FIX for testAddRuleInvalidWeight
        if (rule.getWeight() <= 0) {
            throw new IllegalArgumentException("Invalid weight");
        }

        return ruleRepository.save(rule);
    }
}
