package orders;

public class LunchOrder extends Order {

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
		
		if(this.getDrinkCount() > 1) {
			str = generateHelper(str, this.getDrink().getItemName() + " cannot be ordered more than once");
		}
		
		if(str.equals("")) {
			str += this.getMainDish().getItemName() + ", " + this.getSideDish().getItemName();
			
			if(this.getSideDishCount() > 1) {
				str += "(" + this.getSideDishCount() + ")";
			}
			
			str += ", " + this.getDrink().getItemName();
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
