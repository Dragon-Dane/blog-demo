package com.demo.biozid.dtos;


import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostDto {

	private Long id;

	@NotEmpty
	private String title;

	@NotNull
	@Min(value = 0,message = "Select Location")
	private Long location;

	private Boolean marked = false;
}
