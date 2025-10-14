package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature}
 */
public class FeatureReadDto implements Serializable {
    private final int id;
    private final String name;
    private final String description;
    private final List<Plan> plans;
    private final UsageReadDto usage;

    public FeatureReadDto(int id, String name, String description, List<Plan> plans, UsageReadDto usage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.plans = plans;
        this.usage = usage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public UsageReadDto getUsage() {
        return usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureReadDto entity = (FeatureReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.plans, entity.plans) &&
                Objects.equals(this.usage, entity.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, plans, usage);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "plans = " + plans + ", " +
                "usage = " + usage + ")";
    }
}