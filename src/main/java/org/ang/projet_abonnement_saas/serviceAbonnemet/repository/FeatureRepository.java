package org.ang.projet_abonnement_saas.serviceAbonnemet.repository;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
    @Query("SELECT f FROM Feature f WHERE f.plan.plan IN :planTypes")
    List<Feature> findFeaturesByPlanTypes(@Param("planTypes") List<plans> planTypes);

}