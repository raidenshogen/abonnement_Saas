package org.ang.projet_abonnement_saas.serviceAbonnemet.controller;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usage")
public class UsageRestController {


        @Autowired
        private UsageService usageService;

        @PostMapping
        public ResponseEntity<Usage> recordUsage(@RequestParam int subscriptionId,
                                                 @RequestParam int featureId,
                                                 @RequestParam int usedValue) {
            Usage usage = usageService.recodUsage(subscriptionId, featureId, usedValue);
            return ResponseEntity.ok(usage);
        }

        @GetMapping("/subscription/{subscriptionId}")
        public ResponseEntity<List<Usage>> getUsageBySubscription(@PathVariable int subscriptionId) {
            List<Usage> usages = usageService.getUsageBySubscription(subscriptionId);
            return ResponseEntity.ok(usages);
        }

        @GetMapping("/total")
        public ResponseEntity<Double> getTotalUsage(@RequestParam int subscriptionId,
                                                    @RequestParam int featureId) {
            Double total = usageService.getTotalUsage(subscriptionId, featureId);
            return ResponseEntity.ok(total);
        }

        @PostMapping("/check-limit")
        public ResponseEntity<Boolean> checkUsageLimit(@RequestParam int subscriptionId,
                                                       @RequestParam int featureId) {
            boolean exceeded = usageService.CheckUsageLimit(subscriptionId, featureId);
            return ResponseEntity.ok(exceeded);
        }

        @PostMapping("/reset")
        public ResponseEntity<Void> resetUsage(@RequestParam int subscriptionId,
                                               @RequestParam int featureId) {
            usageService.resetUsage(subscriptionId, featureId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/remaining-quota")
        public ResponseEntity<Double> getRemainingQuota(@RequestParam int subscriptionId,
                                                        @RequestParam int featureId) {
            Double quota = usageService.calculateRemainingQuota(subscriptionId, featureId);
            return ResponseEntity.ok(quota);
        }
}
