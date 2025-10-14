package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage}
 */
public class UsageReadDto implements Serializable {
    private final int id;
    private final int subscription_id;
    private final int used_value;
    private final FeatureReadDto feature;

    public UsageReadDto(int id, int subscription_id, int used_value, FeatureReadDto feature) {
        this.id = id;
        this.subscription_id = subscription_id;
        this.used_value = used_value;
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public int getUsed_value() {
        return used_value;
    }

    public FeatureReadDto getFeature() {
        return feature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageReadDto entity = (UsageReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.subscription_id, entity.subscription_id) &&
                Objects.equals(this.used_value, entity.used_value) &&
                Objects.equals(this.feature, entity.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscription_id, used_value, feature);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "subscription_id = " + subscription_id + ", " +
                "used_value = " + used_value + ", " +
                "feature = " + feature + ")";
    }
}