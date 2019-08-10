package lk.autostreet.services.core.controller;

import com.netflix.discovery.converters.Auto;
import lk.autostreet.services.core.model.*;
import lk.autostreet.services.core.model.dto.response.*;
import lk.autostreet.services.core.service.ItemCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lk.autostreet.services.core.config.AppConfig.VERSION;

@RestController
public class ItemCategoryController implements ItemCategoryApi {

    private ItemCategoryService categoryService;

    @Autowired
    public ItemCategoryController(ItemCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @GetMapping(value = "/items/categories", headers = "X-Api-Version=" + VERSION)
    public ItemCategoriesResponse getItemCategories(@RequestParam("type") ItemType itemType) {

        //todo refactor the logic to transformer
        List<ItemCategory> itemCategories = categoryService.findItemCategoriesByType(itemType);

        List<CategoryItem> categoryItemList = itemCategories.stream().map(itemCategory -> CategoryItem.builder()
                .id(itemCategory.getId())
                .name(itemCategory.getName())
                .build()
        ).collect(Collectors.toList());

        return ItemCategoriesResponse.builder()
                .type(itemType)
                .categoryItems(categoryItemList)
                .build();
    }

}
