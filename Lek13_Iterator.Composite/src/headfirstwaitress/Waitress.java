package headfirstwaitress;

import java.util.Iterator;

public class Waitress {
	private PancakeHouseMenu pancakeHouseMenu;
	private DinerMenu dinerMenu;
	
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu() {

		
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.iterator();		
		System.out.println("Menu\n ---\nBreakfast");
		printMenu(pancakeIterator);
		
		Iterator<MenuItem> dinerIterator = dinerMenu.iterator();		
		System.out.println("\nLunch");
		printMenu(dinerIterator);
	}
	
	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.println(menuItem.getName() + ", ");
			System.out.println(menuItem.getPrice() + "--  ");
			System.out.println(menuItem.getDescription());
			System.out.println();
		}
	}
}
