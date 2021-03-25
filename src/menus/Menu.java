package menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import items.DrinkItem;
import items.Item;

public class Menu {

	private String menuType;
	private Map<Integer, Item> items;
	
	public Menu(String menuType) {
		this.menuType = menuType;
		items = new HashMap<Integer, Item>();
	}
	
	public void addItem(Item item) {
		items.put(item.getItemId(), item);
	}
	
	public Item getItemById(int itemId) {
		return items.get(itemId);
	}
	
}
