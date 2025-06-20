package br.com.emodulo.vehicle.adapter.out.database;

import br.com.emodulo.vehicle.adapter.out.database.entity.MakeEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.ModelEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import br.com.emodulo.vehicle.adapter.out.database.repository.VehicleJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VehicleDatabaseAdapterTest {

    @Autowired
    private VehicleJpaRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldSaveVehicle() {
        ModelEntity model = createAndPersistModel();
        VehicleEntity vehicle = createVehicle(model);

        VehicleEntity saved = repository.save(vehicle);

        assertNotNull(saved.getId());
        assertEquals(vehicle.getVersion(), saved.getVersion());
    }

    @Test
    void shouldFindById() {
        ModelEntity model = createAndPersistModel();
        VehicleEntity vehicle = repository.save(createVehicle(model));

        Optional<VehicleEntity> found = repository.findById(vehicle.getId());

        assertTrue(found.isPresent());
        assertEquals(vehicle.getId(), found.get().getId());
    }

    @Test
    void shouldFindAllPaged() {
        ModelEntity model = createAndPersistModel();
        repository.save(createVehicle(model));
        repository.save(createVehicle(model));

        Page<VehicleEntity> page = repository.findAll(PageRequest.of(0, 10));

        assertEquals(2, page.getTotalElements());
    }

    @Test
    void shouldFindByIsSold() {
        ModelEntity model = createAndPersistModel();

        VehicleEntity v1 = createVehicle(model);
        v1.setIsSold(true);
        repository.save(v1);

        VehicleEntity v2 = createVehicle(model);
        v2.setIsSold(false);
        repository.save(v2);

        Page<VehicleEntity> soldTrue = repository.findByIsSold(true, PageRequest.of(0, 10));
        Page<VehicleEntity> soldFalse = repository.findByIsSold(false, PageRequest.of(0, 10));

        assertEquals(1, soldTrue.getTotalElements());
        assertEquals(1, soldFalse.getTotalElements());
    }

    @Test
    void shouldDeleteById() {
        ModelEntity model = createAndPersistModel();
        VehicleEntity vehicle = repository.save(createVehicle(model));

        repository.deleteById(vehicle.getId());

        Optional<VehicleEntity> found = repository.findById(vehicle.getId());
        assertFalse(found.isPresent());
    }

    @Test
    void shouldCheckExistenceById() {
        ModelEntity model = createAndPersistModel();
        VehicleEntity vehicle = repository.save(createVehicle(model));

        boolean exists = repository.existsById(vehicle.getId());

        assertTrue(exists);
    }

    private ModelEntity createAndPersistModel() {
        MakeEntity make = new MakeEntity();
        make.setName("Chevrolet");
        entityManager.persist(make);

        ModelEntity model = new ModelEntity();
        model.setName("Onix");
        model.setBrand(make);
        entityManager.persist(model);

        return model;
    }

    private VehicleEntity createVehicle(ModelEntity model) {
        VehicleEntity v = new VehicleEntity();
        v.setVersion("1.0 LT");
        v.setYearFabrication(2022);
        v.setYearModel(2023);
        v.setOdometer(15000);
        v.setColor("Preto");
        v.setBodyType("Hatch");
        v.setTransmission("Manual");
        v.setIsArmored(false);
        v.setPrice(new java.math.BigDecimal("75000.00"));
        v.setIsSold(false);
        v.setModel(model);
        return v;
    }
}