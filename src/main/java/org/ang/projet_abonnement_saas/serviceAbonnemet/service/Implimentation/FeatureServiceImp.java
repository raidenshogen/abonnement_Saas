package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.FeatureRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.PlanRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImp implements FeatureService {
    @Autowired
    FeatureRepository featureRepo;
    @Autowired
    PlanRepository planRepo;
    @Override
    public Feature addFeatureToPlan(int featureId, int planId) {
        Plan p=planRepo.findById(planId).orElse(null);
        Feature f = featureRepo.findById(featureId).get();
        if (p == null) {
            throw new RuntimeException("Plan not found with ID: " + planId);
        }
        if (f == null) {
            throw new RuntimeException("Feature not found with ID: " + featureId);
        }
        List<Feature> featureList=p.getFeatures();
        List<Feature> features = p.getFeatures();
        if (!features.contains(f)) {
            features.add(f);
            p.setFeatures(features);
            planRepo.save(p);
        }
        return f;
    }

    @Override
    public void removeFeatureFromPlan(int featureId,int planId) {
        Plan p=planRepo.findById(planId).orElse(null);
        Feature f = featureRepo.findById(featureId).get();
        if (p == null) {
            throw new RuntimeException("Plan not found with ID: " + planId);
        }
        if (f == null) {
            throw new RuntimeException("Feature not found with ID: " + featureId);
        }

        List<Feature> features = p.getFeatures();
        if (!features.contains(f)) {
            features.remove(f);
            p.setFeatures(features);
            planRepo.save(p);
        }

    }

    @Override
    public Feature updateFeatureToPlan(Feature feature) {
        Feature f = featureRepo.findById(feature.getId()).orElse(null);
        if (f != null) {
            f.setDescription(feature.getDescription());
            f.setName(feature.getName());
            f.setPlans(feature.getPlans());
            f.setType(feature.getType());
            f.setLimit(feature.getLimit());

        }
        return featureRepo.save(f);
    }

    @Override
    public List<Feature> getFeaturesByPlan(Plan plan) {
        return featureRepo.findFeaturesByPlan(plan);
    }

    @Override
    public Feature CreateFeature(Feature feature) {
        if (featureRepo.findById(feature.getId()).isPresent()) {
            throw new RuntimeException("Feature already exists with ID: " + feature.getId());
        }
        return featureRepo.save(feature);
    }
}
