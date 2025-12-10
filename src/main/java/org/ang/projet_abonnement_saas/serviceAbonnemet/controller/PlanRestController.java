package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import jakarta.validation.Valid;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanRestController {

    private final PlanService planService;
    @Autowired
    public PlanRestController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<PlanReadDto> createPlan(@Valid @RequestBody PlanCUDto dto) {
        PlanReadDto created = planService.createPlan(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanReadDto> getPlan(@PathVariable int id) {
        PlanReadDto plan = planService.getPlan(id);
        return ResponseEntity.ok(plan);
    }

    @GetMapping
    public ResponseEntity<List<PlanReadDto>> getAllPlans() {
        List<PlanReadDto> plans = planService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanReadDto> updatePlan(
            @PathVariable int id,
            @Valid @RequestBody PlanCUDto dto) {
        PlanReadDto updated = planService.updatePlan(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlan(@PathVariable int id) {
        planService.deletePlan(id);
    }
}
