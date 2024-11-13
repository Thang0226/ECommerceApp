package java_source.controller.product_control.sort;

import java_source.controller.product_control.sort.SortStrategy;
import java_source.model.product.Product;

import java.util.List;

public class SortContext {
	private SortStrategy sortMethod;

	public SortContext() {
		sortMethod = new SortByID();
	}

	public SortContext(SortStrategy strategy) {
		this.sortMethod = strategy;
	}

	public void setSortMethod(SortStrategy strategy) {
		this.sortMethod = strategy;
	}

	public void sort(List<Product> products) {
		sortMethod.sort(products);
	}
}
