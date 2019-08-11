package lk.autostreet.services.core.controller;

import static lk.autostreet.services.core.config.AppConfig.VERSION;

import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.model.dto.request.AddNewItemRequest;
import lk.autostreet.services.core.model.dto.response.AddNewItemResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

public interface ItemApi {

    @PostMapping(value = "/sellers/{seller-id}/items", headers = "X-Api-Version=" + VERSION)
    AddNewItemResponse addNewSellingItem(@PathVariable("seller-id") Long sellerId,
                                         @Validated @RequestBody AddNewItemRequest requestBody,
                                         BindingResult bindingResult) throws AppGenericException;
//
//    @GetMapping(value = "/sellers/{seller-id}/items", headers = "X-Api-Version=" + VERSION)
//    ItemSummaryListResponse getItemsBySeller(@PathVariable("seller-id") Long sellerId,
//                                             @RequestParam("type") String type,
//                                             @RequestParam("page") int page,
//                                             @RequestParam("size") int size) throws SellerNotFoundException;
//
//
//    @PostMapping(value = "/items/{item-id}/images", headers = "X-Api-Version=" + VERSION)
//    void uploadImagesForSellingItem(@PathVariable("item-id") Long itemId,
//                                    @RequestPart("images") MultipartFile[] multipartFiles) throws ItemNotFoundException, ItemImageNotAddedException;
//
//
//    @PutMapping(value = "/sellers/{seller-id}/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    UpdateItemResponse updateSellingItem(@PathVariable("seller-id") Long sellerId,
//                                         @PathVariable("item-id") Long itemId,
//                                         @Validated @RequestBody UpdateItemRequest requestBody,
//                                         BindingResult bindingResult) throws ItemNotUpdatedException, ItemNotFoundException;
//
//    @PutMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    void updateSellingItemStatus(@PathVariable("item-id") Long itemId,
//                                 @RequestParam("status") ItemStatus status) throws ItemNotUpdatedException, ItemNotFoundException;
//
//
//    @GetMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    ItemDetailsResponse getItemDetailsById(@PathVariable("item-id") Long itemId) throws ItemNotFoundException;
//
//
//    @PutMapping(value = "/items/{item-id}/images/{image-id}", headers = "X-Api-Version=" + VERSION)
//    UpdateItemResponse updateItemImage(@PathVariable("item-id") Long itemId,
//                                       @PathVariable("image-id") Long imageId,
//                                       @RequestPart("image") MultipartFile multipartFile)
//            throws ItemNotFoundException, ItemImageNotFoundException, ItemImageNotAddedException;
//
//
//    @DeleteMapping(value = "/items/{item-id}/images/{image-id}", headers = "X-Api-Version=" + VERSION)
//    void deleteItemImage(@PathVariable("item-id") Long itemId, @PathVariable("image-id") Long imageId)
//            throws ItemNotFoundException, ItemImageNotRemovedException;
//
//    @DeleteMapping(value = "/items/{item-id}", headers = "X-Api-Version=" + VERSION)
//    void deleteItem(@PathVariable("item-id") Long itemId);
//
//
//    @GetMapping(value = "/items/types", headers = "X-Api-Version=" + VERSION)
//    ItemTypesResponse getSellingItemTypes();
//
//    @GetMapping(value = "/items/fuel-types", headers = "X-Api-Version=" + VERSION)
//    FuelTypesResponse getFuelTypes();
//
//    @GetMapping(value = "/items/transmissions", headers = "X-Api-Version=" + VERSION)
//    TransmissionsResponse getTransmissions();
//
//    @GetMapping(value = "/items/conditions", headers = "X-Api-Version=" + VERSION)
//    ItemConditionsResponse getItemConditions(@RequestParam("type") ItemType itemType);
//
//    @GetMapping(value = "/items/categories", headers = "X-Api-Version=" + VERSION)
//    ItemCategoriesResponse getItemCategories(@RequestParam("type") ItemType itemType);
}
