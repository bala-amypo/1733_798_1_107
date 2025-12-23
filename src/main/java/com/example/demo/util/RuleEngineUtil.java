package com.example.demo.util;

import com.example.demo.model.ClaimRule;

import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String claimDescription, List<ClaimRule> rules) {

        double score = 0.0;

        if (rules == null || rules.isEmpty()) {
            return score;
        }

        for (ClaimRule rule : rules) {

            String expression = rule.getConditionExpression();
            Double weight = rule.getWeight();

            if (expression == null || weight == null) {
                continue;
            }

            if ("always".equalsIgnoreCase(expression)) {
                score += weight;
            }

            else if (expression.startsWith("description_contains:")) {

                if (claimDescription != null) {
                    String keyword = expression.substring(
                            "description_contains:".length()
                    );

                    if (claimDescription.toLowerCase()
                            .contains(keyword.toLowerCase())) {
                        score += weight;
                    }
                }
            }
        }

        // Cap score to max 1.0
        return Math.min(score, 1.0);
    }
}
