package lk.autostreet.services.core.controller;

import static lk.autostreet.services.core.config.AppConfig.VERSION;

import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.model.Item;
import lk.autostreet.services.core.model.dto.request.AddNewItemRequest;
import lk.autostreet.services.core.model.dto.response.AddNewItemResponse;
import lk.autostreet.services.core.service.ItemService;
import lk.autostreet.services.core.transformer.AddNewItemTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@RestController
public class ItemController implements ItemApi {

    private ItemService itemService;
//    private ItemConditionService itemConditionService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @PostMapping(value = "/sellers/{seller-id}/items", headers = "X-Api-Version=" + VERSION)
    public AddNewItemResponse addNewSellingItem(@PathVariable("seller-id") Long sellerId,
                                                @Validated @RequestBody AddNewItemRequest requestBody,
                                                BindingResult bindingResult) throws AppGenericException {

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.error("bad request to add new selling item. error is [{}] ", message);
            throw new NotCreatedException(message);
        }

        Map<String, Long> params = new HashMap<>();
        params.put("seller_id", sellerId);

        AddNewItemTransformer transformer = new AddNewItemTransformer(params);

        log.debug("start to add new selling item [{}] for the seller [{}]", requestBody.getType(), sellerId);
        Item item = transformer.createFrom(requestBody);
        log.info("item [{}] ", item.toString());
        log.debug("item [{}] ", item.toString());

        Item itemAdded = itemService.create(item);

        return transformer.createFrom(itemAdded);
    }

