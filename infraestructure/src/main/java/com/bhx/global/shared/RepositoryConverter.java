package com.bhx.global.shared;

import com.bhx.product.Product;
import com.bhx.product.persistence.entities.ProductEntity;

import java.io.Serializable;

public interface RepositoryConverter<T extends Serializable, P extends Serializable> {

	default T mapToTable(final P persistenceObject) {
		throw new UnsupportedOperationException();
	}

	default P mapToEntity(final T tableObject) {
		throw new UnsupportedOperationException();
	}


}
