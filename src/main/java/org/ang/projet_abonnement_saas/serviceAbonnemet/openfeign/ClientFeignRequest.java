package org.ang.projet_abonnement_saas.serviceAbonnemet.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "customer-service", contextId = "clientFeignRequest")
public interface ClientFeignRequest {
    @GetMapping("/api/customers/{id}")
    ResponseEntity<ClientDto> getClientById(@PathVariable("id") UUID id);

}
