package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@AllArgsConstructor
@Data
public class SubscriptionReadDto implements Serializable {
    private int id;
    private String userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate createdAt;
    private Status status;
    private PlanReadDto plan;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionReadDto that = (SubscriptionReadDto) o;
        return id == that.id && userId == that.userId && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(createdAt, that.createdAt) && status == that.status && Objects.equals(plan, that.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getStartDate(), getEndDate(), getCreatedAt(), getStatus(), getPlan());
    }

    @Override
    public String toString() {
        return "SubscriptionReadDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", plan=" + plan +
                '}';
    }
}