package lk.autostreet.services.core.repository;

import lk.autostreet.services.core.model.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

//    List<Item> findItemsBySellerAndType(Seller seller, String type, Pageable pageable);
}
