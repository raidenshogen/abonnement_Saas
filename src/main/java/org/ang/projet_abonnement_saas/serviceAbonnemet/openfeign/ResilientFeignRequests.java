package org.ang.projet_abonnement_saas.serviceAbonnemet.openfeign;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResilientFeignRequests {
    private final ClientFeignRequest clientFeignRequest;

    public ResilientFeignRequests(ClientFeignRequest clientFeignRequest) {
        this.clientFeignRequest = clientFeignRequest;
    }


    @CircuitBreaker(name = "customer-service", fallbackMethod = "getClientByIdFallback")
    @Retry(name = "customer-service")
    public ResponseEntity<ClientDto> getClientById(String customerIdStr) {
        try {

            UUID customerIdUuid = UUID.fromString(customerIdStr);
            return clientFeignRequest.getClientById(customerIdUuid);
        } catch (IllegalArgumentException e) {

            throw new RuntimeException("Invalid customer ID format: " + customerIdStr, e);
        } catch (FeignException e) {
            throw e;
        }
    }

    private ResponseEntity<ClientDto> getClientByIdFallback(String customerIdStr, Exception ex) {
        throw new RuntimeException("Customer service (customer-service) is not available for ID: " + customerIdStr + ". Error: " + ex.getMessage(), ex);
    }
}