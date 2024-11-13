package java_source.controller.product_control.sort;

import java_source.model.product.Product;

import java.util.List;

public interface SortStrategy {
	void sort(List<Product> list);
}
