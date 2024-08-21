package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.Estore.dto.reponse.OrderResponse;
import com.Estore.dto.request.OrderRequest;
import com.Estore.entity.Orders;

@Mapper(componentModel = "Spring")
public interface OrderMapper {
	
	OrderResponse toOrderResponse(Orders request);
}
