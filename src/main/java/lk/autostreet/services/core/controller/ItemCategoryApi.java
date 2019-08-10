package lk.autostreet.services.core.controller;

import lk.autostreet.services.core.model.ItemType;
import lk.autostreet.services.core.model.dto.response.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lk.autostreet.services.core.config.AppConfig.VERSION;

@RestController
public interface ItemCategoryApi {

    @GetMapping(value = "/items/categories", headers = "X-Api-Version=" + VERSION)
    ItemCategoriesResponse getItemCategories(@RequestParam("type") ItemType itemType);
}
