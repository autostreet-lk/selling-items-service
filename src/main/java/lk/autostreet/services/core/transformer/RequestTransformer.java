package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;

import java.io.Serializable;

public interface RequestTransformer<E, D extends Serializable> {

    E createFrom(D dto) throws TransformException;
}