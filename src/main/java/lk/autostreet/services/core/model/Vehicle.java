package lk.autostreet.services.core.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("VEHICLE")
public class Vehicle extends Item {

    @Column(name = "engine_capacity")
    private String engineCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private TransmissionType transmission;

    @Column(name = "manufacture_year")
    private Integer manufacturerYear;

    private Long millage;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_condition")
    private VehicleCondition condition;

    @Column(name = "trim")
    private String trim;
}
