package com.fr.adaming.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExamenDtoCreate {
	
	private int id;
	
	private LocalDate date;
	
	private String type;
	
	private double coefficient;
 

}
