package br.com.emodulo.vehicle.adapter.out.database.repository;

import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    Page<VehicleEntity> findByIsSold(Boolean isSold, Pageable pageable);
}
