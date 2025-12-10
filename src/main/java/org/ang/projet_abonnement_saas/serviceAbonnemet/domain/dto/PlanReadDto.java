package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.plans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan}
 */
@Data
@AllArgsConstructor
public class PlanReadDto implements Serializable {
    private  int id;
    private  plans planType;
    private String description;
    private BigDecimal price;
    private List<FeatureReadDto> features;


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