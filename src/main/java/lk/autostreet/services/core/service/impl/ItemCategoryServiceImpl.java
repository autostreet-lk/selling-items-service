package lk.autostreet.services.core.service.impl;

import com.netflix.discovery.converters.Auto;
import lk.autostreet.services.core.exception.AlreadyRegisteredException;
import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.model.ItemCategory;
import lk.autostreet.services.core.model.ItemType;
import lk.autostreet.services.core.repository.ItemCategoryRepository;
import lk.autostreet.services.core.service.ItemCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private ItemCategoryRepository repository;

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemCategory> findItemCategoriesByType(ItemType type) {
        return repository.findByType(type);
    }

    @Override
    public  ItemCategory create(ItemCategory itemCategory) throws AppGenericException {
        return null;
    }

    @Override
    public Optional<ItemCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ItemCategory> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
