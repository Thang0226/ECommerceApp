package java_source.controller.product_control.sort;

import java_source.model.product.Product;

import java.util.List;

public class SortByID implements SortStrategy {
	@Override
	public void sort(List<Product> list) {
		// Insertion sort
		int n = list.size();
		for (int i = 0; i < n; i++) {
			int pos = i;
			Product temp = list.get(i);
			while (pos > 0 && temp.getId() < list.get(pos - 1).getId()) {
				list.set(pos, list.get(pos - 1));
				pos--;
			}
			list.set(pos, temp);
		}
	}
}
