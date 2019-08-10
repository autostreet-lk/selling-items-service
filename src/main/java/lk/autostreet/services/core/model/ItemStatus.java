package lk.autostreet.services.core.model;

public enum ItemStatus {

    PENDING("PENDING"),
    APPROVED("APPROVED"),
    SUSPENDED("SUSPENDED"),
    REMOVED("REMOVED"),
    SOLD("SOLD");

    private String status;

    ItemStatus(String status) {
        this.status = status;
    }
}
