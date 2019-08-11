package lk.autostreet.services.core.model.dto.request;

import lk.autostreet.services.core.model.SparePartCondition;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class AddNewSparePartRequest extends AddNewItemRequest {

    @NotNull(message = "spare part condition is required")
    private SparePartCondition condition;
}
