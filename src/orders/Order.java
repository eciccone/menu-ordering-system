package orders;
import items.DesertItem;
import items.DrinkItem;
import items.Item;
import items.MainItem;
import items.SideItem;

/**
 * A Order class to encapsulate the properties of an Order.
 * 
 * Although all orders are only required to contain a main and a side, I included
 * a drink and desert as well for the chance of extending the requirements in the future.
 * 
 * @author eddie
 *
 */
public class Order {

	private MainItem mainDish;
	private SideItem sideDish;
	private DrinkItem drink;
	private DesertItem desert;

	private int mainDishCount;
	private int sideDishCount;
	private int drinkCount;
	private int desertCount;

	public Order() {
		mainDish = null;
		sideDish = null;
		drink = new DrinkItem(-1, "Water");
		desert = null;
		mainDishCount = 0;
		sideDishCount = 0;
		drinkCount = 0;
		desertCount = 0;
	}

	public MainItem getMainDish() {
		return mainDish;
	}

	public SideItem getSideDish() {
		return sideDish;
	}

	public DrinkItem getDrink() {
		return drink;
	}

	public DesertItem getDesert() {
		return desert;
	}

	public int getMainDishCount() {
		return mainDishCount;
	}

	public int getSideDishCount() {
		return sideDishCount;
	}

	public int getDrinkCount() {
		return drinkCount;
	}

	public int getDesertCount() {
		return desertCount;
	}

	public void addItem(Item item) {
		if (item instanceof MainItem) {
			mainDish = (MainItem) item;
			mainDishCount++;
		} else if (item instanceof SideItem) {
			sideDish = (SideItem) item;
			sideDishCount++;
		} else if (item instanceof DrinkItem) {
			drink = (DrinkItem) item;
			drinkCount++;
		} else if (item instanceof DesertItem) {
			desert = (DesertItem) item;
			desertCount++;
		}
	}
	
	public String generateOrder() {
		return mainDish.getItemName() + ", " + sideDish.getItemName() + ", " + drink.getItemName() + ", " + desert.getItemName();
	}
}
