package br.com.emodulo.vehicle.adapter.in.api.controller;

import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleResponseDTO;
import br.com.emodulo.vehicle.adapter.in.api.handler.VehicleExceptionHandler;
import br.com.emodulo.vehicle.adapter.in.api.mapper.VehicleDtoMapper;
import br.com.emodulo.vehicle.domain.exception.VehicleNotFoundException;
import br.com.emodulo.vehicle.domain.model.Make;
import br.com.emodulo.vehicle.domain.model.Model;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class VehicleControllerTest {

    @InjectMocks
    private VehicleController controller;

    private MockMvc mockMvc;

    @Mock
    private VehicleUseCasePort service;

    @Mock
    private VehicleDtoMapper mapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new VehicleExceptionHandler())
                .build();
    }

    @Test
    void shouldGetVehicleById() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "1.0", 2022, 2023, 15000, "Preto", "Hatch", "Manual", false,
                new java.math.BigDecimal("70000.00"), false,
                new Model(1L, "Onix", new Make(1L, "Chevrolet")));

        VehicleResponseDTO dto = new VehicleResponseDTO(1L, "1.0", 2022, 2023, 15000, "Preto", "Hatch",
                "Manual", false, new java.math.BigDecimal("70000.00"), false, "Onix", "Chevrolet");

        when(service.getById(1L)).thenReturn(vehicle);
        when(mapper.toResponseDTO(vehicle)).thenReturn(dto);

        mockMvc.perform(get("/vehicles/1")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void shouldReturnNotFoundIfVehicleDoesNotExist() throws Exception {
        when(service.getById(99L)).thenThrow(new VehicleNotFoundException("Vehicle not found"));

        mockMvc.perform(get("/vehicles/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle(null, "1.0", 2022, 2023, 10000, "Prata", "Hatch", "Manual", false,
                new java.math.BigDecimal("60000.00"), false, new Model(1L, "Onix", null));

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(1L, "1.0", 2022, 2023, 10000, "Prata",
                "Hatch", "Manual", false, new java.math.BigDecimal("60000.00"), false, "Onix", "Chevrolet");

        when(mapper.toDomain(any())).thenReturn(vehicle);
        when(service.create(vehicle)).thenReturn(vehicle);
        when(mapper.toResponseDTO(vehicle)).thenReturn(responseDTO);

        String json = "{\"version\":\"1.0\",\"yearFabrication\":2022,\"yearModel\":2023,\"odometer\":10000,\"color\":\"Prata\",\"bodyType\":\"Hatch\",\"transmission\":\"Manual\",\"isArmored\":false,\"price\":60000.00,\"isSold\":false,\"modelId\":1}";

        mockMvc.perform(post("/vehicles")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version").value("1.0"));
    }

    @Test
    void shouldUpdateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "1.6", 2022, 2023, 20000, "Branco", "Sedã", "Automática", false,
                new java.math.BigDecimal("85000.00"), false, new Model(1L, "Onix", null));

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(1L, "1.6", 2022, 2023, 20000, "Branco",
                "Sedã", "Automática", false, new java.math.BigDecimal("85000.00"), false, "Onix", "Chevrolet");

        when(mapper.toDomain(any())).thenReturn(vehicle);
        when(service.update(eq(1L), any())).thenReturn(vehicle);
        when(mapper.toResponseDTO(vehicle)).thenReturn(responseDTO);

        String json = "{\"version\":\"1.6\",\"yearFabrication\":2022,\"yearModel\":2023,\"odometer\":20000,\"color\":\"Branco\",\"bodyType\":\"Sedã\",\"transmission\":\"Automática\",\"isArmored\":false,\"price\":85000.00,\"isSold\":false,\"modelId\":1}";

        mockMvc.perform(put("/vehicles/1")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version").value("1.6"));
    }

    @Test
    void shouldDeleteVehicle() throws Exception {
        when(service.getById(99L)).thenThrow(new VehicleNotFoundException("Vehicle not found with id " + 99L));

        mockMvc.perform(get("/vehicles/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldMarkVehicleAsSold() throws Exception {
        Vehicle soldVehicle = new Vehicle(1L, "1.0", 2022, 2023, 10000, "Prata", "Hatch", "Manual", false,
                new java.math.BigDecimal("60000.00"), true, new Model(1L, "Onix", new Make(1L, "Chevrolet")));

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(1L, "1.0", 2022, 2023, 10000, "Prata",
                "Hatch", "Manual", false, new java.math.BigDecimal("60000.00"), true, "Onix", "Chevrolet");

        when(service.markAsSold(1L)).thenReturn(soldVehicle);
        when(mapper.toResponseDTO(soldVehicle)).thenReturn(responseDTO);

        mockMvc.perform(patch("/vehicles/1/sell"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isSold").value(true));
    }
}