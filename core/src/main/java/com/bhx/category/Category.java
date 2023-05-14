package com.bhx.category;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



import com.bhx.shared.SelfValidating;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category extends SelfValidating<Category> implements Serializable{
	@NotEmpty
	private String id;

	@NotEmpty
	private String name;
	private String thumbImage;
	private Boolean available;
}
