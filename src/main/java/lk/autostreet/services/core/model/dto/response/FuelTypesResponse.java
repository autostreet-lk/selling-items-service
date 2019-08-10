package lk.autostreet.services.core.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class FuelTypesResponse implements Serializable {

    @JsonProperty("fuels")
    private List<KeyValuePairItem> items;
}
