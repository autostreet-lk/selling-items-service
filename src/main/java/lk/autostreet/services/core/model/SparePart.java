package lk.autostreet.services.core.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper=true)
@Entity
@DiscriminatorValue("SPARE_PART")
public class SparePart extends Item {

    @Enumerated(EnumType.STRING)
    @Column(name = "item_condition")
    private SparePartCondition condition;
}
