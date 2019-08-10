package lk.autostreet.services.core.controller;

import lk.autostreet.services.core.model.*;
import lk.autostreet.services.core.model.dto.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lk.autostreet.services.core.config.AppConfig.VERSION;


@Slf4j
@RestController
public class ItemMetaController implements ItemMetaApi {

    @Override
    @GetMapping(value = "/items/types", headers = "X-Api-Version=" + VERSION)
    public ItemTypesResponse getSellingItemTypes() {
        List<KeyValuePairItem> items = new ArrayList<>();

        for (ItemType itemTypeEnum : ItemType.values()) {
            KeyValuePairItem item = KeyValuePairItem.builder()
                    .key(itemTypeEnum)
                    .value(itemTypeEnum.getType())
                    .build();
            items.add(item);
        }
        return ItemTypesResponse.builder()
                .items(items)
                .build();
    }


    @Override
    @GetMapping(value = "/items/fuel-types", headers = "X-Api-Version=" + VERSION)
    public FuelTypesResponse getFuelTypes() {

        List<KeyValuePairItem> items = new ArrayList<>();

        for (FuelType itemTypeEnum : FuelType.values()) {
            KeyValuePairItem item = KeyValuePairItem.builder()
                    .key(itemTypeEnum)
                    .value(itemTypeEnum.getValue())
                    .build();
            items.add(item);
        }
        return FuelTypesResponse.builder()
                .items(items)
                .build();
    }


    @Override
    @GetMapping(value = "/items/transmissions", headers = "X-Api-Version=" + VERSION)
    public TransmissionsResponse getTransmissions() {

        List<KeyValuePairItem> items = new ArrayList<>();

        for (TransmissionType itemTypeEnum : TransmissionType.values()) {
            KeyValuePairItem item = KeyValuePairItem.builder()
                    .key(itemTypeEnum)
                    .value(itemTypeEnum.getValue())
                    .build();
            items.add(item);
        }
        return TransmissionsResponse.builder()
                .items(items)
                .build();
    }




    @Override
    @GetMapping(value = "/items/conditions", headers = "X-Api-Version=" + VERSION)
    public ItemConditionsResponse getItemConditions(@RequestParam("type") ItemType itemType) {

        List<KeyValuePairItem> conditions = new ArrayList<>();

        if (itemType.equals(ItemType.VEHICLE)) {
            for (VehicleCondition vehicleConditionEnum : VehicleCondition.values()) {
                KeyValuePairItem item = KeyValuePairItem.builder()
                        .key(vehicleConditionEnum)
                        .value(vehicleConditionEnum.getValue())
                        .build();
                conditions.add(item);
            }
        } else if (itemType.equals(ItemType.SPARE_PART)) {
            for (SparePartCondition sparePartConditionEnum : SparePartCondition.values()) {
                KeyValuePairItem item = KeyValuePairItem.builder()
                        .key(sparePartConditionEnum)
                        .value(sparePartConditionEnum.getValue())
                        .build();
                conditions.add(item);
            }
        }

        return ItemConditionsResponse.builder()
                .items(conditions)
                .build();
    }
}