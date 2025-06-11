package br.com.emodulo.vehicle.adapter.out.database.mapper;

import java.util.List;

public interface Mappable<E, D> {
        E fromDomain(D domain);

        D toDomain(E entity);

        List<D> toDomain(List<E> entities);
        }