package lk.autostreet.services.core.model;

import lombok.Getter;

@Getter
public enum FuelType {

    DIESEL("diesel"),
    PETROL("petrol"),
    HYBRID("Hybrid"),
    ELECTRICAL("electrical");

    private String value;

    FuelType(String value) {
        this.value = value;
    }
}
