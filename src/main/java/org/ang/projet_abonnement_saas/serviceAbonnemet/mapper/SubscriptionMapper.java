package org.ang.projet_abonnement_saas.serviceAbonnemet.mapper;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubscriptionMapper {

    Subscription toEntity(SubscriptionReadDto subscriptionReadDto);

    @AfterMapping
    default void linkPlans(@MappingTarget Subscription subscription) {
        subscription.getPlans().forEach(plan -> plan.setSubscription(subscription));
    }

    SubscriptionReadDto toDto(Subscription subscription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Subscription partialUpdate(SubscriptionReadDto subscriptionReadDto, @MappingTarget Subscription subscription);


}