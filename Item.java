
/**
 * This Item class represent the items available in the vending machine.
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class Item {
    
   private String name;// The name of the item
   private int calories;// The amount of calories the item has
   private int price;// The price of the item

    /**
     * Constructs a new Item object with the given attributes.
     *
     * @param name  The name of the item
     * @param calories  The amount of calories the item has
     * @param price  The price of the item
     */
   Item(String name, int calories, int price){
       this.name = name;
       this.calories = calories;
       this.price = price;
   }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
   public String getName(){
       return name;
   }

    /**
     * Returns the amount of calories the item has.
     *
     * @return the amount of calories the item has
     */
   public int getCalories(){
       return calories;
   }

    /**
     * Returns the price of the item .
     *
     * @return the price of the item
     */
   public int getPrice(){
       return price;
   }

    /**
     * Sets the price of the item .
     *
     * @param price The price of the item
     */
   public void setPrice(int price){
       this.price = price;
   }
}
