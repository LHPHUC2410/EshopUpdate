package com.Estore.dto.reponse;

import java.time.LocalDate;
import java.util.Set;

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
public class OrderResponse {
	private String id;
	private LocalDate orderDate;
	
	private Set<OrderDetailsResponse> orderDetailsResponses;
}
