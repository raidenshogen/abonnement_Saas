package org.ang.projet_abonnement_saas.serviceAbonnemet.repository;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Integer> {
    List<Usage> findBySubscriptionId(int subscriptionId);
    List<Usage> findBySubscriptionIdAndFeatureId(int subscriptionId,int featureId);
}