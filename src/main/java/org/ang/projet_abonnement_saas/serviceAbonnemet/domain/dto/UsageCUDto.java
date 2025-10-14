package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage}
 */
public class UsageCUDto implements Serializable {
    private final int feature_id;
    private final int used_value;
    private final int featureId;
    private final List<Integer> featurePlanIds;
    private final List<Subscription> featurePlanSubscriptions;

    public UsageCUDto(int feature_id, int used_value, int featureId, List<Integer> featurePlanIds, List<Subscription> featurePlanSubscriptions) {
        this.feature_id = feature_id;
        this.used_value = used_value;
        this.featureId = featureId;
        this.featurePlanIds = featurePlanIds;
        this.featurePlanSubscriptions = featurePlanSubscriptions;
    }

    public int getFeature_id() {
        return feature_id;
    }

    public int getUsed_value() {
        return used_value;
    }

    public int getFeatureId() {
        return featureId;
    }

    public List<Integer> getFeaturePlanIds() {
        return featurePlanIds;
    }

    public List<Subscription> getFeaturePlanSubscriptions() {
        return featurePlanSubscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageCUDto entity = (UsageCUDto) o;
        return Objects.equals(this.feature_id, entity.feature_id) &&
                Objects.equals(this.used_value, entity.used_value) &&
                Objects.equals(this.featureId, entity.featureId) &&
                Objects.equals(this.featurePlanIds, entity.featurePlanIds) &&
                Objects.equals(this.featurePlanSubscriptions, entity.featurePlanSubscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feature_id, used_value, featureId, featurePlanIds, featurePlanSubscriptions);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "feature_id = " + feature_id + ", " +
                "used_value = " + used_value + ", " +
                "featureId = " + featureId + ", " +
                "featurePlanIds = " + featurePlanIds + ", " +
                "featurePlanSubscriptions = " + featurePlanSubscriptions + ")";
    }
}