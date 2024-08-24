package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.request.OrderDetailsRequest;
import com.Estore.entity.OrderDetails;

@Mapper(componentModel = "Spring")
public interface OrderDetailsMapper {
	OrderDetails toOrderDetails(OrderDetailsRequest request);
	
	OrderDetailsResponse toOrderDetailsResponse(OrderDetails request);

	OrderDetails updateDetails(@MappingTarget OrderDetails orderDetails, OrderDetailsRequest request);
}
