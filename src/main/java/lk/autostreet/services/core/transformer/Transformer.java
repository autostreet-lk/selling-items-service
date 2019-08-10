package lk.autostreet.services.core.transformer;

import java.io.Serializable;

public interface Transformer<E, R1 extends Serializable, R2 extends Serializable> extends RequestTransformer<E, R1>, ResponseTransformer<E, R2> {

}