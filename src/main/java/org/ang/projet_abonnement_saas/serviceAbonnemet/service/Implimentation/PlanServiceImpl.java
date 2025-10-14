package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.PlanRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepo;

    @Override
    public Plan CreatePlan(Plan plan) {
        return planRepo.save(plan);
    }

    @Override
    public Plan UpdatePlan(Plan plan) {
        Plan plan1=planRepo.findById(plan.getId()).orElse(null);
              plan.setDescription(plan1.getDescription());
              plan.setDuration(plan1.getDuration());
              plan.setPlan(plan1.getPlan());
              plan.setPrice(plan1.getPrice());
              plan.setIs_active(plan1.getIs_active());
                return planRepo.save(plan);
    }

    @Override
    public void DeletePlan(Plan plan) {
        Plan plan1=planRepo.findById(plan.getId()).orElse(null);
        if(plan1!=null){
            planRepo.delete(plan1);
        }
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepo.findAll();
    }

    @Override
    public Plan getActivePlan(Plan plan) {
        return planRepo.findById(plan.getId()).filter(Plan::getIs_active).orElse(null);

    }
}
