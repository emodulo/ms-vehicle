package br.com.emodulo.vehicle.adapter.out.database.mapper;

import java.util.List;

public interface Mappable<Entity, Domain> {

        Entity toEntity(Domain domain);

        Domain toDomain(Entity entity);

        List<Entity> toEntity(List<Domain> domains);
}