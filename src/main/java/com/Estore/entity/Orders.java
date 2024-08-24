package com.Estore.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private LocalDate orderDate;	

	@OneToMany(mappedBy = "order")
	private Set<OrderDetails> listorderDetails;
}
