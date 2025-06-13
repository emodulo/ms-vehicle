package br.com.emodulo.vehicle.adapter.in.api.mapper;

import java.util.List;

public interface Mappable <DTO, Domain> {

    DTO toDto(Domain domain);

    Domain toDomain(DTO dto);

    List<DTO> toDto(List<Domain> dto);
}
