package com.demo.biozid.dtos;


import lombok.Data;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
@Data
public class PostDto {

	private Long id;

	@NotEmpty
	private String title;

	@NotEmpty
	private Long location;

	@AssertTrue
	private Boolean marked;

}