//
//    @GetMapping(value = "/sellers/{seller-id}/items", headers = "X-Api-Version=" + VERSION)
//    public ItemSummaryListResponse getItemsBySeller(@PathVariable("seller-id") Long sellerId,
//                                                    @RequestParam("type") String type,
//                                                    @RequestParam("page") int page,
//                                                    @RequestParam("size") int size) throws SellerNotFoundException {
//        List<Item> itemList = itemService.findItemBySellers(sellerId, type, page, size);
//        ItemSummaryListResponseTransformer transformer = new ItemSummaryListResponseTransformer();
//        return transformer.createFrom(itemList);
//    }
//
//
//    @Override
//    @PutMapping(value = "/sellers/{seller-id}/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    public UpdateItemResponse updateSellingItem(@PathVariable("seller-id") Long sellerId,
//                                                @PathVariable("item-id") Long itemId,
//                                                @Validated @RequestBody UpdateItemRequest requestBody,
//                                                BindingResult bindingResult) throws ItemNotUpdatedException, ItemNotFoundException {
//
//        Map<String, Long> params = new HashMap<>();
//        params.put("seller_id", sellerId);
//        params.put("item_id", itemId);
//
//        UpdateItemTransformer itemTransformer = new UpdateItemTransformer(params);
//        Item item = itemTransformer.createFrom(requestBody);
//
//        Item itemUpdated = itemService.update(item);
//        return itemTransformer.createFrom(itemUpdated);
//    }
//
//
//    @PutMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    public void updateSellingItemStatus(@PathVariable("item-id") Long itemId,
//                                        @RequestParam("status") ItemStatus status) throws ItemNotUpdatedException, ItemNotFoundException {
//        itemService.updateItemStatus(itemId, status);
//    }
//
//
//    @GetMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    public ItemDetailsResponse getItemDetailsById(@PathVariable("item-id") Long itemId) throws ItemNotFoundException {
//
//        Item item = itemService.getById(itemId);
//
//        ItemDetailsResponseTransformer transformer = new ItemDetailsResponseTransformer();
//        return transformer.createFrom(item);
//    }
//
//
//    @Override
//    @PostMapping(value = "/items/{item-id}/images", headers = "X-Api-Version=" + VERSION)
//    public void uploadImagesForSellingItem(@PathVariable("item-id") Long itemId,
//                                           @RequestPart("images") MultipartFile[] multipartFiles)
//            throws ItemNotFoundException, ItemImageNotAddedException {
//        log.debug("request to upload [{}]  images for item [{}] ", multipartFiles.length, itemId);
//        itemService.addImages(itemId, multipartFiles);
//    }
//
//
//    @Override
//    @PutMapping(value = "/items/{item-id}/images/{image-id}", headers = "X-Api-Version=" + VERSION)
//    public UpdateItemResponse updateItemImage(@PathVariable("item-id") Long itemId,
//                                              @PathVariable("image-id") Long imageId,
//                                              @RequestPart("image") MultipartFile multipartFile)
//            throws ItemNotFoundException, ItemImageNotFoundException, ItemImageNotAddedException {
//
//        log.info("updating image [{}]  of item [{}] ", imageId, itemId);
//        ItemImage itemImage = itemService.updateImage(itemId, imageId, multipartFile);
//
//        return UpdateItemResponse.builder()
//                .id(itemImage.getId())
//                .build();
//    }
//
//
//    @Override
//    @DeleteMapping(value = "/items/{item-id}/images/{image-id}", headers = "X-Api-Version=" + VERSION)
//    public void deleteItemImage(@PathVariable("item-id") Long itemId, @PathVariable("image-id") Long imageId)
//            throws ItemNotFoundException, ItemImageNotRemovedException {
//
//        log.debug("request to remove image [{}] of item [{}]", imageId, itemId);
//        itemService.removeImage(itemId, imageId);
//    }
//
//
//    @Override
//    @DeleteMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    public void deleteItem(@PathVariable("item-id") Long itemId) {
//
//        log.debug("request to remove item [{}]", itemId);
//        itemService.delete(itemId);
//    }
//
//    @Override
//    @GetMapping(value = "/items/types", headers = "X-Api-Version=" + VERSION)
//    public ItemTypesResponse getSellingItemTypes() {
//        List<KeyValuePairItem> items = new ArrayList<>();
//
//        for (ItemType itemTypeEnum : ItemType.values()) {
//            KeyValuePairItem item = KeyValuePairItem.builder()
//                    .key(itemTypeEnum)
//                    .value(itemTypeEnum.getType())
//                    .build();
//            items.add(item);
//        }
//        return ItemTypesResponse.builder()
//                .items(items)
//                .build();
//    }
//
//
//    @Override
//    @GetMapping(value = "/items/fuel-types", headers = "X-Api-Version=" + VERSION)
//    public FuelTypesResponse getFuelTypes() {
//
//        List<KeyValuePairItem> items = new ArrayList<>();
//
//        for (FuelType itemTypeEnum : FuelType.values()) {
//            KeyValuePairItem item = KeyValuePairItem.builder()
//                    .key(itemTypeEnum)
//                    .value(itemTypeEnum.getValue())
//                    .build();
//            items.add(item);
//        }
//        return FuelTypesResponse.builder()
//                .items(items)
//                .build();
//    }
//
//
//    @Override
//    @GetMapping(value = "/items/transmissions", headers = "X-Api-Version=" + VERSION)
//    public TransmissionsResponse getTransmissions() {
//
//        List<KeyValuePairItem> items = new ArrayList<>();
//
//        for (TransmissionType itemTypeEnum : TransmissionType.values()) {
//            KeyValuePairItem item = KeyValuePairItem.builder()
//                    .key(itemTypeEnum)
//                    .value(itemTypeEnum.getValue())
//                    .build();
//            items.add(item);
//        }
//        return TransmissionsResponse.builder()
//                .items(items)
//                .build();
//    }
//
//
//    @Override
//    @GetMapping(value = "/items/conditions", headers = "X-Api-Version=" + VERSION)
//    public ItemConditionsResponse getItemConditions(@RequestParam("type") ItemType itemType) {
//
//        List<ItemCondition> itemConditionList = itemConditionService.findItemConditionsByType(itemType);
//        log.debug("[{}] of item conditions found for the item type [{}]", itemConditionList.size(), itemType);
//
//        List<KeyValuePairItem> conditions = new ArrayList<>();
//
//        for (ItemCondition itemCondition : itemConditionList) {
//            KeyValuePairItem item = KeyValuePairItem.builder()
//                    .key(itemCondition.getId())
//                    .value(itemCondition.getName())
//                    .build();
//            conditions.add(item);
//        }
//        return ItemConditionsResponse.builder().items(conditions).build();
//    }
//
//
//    @Override
//    @GetMapping(value = "/items/categories", headers = "X-Api-Version=" + VERSION)
//    public ItemCategoriesResponse getItemCategories(@RequestParam("type") ItemType itemType) {
//
//        List<ItemCategory> itemCategories = itemService.findItemCategoriesByType(itemType);
//
//        List<CategoryItem> categoryItemList = itemCategories.stream().map(itemCategory -> CategoryItem.builder()
//                .id(itemCategory.getId())
//                .name(itemCategory.getName())
//                .build()
//        ).collect(Collectors.toList());
//
//        return ItemCategoriesResponse.builder()
//                .type(itemType)
//                .categoryItems(categoryItemList)
//                .build();
//    }
}
