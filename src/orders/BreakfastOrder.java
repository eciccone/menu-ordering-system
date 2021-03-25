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
	
	/*
	@Override
	public String generateOrder() {
		StringBuilder sb = new StringBuilder();
		
		if(this.getMainDishCount() == 0) {
			sb.append("Unable to process: Main is missing");
		}
		
		if(this.getMainDishCount() > 1) {
			sb.append("Unable to process: " + this.getMainDish().getItemName() + " cannot be ordered more than once");
		}
		
		if(this.getSideDishCount() == 0) {
			generateHelper(sb, "Side is missing");
		}
		
		if(this.getSideDishCount() > 1) {
			generateHelper(sb, this.getSideDish().getItemName() + " cannot be ordered more than once");
		}
		
		if(sb.isEmpty()) {
			sb.append(this.getMainDish().getItemName() + ", " + this.getSideDish().getItemName() + ", " + this.getDrink().getItemName());
			
			if(this.getDrinkCount() > 1) {
				sb.append("(" + this.getDrinkCount() + ")");
			}
		}
		
		return sb.toString();
	}
	
	private void generateHelper(StringBuilder sb, String message) {
		if(sb.isEmpty()) {			
			sb.append("Unable to process: ");
		} else {
			sb.append(", ");
		}
		
		sb.append(message);
	} */
}
