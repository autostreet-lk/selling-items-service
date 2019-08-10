package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;

import java.io.Serializable;

public interface ResponseTransformer<E, D extends Serializable> {
    D createFrom(E e) throws TransformException;
}