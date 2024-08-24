package com.Estore.mapper;

import org.mapstruct.Mapper;
import com.Estore.dto.reponse.OrderResponse;
import com.Estore.entity.Orders;

@Mapper(componentModel = "Spring")
public interface OrderMapper {
	
	OrderResponse toOrderResponse(Orders request);
}
