package java_source.controller.product_control.sort;

import java_source.controller.product_control.sort.SortStrategy;
import java_source.model.product.Product;

import java.util.List;

public class SortByPriceAsc implements SortStrategy {
	@Override
	public void sort(List<Product> list) {
		int n = list.size();
		// Bubble sort (improved with boolean needNextPass)
		boolean needNextPass = true;
		for (int i = 0; i < n - 1 && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
					needNextPass = true;
					Product temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
}
