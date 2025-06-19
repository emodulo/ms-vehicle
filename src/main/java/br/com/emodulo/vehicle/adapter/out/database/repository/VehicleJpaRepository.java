package br.com.emodulo.vehicle.adapter.out.database.repository;

import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByIsSoldFalseOrderByPriceAsc();
    List<VehicleEntity> findByIsSoldTrueOrderByPriceAsc();
}
