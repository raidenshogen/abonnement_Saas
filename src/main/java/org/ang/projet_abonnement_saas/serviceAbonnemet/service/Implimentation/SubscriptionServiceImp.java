package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import jakarta.persistence.EntityNotFoundException;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Status;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.ang.projet_abonnement_saas.serviceAbonnemet.mapper.SubscriptionMapper;
import org.ang.projet_abonnement_saas.serviceAbonnemet.openfeign.ClientDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.openfeign.ResilientFeignRequests; // Import the wrapper
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.PlanRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.SubscriptionRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity; // Import if using ResponseEntity
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    private final SubscriptionRepository repo;
    private final PlanRepository planRepo;
    private final SubscriptionMapper readMapper;
    // private final ClientFeignRequest clientFeignRequest; // Remove direct injection
    private final ResilientFeignRequests resilientFeignRequests; // Inject the wrapper

    @Autowired
    public SubscriptionServiceImp(SubscriptionRepository repo, PlanRepository planRepo,
                                  @Qualifier("subscriptionMapperImpl") SubscriptionMapper readMapper,
                                  // ClientFeignRequest clientFeignRequest, // Remove from constructor
                                  ResilientFeignRequests resilientFeignRequests) { // Add wrapper to constructor
        this.repo = repo;
        this.planRepo = planRepo;
        this.readMapper = readMapper;
        // this.clientFeignRequest = clientFeignRequest; // Remove assignment
        this.resilientFeignRequests = resilientFeignRequests; // Assign the wrapper
    }

    @Override
    public SubscriptionReadDto createSubscription(SubscriptionCUDto dto) {
        // 1. Resolve customerId (String) from DTO to internal userId (String) via Resilient Feign
        // Assuming dto.getUserId() holds the external customer ID string provided by the client
        String customerIdFromClient = dto.getUserId();
        // UUID customerIdUuid = UUID.fromString(customerIdFromClient); // Convert String to UUID for the Feign call

        ResponseEntity<ClientDto> clientResponse;
        try {
            // Pass the String ID to the resilient wrapper, which converts it internally
            clientResponse = resilientFeignRequests.getClientById(customerIdFromClient);
        } catch (RuntimeException e) { // Catch the exception thrown by the fallback method
            // Handle the failure, e.g., throw a specific exception or return an error DTO
            throw new EntityNotFoundException("Failed to retrieve customer details from service: " + e.getMessage(), e);
        }

        ClientDto clientDto = clientResponse.getBody();

        if (clientDto == null) {
            // Consider throwing a specific exception or handling differently
            // e.g., throw new CustomerNotFoundException("Customer not found: " + customerIdFromClient);
            throw new EntityNotFoundException("Customer not found via Feign: " + customerIdFromClient);
        }


        String internalUserId = clientDto.getClientid(); // Or clientDto.getClientid() if that's the field name in ClientDto


        Plan plan = planRepo.findById(dto.getPlanId())
                .orElseThrow(() -> new EntityNotFoundException("Plan not found with ID: " + dto.getPlanId()));


        Subscription sub = readMapper.toEntity(dto);
        sub.setUserId(internalUserId); // Set the internal user ID string (which is the string representation of the UUID)
        sub.setPlan(plan);
        sub.setStatut(Status.active);
        sub.setCreated_at(LocalDate.now());


        Subscription saved = repo.save(sub);
        return readMapper.toDto(saved);
    }

    @Override
    public SubscriptionReadDto getSubscription(int id) { // Get by subscription ID
        Subscription sub = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with ID: " + id));
        return readMapper.toDto(sub);
    }

    // Remove the old create method with UUID clientId
    // @Override
    // public SubscriptionReadDto createSubscription(SubscriptionCUDto dto, UUID clientId) { ... }

    // Remove the getSubscription method that takes a String id (likely confused with customer ID)
    // @Override
    // public SubscriptionReadDto getSubscription(String id) { ... }

    @Override
    public List<SubscriptionReadDto> getAllSubscriptions() {
        // Implemented: Fetch all subscriptions from the repo and map them to DTOs
        List<Subscription> subscriptions = repo.findAll();
        return subscriptions.stream()
                .map(readMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionReadDto> getSubscriptionsByUser(String userId) { // Get by internal user ID string

        List<Subscription> subscriptions = repo.findByUserId(userId); // Adjust method name if different
        return subscriptions.stream()
                .map(readMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionReadDto updateSubscription(int id, SubscriptionCUDto dto) {
        // Implemented: Fetch existing, update fields from DTO (except ID, userId, potentially plan_id if not allowed to change)
        Subscription existingSub = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with ID: " + id));


        if (dto.getStartDate() != null) existingSub.setStart_date(dto.getStartDate());
        if (dto.getEndDate() != null) existingSub.setEnd_date(dto.getEndDate());


        Subscription updated = repo.save(existingSub);
        return readMapper.toDto(updated);
    }

    @Override
    public void deleteSubscription(int id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Subscription not found with ID: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public SubscriptionReadDto activateSubscription(int id) {

        Subscription sub = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with ID: " + id));


        sub.setStatut(Status.active);
        Subscription updated = repo.save(sub);
        return readMapper.toDto(updated);
    }

    @Override
    public SubscriptionReadDto cancelSubscription(int id) {
        // Implemented: Fetch, update status, save, return DTO
        Subscription sub = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found with ID: " + id));

        sub.setStatut(Status.cancelled);
        Subscription updated = repo.save(sub);
        return readMapper.toDto(updated);
    }
}