package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;

import java.util.List;

public interface PlanService {
    PlanReadDto createPlan(PlanCUDto dto);
    PlanReadDto getPlan(int id);
    List<PlanReadDto> getAllPlans();
    PlanReadDto updatePlan(int id, PlanCUDto dto);
    void deletePlan(int id);
}
