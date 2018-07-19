package com.woof.cas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rule {

    private List<RuleEntry> entries;

    public Rule() {
        entries = new ArrayList<>();
    }

    public Rule(List<RuleEntry> entries) {
        this.entries = entries;
    }

    public List<RuleEntry> getEntries() {
        return entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return Objects.equals(entries, rule.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "entries=" + entries.toString() +
                '}';
    }
}
