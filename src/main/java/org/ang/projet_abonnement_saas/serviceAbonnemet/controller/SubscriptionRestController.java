package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionRestController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription saved = subscriptionService.CreateSubscription(subscription);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updated = subscriptionService.UpdateSubscriptionStatus(subscription);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelSubscription(@PathVariable int id) {
        Subscription sub = new Subscription();
        sub.setId(id);
        subscriptionService.CancalSubscription(sub);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/renew")
    public ResponseEntity<Subscription> renewSubscription(@PathVariable int id) {
        Subscription sub = new Subscription();
        sub.setId(id);
        Subscription renewed = subscriptionService.RenewSubscription(sub);
        return ResponseEntity.ok(renewed);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Subscription>> getActiveSubscriptions() {
        List<Subscription> active = subscriptionService.getActiveSubscriptions();
        return ResponseEntity.ok(active);
    }
}