
/**
 * The ItemSlot class represents a slot in the vending machine that holds a specific item and its quantity.
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class ItemSlot {
    private int quantity;
    private Item item;

    /**
     * Constructs a new ItemSlot object with the given attributes.
     *
     * @param item The item to be stored in the ItemSlot
     * @param quantity The quantity of the item in the ItemSlot
     */
    ItemSlot(Item item, int quantity ){
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Returns the item inside the ItemSlot.
     *
     * @return the item inside the ItemSlot
     */
    public Item getItem(){
        return item;
    }

    /**
     * Returns the quantity of the item inside the ItemSlot.
     *
     * @return the quantity of the item inside the ItemSlot
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Sets the quantity of the item inside the ItemSlot.
     *
     * @param quantity The quantity of the item inside the ItemSlot
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
}
