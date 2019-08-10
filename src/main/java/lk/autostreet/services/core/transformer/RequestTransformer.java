package lk.autostreet.services.core.transformer;

import java.io.Serializable;

public interface RequestTransformer<E, D extends Serializable> {

    E createFrom(D dto);
}