package com.bhx.category.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class CategoryEntity implements Serializable {
	@Id
	private String id;
	@NotEmpty
	private String name;
	@Nullable
	private String parentId;
	@Nullable
	private List<String> keywords;
	@NotEmpty
	private String href;
	private Boolean available;
}
