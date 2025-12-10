package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions") // Base path for subscription endpoints
public class SubscriptionRestController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionRestController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // POST /api/subscriptions - Create a new subscription
    @PostMapping
    public ResponseEntity<SubscriptionReadDto> createSubscription(@Valid @RequestBody SubscriptionCUDto dto) {
        SubscriptionReadDto createdSubscription = subscriptionService.createSubscription(dto);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    // GET /api/subscriptions/{id} - Get a subscription by its ID
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionReadDto> getSubscription(@PathVariable int id) {
        SubscriptionReadDto subscription = subscriptionService.getSubscription(id);
        return ResponseEntity.ok(subscription);
    }

    // GET /api/subscriptions - Get all subscriptions
    @GetMapping
    public ResponseEntity<List<SubscriptionReadDto>> getAllSubscriptions() {
        List<SubscriptionReadDto> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    // GET /api/subscriptions/user/{userId} - Get subscriptions by internal user ID string
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SubscriptionReadDto>> getSubscriptionsByUser(@PathVariable String userId) {
        List<SubscriptionReadDto> subscriptions = subscriptionService.getSubscriptionsByUser(userId);
        return ResponseEntity.ok(subscriptions);
    }

    // PUT /api/subscriptions/{id} - Update an existing subscription
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionReadDto> updateSubscription(
            @PathVariable int id,
            @Valid @RequestBody SubscriptionCUDto dto) {
        SubscriptionReadDto updatedSubscription = subscriptionService.updateSubscription(id, dto);
        return ResponseEntity.ok(updatedSubscription);
    }

    // DELETE /api/subscriptions/{id} - Delete a subscription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // PATCH /api/subscriptions/{id}/activate - Activate a subscription
    @PatchMapping("/{id}/activate")
    public ResponseEntity<SubscriptionReadDto> activateSubscription(@PathVariable int id) {
        SubscriptionReadDto activatedSubscription = subscriptionService.activateSubscription(id);
        return ResponseEntity.ok(activatedSubscription);
    }

    // PATCH /api/subscriptions/{id}/cancel - Cancel a subscription
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<SubscriptionReadDto> cancelSubscription(@PathVariable int id) {
        SubscriptionReadDto cancelledSubscription = subscriptionService.cancelSubscription(id);
        return ResponseEntity.ok(cancelledSubscription);
    }
}