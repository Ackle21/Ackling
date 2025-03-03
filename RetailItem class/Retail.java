//Alex Miller
public class Retail 
{

	public static void main(String[] args) throws NegativePrice, NegativeUnit
   {
		RetailItem item1 = new RetailItem("Gloves", 4, 2);
		RetailItem item2 = new RetailItem("Pants", -6, 23);
		RetailItem item3 = new RetailItem("Shirt", 100, -5);
		
		System.out.printf("Item 1: %s\nUnits: %d\nPrice: %.2f\n" + "", item1.getDescription(), item1.getUnitsOnHand(), item1.getPrice());
		System.out.printf("\nItem 2: %s\nUnits: %d\nPrice: %.2f\n" + "", item2.getDescription(), item2.getUnitsOnHand(), item2.getPrice());
		System.out.printf("\nItem 3: %s\nUnits: %d\nPrice: %.2f\n" + "", item3.getDescription(), item3.getUnitsOnHand(), item3.getPrice());
		
	}

}