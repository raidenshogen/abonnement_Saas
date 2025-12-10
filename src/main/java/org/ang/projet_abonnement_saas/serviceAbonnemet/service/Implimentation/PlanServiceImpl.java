package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import jakarta.transaction.Transactional;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.mapper.PlanMapper;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.PlanRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper readMapper;

    public PlanServiceImpl(
            PlanRepository planRepository,
            PlanMapper readMapper){
        this.planRepository = planRepository;
        this.readMapper = readMapper;
    }

    @Override
    public PlanReadDto createPlan(PlanCUDto dto) {
        // Optional: prevent duplicate plan types


        Plan plan = readMapper.toEntity(dto);
        Plan saved = planRepository.save(plan);
        return readMapper.toDto(saved);
    }

    @Override
    public PlanReadDto getPlan(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Plan not found with id: " + id));
        return readMapper.toDto(plan);
    }

    @Override
    public List<PlanReadDto> getAllPlans() {
        return planRepository.findAll().stream()
                .map(readMapper::toDto)
                .toList();
    }

    @Override
    public PlanReadDto updatePlan(int id, PlanCUDto dto) {
        Plan existing = planRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Plan not found with id: " + id));

        // Update the existing entity in-place
        readMapper.partialUpdate(dto, existing);

        Plan updated = planRepository.save(existing);
        return readMapper.toDto(updated);

    }

    @Override
    public void deletePlan(int id) {
        if (!planRepository.existsById(id)) {
            throw new NoSuchElementException("Plan not found with id: " + id);
        }
        // Optional: check if used by subscriptions (add later if needed)
        planRepository.deleteById(id);
    }

}
