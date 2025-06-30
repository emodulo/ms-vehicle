package br.com.emodulo.vehicle.adapter.out.database.repository;

import br.com.emodulo.vehicle.adapter.out.database.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelJpaRepository extends JpaRepository<ModelEntity, Long> {
}

