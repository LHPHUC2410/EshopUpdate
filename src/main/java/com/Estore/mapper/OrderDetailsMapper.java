package com.Estore.mapper;

import org.mapstruct.Mapper;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.request.OrderDetailsRequest;
import com.Estore.entity.OrderDetails;

@Mapper(componentModel = "Spring")
public interface OrderDetailsMapper {
	OrderDetails toOrderDetails(OrderDetailsRequest request);
	
	OrderDetailsResponse toOrderDetailsResponse(OrderDetails request);
}
