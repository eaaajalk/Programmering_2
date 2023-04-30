package headfirstwaitress;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Iterable<MenuItem> {
	private ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("K&B' Pancake Breakfast", "Pancake with scrambles eggs, and toast", true, 2.99);
		addItem("Regular Pancake Breakfast", "Pancake with fried eggs, and sausage", false, 2.99);
		addItem("Blueberry Pancakes", "Pancake with fresh blueberries", true, 3.49);
		addItem("Waffels", "Waffels, with ypur choice af blueberries or strawberries", true, 3.59);
		
	}
			
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description,vegetarian,price);
		menuItems.add(menuItem);
	}
	
	public ArrayList<MenuItem> getMenuItems(){
		return new ArrayList<MenuItem>(menuItems);
	}

	@Override
	public Iterator<MenuItem> iterator() {
		return menuItems.iterator();
	}
	
	
	
	
}
