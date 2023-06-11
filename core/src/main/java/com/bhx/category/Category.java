package com.bhx.category;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.List;
import java.util.function.Function;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



import com.bhx.shared.SelfValidating;

import jakarta.annotation.Generated;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Category extends SelfValidating<Category> implements Serializable{
	@Id
	private String id;
	@Nullable
	private String parentId;

	@NotEmpty
	private String name;

	@NotEmpty
	private String href;

	@Nullable
	private List<String> keywords;

	private Boolean available;


	public Category(@Nullable String parentId, String name, @Nullable List<String> keywords, Boolean available) {
		this.parentId = parentId;
		this.name = name;
		this.keywords = keywords;
		this.available = available;
		this.href = convertToSlug(name);
	}



	public static String convertToSlug(String input) {
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD); // Normalize the string
		normalized = normalized.replaceAll("[^\\p{ASCII}]", ""); // Remove non-ASCII characters
		normalized = normalized.toLowerCase(); // Convert to lowercase
		normalized = normalized.replaceAll("\\s", "-"); // Replace spaces with hyphens
		normalized = normalized.replaceAll("[^a-z0-9-]", ""); // Remove non-alphanumeric characters except hyphens
		return normalized;
	}
}
