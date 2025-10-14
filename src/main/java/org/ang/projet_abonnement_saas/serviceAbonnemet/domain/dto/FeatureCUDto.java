package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature}
 */
public class FeatureCUDto implements Serializable {
    private final String name;
    private final String description;
    private final String type;
    private final int limit;
    private final List<Integer> planIds;
    private final int usageId;

    public FeatureCUDto(String name, String description, String type, int limit, List<Integer> planIds, int usageId) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.limit = limit;
        this.planIds = planIds;
        this.usageId = usageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getLimit() {
        return limit;
    }

    public List<Integer> getPlanIds() {
        return planIds;
    }

    public int getUsageId() {
        return usageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureCUDto entity = (FeatureCUDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.limit, entity.limit) &&
                Objects.equals(this.planIds, entity.planIds) &&
                Objects.equals(this.usageId, entity.usageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, limit, planIds, usageId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "type = " + type + ", " +
                "limit = " + limit + ", " +
                "planIds = " + planIds + ", " +
                "usageId = " + usageId + ")";
    }
}