package lk.autostreet.services.core.controller;


import lk.autostreet.services.core.model.ItemType;
import lk.autostreet.services.core.model.dto.response.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lk.autostreet.services.core.config.AppConfig.VERSION;

@RestController
public interface ItemMetaApi {

    @GetMapping(value = "/items/types", headers = "X-Api-Version=" + VERSION)
    ItemTypesResponse getSellingItemTypes();


    @GetMapping(value = "/items/fuel-types", headers = "X-Api-Version=" + VERSION)
    FuelTypesResponse getFuelTypes();


    @GetMapping(value = "/items/transmissions", headers = "X-Api-Version=" + VERSION)
    TransmissionsResponse getTransmissions();


    @GetMapping(value = "/items/conditions", headers = "X-Api-Version=" + VERSION)
    ItemConditionsResponse getItemConditions(@RequestParam("type") ItemType itemType);

}
