package com.lilium.springangular;

import com.lilium.springangular.dto.VehicleDTO;
import com.lilium.springangular.service.VehicleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VehicleServiceIntegrationTest {

    @Autowired
    public VehicleService service;

    @Test
    void testVehicleCRUDL() {
        final VehicleDTO dto = new VehicleDTO();
        dto.setNumber("Vehicle test number");

        final VehicleDTO savedVehicle = service.save(dto);
        Assertions.assertThat(savedVehicle).isNotNull();
        Assertions.assertThat(savedVehicle.getId()).isNotNull();
        Assertions.assertThat(savedVehicle.getCreated()).isNotNull();
        Assertions.assertThat(savedVehicle.getModified()).isNotNull();
        Assertions.assertThat(savedVehicle.getNumber()).isEqualTo(dto.getNumber());

        final VehicleDTO vehicleById = service.getById(savedVehicle.getId());
        Assertions.assertThat(vehicleById).isNotNull();
        Assertions.assertThat(vehicleById)
                .extracting(
                        VehicleDTO::getId,

                        VehicleDTO::getNumber
                )
                .contains(
                        savedVehicle.getId(),
                        savedVehicle.getNumber()
                );

        final List<VehicleDTO> vehicles = service.list();
        Assertions.assertThat(vehicles).isNotNull();
        Assertions.assertThat(vehicles).hasSize(1);

        savedVehicle.setNumber("New vehicle number");
        VehicleDTO updatedVehicle = service.save(savedVehicle);
        Assertions.assertThat(updatedVehicle).isNotNull();
        Assertions.assertThat(updatedVehicle.getNumber()).isEqualTo(savedVehicle.getNumber());
        Assertions.assertThat(updatedVehicle.getModified()).isAfter(savedVehicle.getModified());

        final Boolean deleted = service.delete(vehicleById.getId());
        Assertions.assertThat(deleted).isTrue();
        Assertions.assertThat(service.getById(savedVehicle.getId())).isNull();

        Assertions.assertThat(service.delete(savedVehicle.getId())).isFalse();
    }

}
