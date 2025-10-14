package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription CreateSubscription(Subscription subscription);
    Subscription UpdateSubscriptionStatus(Subscription subscription);
    void CancalSubscription(Subscription subscription); // void ici
    Subscription RenewSubscription(Subscription subscription);
    List<Subscription> getActiveSubscriptions();

}

