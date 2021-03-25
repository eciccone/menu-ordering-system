
import java.util.Arrays;
import java.util.Scanner;

import items.DesertItem;
import items.DrinkItem;
import items.Item;
import items.MainItem;
import items.SideItem;
import menus.Menu;
import orders.BreakfastOrder;
import orders.DinnerOrder;
import orders.LunchOrder;
import orders.Order;

public class MenuOrderingSystem {

	private Menu breakfastMenu;
	private Menu lunchMenu;
	private Menu dinnerMenu;

	public MenuOrderingSystem() {
		// build the breakfast menu
		breakfastMenu = new Menu("breakfast");
		breakfastMenu.addItem(new MainItem(1, "Eggs"));
		breakfastMenu.addItem(new SideItem(2, "Toast"));
		breakfastMenu.addItem(new DrinkItem(3, "Coffee"));

		// build the lunch menu
		lunchMenu = new Menu("lunch");
		lunchMenu.addItem(new MainItem(1, "Salad"));
		lunchMenu.addItem(new SideItem(2, "Chips"));
		lunchMenu.addItem(new DrinkItem(3, "Soda"));

		// build the dinner menu
		dinnerMenu = new Menu("dinner");
		dinnerMenu.addItem(new MainItem(1, "Steak"));
		dinnerMenu.addItem(new SideItem(2, "Potatoes"));
		dinnerMenu.addItem(new DrinkItem(3, "Wine"));
		dinnerMenu.addItem(new DesertItem(4, "Cake"));
	}

	/**
	 * Creates and returns a new order. The type of order is based on the String,
	 * orderType
	 * 
	 * @param orderType Valid options are breakfast, lunch, and dinner
	 * @return the appropriate order type based on the parameter
	 */
	public Order createOrder(String orderType) {
		if (orderType.equalsIgnoreCase("breakfast")) {
			return new BreakfastOrder();
		} else if (orderType.equalsIgnoreCase("lunch")) {
			return new LunchOrder();
		} else if (orderType.equalsIgnoreCase("dinner")) {
			return new DinnerOrder();
		} else {
			return null;
		}
	}

	/**
	 * Returns a menu for the appropriate order type. Breakfast order gets the
	 * breakfast menu, lunch order gets the lunch menu, dinner order gets the dinner
	 * menu.
	 * 
	 * @param order The order that is requesting a menu
	 * @return The appropriate menu type
	 */
	public Menu getMenu(Order order) {
		if (order instanceof BreakfastOrder) {
			return breakfastMenu;
		} else if (order instanceof LunchOrder) {
			return lunchMenu;
		} else if (order instanceof DinnerOrder) {
			return dinnerMenu;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		MenuOrderingSystem mos = new MenuOrderingSystem();

		// creates a scanner object to get user input
		Scanner scan = new Scanner(System.in);

		System.out.println("To end program, enter: end\n\n");
		System.out.print("In: ");

		// get the entire users input
		String input = scan.nextLine();

		// execute in a loop until user inputs "end"
		while (!input.equals("end")) {

			// make sure there is a space between the type of order and the item ids
			if (input.contains(" ")) {
				int indexOfSpace = input.indexOf(' ');
				
				// extract the order type
				String orderType = input.substring(0, indexOfSpace);

				// extract the item ids as a String
				String numbersAsString = input.substring(indexOfSpace + 1);

				// create a order
				Order o = mos.createOrder(orderType);

				// if type of order doesn't exist (not a breakfast, lunch, or dinner order) get input again
				if (o == null) {
					System.out.println(orderType + " is not a valid option.");
					System.out.print("Please try again: ");
					input = scan.nextLine();
					continue;
				}

				// get the correct menu
				Menu m = mos.getMenu(o);

				// if the order contained item ids then extract the item ids
				if (!numbersAsString.equals("")) {
					
					// convert String of item ids into an array of integers
					int[] itemIds = Arrays.asList(numbersAsString.split(",")).stream().map(String::trim)
							.mapToInt(Integer::parseInt).toArray();

					// add the items to the order
					for (int i = 0; i < itemIds.length; i++) {
						Item item = m.getItemById(itemIds[i]);
						o.addItem(item);
					}
				}

				System.out.println("Out: " + o.generateOrder());

			} 
			// if the input didn't contain a space do the appropriate actions
			else {
				Order o = mos.createOrder(input);

				// if type of order doesn't exist (not a breakfast, lunch, or dinner order) get input again
				if (o == null) {
					System.out.println(input + " is not a valid option.");
					System.out.print("Please try again: ");
					input = scan.nextLine();
					continue;
				}

				System.out.println("Out: " + o.generateOrder());
			}

			// get user input again
			System.out.print("\nIn: ");
			input = scan.nextLine();
		}

	}
}
