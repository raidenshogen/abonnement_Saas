package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;

import java.util.List;

public interface PlanService {
    Plan CreatePlan(Plan plan);
    Plan UpdatePlan(Plan plan);
    void DeletePlan(Plan plan);
    List<Plan> getAllPlan();
    Plan getActivePlan(Plan plan);
}
