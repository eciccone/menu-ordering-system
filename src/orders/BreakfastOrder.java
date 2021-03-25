package orders;

public class BreakfastOrder extends Order {
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
		
		if(str.equals("")) {
			str += this.getMainDish().getItemName() + ", " + this.getSideDish().getItemName() + ", " + this.getDrink().getItemName();
			
			if(this.getDrinkCount() > 1) {
				str += "(" + this.getDrinkCount() + ")";
			}
		}
		
		return str;
	}
	
	private String generateHelper(String str, String message) {
		String newStr = "";
		
		if(str.equals("")) {			
			newStr = "Unable to process: " + str;
		} else {
			newStr += str + ", ";
		}
		
		newStr += message;
		
		return newStr;
	} 
	
}
