package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription}
 */
public class SubscriptionReadDto implements Serializable {
    private final int id;
    private final Date start_date;
    private final Date end_date;
    private final Status statut;
    private final Date created_at;
    private final List<PlanReadDto> plans;

    public SubscriptionReadDto(int id, Date start_date, Date end_date, Status statut, Date created_at, List<PlanReadDto> plans) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.statut = statut;
        this.created_at = created_at;
        this.plans = plans;
    }

    public int getId() {
        return id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Status getStatut() {
        return statut;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public List<PlanReadDto> getPlans() {
        return plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionReadDto entity = (SubscriptionReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.start_date, entity.start_date) &&
                Objects.equals(this.end_date, entity.end_date) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.created_at, entity.created_at) &&
                Objects.equals(this.plans, entity.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, end_date, statut, created_at, plans);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "start_date = " + start_date + ", " +
                "end_date = " + end_date + ", " +
                "statut = " + statut + ", " +
                "created_at = " + created_at + ", " +
                "plans = " + plans + ")";
    }
}