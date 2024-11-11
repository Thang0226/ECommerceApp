package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByKeyWord implements SearchStrategy {
	@Override
	public void search(List<Product> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a search keyword: ");
		String keyword = scanner.nextLine();
		keyword = keyword.trim().toLowerCase();

		Pattern pattern = Pattern.compile(keyword);
		System.out.println("Products related to '" + keyword + "':");
		for (Product product : list) {
			String str = product.toString().toLowerCase();
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				System.out.println(product);
			}
		}
	}
}
