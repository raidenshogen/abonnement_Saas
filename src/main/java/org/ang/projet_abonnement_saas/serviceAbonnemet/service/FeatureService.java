package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;

import java.util.List;

public interface FeatureService {
    Feature addFeatureToPlan(int featureId, int planId);
    void removeFeatureFromPlan(int featureId, int planId);
    Feature updateFeatureToPlan(Feature feature);
    List<Feature> getFeaturesByPlan(Plan plan);
    Feature CreateFeature(Feature feature);


}
