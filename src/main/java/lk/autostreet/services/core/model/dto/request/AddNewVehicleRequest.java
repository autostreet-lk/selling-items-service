package lk.autostreet.services.core.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.autostreet.services.core.model.FuelType;
import lk.autostreet.services.core.model.TransmissionType;
import lk.autostreet.services.core.model.VehicleCondition;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewVehicleRequest extends AddNewItemRequest {

//    @NotNull(message = "vehicle model is required")
//    @JsonProperty("model")
//    @Min(value = 1, message = "invalid vehicle model")
//    protected Long modelId;

    @NotNull(message = "vehicle millage is required")
    private Long millage;

    @NotNull(message = "fuel type is required")
    @JsonProperty("fuel")
    private FuelType fuelType;

    @NotNull(message = "transmission is required")
    private TransmissionType transmission;

    @NotNull(message = "Year of manufacture is required")
    private Integer year;

    @NotNull(message = "engine capacity is required")
    @JsonProperty("engine_capacity")
    private String engineCapacity;

    @NotNull(message = "vehicle condition is required")
    private VehicleCondition condition;

    private String trim;
}

