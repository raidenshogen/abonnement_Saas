package org.ang.projet_abonnement_saas.serviceAbonnemet.mapper;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.dto.FeatureReadDto;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Feature;
import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Usage;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface FeatureMapper {
    Feature toEntity(FeatureReadDto featureReadDto);

    @AfterMapping
    default void linkUsage(@MappingTarget Feature feature) {
        Usage usage = feature.getUsage();
        if (usage != null) {
            usage.setFeature(feature);
        }
    }

    FeatureReadDto toDto(Feature feature);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Feature partialUpdate(FeatureReadDto featureReadDto, @MappingTarget Feature feature);
}