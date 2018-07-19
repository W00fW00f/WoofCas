package com.woof.cas.model;

import java.util.Objects;

public class RuleEntry {

    private Integer highPriorityRoad;
    private Integer lowPriorityRoad;

    public RuleEntry() {
        highPriorityRoad = 0;
        lowPriorityRoad = 0;
    }

    public RuleEntry(Integer highPriorityRoad, Integer lowPriorityRoad) {
        this.highPriorityRoad = highPriorityRoad;
        this.lowPriorityRoad = lowPriorityRoad;
    }

    public Integer getHighPriorityRoad() {
        return highPriorityRoad;
    }

    public void setHighPriorityRoad(Integer highPriorityRoad) {
        this.highPriorityRoad = highPriorityRoad;
    }

    public Integer getLowPriorityRoad() {
        return lowPriorityRoad;
    }

    public void setLowPriorityRoad(Integer lowPriorityRoad) {
        this.lowPriorityRoad = lowPriorityRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleEntry ruleEntry = (RuleEntry) o;
        return Objects.equals(highPriorityRoad, ruleEntry.highPriorityRoad) &&
                Objects.equals(lowPriorityRoad, ruleEntry.lowPriorityRoad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highPriorityRoad, lowPriorityRoad);
    }

    @Override
    public String toString() {
        return "RuleEntry{" +
                "highPriorityRoad=" + highPriorityRoad +
                ", lowPriorityRoad=" + lowPriorityRoad +
                '}';
    }
}
