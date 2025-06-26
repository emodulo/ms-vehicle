CREATE SCHEMA IF NOT EXISTS vehicle;

CREATE TABLE vehicle.tb_makes (
    make_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE vehicle.tb_models (
    model_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    make_id INT NOT NULL,
    CONSTRAINT fk_model_make FOREIGN KEY (make_id)
        REFERENCES vehicle.tb_makes(make_id)
        ON DELETE CASCADE
);

CREATE TABLE vehicle.tb_vehicles (
    vehicle_id SERIAL PRIMARY KEY,
    version VARCHAR(255),
    yearFabrication INT,
    yearModel INT,
    Odometer INT,
    color VARCHAR(50),
    bodyType VARCHAR(50),
    transmission VARCHAR(50),
    isArmored BOOLEAN,
    price NUMERIC(12, 2),
    isSold BOOLEAN,
    model_id INT NOT NULL,
    CONSTRAINT fk_vehicle_model FOREIGN KEY (model_id)
        REFERENCES vehicle.tb_models(model_id)
        ON DELETE CASCADE
);