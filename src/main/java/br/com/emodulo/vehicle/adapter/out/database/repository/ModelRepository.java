package br.com.emodulo.vehicle.adapter.out.database.repository;

import br.com.emodulo.vehicle.adapter.out.database.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
