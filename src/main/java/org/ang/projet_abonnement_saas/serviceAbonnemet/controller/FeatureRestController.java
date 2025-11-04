package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureRestController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<Feature> createFeature(@RequestBody Feature feature) {
        Feature saved = featureService.CreateFeature(feature);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{featureId}/add-to-plan/{planId}")
    public ResponseEntity<Feature> addFeatureToPlan(@PathVariable int featureId,
                                                    @PathVariable int planId) {
        Feature feature = featureService.addFeatureToPlan(featureId, planId);
        return ResponseEntity.ok(feature);
    }

    @PostMapping("/{featureId}/remove-from-plan/{planId}")
    public ResponseEntity<Void> removeFeatureFromPlan(@PathVariable int featureId,
                                                      @PathVariable int planId) {
        featureService.removeFeatureFromPlan(featureId, planId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Feature> updateFeature(@RequestBody Feature feature) {
        Feature updated = featureService.updateFeatureToPlan(feature);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<List<Feature>> getFeaturesByPlan(@PathVariable int planId) {
        Plan plan = new Plan();
        plan.setId(planId);
        List<Feature> features = featureService.getFeaturesByPlan(plan);
        return ResponseEntity.ok(features);
    }
}
