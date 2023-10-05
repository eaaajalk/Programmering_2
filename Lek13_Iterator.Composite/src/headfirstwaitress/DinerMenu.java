package headfirstwaitress;


import java.util.Iterator;

public class DinerMenu implements Iterable<MenuItem>{
	private static final int MAX_ITEMS = 6;
	private int numberOfItems;
	private MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		numberOfItems = 0;

		addItem("Vegetarian BLT", "(Fakin') Bacon with letture & tomato on whole wheat", true, 2.99);
		addItem("BLT", "Bacon with letture & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "\"Soup of the day with a side og potato salad", false, 3.29);
		addItem("Hotdog", "A hotdog, with saurkraut, relish, onion, toppes with cheese", false, 3.05);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.out.println("Sorry, menu is full!");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems++;
		}
	}
	@Override
	public Iterator<MenuItem> iterator() {
		return new DinerMenuIterator();
	}
	
//	--------------------------------------------- Indre klasse ---------------------------------------
	private class DinerMenuIterator implements Iterator<MenuItem> {

		private int position;

		public DinerMenuIterator() {
			position = 0;
		}

		@Override
		public boolean hasNext() {
			return position<menuItems.length && menuItems[position]!=null;
		}

		@Override
		public MenuItem next() {
			MenuItem item = menuItems[position];
			position++;
			return item;
		}

	}


}
