package lk.autostreet.services.core.model;

import lombok.Getter;

@Getter
public enum VehicleCondition  {

    BRAND_NEW("Brand New"),
    UNREGISTERED("Reconditioned - Unregistered"),
    REGISTERED("Used - Registered");

    private String value;

    VehicleCondition(String value) {
        this.value = value;
    }
}
