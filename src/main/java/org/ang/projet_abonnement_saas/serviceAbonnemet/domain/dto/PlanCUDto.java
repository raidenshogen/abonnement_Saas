package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.plans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan}
 */
public class PlanCUDto implements Serializable {
    private final plans plan;
    private final String description;
    private final BigDecimal price;
    private final Date duration;
    private final List<Integer> featureIds;
    private final int subscriptionId;

    public PlanCUDto(plans plan, String description, BigDecimal price, Date duration, List<Integer> featureIds, int subscriptionId) {
        this.plan = plan;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.featureIds = featureIds;
        this.subscriptionId = subscriptionId;
    }

    public plans getPlan() {
        return plan;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDuration() {
        return duration;
    }

    public List<Integer> getFeatureIds() {
        return featureIds;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanCUDto entity = (PlanCUDto) o;
        return Objects.equals(this.plan, entity.plan) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.duration, entity.duration) &&
                Objects.equals(this.featureIds, entity.featureIds) &&
                Objects.equals(this.subscriptionId, entity.subscriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plan, description, price, duration, featureIds, subscriptionId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "plan = " + plan + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "duration = " + duration + ", " +
                "featureIds = " + featureIds + ", " +
                "subscriptionId = " + subscriptionId + ")";
    }
}