package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.*;
import lk.autostreet.services.core.model.dto.request.AddNewItemRequest;
import lk.autostreet.services.core.model.dto.request.AddNewSparePartRequest;
import lk.autostreet.services.core.model.dto.request.AddNewVehicleRequest;
import lk.autostreet.services.core.model.dto.response.AddNewItemResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AddNewItemTransformer implements Transformer<Item, AddNewItemRequest, AddNewItemResponse> {

    private Map<String, Long> params;

    public AddNewItemTransformer(Map<String, Long> params) {
        this.params = params;
    }

    @Override
    public Item createFrom(AddNewItemRequest dto) throws TransformException {
        if (dto == null) {
            throw new TransformException("instance of AddNewItemRequest is required");
        }
        if (dto instanceof AddNewVehicleRequest) {
            log.debug("request to add new vehicle");
            return createVehicle((AddNewVehicleRequest) dto);
        } else if (dto instanceof AddNewSparePartRequest) {
            log.debug("add new spare part request");
            return createSparePart((AddNewSparePartRequest) dto);
        }
        throw new TransformException("request type is not supported");
    }

    @Override
    public AddNewItemResponse createFrom(Item item) {
        return AddNewItemResponse.builder()
                .id(item.getId())
                .build();
    }


    private Vehicle createVehicle(AddNewVehicleRequest request) {

//        VehicleModel vehicleModel = new VehicleModel();
//        vehicleModel.setId(request.getModelId());
//
//        Seller company = new Seller();
//        company.setId(params.get("seller_id"));
//
        ItemCategory category = new ItemCategory();
        category.setId(request.getCategory());
//
//        ItemCondition itemCondition = new ItemCondition();
//        itemCondition.setId(request.getItemCondition());
//
//        City city = new City();
//        city.setId(request.getCityId());

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel(request.getModel());
        vehicle.setSeller(params.get("seller_id"));
        vehicle.setCity(request.getCity());
        vehicle.setTitle(request.getTitle());
        vehicle.setManufacturerYear(request.getYear());
        vehicle.setDescription(request.getDescription());
        vehicle.setStatus(ItemStatus.PENDING);
        vehicle.setItemCategory(category);
        vehicle.setPrice(request.getPrice());
        vehicle.setTransmission(request.getTransmission());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setMillage(request.getMillage());
        vehicle.setCondition(request.getCondition());
        vehicle.setEngineCapacity(request.getEngineCapacity());

        return vehicle;
    }


    private SparePart createSparePart(AddNewSparePartRequest request) {

//        VehicleModel vehicleModel = new VehicleModel();
//        vehicleModel.setId(request.getModelId());
//
//        Seller seller = new Seller();
//        seller.setId(params.get("seller_id"));
//
//        ItemCondition itemCondition = new ItemCondition();
//        itemCondition.setId(request.getItemCondition());
//
//        ItemCategory itemCategory =  new ItemCategory();
//        itemCategory.setId(request.getItemCategory());
//
//        City city = new City();
//        city.setId(request.getCityId());

        log.info("new spare part request [{}]  [{}] ", request.toString(), request.getTitle());

        ItemCategory category = new ItemCategory();
        category.setId(request.getCategory());


        SparePart sparePart = new SparePart();
        sparePart.setVehicleModel(request.getModel());
        sparePart.setSeller(params.get("seller_id"));
        sparePart.setCity(request.getCity());
        sparePart.setTitle(request.getTitle());
        sparePart.setDescription(request.getDescription());
        sparePart.setStatus(ItemStatus.PENDING);
        sparePart.setPrice(request.getPrice());
        sparePart.setItemCategory(category);
        sparePart.setCondition(request.getCondition());

        log.info("spare part [{}] [{}]", sparePart.toString(), sparePart.getTitle());
        return sparePart;
    }

}
