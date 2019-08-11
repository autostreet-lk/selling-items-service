package lk.autostreet.services.core.service.impl;

import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.model.Item;
import lk.autostreet.services.core.repository.ItemRepository;
import lk.autostreet.services.core.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    //    @Override
//    public Item create(@Valid Item item) throws NotCreatedException {
//        return null;
//    }
    private ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item create(@Valid Item item) throws NotCreatedException {
        if (item == null) {
            throw new NotCreatedException("selling item is required");
        }
        item.setType("SPARE_PART");
        return repository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
