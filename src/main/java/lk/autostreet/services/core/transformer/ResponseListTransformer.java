package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;

import java.io.Serializable;
import java.util.List;

public interface ResponseListTransformer<E, D extends Serializable> {

    D createFrom(List<E> es) throws TransformException;
}