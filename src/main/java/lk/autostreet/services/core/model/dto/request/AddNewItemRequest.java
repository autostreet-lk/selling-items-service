package lk.autostreet.services.core.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lk.autostreet.services.core.model.ItemType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "item_type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddNewSparePartRequest.class, name = "SPARE_PART"),
        @JsonSubTypes.Type(value = AddNewVehicleRequest.class, name = "VEHICLE")
})
public class AddNewItemRequest extends RequestBody {

//    @NotEmpty(message = "title is required")
    private String title;

    private String description;

    @NotNull(message = "price is required")
    @Min(value = 1, message = "invalid price")
    private Double price;

    @NotNull(message = "selling item type is required (e.g:- VEHICLE | SPARE_PART )")
    @JsonProperty("item_type")
    private ItemType type;

    @NotNull(message = "item category is required")
    @JsonProperty("item_category")
    private Long category;

//    @NotEmpty(message = "at least one contact number is required")
//    @JsonProperty("contacts")
//    private List<String> contactNumbers;

    @NotNull(message = "vehicle model is required")
    @JsonProperty("model")
    @Min(value = 1, message = "invalid vehicle model")
    private Long model;

//    @NotNull(message = "item condition is required")
//    @Min(value = 1, message = "invalid item condition")
//    @JsonProperty("condition")
//    private Long condition;

    @NotNull(message = "city is required")
    @Min(value = 1, message = "invalid city")
    @JsonProperty("city")
    private Long city;
}
