package org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription}
 */
public class SubscriptionCUDto implements Serializable {
    private final int plan_id;
    private final Date start_date;
    private final Date end_date;
    private final Status statut;
    private final List<Integer> planIds;
    private final List<Feature> planFeatures;

    public SubscriptionCUDto(int plan_id, Date start_date, Date end_date, Status statut, List<Integer> planIds, List<Feature> planFeatures) {
        this.plan_id = plan_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.statut = statut;
        this.planIds = planIds;
        this.planFeatures = planFeatures;
    }

    public int getPlan_id() {
        return plan_id;
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

    public List<Integer> getPlanIds() {
        return planIds;
    }

    public List<Feature> getPlanFeatures() {
        return planFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionCUDto entity = (SubscriptionCUDto) o;
        return Objects.equals(this.plan_id, entity.plan_id) &&
                Objects.equals(this.start_date, entity.start_date) &&
                Objects.equals(this.end_date, entity.end_date) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.planIds, entity.planIds) &&
                Objects.equals(this.planFeatures, entity.planFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plan_id, start_date, end_date, statut, planIds, planFeatures);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "plan_id = " + plan_id + ", " +
                "start_date = " + start_date + ", " +
                "end_date = " + end_date + ", " +
                "statut = " + statut + ", " +
                "planIds = " + planIds + ", " +
                "planFeatures = " + planFeatures + ")";
    }
}