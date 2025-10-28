package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.FeatureRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.SubscriptionRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.UsageRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsageServiceImp implements UsageService {
    @Autowired
    private UsageRepository usageRepo;
     @Autowired
     private SubscriptionRepository subscriptionRepo;
     @Autowired
     private FeatureRepository featureRepo;

        @Override
    public Usage recodUsage(int subscriptionId, int featureId, int usedValue) {
        Subscription sub=subscriptionRepo.findById(subscriptionId).orElse(null);
        Feature ft=featureRepo.findById(featureId).orElse(null);
        if(sub==null){
            throw new RuntimeException("Subscription Not Found");
        }
        if(ft==null){
            throw new RuntimeException("Feature Not Found");
        }
        Usage usage=new Usage();
        usage.setSubscription_id(sub.getId());
        usage.setFeature_id(ft.getId());
        usage.setUsed_value(usedValue);
        usage.setRecorded_at(LocalDate.now());
        return usageRepo.save(usage);
    }

    @Override
    public List<Usage> getUsageBySubscription(int subscriptionId) {
        return usageRepo.findBySubscriptionId(subscriptionId);
    }

    @Override
    public boolean CheckUsageLimit(int subscriptionId, int featureId) {
        Feature feature = featureRepo.findById(featureId).orElse(null);
        if (feature == null) {
            throw new IllegalArgumentException("Feature not found");
        }

        double limit = feature.getLimit();
        double totalUsed = getTotalUsage(subscriptionId, featureId);

        return totalUsed >= limit;
    }

    @Override
    public Double getTotalUsage(int subscriptionId, int featureId) {
        List<Usage> usages = usageRepo.findBySubscriptionIdAndFeatureId(subscriptionId, featureId);
        return usages.stream().mapToDouble(Usage::getUsed_value).sum();
    }

    @Override
    public void resetUsage(int subscriptionId, int featureId) {
        List<Usage> usages = usageRepo.findBySubscriptionIdAndFeatureId(subscriptionId, featureId);
        usageRepo.deleteAll(usages);
    }

    @Override
    public Double calculateRemainingQuota(int subscriptionId, int featureId) {
        Feature feature = featureRepo.findById(featureId).orElse(null);
        if (feature == null) {
            throw new IllegalArgumentException("Feature not found");
        }

        double limit = feature.getLimit();
        double totalUsed = getTotalUsage(subscriptionId, featureId);

        return Math.max(0, limit - totalUsed);
    }
}
