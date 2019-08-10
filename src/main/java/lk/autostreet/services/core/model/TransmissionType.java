package lk.autostreet.services.core.model;

import lombok.Getter;

@Getter
public enum TransmissionType {

    AUTO("auto"),
    MANUAL("manual"),
    TIPTRONIC("tip-tronic");

    TransmissionType(String transmissionType) {
        this.value = transmissionType;
    }

    private String value;
}
