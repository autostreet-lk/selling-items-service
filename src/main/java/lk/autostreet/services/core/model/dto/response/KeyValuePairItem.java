package lk.autostreet.services.core.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class KeyValuePairItem implements Serializable {

    private Object key;
    private Object value;
}
