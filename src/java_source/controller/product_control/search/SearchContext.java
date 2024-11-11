package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.List;

public class SearchContext {
	private SearchStrategy searcher;

	public SearchContext(SearchStrategy strategy) {
		this.searcher = strategy;
	}

	public void setSearchStrategy(SearchStrategy strategy) {
		this.searcher = strategy;
	}

	public void search(List<Product> list) {
		searcher.search(list);
	}
}
