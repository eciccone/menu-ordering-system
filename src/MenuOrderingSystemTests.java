
import menus.Menu;
import orders.Order;

public class MenuOrderingSystemTests {

	private String breakfast = "Breakfast";
	private String lunch = "Lunch";
	private String dinner = "Dinner";
	
	private MenuOrderingSystem mos;
	
	public MenuOrderingSystemTests() {
		mos = new MenuOrderingSystem();
	}
	
	public void executeTests() {
		System.out.println();
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		test12();
		test13();
	}
	
	public void test1() {
		System.out.println("Input: Breakfast 1,2,3");

		String expected = "Eggs, Toast, Coffee";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(breakfast);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test2() {
		System.out.println("Input: Breakfast 2,3,1");

		String expected = "Eggs, Toast, Coffee";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(breakfast);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		order.addItem(menu.getItemById(1));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test3() {
		System.out.println("Input: Breakfast 1,2,3,3,3");

		String expected = "Eggs, Toast, Coffee(3)";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(breakfast);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		order.addItem(menu.getItemById(3));
		order.addItem(menu.getItemById(3));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	
	public void test4() {
		System.out.println("Input: Breakfast 1");

		String expected = "Unable to process: Side is missing";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(breakfast);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test5() {
		System.out.println("Input: Lunch 1,2,3");

		String expected = "Salad, Chips, Soda";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(lunch);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}	
	
	public void test6() {
		System.out.println("Input: Lunch 1,1,2,3");

		String expected = "Unable to process: Salad cannot be ordered more than once";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(lunch);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test7() {
		System.out.println("Input: Lunch 1,2,2");

		String expected = "Salad, Chips(2), Water";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(lunch);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(2));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test8() {
		System.out.println("Input: Lunch");

		String expected = "Unable to process: Main is missing, side is missing";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(lunch);
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test9() {
		System.out.println("Input: Dinner 1,2,3,4");

		String expected = "Steak, Potatoes, Wine, Water, Cake";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(dinner);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		order.addItem(menu.getItemById(4));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}	
	
	public void test10() {
		System.out.println("Input: Dinner 1,2,3");

		String expected = "Unable to process: Desert is missing";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(dinner);
		Menu menu = mos.getMenu(order);
		order.addItem(menu.getItemById(1));
		order.addItem(menu.getItemById(2));
		order.addItem(menu.getItemById(3));
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test11() {
		System.out.println("Input: Dinner");

		String expected = "Unable to process: Main is missing, side is missing, desert is missing";
		System.out.println("Expected: " + expected);
		
		Order order = mos.createOrder(dinner);
		
		String actual = order.generateOrder();
		System.out.println("Actual:   " + actual);
		System.out.println("Test Passed: " + expected.equalsIgnoreCase(actual));
		
		testDivider();
	}
	
	public void test12() {
		System.out.println("Input: asdf");

		Object expected = null;
		System.out.println("Expected Order to be: " + expected);
		System.out.println("Expected Menu to be: " + expected);
		
		Order order = mos.createOrder("asdf");
		Menu menu = mos.getMenu(order);
		
		//String actual = order.generateOrder();
		System.out.println("Actual (order):   " + order);
		System.out.println("Actual (menu):   " + menu);
		
		System.out.println("Test Passed (order): " + (order == null));
		System.out.println("Test Passed (menu): " + (menu == null));
		
		testDivider();
	}
	
	public void test13() {
		System.out.println("Input: asdf 1,2,3");

		Object expected = null;
		System.out.println("Expected Order to be: " + expected);
		System.out.println("Expected Menu to be: " + expected);
		
		Order order = mos.createOrder("asdf");
		Menu menu = mos.getMenu(order);
		
		System.out.println("Actual (order):   " + order);
		System.out.println("Actual (menu):   " + menu);
		
		System.out.println("Test Passed (order): " + (order == null));
		System.out.println("Test Passed (menu): " + (menu == null));
		
		testDivider();
	}
	
	private void testDivider() {
		System.out.println("\n*********************************\n");
	}
}
