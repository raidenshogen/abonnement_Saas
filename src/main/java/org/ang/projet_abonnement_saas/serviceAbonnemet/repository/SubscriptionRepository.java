package org.ang.projet_abonnement_saas.serviceAbonnemet.repository;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    public Subscription getSubscriptionByUserId(String userid);
    public List<Subscription> findByUserId(String userId);

}