package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription}
 */
@Data
@AllArgsConstructor

public class SubscriptionCUDto implements Serializable {
    private String userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int planId;

    @Override
    public String toString() {
        return "SubscriptionCUDto{" +
                "userId=" + userId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +

                '}';

    }
}