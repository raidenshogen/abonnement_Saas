package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import lombok.Data;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for
 * {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature}
 */
@Data
public class FeatureReadDto implements Serializable {
    private int id;
    private String name;
    private String description;
    private String type;
    private int featureLimit;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        FeatureReadDto that = (FeatureReadDto) o;
        return getId() == that.getId() && getFeatureLimit() == that.getFeatureLimit()
                && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription())
                && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getType(), getFeatureLimit());
    }

    @Override
    public String toString() {
        return "FeatureReadDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", featureLimit=" + featureLimit +
                '}';
    }
}