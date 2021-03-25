package orders;

import items.DrinkItem;

public class DinnerOrder extends Order {

	private DrinkItem water;
	
	public DinnerOrder() {
		super();
		water = new DrinkItem(-1, "Water");
	}

	@Override
	public String generateOrder() {
		String str = "";
		
		if(this.getMainDishCount() == 0) {
			str += "Unable to process: Main is missing";
		}
		
		if(this.getMainDishCount() > 1) {
			str += "Unable to process: " + this.getMainDish().getItemName() + " cannot be ordered more than once";
		}
		
		if(this.getSideDishCount() == 0) {
			str = generateHelper(str, "Side is missing");
		}
		
		if(this.getSideDishCount() > 1) {
			str = generateHelper(str, this.getSideDish().getItemName() + " cannot be ordered more than once");
		}
		
		if(this.getDrinkCount() > 1) {
			str = generateHelper(str, this.getDrink().getItemName() + " cannot be ordered more than once");
		}
		
		if(this.getDesertCount() == 0) {
			str = generateHelper(str, "Desert is missing");
		}
		
		if(this.getDesertCount() > 1) {
			str = generateHelper(str, this.getDesert().getItemName() + " cannot be ordered more than once");
		}
		
		if(str.equals("")) {
		    str += this.getMainDish().getItemName() + ", " + this.getSideDish().getItemName() + ", " + this.getDrink().getItemName();
			
			if(this.getDrinkCount() > 0) {
				str += ", " + water.getItemName();
			}
			
			str += ", " + this.getDesert().getItemName();
		}
		
		return str;
	}
	
	private String generateHelper(String str, String message) {
		String newStr = "";
		
		if(str.equals("")) {			
			newStr = "Unable to process: ";
		} else {
			newStr += str + ", ";
		}
		
		newStr += message;
		
		return newStr;
	} 
}
