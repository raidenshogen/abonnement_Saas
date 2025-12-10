package org.ang.projet_abonnement_saas.serviceAbonnemet.mapper;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanCUDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PlanMapper {
    Plan toEntity(PlanCUDto dto);

    PlanReadDto toDto(Plan plan);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Plan partialUpdate(PlanCUDto dto, @MappingTarget Plan plan); // ← returns void
}