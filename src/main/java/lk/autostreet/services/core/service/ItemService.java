package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.model.Item;
import lk.autostreet.services.core.model.ItemCategory;

import javax.validation.Valid;

public interface ItemService extends BaseCrudService<Item, Long>{

//    Item create(@Valid Item item) throws NotCreatedException;
}
