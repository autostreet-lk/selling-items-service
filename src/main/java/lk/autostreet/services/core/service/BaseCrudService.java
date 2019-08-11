package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.AlreadyRegisteredException;
import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.exception.NotCreatedException;

import java.util.List;
import java.util.Optional;

public interface BaseCrudService<T, PK> {

    <E extends AppGenericException> T create(T t) throws E;

    Optional<T> findById(PK id);

    List<T> findAll();

    void delete(PK id);
}
