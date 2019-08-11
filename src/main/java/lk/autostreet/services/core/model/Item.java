package lk.autostreet.services.core.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "selling_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type",
        discriminatorType = DiscriminatorType.STRING)
@EntityListeners(AuditingEntityListener.class)
public class Item extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long id;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
//    private List<ItemImage> images = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
//    private List<ContactNumber> contactNumberList;

    @NotNull(message = "seller is required")
    @Column(name = "seller_id", nullable = false)
    private Long seller;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @NotEmpty(message = "title is required")
    @Column(nullable = false)
    private String title;

    @NotNull(message = "vehicle model is required")
    @Column(name = "model_id", nullable = false)
    private Long vehicleModel;

//    @NotNull(message = "item condition is required")
//    @ManyToOne
//    @JoinColumn(name = "item_condition")
//    private  itemCondition;

    @NotNull(message = "item category is required")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    @Lob
    private String description;

    @Column(name = "item_type", insertable = false, updatable = false)
    private String type;


    @Column(name = "city_id")
    private Long city;

    private Double price;
}
