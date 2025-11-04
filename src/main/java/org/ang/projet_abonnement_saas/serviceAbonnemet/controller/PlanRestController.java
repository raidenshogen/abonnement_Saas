package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanRestController {

    @Autowired
    private PlanService planService;

    @PostMapping
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        Plan saved = planService.CreatePlan(plan);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan) {
        Plan updated = planService.UpdatePlan(plan);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable int id) {
        Plan plan = new Plan();
        plan.setId(id);
        planService.DeletePlan(plan);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Plan>> getAllPlans() {
        List<Plan> plans = planService.getAllPlan();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<Plan> getActivePlan(@PathVariable int id) {
        Plan plan = new Plan();
        plan.setId(id);
        Plan active = planService.getActivePlan(plan);
        if (active != null) {
            return ResponseEntity.ok(active);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
