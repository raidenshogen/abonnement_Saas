package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface UsageService {
    Usage recodUsage(int subscriptionId, int featureId,int usedValue);
    List<Usage> getUsageBySubscription(int subscriptionId);
    boolean CheckUsageLimit(int subscriptionId, int featureId);
    Double getTotalUsage(int subscriptionId, int featureId);
    void resetUsage(int subscriptionId, int featureId);
    Double calculateRemainingQuota(int subscriptionId, int featureId);

}
