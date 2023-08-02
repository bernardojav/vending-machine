
/**
 * The Transaction class represents each transaction done/made by the vending machine
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class Transaction {
    
    private Item item;// The item purchased in the transaction
    private int amountPaid;// The amount paid by the customer
    private int changeGiven;// The change given by the vending machine (if any)

    /**
     * Constructs a new Transaction object with the given attributes.
     *
     * @param item The item bought by the customer
     * @param amountPaid The amount paid by the customer
     * @param changeGiven The amount of change given by the vending machine
     */
    Transaction(Item item, int amountPaid, int changeGiven){
        this.item = item;
        this.amountPaid = amountPaid;
        this.changeGiven = changeGiven;
    }

    /**
     * Returns the item in the transaction.
     *
     * @return the item in the transaction
     */
    public Item getItem(){
        return item;
    }

    /**
     * Returns the amount the customer paid in the transaction.
     *
     * @return the amount the customer paid in the transaction
     */
    public int getAmountPaid(){
        return amountPaid;
    }

    /**
     * Returns the amount of change the customer paid in the transaction.
     *
     * @return the amount of change the customer paid in the transaction
     */
    public int getChangeGiven(){
        return changeGiven;
    }
    
}
