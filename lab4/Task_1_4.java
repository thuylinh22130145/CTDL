package lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Task_1_4 {

	private OrderItem[] items;

	// Constructor and other code

	public void sortItemsByPriceDescending() {
		Arrays.sort(items, new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem item1, OrderItem item2) {
				return Integer.compare(item2.getPrice(), item1.getPrice());
			}
		});
	}

	public void sortItemsByQuantityDescending() {
		Arrays.sort(items, new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem item1, OrderItem item2) {
				return Integer.compare(item2.getQuantity(), item1.getQuantity());
			}
		});
	}

	// Other methods

}
