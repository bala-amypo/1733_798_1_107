package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.ArrayList;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String description, List<ClaimRule> rules) {
        double score = 0.0;

        if (description == null || rules == null) {
            return score;
        }

        for (ClaimRule rule : rules) {
            if (rule.getConditionExpression() != null &&
                description.toLowerCase()
                        .contains(rule.getConditionExpression().toLowerCase())) {

                if (rule.getWeight() != null) {
                    score += rule.getWeight();
                }
            }
        }
        return score;
    }
}
