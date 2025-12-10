package org.ang.projet_abonnement_saas.serviceAbonnemet.service;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionReadDto;
import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    SubscriptionReadDto createSubscription(SubscriptionCUDto dto);

    SubscriptionReadDto getSubscription(int id);

    List<SubscriptionReadDto> getAllSubscriptions();

    List<SubscriptionReadDto> getSubscriptionsByUser(String userId); // Internal user ID

    SubscriptionReadDto updateSubscription(int id, SubscriptionCUDto dto);

    void deleteSubscription(int id);

    SubscriptionReadDto activateSubscription(int id);

    SubscriptionReadDto cancelSubscription(int id);
}