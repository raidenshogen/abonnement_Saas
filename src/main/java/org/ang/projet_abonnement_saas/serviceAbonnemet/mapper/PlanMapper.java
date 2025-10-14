package org.ang.projet_abonnement_saas.serviceAbonnemet.mapper;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.PlanReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Plan;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface PlanMapper {
    Plan toEntity(PlanReadDto planReadDto);

    PlanReadDto toDto(Plan plan);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Plan partialUpdate(PlanReadDto planReadDto, @MappingTarget Plan plan);
}