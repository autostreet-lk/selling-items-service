package lk.autostreet.services.core.repository;

import lk.autostreet.services.core.model.ItemCategory;
import lk.autostreet.services.core.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

    List<ItemCategory> findByType(ItemType itemType);
}
