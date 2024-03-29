package lk.autostreet.services.core.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CategoryItem implements Serializable {

    private Long id;
    private String name;
}
