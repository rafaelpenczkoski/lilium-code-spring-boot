package com.lilium.springangular.converter;

import com.lilium.springangular.dto.VehicleDTO;
import com.lilium.springangular.entity.Vehicle;
import org.springframework.stereotype.Component;


@Component
public class VehicleDTOConverter extends AbstractDTOConverter<Vehicle, VehicleDTO> {

    @Override
    public VehicleDTO convert(final Vehicle entity) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        convert(entity, vehicleDTO);

        // entity specific conversion
        vehicleDTO.setNumber(entity.getNumber());
        return vehicleDTO;
    }

}
