package com.Estore.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //null -> khong hien thi
public class OrderDetailsResponse {
	private String id;
	
	private String order_id;
	
	private String product_name;
	
	private int quantity;
}
