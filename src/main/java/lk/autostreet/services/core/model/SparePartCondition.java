package lk.autostreet.services.core.model;

import lombok.Getter;

@Getter
public enum SparePartCondition {

    BRAND_NEW("Brand New"),
    USED("Used");

    private String value;

    SparePartCondition(String value) {
        this.value = value;
    }
}
