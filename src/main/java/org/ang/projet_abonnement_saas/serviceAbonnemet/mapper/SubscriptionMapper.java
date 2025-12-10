package org.ang.projet_abonnement_saas.serviceAbonnemet.mapper;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.SubscriptionReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubscriptionMapper {
    Subscription toEntity(SubscriptionCUDto subscriptionCUDto);

    SubscriptionReadDto toDto(Subscription subscription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Subscription partialUpdate(SubscriptionCUDto subscriptionCUDto, @MappingTarget Subscription subscription);
}