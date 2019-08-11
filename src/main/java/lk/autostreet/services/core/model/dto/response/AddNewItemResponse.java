package lk.autostreet.services.core.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddNewItemResponse extends ResponseBody {

    private Long id;
}
