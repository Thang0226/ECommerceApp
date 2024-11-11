package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.List;

public interface SearchStrategy {
	void search(List<Product> list);
}
