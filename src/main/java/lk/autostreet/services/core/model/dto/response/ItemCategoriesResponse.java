package lk.autostreet.services.core.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.autostreet.services.core.model.ItemType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ItemCategoriesResponse implements Serializable {

    private ItemType type;

    @JsonProperty("categories")
    private List<CategoryItem> categoryItems;
}
