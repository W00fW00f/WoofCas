package com.woof.cas.storage;

import com.woof.cas.model.Rule;

import java.util.HashMap;
import java.util.Map;

public class RuleStorage {

    private Map<Integer, Rule> rules;

    public RuleStorage() {
        rules = new HashMap<>();
    }

    synchronized public void updateRuleFor(Integer intersectionId, Rule rule) {
        rules.put(intersectionId, rule);
    }

    synchronized public Rule getLatestRuleFor(Integer intersectionId) {
        return rules.get(intersectionId);
    }
}
