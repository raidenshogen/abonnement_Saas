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
public class PlanReadDto implements Serializable {
    private final int id;
    private final plans plan;
    private final String description;
    private final BigDecimal price;
    private final Date duration;
    private final List<FeatureDto> features;

    public PlanReadDto(int id, plans plan, String description, BigDecimal price, Date duration, List<FeatureDto> features) {
        this.id = id;
        this.plan = plan;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.features = features;
    }

    public int getId() {
        return id;
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

    public List<FeatureDto> getFeatures() {
        return features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanReadDto entity = (PlanReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.plan, entity.plan) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.duration, entity.duration) &&
                Objects.equals(this.features, entity.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plan, description, price, duration, features);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "plan = " + plan + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "duration = " + duration + ", " +
                "features = " + features + ")";
    }

    /**
     * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature}
     */
    public static class FeatureDto implements Serializable {
        private final int id;
        private final String name;
        private final String description;

        public FeatureDto(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FeatureDto entity = (FeatureDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.name, entity.name) &&
                    Objects.equals(this.description, entity.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, description);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ", " +
                    "description = " + description + ")";
        }
    }
}