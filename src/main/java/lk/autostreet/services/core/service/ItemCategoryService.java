package lk.autostreet.services.core.service;

import lk.autostreet.services.core.model.ItemCategory;
import lk.autostreet.services.core.model.ItemType;

import java.util.List;

public interface ItemCategoryService extends BaseCrudService<ItemCategory, Long> {

    List<ItemCategory> findItemCategoriesByType(ItemType type);
}
