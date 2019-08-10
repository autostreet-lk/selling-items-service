package lk.autostreet.services.core.model;

public enum ItemType {

    VEHICLE("Vehicle"),
    SPARE_PART("Spare Part"),
    ACCESSORY("Accessory");

    private String type;

    ItemType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
