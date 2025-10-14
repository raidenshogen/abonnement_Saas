package org.ang.projet_abonnement_saas.serviceAbonnemet.repository;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
}